package com.oh.my.news.web.controller.detailData;


import com.oh.my.news.model.vo.detail.*;
import com.oh.my.news.model.vo.edit.Category;

import java.util.*;

/**
 * Created by Prometheus on 2017/4/25.
 */
public class DetailData {
    static Article thisArticle;
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
                "images/img/avatar.png",
                1000
        );

        thisUser = replier;

        User replier1 = new User(
                2,
                "Andy Shen",
                "images/img/smy.jpg",
                0
        );
        User replier2 = new User(
                3,
                "Sun Sun",
                "images/img/sun.jpg",
                0
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


    public static Article getarticle(int articleId) {
        User user = new User(
                1,
                "John Doe",
                "images/img/avatar.png",
                0
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

        Article article1 = new Article();
        article1.setId(2);
        ArticleInfo articleInfo1 = new ArticleInfo();
        articleInfo1.setTopic("Clean - Responsive HTML5 Template");
        article1.setArticleInfo(articleInfo1);
        Article article2 = new Article();
        article2.setId(3);
        ArticleInfo articleInfo2 = new ArticleInfo();
        articleInfo2.setTopic("Responsive Pricing Table");
        article2.setArticleInfo(articleInfo2);
        Article article3 = new Article();
        article3.setId(4);
        ArticleInfo articleInfo3 = new ArticleInfo();
        articleInfo3.setTopic("Yellow HTML5 Template");
        article3.setArticleInfo(articleInfo3);
        Article article4 = new Article();
        article4.setId(5);
        ArticleInfo articleInfo4 = new ArticleInfo();
        articleInfo4.setTopic("Blackor Responsive Theme");
        article4.setArticleInfo(articleInfo4);
        Article article5 = new Article();
        article5.setId(6);
        ArticleInfo articleInfo5 = new ArticleInfo();
        articleInfo5.setTopic("Blackor Responsive Theme");
        article5.setArticleInfo(articleInfo5);
        Article article6 = new Article();
        article6.setId(7);
        ArticleInfo articleInfo6 = new ArticleInfo();
        articleInfo6.setTopic("Portfolio Bootstrap Template");
        article6.setArticleInfo(articleInfo6);
        Article article7 = new Article();
        article7.setId(8);
        ArticleInfo articleInfo7 = new ArticleInfo();
        articleInfo7.setTopic("Clean Slider Template");
        article7.setArticleInfo(articleInfo7);
        Article article8 = new Article();
        article8.setId(9);
        ArticleInfo articleInfo8 = new ArticleInfo();
        articleInfo8.setTopic("Clean - Responsive HTML5 Template");
        article8.setArticleInfo(articleInfo8);

        List<Article> authorPost = new ArrayList<Article>();
        authorPost.add(article1);
        authorPost.add(article2);
        authorPost.add(article3);
        authorPost.add(article4);
        List<Article> relatedPost = new ArrayList<Article>();
        relatedPost.add(article5);
        relatedPost.add(article6);
        relatedPost.add(article7);
        relatedPost.add(article8);


        ArticleInfo articleInfo = new ArticleInfo(
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

        Article article = new Article(
                1,
                articleInfo,
                user,
                category
        );

        thisArticle = article;

        return article;
    }

    public static ArticleReader getarticleReader(int articleId) {
        ArticleReader articleReader = new ArticleReader(
                thisUser,
                thisArticle,
                3,
                false,
                0,
                false,
                false
        );
        return articleReader;
    }


}
