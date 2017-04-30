package com.oh.my.news.web.controller.mainpage;

import com.oh.my.news.model.template.Item;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.vo.EditContent;
import com.oh.my.news.web.util.BaseAction;
import jdk.nashorn.internal.runtime.Undefined;
import mainpage.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.text.html.parser.Entity;
import java.util.*;

/**
 * Created by Dzhaoooo on 17/4/13.
 */
@Controller
@RequestMapping(value = "/mainpage")
public class MainAction extends BaseAction {
    //新闻显示
    @RequestMapping(value = "/showPage", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object showPage(@RequestBody Map showPageMap) {
        System.out.println(showPageMap);
        int index = Integer.parseInt(showPageMap.get("pageIndex").toString().trim());
        int currentPage = Integer.parseInt(showPageMap.get("currentPage").toString().trim());


        List<EditContent> list=new ArrayList<EditContent>();
        if(index==0){
            if(currentPage==1){
                list.add(new EditContent(100,
                        "外交部网站",
                        "20分钟前",
                        "李克强主持召开贯彻新发展理念 培育发展新动能座谈会",
                        "<p><img src='http://cms-bucket.nosdn.127.net/catchpic/e/e8/e8af197c3b3ab1786ef430976c9ae8f3.jpg?imageView&thumbnail=550x0'/>​</p>" +
                                "<p><img src='http://cms-bucket.nosdn.127.net/catchpic/9/91/91632ac5687057238bbe4c4d3b6b603e.jpg?imageView&thumbnail=550x0' />​</p> " +
                                "<p><img src='http://cms-bucket.nosdn.127.net/catchpic/5/51/51d8a1639fbaae2b578a580de8ef6da4.jpg?imageView&thumbnail=550x0' />​</p> " +
                                "<p>4月18日，中共中央政治局常委、国务院总理李克强主持召开“贯彻新发展理念 培育发展新动能”座谈会，" +
                                "与正在国家行政学院该专题研讨班学习的全体学员、有关部门、部分企业和金融机构负责人座谈交流。" +
                                "在以习近平同志为核心的党中央坚强领导下，全国上下坚持稳中求进工作总基调，深入贯彻创新、协调、绿色、开放、共享的新发展理念" +
                                "，推进供给侧结构性改革，努力在促进经济结构转型升级上迈出更大步伐。</p>",
                        "文化",
                        2

                ));
                list.add(new EditContent(101,
                        "澎湃新闻网",
                        "2分钟前",
                        "蒂勒森:伊朗遵守了核协议 但其仍在支持恐怖主义",
                        "<p><img src='http://cms-bucket.nosdn.127.net/catchpic/d/d0/d0c3d73bb5d83a5351ed6243ce3e95a5.jpg?imageView&thumbnail=550x0'/>​</p>" +
                                "<p>美国国务卿蒂勒森18日宣布：伊朗遵守了核协议，将继续解除对其制裁，但美方将就此进行评估。据俄罗斯卫星网4月19日消息，" +
                                "蒂勒森18日表示，美国总统特朗普指示国家安全委员会（National Security Council）调查评估解除对伊朗的制裁是否符合美国的国家安全利益。" +
                                "但在承认伊朗遵守核协议的同时，蒂勒森指出，这个国家仍在支持恐怖主义。</p>",
                        "文化",
                        2

                ));
            }else if(currentPage==2){
                list.add(new EditContent(112,
                        "董昭",
                        "3小时前",
                        "轴距2874mm 路虎高颜值SUV展前曝光",
                        "<p><img src='http://img5.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T9GD2ODN0008.JPG'/>​</p>" +
                                "<p><img src='http://img2.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T8G92ODN0008.JPG' />​</p> " +
                                "<p>2017上海车展即将开幕，我们在探馆过程中发现了进行伪装的路虎揽胜星脉，该车将在上海车展亮相，这也是该车在国内的首次亮相.</p>" +
                                "<p>1.该车基于捷豹F-PACE的全铝平台打造，揽胜星脉车身长宽高分别为4803x2145x1657mm，轴距则达到2874mm；</p>" +
                                "<p>2.前脸和侧面造型更加接近于揽胜运动版，尾部造型则与揽胜极光有几分相似，不过比极光的层次感更强；</p> " +
                                "<p>3.中控台所有功能被集成进一套双屏触控系统中，可以实现多媒体操控、移动互联、空调控制、全地形选择等功能的操作；</p>",
                        "科技",
                        3

                ));
                list.add(new EditContent(113,
                        "环球时报",
                        "2天前",
                        "韩系汽车在华销量同比骤降52% 因受萨德影响",
                        "<p>报道说，北京现代是韩国现代汽车与北汽集团组建的合资公司，其董事长徐和谊19日在上海车展作出以上表示。" +
                                "徐和谊说“目前，鉴于复杂的政治、经济和市场竞争环境，北京现代面临着严峻的市场挑战”，他说，但公司将不会放慢在中国市场的创新步伐。" +
                                "路透社称，韩国不顾中国反对，执意在韩部署萨德的决定在中国引发抗议浪潮，3月现代汽车与起亚汽车在中国的汽车销售总量较上年同期骤降52%。</p>",
                        "文化",
                        2

                ));
            }



        }else {

            list.add(new EditContent(112,
                    "董昭",
                    "3小时前",
                    "轴距2874mm 路虎高颜值SUV展前曝光",
                    "<p><img src='http://img5.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T9GD2ODN0008.JPG'/>​</p>" +
                            "<p><img src='http://img2.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T8G92ODN0008.JPG' />​</p> " +
                            "<p>2017上海车展即将开幕，我们在探馆过程中发现了进行伪装的路虎揽胜星脉，该车将在上海车展亮相，这也是该车在国内的首次亮相.</p>" +
                            "<p>1.该车基于捷豹F-PACE的全铝平台打造，揽胜星脉车身长宽高分别为4803x2145x1657mm，轴距则达到2874mm；</p>" +
                            "<p>2.前脸和侧面造型更加接近于揽胜运动版，尾部造型则与揽胜极光有几分相似，不过比极光的层次感更强；</p> " +
                            "<p>3.中控台所有功能被集成进一套双屏触控系统中，可以实现多媒体操控、移动互联、空调控制、全地形选择等功能的操作；</p>",
                    "科技",
                    3

                    ));

            list.add(new EditContent(113,
                    "环球时报",
                    "2天前",
                    "韩系汽车在华销量同比骤降52% 因受萨德影响",
                    "<p>报道说，北京现代是韩国现代汽车与北汽集团组建的合资公司，其董事长徐和谊19日在上海车展作出以上表示。" +
                            "徐和谊说“目前，鉴于复杂的政治、经济和市场竞争环境，北京现代面临着严峻的市场挑战”，他说，但公司将不会放慢在中国市场的创新步伐。" +
                            "路透社称，韩国不顾中国反对，执意在韩部署萨德的决定在中国引发抗议浪潮，3月现代汽车与起亚汽车在中国的汽车销售总量较上年同期骤降52%。</p>",
                    "文化",
                    2

            ));

        }
        Map<String, Object> itemsmap = new HashMap<String, Object>();
        itemsmap.put("newList", list);
        itemsmap.put("pageIndex",index);
        itemsmap.put("pagination",new Pagination(200,currentPage));
        return successReturnObject(itemsmap);
    }


    //收藏排行
    @RequestMapping(value = "/collectList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody Object collect(@RequestBody Map indexMap) {
        List<News> lists = new ArrayList<News>();
        lists.add(new News(1,
                "李克强力促“多证合一”:一季度日均诞生市场主体4万户",
                "董昭",
                "3小时前",
                null,
                "这是第一则新闻的内容"));
        lists.add(new News(2,
                "李克强为啥要全面推开医联体建设",
                "董昭",
                "3小时前",
                null,
                "这是第二则新闻的内容"));
        lists.add(new News(3,
                "军事专家：美韩朝三国军力对比差距有多大？",
                "董昭",
                "3小时前",
                null,
                "这是第三则新闻的内容"));
        lists.add(new News(4,
                "企业家法国坠机身亡 其父亲与妻子为争股权上法庭",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        lists.add(new News(5,
                "轴距2874mm 路虎高颜值SUV展前曝光",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        Map<String, Object> collectmap = new HashMap<String, Object>();
        collectmap.put("collectList", lists);
        return successReturnObject(collectmap);


    }
    //评论排行
    @RequestMapping(value = "/markList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
    Object mark(@RequestBody Map indexMap) {
        List<News> lists = new ArrayList<News>();
        lists.add(new News(1,
                "李克强力促“多证合一”:一季度日均诞生市场主体4万户",
                "董昭",
                "3小时前",
                null,
                "这是第一则新闻的内容"));
        lists.add(new News(2,
                "军事专家：美韩朝三国军力对比差距有多大？",
                "董昭",
                "3小时前",
                null,
                "这是第三则新闻的内容"));
        lists.add(new News(3,
                "李克强为啥要全面推开医联体建设",
                "董昭",
                "3小时前",
                null,
                "这是第二则新闻的内容"));
        lists.add(new News(4,
                "轴距2874mm 路虎高颜值SUV展前曝光",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        lists.add(new News(5,
                "企业家法国坠机身亡 其父亲与妻子为争股权上法庭",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        Map<String, Object> markmap = new HashMap<String, Object>();
        markmap.put("markList", lists);
        return successReturnObject(markmap);


    }
    //最新动态
    @RequestMapping(value = "/lastList", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public @ResponseBody
    Object last(@RequestBody Map indexMap) {
        List<News> lists = new ArrayList<News>();
        lists.add(new News(1,
                "李克强为啥要全面推开医联体建设",
                "董昭",
                "3小时前",
                null,
                "这是第二则新闻的内容"));
        lists.add(new News(2,
                "企业家法国坠机身亡 其父亲与妻子为争股权上法庭",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        lists.add(new News(3,
                "李克强力促“多证合一”:一季度日均诞生市场主体4万户",
                "董昭",
                "3小时前",
                null,
                "这是第一则新闻的内容"));
        lists.add(new News(4,
                "军事专家：美韩朝三国军力对比差距有多大？",
                "董昭",
                "3小时前",
                null,
                "这是第三则新闻的内容"));
        lists.add(new News(5,
                "轴距2874mm 路虎高颜值SUV展前曝光",
                "董昭",
                "3小时前",
                null,
                "这是第四则新闻的内容"));
        Map<String, Object> lastmap = new HashMap<String, Object>();
        lastmap.put("lastList", lists);
        return successReturnObject(lastmap);


    }



}
