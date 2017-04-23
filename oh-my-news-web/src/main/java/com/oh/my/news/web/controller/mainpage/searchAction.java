package com.oh.my.news.web.controller.mainpage;

import com.oh.my.news.web.util.BaseAction;
import mainpage.News;
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
 * Created by Dzhaoooo on 17/4/19.
 */
@Controller
@RequestMapping(value = "/search")
public class searchAction extends BaseAction {
    @RequestMapping(value = "/showResult",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object showResult(@RequestBody Map contentMap){
        String keyword=contentMap.get("KeyWord").toString().trim();
        System.out.println(keyword);
        List<News> lists=new ArrayList<News>();
        List<String> urls1=new ArrayList<String>();
        lists.add(new News(1,
                "山东58家企业试水“中小股东制”改革 全国首创",
                "董昭",
                "20分钟前",
                null,
                "据山东省国资委主任张斌介绍，参与首批试点的58户企业混合所有制改革方案均按照法律法规设计了规范的公司治理体系。" +
                        "已完成混改的企业普遍构建了“三会一层”定位清晰、权责对等、协同运转、制衡有效的公司治理运行机制。" +
                        "“经过一年多的实践和探索，省属企业混改试点工作整体进展平稳有序，取得积极成效。" +
                        "”张斌举例说，作为试点企业标杆的山东交运集团，目前其职工安置方案已获职工代表大会审议通过，混改工作取得突破性进展。" +
                        "已经完成混改的企业不仅起到了良好的示范引领作用，自身经营状况也得到明显改善。"));
        lists.add(new News(2,
                "山东教育扶贫再出新规：“改善薄弱校”工程启动",
                "董昭",
                "3小时前",
                null,
                "山东对所有中小学校舍维修、加固、重建、改扩建等建设项目中，涉及的土地复垦费、" +
                        "耕地开垦费等24项行政事业性收费和政府性基金予以免收；对建设工程交易服务费等12项经营服务性收费项目予以减收或免收。"));
        urls1.add("http://img5.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T9GD2ODN0008.JPG");
        urls1.add("http://img2.cache.netease.com/photo/0008/2017-03-07/900x600_CEV3T8G92ODN0008.JPG");
        lists.add(new News(3,
                "轴距2874mm 路虎高颜值SUV展前曝光",
                "董昭",
                "20分钟前",
                 urls1,
                "2017上海车展即将开幕，我们在探馆过程中发现了进行伪装的路虎揽胜星脉，该车将在上海车展亮相，这也是该车在国内的首次亮相。" +
                        "1.该车基于捷豹F-PACE的全铝平台打造，揽胜星脉车身长宽高分别为4803x2145x1657mm，轴距则达到2874mm；" +
                        "2.前脸和侧面造型更加接近于揽胜运动版，尾部造型则与揽胜极光有几分相似，不过比极光的层次感更强；" +
                        "3.中控台所有功能被集成进一套双屏触控系统中，可以实现多媒体操控、移动互联、空调控制、全地形选择等功能的操作；" +
                        "4.路虎揽胜星脉将提供有6台动力系统，与之匹配的是ZF的8速自动变速箱，新车还将配备路虎全地形选择系统及四驱系统。"));

        Map<String,Object> resultmap=new HashMap<String, Object>();
        resultmap.put("resultList",lists);
        return successReturnObject(resultmap);
    }
}
