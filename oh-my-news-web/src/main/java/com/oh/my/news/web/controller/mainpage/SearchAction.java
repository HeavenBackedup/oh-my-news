package com.oh.my.news.web.controller.mainpage;

import com.oh.my.news.business.read.manage.ArticleReadManage;
import com.oh.my.news.model.dto.ArticleCategoryDto;
import com.oh.my.news.model.dto.ArticleDto;
import com.oh.my.news.model.dto.EditContent;
import com.oh.my.news.model.dto.EditContentDto;
import com.oh.my.news.model.vo.detail.Article;
import com.oh.my.news.web.util.BaseAction;
import mainpage.News;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dzhaoooo on 17/4/19.
 */
@Controller
@RequestMapping(value = "/search")
public class SearchAction extends BaseAction {
    @Resource
    private ArticleReadManage articleReadManage;

    private static Logger logger = Logger.getLogger(SearchAction.class);


    @RequestMapping(value = "/showResult",consumes = APPLICATION_JSON,method = RequestMethod.POST)
    public @ResponseBody Object showResult(@RequestBody Map searchMap) throws Exception{
        try {
            String keyword = searchMap.get("KeyWord").toString().trim();
            int pageItemNum = 10;
            ArticleDto searchLists = articleReadManage.search(keyword, 1, pageItemNum);
            List<ArticleCategoryDto> searchContents = searchLists.getArticle();
            List<EditContent> editContents = new ArrayList<EditContent>();
            for (ArticleCategoryDto searchList : searchContents) {
                EditContent editContent = new EditContent();
                editContent.setCategoryId(searchList.getCategory().getId());
                editContent.setContentSnapshot(searchList.getArticle().getContentSnapshot());
                editContent.setLabels(searchList.getArticle().getLabels());
                editContent.setTopic(searchList.getArticle().getTopic());
                editContents.add(editContent);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("contents", editContents);
            return successReturnObject(map);
        }catch (Exception e){
            logger.error(e);
            throw e;
        }

    }
}
