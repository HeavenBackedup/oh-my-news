package com.oh.my.news.web.controller;

import com.oh.my.news.model.template.Item;
import com.oh.my.news.model.template.Pagination;
import com.oh.my.news.model.test.Content;
import com.oh.my.news.web.util.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leilei on 2017/4/18.
 */
@Controller
@RequestMapping(value = "/draft")
public class DraftAction extends BaseAction {
    @RequestMapping(value = "/getInit", consumes = APPLICATION_JSON, method = RequestMethod.POST)
    public
    @ResponseBody
    Object getInit() {
        List<Content> contents = new ArrayList<Content>();
        contents.add(new Content("天舟一号太空行有五大亮点 创造数个中国首次",null,"　【环球时报赴文昌特派记者 刘 扬】中国首个货运飞船天舟一号于20日19时41分准时在海南文昌航天发射场，由新型运载火箭长征七号发射升空。由于此次任务是天舟一号货运飞船和长征七号组成的空间站货物运输系统的首次实用性亮相，外界对于这次发射给予极大关注。到底这个“只运货、不送人”的飞船大力士有哪些神奇的本领？这次任务又有哪些亮点呢？\n" +
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
       //System.out.println(ctgyMap);
       /* class Message {
            public String message;

            public Message(String message) {
                this.message = message;
            }
        }*/
         int MAX_SIZE = 200;
//       List<Map> list = new ArrayList<Map>();
//        Content[] listArray = new Content[2];
//        List<Object[]> list2 = new ArrayList<Object[]>();
        //下拉框的选择
        int dd= Integer.parseInt(ctgyMap.get("value").toString().trim());
        System.out.println(dd);
//        int pageMap = Integer.parseInt(ctgyMap.get("currentPage").toString().trim());
        //返回的值
        Map<String,Object> map = new HashMap();
//        Map<String,Object> m= new HashMap();
//        map.put("pagination",new Pagination(MAX_SIZE,pageMap));
        List<Content> contents = new ArrayList<Content>();

        contents.add(new Content("123济南西安等地出台楼市新政 限售城市增至18个",null,"进入4月，楼市调控仍在不断深入，一二线城市的调控不断升级，一些三四线城市也加入到调控队伍。\n" +
                "\n" +
                "　　4月19日，山东省济南市发布楼市新政，将长清区、章丘区纳入限购范围。通知要求，本市户籍家庭已拥有一套住房或有住房贷款记录的，申请住房贷款均视为第二套住房贷款，首付比例提高至60%。\n" +
                "\n" +
                "　　通知明确，优化居住用地供应。本着“增加总量、控制热点、均衡供地”原则，实施精准供地，平抑土地市场。此外，限购区域内自本通知施行之日起购买的住房，须取得不动产权证满2年后方可上市交易。\n" +
                "\n" +
                "　　同样出台限售政策的还有西安。继去年年底出台限购政策后，西安市近日对楼市再出“紧箍咒”，不仅将限购政策扩大至长安区，同时还明确，商业贷款首套房首付不低于30% ；二套房不低于40%；第三套房则不能贷款。同时，在住房限购区域范围内购买的商品住房及二手住房，需取得《不动产权证书》后满2年方可上市交易（买卖、赠与）。\n"));
       contents.add(new Content("456北京地铁17号线正式开建",null,"贯穿南北的地铁17号线将穿越昌平、朝阳、东城、通州4个区，4月19日，北京晨报记者从北京市政路桥市政集团了解到，地铁17号线通州区内的次渠站及两个区间开始进行地下连续墙施工，成为地铁17号线同期招标第一个实体开工的站点，为17号线全线2017年实质性开工拉开序幕。\n" +
               "\n" +
               "\n" +
               "\n" +
               "　　贯穿南北的地铁17号线总体呈“L型”，穿越昌平、朝阳、东城、通州4个区，连接昌平未来科技城和亦庄新城，中间又途经天通苑、望京、太阳宫、潘家园等人口密集的城市居住区，是北京市轨道交通网络中一条重要骨干线路。线路总长约49.7公里，设车站20座，10座换乘站中7座可与既有地铁线实现换乘，是北京地铁换乘比例最高的线路之一。\n" +
               "\n" +
               "　　据北京市政路桥市政集团相关负责人介绍，北京地铁17号线18标已正式开工建设，昨日开始进行地下连续墙施工。“18标位于通州区，包括1站2区间，分别为四线明挖段至次渠站区间、次渠站、次渠站至次渠北站区间，全长约1921.9米，主要工法为明挖、暗挖、盾构。其中，新建次渠站与既有亦庄线次渠站十字换乘，所处地层地质条件复杂，施工风险高，承压水下粉细砂层零距离下穿既有车站亦庄线次渠站非降水暗挖隧道，施工难度大。”该负责人称。\n"));
        contents.add(new Content("789北京地铁17号线正式开建",null,"贯穿南北的地铁17号线将穿越昌平、朝阳、东城、通州4个区，4月19日，北京晨报记者从北京市政路桥市政集团了解到，地铁17号线通州区内的次渠站及两个区间开始进行地下连续墙施工，成为地铁17号线同期招标第一个实体开工的站点，为17号线全线2017年实质性开工拉开序幕。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　贯穿南北的地铁17号线总体呈“L型”，穿越昌平、朝阳、东城、通州4个区，连接昌平未来科技城和亦庄新城，中间又途经天通苑、望京、太阳宫、潘家园等人口密集的城市居住区，是北京市轨道交通网络中一条重要骨干线路。线路总长约49.7公里，设车站20座，10座换乘站中7座可与既有地铁线实现换乘，是北京地铁换乘比例最高的线路之一。\n" +
                "\n" +
                "　　据北京市政路桥市政集团相关负责人介绍，北京地铁17号线18标已正式开工建设，昨日开始进行地下连续墙施工。“18标位于通州区，包括1站2区间，分别为四线明挖段至次渠站区间、次渠站、次渠站至次渠北站区间，全长约1921.9米，主要工法为明挖、暗挖、盾构。其中，新建次渠站与既有亦庄线次渠站十字换乘，所处地层地质条件复杂，施工风险高，承压水下粉细砂层零距离下穿既有车站亦庄线次渠站非降水暗挖隧道，施工难度大。”该负责人称。\n"));

        contents.add(new Content("100北京地铁17号线正式开建",null,"贯穿南北的地铁17号线将穿越昌平、朝阳、东城、通州4个区，4月19日，北京晨报记者从北京市政路桥市政集团了解到，地铁17号线通州区内的次渠站及两个区间开始进行地下连续墙施工，成为地铁17号线同期招标第一个实体开工的站点，为17号线全线2017年实质性开工拉开序幕。\n" +
                "\n" +
                "\n" +
                "\n" +
                "　　贯穿南北的地铁17号线总体呈“L型”，穿越昌平、朝阳、东城、通州4个区，连接昌平未来科技城和亦庄新城，中间又途经天通苑、望京、太阳宫、潘家园等人口密集的城市居住区，是北京市轨道交通网络中一条重要骨干线路。线路总长约49.7公里，设车站20座，10座换乘站中7座可与既有地铁线实现换乘，是北京地铁换乘比例最高的线路之一。\n" +
                "\n" +
                "　　据北京市政路桥市政集团相关负责人介绍，北京地铁17号线18标已正式开工建设，昨日开始进行地下连续墙施工。“18标位于通州区，包括1站2区间，分别为四线明挖段至次渠站区间、次渠站、次渠站至次渠北站区间，全长约1921.9米，主要工法为明挖、暗挖、盾构。其中，新建次渠站与既有亦庄线次渠站十字换乘，所处地层地质条件复杂，施工风险高，承压水下粉细砂层零距离下穿既有车站亦庄线次渠站非降水暗挖隧道，施工难度大。”该负责人称。\n"));




//        for (int j = 0; j < contents.size(); j++) {
//        // int num=0;
////                list.get(pageMap);
//        listArray[0] = contents.get(j);
//        j++;
//        listArray[1] = contents.get(j);
//        list2.add(listArray);
////            list2.get(0)
//    }

//        for (int i = 0;i<list2.size();i++) {
//
//            map.put("content", list2.get(i));
//            list.add(map);
//           // map.remove("content");
//
//     }
//          for (int i=0;i<list.size();i++){
//              if (i == (pageMap-1)){
//                  m= list.get(i);
//
//
//              }
//          }
        map.put("content",contents);
        return successReturnObject(map);

    }
//    @RequestMapping(value = "/pageReq",consumes = APPLICATION_JSON, method = RequestMethod.POST)
//    public @ResponseBody Object pageReq(@RequestBody Map pageMap){
//        System.out.println(pageMap);
//        int currentPage = Integer.parseInt(pageMap.get("currentPage").toString().trim());
//        Map<String,Object> map = new HashMap();
//        map.put("pagination",new Pagination(200,currentPage));
//        return successReturnObject(map);
//    }
}

