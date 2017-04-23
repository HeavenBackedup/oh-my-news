package com.oh.my.news.web.controller;

import com.oh.my.news.model.test.Content;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leilei on 2017/4/19.
 */
@Controller
@RequestMapping(value = "/history")
public class HistoryAction extends BaseAction {
    @RequestMapping(value = "/getInit", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getInit() {
        List<Content> contents = new ArrayList<Content>();
        contents.add(new Content("天舟一号太空行有五大亮点 创造数个中国首次","赵明","　【环球时报赴文昌特派记者 刘 扬】中国首个货运飞船天舟一号于20日19时41分准时在海南文昌航天发射场，由新型运载火箭长征七号发射升空。由于此次任务是天舟一号货运飞船和长征七号组成的空间站货物运输系统的首次实用性亮相，外界对于这次发射给予极大关注。到底这个“只运货、不送人”的飞船大力士有哪些神奇的本领？这次任务又有哪些亮点呢？\n" +
                "\n" +
                "　　一、天舟“肚大能装货”\n" +
                "\n" +
                "　　据天舟一号副总设计师徐小平介绍，天舟系列货运飞船是中国载人航天工程“三步走”战略中，载人空间站工程的重要组成部分。据他介绍，天舟一号身高10.6米，体宽3.35米，可以运送6吨多的货物，整船最大装载状态下重量达13.5吨。\n" +
                "\n" +
                "　　天舟一号的“大肚子”里装着哪些货物呢？载人航天工程航天员系统副总设计师黄伟芬透露，天舟一号这次任务将验证货物在打包、运输、信息管理、交付、装载及微生物控制全过程方案的有效性。货物主要侧重3人30天的生活和健康的保障，比如航天食品、饮用水、个人卫生清洁用品、废物处理物品、医监医保物品等，它们要按照尺寸、类别、数量来选择不同货包并固定在货舱支架上。据她介绍，此次任务中还将要搭载舱外航天服结构服。我们此前只进行过一次航天员出舱，所以希望通过这次飞行任务获得更多的数据，为未来舱外服的设计工作提供依据。\n"));
        return successReturnObject(contents);
    }
    @RequestMapping(value = "/getContent", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getContent(@RequestBody Map ctgyMap) {
        int dd= Integer.parseInt(ctgyMap.get("value").toString().trim());
        System.out.println(dd);
        Map<String,Object> map = new HashMap();
        List<Content> contents = new ArrayList<Content>();
        contents.add(new Content("24省份明日举行公务员省考 多地报名人数创新高","汪强","　今天，全国有24个省份同日举行公务员招录的“省考”，与公众较为熟悉的公务员“国考”(中央机关及其直属机构公务员招考)相比，公务员“省考”主要是省、市、县、乡四级的公务员招考。\n" +
                "\n" +
                "　　去年11月开始，2017年的公务员“省考”招录工作就已陆续启动，北京、上海的2017年公务员招考已于去年底进行了笔试，今年3月11日和4月8日，江苏和广东的“省考”笔试也已举行。\n" +
                "\n" +
                "　　今天，选择同日举行公务员招录“省考”笔试的24个省份包括吉林、黑龙江、浙江、贵州、福建、云南、湖南、甘肃、江西、广西、海南、新疆、天津、山东、山西、四川、内蒙古、安徽、湖北、宁夏、重庆、河北、陕西、青海。\n" +
                "\n" +
                "　　从招录规模来看，根据各地公布的招录人数统计，上述24省份本次公务员招录总人数接近12万。\n" +
                "\n" +
                "　　分省来看，湖南、黑龙江、山东、广西等省份招录规模较大，招考人数均超过8000人，其中，黑龙江今年共招录公务员8831人，较去年增加2687人，增幅高达43.7%。\n"));
        contents.add(new Content("天舟一号太空行有五大亮点 创造数个中国首次","赵明","　【环球时报赴文昌特派记者 刘 扬】中国首个货运飞船天舟一号于20日19时41分准时在海南文昌航天发射场，由新型运载火箭长征七号发射升空。由于此次任务是天舟一号货运飞船和长征七号组成的空间站货物运输系统的首次实用性亮相，外界对于这次发射给予极大关注。到底这个“只运货、不送人”的飞船大力士有哪些神奇的本领？这次任务又有哪些亮点呢？\n" +
                "\n" +
                "　　一、天舟“肚大能装货”\n" +
                "\n" +
                "　　据天舟一号副总设计师徐小平介绍，天舟系列货运飞船是中国载人航天工程“三步走”战略中，载人空间站工程的重要组成部分。据他介绍，天舟一号身高10.6米，体宽3.35米，可以运送6吨多的货物，整船最大装载状态下重量达13.5吨。\n" +
                "\n" +
                "　　天舟一号的“大肚子”里装着哪些货物呢？载人航天工程航天员系统副总设计师黄伟芬透露，天舟一号这次任务将验证货物在打包、运输、信息管理、交付、装载及微生物控制全过程方案的有效性。货物主要侧重3人30天的生活和健康的保障，比如航天食品、饮用水、个人卫生清洁用品、废物处理物品、医监医保物品等，它们要按照尺寸、类别、数量来选择不同货包并固定在货舱支架上。据她介绍，此次任务中还将要搭载舱外航天服结构服。我们此前只进行过一次航天员出舱，所以希望通过这次飞行任务获得更多的数据，为未来舱外服的设计工作提供依据。\n"));
        map.put("content",contents);
        return successReturnObject(map);
    }
}


