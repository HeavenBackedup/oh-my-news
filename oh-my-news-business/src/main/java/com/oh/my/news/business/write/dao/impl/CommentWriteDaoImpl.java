package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.manage.CommentReadManage;
import com.oh.my.news.business.write.dao.CommentWriteDao;
import com.oh.my.news.model.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Dzhaoooo on 17/5/6.
 */
@Repository
public class CommentWriteDaoImpl implements CommentWriteDao {
    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public Integer insertCommentReturnId(Comment comment) throws Exception {
        return (Integer)sqlMapClient.insert("comment_sqlMap.insert_comment",comment);
    }

    public void updateRootCommentId(Integer id) throws Exception {
        sqlMapClient.update("comment_sqlMap.update_root_comment_id",id);
    }
}
