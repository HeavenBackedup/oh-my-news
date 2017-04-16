/**
 * Created by shj on 2017/4/16.
 */
app.factory('content',function () {
    var content = {};
    var c_id = -1;
    var c_topic;
    var c_htmlContent;
    var c_labels;
    var c_categoryId = -1;
    content.setId = function (id) {
        c_id = id;
    };
    content.setTopic = function (topic) {
        c_topic = topic;
    };


    content.setHtmlContent = function (htmlContent) {
        c_htmlContent = htmlContent;
    };
    content.setLabels = function (labels) {
        c_labels = labels;
    };
    content.setCategoryId = function (categoryId) {
        c_categoryId = categoryId;
    }

    content.getEditContent = function () {
        return {
            id: c_id,
            topic: c_topic,
            htmlContent: c_htmlContent,
            labels: c_labels,
            categoryId: c_categoryId
        }
    }

    content.destroy = function () {
        c_id = -1;
        c_topic = undefined;
        c_htmlContent = undefined;
        c_labels = undefined;
        c_categoryId = -1;

    }

    content.getTemplate = function () {
        return {
            id: 1,
            topic: '模板文章',
            htmlContent: '<p><img src="http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492101116270_1?Expires=1807461113&amp;OSSAccessKeyId=LTAImvg3z9iZRy2n&amp;Signature=6RGGw112mdxa4QdT534b%2F0ul6vQ%3D" style="width: 25%;float: left;"/>​</p><p style="font-size: 16px;text-align: justify;">新华社北京4月14日电 国家主席习近平14日在人民大会堂会见圣多美和普林西比总理特罗瓦达。</p><p style="font-size: 16px;text-align: justify;">习近平指出，中圣普关系揭开了新的一页，圣普重回中非友好合作大家庭，顺应了当今时代潮流。中方高度赞赏总理先生为实现中圣普关系正常化作出的重要贡献，愿同圣普方一道，共同推进两国各领域友好互利合作，推动构建平等互信、合作共赢的全面合作伙伴关系。</p><p style="font-size: 16px;text-align: justify;">习近平强调，双方要深化政治互信，密切两国政府、立法机构、政党等各领域交流与合作，在涉及彼此核心利益和重大关切问题上相互理解和支持。双方要拓展务实合作。中方愿优先支持圣普完善国家全面发展规划，着力开展旅游业、渔业、农业三大领域互利合作，帮助圣普构筑基础设施建设、人力资源开发和安全能力建设三大支柱保障，实现自主可持续发展。双方要积极开展教育、文化、医疗卫生、智库、媒体、青年、妇女等人文领域交流合作，不断增进两国人民之间相互了解和友谊，巩固两国友好民意和社会基础。中方愿同圣普方在打击海盗和跨国有组织犯罪等安全领域开展交流合作，就联合国2030年可持续发展议程、气候变化、非洲和平与发展等国际和地区问题加强沟通和协调。</p><p style="font-size: 16px;text-align: justify;"><br/></p><p style="font-size: 16px;text-align: justify;"><img src="http://oh-my-news.oss-cn-shanghai.aliyuncs.com/1492105228958_1?Expires=2122825175&amp;OSSAccessKeyId=LTAImvg3z9iZRy2n&amp;Signature=3gA%2BJohAw18jKqhHSCoyhgMj9MQ%3D" style="width: 25%;float: right;"/>​</p><p style="font-size: 16px;text-align: justify;">习近平指出，我提出发展中非关系要秉持真实亲诚的政策理念和正确义利观，其核心要义就是把中国发展同助力非洲发展紧密结合起来，实现互利共赢。中方愿支持非洲致力于联合自强和发展振兴，实现自主可持续发展，携手推进构建中非命运共同体和利益共同体。</p><p style="font-size: 16px;text-align: justify;">特罗瓦达表示，圣普人民同中国人民的友谊源远流长。圣普人民从来没有忘记中国人民给予的帮助和支持。与中国复交在圣普受到广泛支持。圣普政府坚定奉行一个中国政策，高度赞赏中国真实亲诚的对非政策，愿本着互尊互信的精神，增进同中方高层交往，加强经贸、基础设施、旅游、安全等领域合作，深化非洲同中国的传统友谊，密切在国际事务中相互支持。</p><p style="font-size: 16px;text-align: justify;">国务委员杨洁篪等参加会见。</p>',
            labels: '政治',
            categoryId: 3
        }
    }



    return content;
})