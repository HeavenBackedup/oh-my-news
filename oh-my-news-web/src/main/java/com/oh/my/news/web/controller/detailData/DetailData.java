package com.oh.my.news.web.controller.detailData;


import com.oh.my.news.model.vo.detail.*;
import com.oh.my.news.model.vo.edit.Category;

import java.util.*;

/**
 * Created by Prometheus on 2017/4/25.
 */
public class DetailData {
    static Artical thisArtical;
    static User thisUser;

    public static void main(String[] args) {
        System.out.println();
    }


    public static List<RootComments> getRootCommentsList(int currentPage) {
        List<Comment> commentList = new ArrayList<Comment>();
        List<RootComments> rootCommentsList = new ArrayList<RootComments>();

        User replier = new User(
                1,
                "John Doe",
                "images/img/avatar.png"
        );

        thisUser = replier;

        User replier1 = new User(
                2,
                "Andy Shen",
                "images/img/smy.jpg"
        );
        User replier2 = new User(
                3,
                "Sun Sun",
                "images/img/sun.jpg"
        );


//"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus.",


        Comment comment1 =new Comment(
                1,
                replier,
                null,
                1,
                "24 August 2017",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
        );
        commentList.add(comment1);
        Comment comment2 =new Comment(
                2,
                replier,
                comment1,
                1,
                "24 August 2017",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
        );
        commentList.add(comment2);
        Comment comment3 =new Comment(
                3,
                replier1,
                comment2,
                1,
                "24 August 2017",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
        );
        commentList.add(comment3);

        Comment comment4 =new Comment(
                4,
                replier2,
                comment3,
                1,
                "24 August 2017",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
        );
        commentList.add(comment4);

        rootCommentsList.add(new RootComments(false,commentList));


        if (currentPage != 2)
        {
            comment1 =new Comment(
                    5,
                    replier,
                    null,
                    1,
                    "24 August 2017",
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
            );
            commentList = new ArrayList<Comment>();
            commentList.add(comment1);
            rootCommentsList.add(new RootComments(false,commentList));

            comment1 =new Comment(
                    6,
                    replier,
                    null,
                    1,
                    "24 August 2017",
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facere sit perspiciatis debitis,vel ducimus praesentium expedita, assumenda ipsum cum corrupti dolorum modi. Rem ipsamsimilique sapiente obcaecati tenetur beatae voluptatibus."
            );
            commentList = new ArrayList<Comment>();
            commentList.add(comment1);
            rootCommentsList.add(new RootComments(false,commentList));

        }else {
        }
        return rootCommentsList;
    }


    public static Artical getArtical(int articalId) {
        User user = new User(
                1,
                "John Doe",
                "images/img/avatar.png"
        );
        Category category = new Category(
                1,
                null,
                "政治"
        );
        List<String> labels = new ArrayList<String>();
        labels.add("HTML5");
        labels.add("CSS3");
        labels.add("COMPONENTS");
        labels.add("TEMPLATE");
        labels.add("PLUGIN");
        labels.add("BOOTSTRAP");

        Artical artical1 = new Artical();
        artical1.setId(2);
        ArticalInfo articalInfo1 = new ArticalInfo();
        articalInfo1.setTopic("Clean - Responsive HTML5 Template");
        artical1.setArticalInfo(articalInfo1);
        Artical artical2 = new Artical();
        artical2.setId(3);
        ArticalInfo articalInfo2 = new ArticalInfo();
        articalInfo2.setTopic("Responsive Pricing Table");
        artical2.setArticalInfo(articalInfo2);
        Artical artical3 = new Artical();
        artical3.setId(4);
        ArticalInfo articalInfo3 = new ArticalInfo();
        articalInfo3.setTopic("Yellow HTML5 Template");
        artical3.setArticalInfo(articalInfo3);
        Artical artical4 = new Artical();
        artical4.setId(5);
        ArticalInfo articalInfo4 = new ArticalInfo();
        articalInfo4.setTopic("Blackor Responsive Theme");
        artical4.setArticalInfo(articalInfo4);
        Artical artical5 = new Artical();
        artical5.setId(6);
        ArticalInfo articalInfo5 = new ArticalInfo();
        articalInfo5.setTopic("Blackor Responsive Theme");
        artical5.setArticalInfo(articalInfo5);
        Artical artical6 = new Artical();
        artical6.setId(7);
        ArticalInfo articalInfo6 = new ArticalInfo();
        articalInfo6.setTopic("Portfolio Bootstrap Template");
        artical6.setArticalInfo(articalInfo6);
        Artical artical7 = new Artical();
        artical7.setId(8);
        ArticalInfo articalInfo7 = new ArticalInfo();
        articalInfo7.setTopic("Clean Slider Template");
        artical7.setArticalInfo(articalInfo7);
        Artical artical8 = new Artical();
        artical8.setId(9);
        ArticalInfo articalInfo8 = new ArticalInfo();
        articalInfo8.setTopic("Clean - Responsive HTML5 Template");
        artical8.setArticalInfo(articalInfo8);

        List<Artical> authorPost = new ArrayList<Artical>();
        authorPost.add(artical1);
        authorPost.add(artical2);
        authorPost.add(artical3);
        authorPost.add(artical4);
        List<Artical> relatedPost = new ArrayList<Artical>();
        relatedPost.add(artical5);
        relatedPost.add(artical6);
        relatedPost.add(artical7);
        relatedPost.add(artical8);


        ArticalInfo articalInfo = new ArticalInfo(
                1,
                "模板文章",
                "<p><img src=\"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&amp;OSSAccessKeyId=LTAImvg3z9iZRy2n&amp;Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D\" style=\"width: 25%;float: left;\"/>\u200B</p><p style=\"font-size: 16px;text-align: justify;\">新华社北京4月14日电 国家主席习近平14日在人民大会堂会见圣多美和普林西比总理特罗瓦达。</p><p style=\"font-size: 16px;text-align: justify;\">习近平指出，中圣普关系揭开了新的一页，圣普重回中非友好合作大家庭，顺应了当今时代潮流。中方高度赞赏总理先生为实现中圣普关系正常化作出的重要贡献，愿同圣普方一道，共同推进两国各领域友好互利合作，推动构建平等互信、合作共赢的全面合作伙伴关系。</p><p style=\"font-size: 16px;text-align: justify;\">习近平强调，双方要深化政治互信，密切两国政府、立法机构、政党等各领域交流与合作，在涉及彼此核心利益和重大关切问题上相互理解和支持。双方要拓展务实合作。中方愿优先支持圣普完善国家全面发展规划，着力开展旅游业、渔业、农业三大领域互利合作，帮助圣普构筑基础设施建设、人力资源开发和安全能力建设三大支柱保障，实现自主可持续发展。双方要积极开展教育、文化、医疗卫生、智库、媒体、青年、妇女等人文领域交流合作，不断增进两国人民之间相互了解和友谊，巩固两国友好民意和社会基础。中方愿同圣普方在打击海盗和跨国有组织犯罪等安全领域开展交流合作，就联合国2030年可持续发展议程、气候变化、非洲和平与发展等国际和地区问题加强沟通和协调。</p><p style=\"font-size: 16px;text-align: justify;\"><br/></p><p style=\"font-size: 16px;text-align: justify;\"><img src=\"http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105228958_1?Expires=2122825175&amp;OSSAccessKeyId=LTAImvg3z9iZRy2n&amp;Signature=3gA%2BJohAw18jKqhHSCoyhgMj9MQ%3D\" style=\"width: 25%;float: right;\"/>\u200B</p><p style=\"font-size: 16px;text-align: justify;\">习近平指出，我提出发展中非关系要秉持真实亲诚的政策理念和正确义利观，其核心要义就是把中国发展同助力非洲发展紧密结合起来，实现互利共赢。中方愿支持非洲致力于联合自强和发展振兴，实现自主可持续发展，携手推进构建中非命运共同体和利益共同体。</p><p style=\"font-size: 16px;text-align: justify;\">特罗瓦达表示，圣普人民同中国人民的友谊源远流长。圣普人民从来没有忘记中国人民给予的帮助和支持。与中国复交在圣普受到广泛支持。圣普政府坚定奉行一个中国政策，高度赞赏中国真实亲诚的对非政策，愿本着互尊互信的精神，增进同中方高层交往，加强经贸、基础设施、旅游、安全等领域合作，深化非洲同中国的传统友谊，密切在国际事务中相互支持。</p><p style=\"font-size: 16px;text-align: justify;\">国务委员杨洁篪等参加会见。</p>",
                labels,
                authorPost,
                relatedPost,
                100,
                1000,
                "23 Agustus 2017",
                3,
                1.5f
        );

        Artical artical = new Artical(
                1,
                articalInfo,
                user,
                category
        );

        thisArtical = artical;

        return artical;
    }

    public static ArticalReader getArticalReader(int articalId) {
        ArticalReader articalReader = new ArticalReader(
                thisUser,
                thisArtical,
                3,
                false,
                0,
                false,
                false
        );
        return articalReader;
    }


}
