package com.oh.my.news.search;

import com.oh.my.news.model.dto.SearchContent;
import com.oh.my.news.search.api.SearchContentApi;
import com.oh.my.news.search.util.ESService;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/4/24.
 */
public class EsMainTestCase extends TestCase {
    private ESService esService;
    private SearchContentApi searchContentApi;


    public EsMainTestCase() {
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:oh-my-news-search/spring-service.xml");
        this.esService = (ESService) applicationContext.getBean("esService");
        this.searchContentApi = (SearchContentApi)applicationContext.getBean("searchContentApi");
    }

    public void testClient(){
        try {
//            Client client = new PreBuiltTransportClient(Settings.builder().put("cluster.name","es_main").build())
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("123.206.210.75"), 9300));
//
//// on shutdown
//            System.out.println(client);
//            System.out.println(client.prepareIndex("test","test").execute().actionGet().toString());;
//
//            client.close();
            Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true)
                    .put("client", true)//仅作为客户端连接
                    .put("data", false)
                    .put("cluster.name", "es_main")//集群名称
                    .build();
           Client client = new TransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("123.206.210.75"),9300));//TCP 连接地址
            System.out.println(client.admin().indices().prepareCreate("test2_index").execute().actionGet());
            client.close();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }



    public void testMapping(){

        try {
            this.esService.createIndex();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }


    public void testInsert(){
        try {
            List<SearchContent> searchContents = new ArrayList<SearchContent>();
            SearchContent content = new SearchContent();
            content.setId(1);
            content.setTopic("习近平:金融活经济活 金融稳经济稳");
            content.setContent("新华社北京4月26日电 中共中央政治局4月25日下午就维护国家金融安全进行第四十次集体学习。中共中央总书记习近平在主持学习时强调，金融安全是国家安全的重要组成部分，是经济平稳健康发展的重要基础。维护金融安全，是关系我国经济社会发展全局的一件带有战略性、根本性的大事。金融活，经济活；金融稳，经济稳。必须充分认识金融在经济发展和社会生活中的重要地位和作用，切实把维护金融安全作为治国理政的一件大事，扎扎实实把金融工作做好。\n" +
                    "这次中央政治局集体学习，由有关负责同志结合各自业务领域和工作实际介绍情况。中国人民银行行长周小川就加强宏观调控、保障金融安全，中国银监会主席郭树清就化解银行体系风险、维护金融稳定，中国证监会主席刘士余就资本市场发展与风险管理，中国保监会副主席陈文辉就回归风险保障、强化保险监督、守住维护金融安全底线谈了认识和体会。\n" +
                    "中央政治局各位同志听取了他们的发言，并就有关问题进行了讨论。\n" +
                    "习近平在主持学习时发表了讲话。他指出，金融是现代经济的核心。保持经济平稳健康发展，一定要把金融搞好。改革开放以来，我们对金融工作和金融安全始终是高度重视的，我国金融业发展取得巨大成就，金融成为资源配置和宏观调控的重要工具，成为推动经济社会发展的重要力量。党的十八大以来，我们反复强调要把防控金融风险放到更加重要的位置，牢牢守住不发生系统性风险底线，采取一系列措施加强金融监管，防范和化解金融风险，维护金融安全和稳定，把住了发展大势。随着金融改革不断深化，金融体系、金融市场、金融监管和调控体系日益完善，金融机构实力大大增强，我国已成为重要的世界金融大国。");
            content.setAuthor("董昭");
            SearchContent content1 = new SearchContent();
            content1.setId(2);
            content1.setTopic("总理再发话：集中攻克雾霾成因 该花多少钱就花多少钱");
            content1.setContent("“许多人都注意到，只要天气好，一些跳广场舞的地方就热闹欢腾；而遇到雾霾天，广场舞的声音立即就变小了。我也听说，咱们在座的一些部长们，出外散步时也习惯先要看看‘雾霾指数’。”4月26日国务院常务会议上，李克强总理一连引用了两个身边的事例说，“雾霾的确已成为事关每个人的民生痛点。”\n" +
                    "当天会议部署对大气重污染成因和治理开展集中攻关，以生态改善提高人民生活质量。李克强说，雾霾治理不仅事关转变发展方式、调整经济结构，更已成为关系人民群众健康的“当务之急”。\n" +
                    "“今年财政预算已经做完了，那我们就从总理预备费中出这个钱！”李克强说，“我们常说钱要花到刀刃上，这件事就是广大人民群众最急切盼望解决的事之一，该花多少钱就花多少钱！”\n" +
                    "今年3月，李克强参加全国人大陕西代表团讨论时，中科院院士、中科院地球环境所所长周卫健向总理建议，应集中多学科科学家攻克“中国北方雾霾的成因及应对”。李克强当即表示，如果有科研团队能够把雾霾形成机理和危害性真正研究透，提出更有效的应对良策，“谁攻克，重奖谁”！\n" +
                    "两会闭幕后两天，总理就在部署落实《政府工作报告》工作时加入一项新任务：设立专项资金，组织相关学科优秀科学家，集中攻关雾霾形成机理与治理。一个多月后的4月26日，李克强主持召开国务院常务会议确定，开展由环境保护部牵头，科技、中科院、高校、农业、工信、气象、卫生等多部门和单位协作的“集中攻关”。\n" +
                    "“我们就是要汇聚跨部门科研资源，组织优秀科研团队进行科学研究，齐心合力打赢这场雾霾成因和治理的‘攻关战’！”总理说。");
            content1.setAuthor("宋寒剑");
            SearchContent content2 = new SearchContent();
            content2.setId(3);
            content2.setTopic("特朗普政府发布美国史上最大规模减税方案");
            content2.setContent("中新社华盛顿4月26日电 特朗普政府26日公布税收改革方案。根据该方案，美国将大幅削减企业税和个人税。特朗普当天表示，“这是一份非常好的方案，它会让更多的美国人重返工作岗位。”\n" +
                    "资料图：美国总统特朗普\n" +
                    "资料图：美国总统特朗普\n" +
                    "26日下午，白宫国家经济委员会主任加里·科恩与美国财政部长史蒂文·姆努钦共同现身白宫简报室，向媒体介绍了新税改方案的部分原则性内容。\n" +
                    "根据这一方案，美国将大幅削减企业税税率，从35%降至15%。个人税税率将从7档减少至3档，分别是10%、25%和35%。此外，个税起征点几乎翻了一番。今后，一对夫妻的所得税起征点将升至2.4万美元。新税改方案还将废除遗产税、“奥巴马医保”税、替代性最低税等税种。与此同时，该方案将取消多项税收减免政策。\n" +
                    "科恩表示，美国的税收体系已严重过时，特朗普总统始终将税收改革列为执政的优先事项。他说，新税改方案是美国自1986年以来出台的最重要的一份税改方案，也是美国历史上最大规模的减税方案之一。\n" +
                    "资料图：美财长姆努钦 中新社记者 刁海洋 摄\n" +
                    "资料图：美财长姆努钦 中新社记者 刁海洋 摄\n" +
                    "姆努钦说，特朗普总统决心通过减税，充分释放商界能量，最大限度促进经济增长、增加就业岗位并扩大中产阶级收入。\n" +
                    "对于减税可能引发的债务激增的问题，姆努钦表示，美国的联邦债务在上一届政府任期内增长过快，从10万亿美元蹿升至20万亿美元，特朗普政府对此感到担忧。他说，新税改方案将促进经济增长，同时带来更多的财政收入。该方案可有效降低债务占GDP的比重。");
            content2.setAuthor("范丹丹");
            SearchContent content3 = new SearchContent();
            content3.setId(4);
            content3.setTopic("中俄两军举行吹风会 中方称萨德部署削弱两国能力");
            content3.setContent("4月26日下午，中俄两军在莫斯科国际安全会议期间就全球和地区反导形势举行联合吹风会。\n" +
                    "中方代表、中央军委联合参谋部作战局副局长蔡军少将说，发展全球反导系统，必然恶化国际安全环境，国际社会广大成员都不赞成。联合国大会曾多次通过反导问题决议，呼吁有关国家停止该计划。罔顾共同的国际环境和其他国家的合法利益，单方面强化反导系统全球部署，实际上是为了谋求绝对的单方军事优势，这将进一步加剧地区紧张局势，引发局部对抗甚至全面军备竞赛，最终破坏全球和地区战略稳定，自身也得不到安全。美韩在韩国部署“萨德”系统真实目的是为美全球反导系统投棋布子，进一步筑牢围堵中俄的亚太反导隔离墙，削弱中俄的战略能力，我们对此坚决反对。中俄将进一步采取应对措施，维护中俄安全利益和地区战略平衡。\n" +
                    "俄方代表、俄军总参作战总局第一副总局长波兹尼希尔中将说，反导形势发展对推动核裁军进程和维护战略稳定产生直接影响。美在本土、欧洲和亚太部署反导系统，将会破坏战略力量平衡，降低核武器使用门槛，威胁太空活动安全，引发新一轮军备竞赛。美以应对伊朗、朝鲜核威胁为名部署反导系统，危害了俄中的战略安全和全球战略稳定。俄方呼吁就反导问题开展平等建设性对话，共同寻找照顾各方利益的解决途径。");
            content3.setAuthor("范丹丹");
            searchContents.add(content);
            searchContents.add(content1);
            searchContents.add(content2);
            searchContents.add(content3);
            searchContentApi.insert(searchContents);

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void testUpdate(){
        try {
            SearchContent content3 = new SearchContent();
            content3.setId(4);
            content3.setTopic("西安交大开警示大会 校长党委书记向全校作检讨");
            content3.setContent("4月20日，西安交大召开2017年党风廉政建设暨警示教育大会，总结部署党风廉政建设工作，通报违纪违规行为查处和问责情况，进行警示教育。陕西省委高教工委书记董小龙，学校党政领导、党委委员、纪委委员，中层以上领导干部及各方面代表450多人参加大会。王树国校长主持会议。\n" +
                    "党委副书记、纪委书记赵昌昌作党风廉政建设工作报告，严肃通报2016年以来学校对违纪违规行为查处和问责情况。在通报的违反中央八项规定精神及“四风”问题的6起案例中，给予4名同志党内警告处分、2名同志诫勉谈话、3个学院领导班子集体诫勉谈话，8家单位被通报批评。因对单位违规办理购物卡、违规发放节日慰问金负有领导责任，给予管理学院党委书记孙卫、经金学院党委原书记张文科党内警告处分，给予法学院党总支书记王保民诫勉谈话，同时给予上述三个学院领导班子集体诫勉谈话并通报批评。因组织学员变相公款出国境旅游等问题，给予管理学院EMBA中心主任赵更申党内警告处分。因组织学员公款国内旅游，给予经金学院培训中心主任王凌云党内警告处分、副主任史芳丽诫勉谈话。\n" +
                    "赵昌昌同志表示，今后将进一步严肃查处、强力问责，正风肃纪，不断营造严的氛围和良好的教育政治生态。\n" +
                    "校党委书记张迈曾、校长王树国、纪委书记赵昌昌带头反思并向全校作检讨：学校存在管党不力、治党不严、纪律松弛、责任缺失的情况，纪委执纪存在宽松软。他们在检讨中均表示自己负有主要责任。认为自己从思想深处对中央全面从严治党的精神和要求认识不够，“四个意识”不到位，为问题的滋生提供了思想的温床。今后将进一步强化对习近平总书记系列重要讲话精神和治国理政新理念新思想新战略的学习，牢固树立党章党规党纪意识，切实担负责任，坚决推动管党治党从宽松软走向严紧硬，真正从政治上、思想上、行动上向党中央看齐。");
            content3.setAuthor("董昭");

            searchContentApi.update(content3);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }


    public void testDelete(){
        try {
            searchContentApi.delete(4);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void testQuery(){
        try {
            System.out.println(searchContentApi.search("测试文章",0,10));
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

//    public ESService getEsService() {
//        return esService;
//    }
//
//    public SearchContentApi getSearchContentApi() {
//        return searchContentApi;
//    }

//    public static void main(String[] args) {
//        EsMainTestCase esMainTestCase = new EsMainTestCase();
//        esMainTestCase.testQuery();
//    }

}
