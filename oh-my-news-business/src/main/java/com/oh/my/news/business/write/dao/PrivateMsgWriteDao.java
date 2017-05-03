package com.oh.my.news.business.write.dao;

import com.oh.my.news.model.po.PrivateMessage;

/**
 * Created by shj on 2017/5/3.
 */
public interface PrivateMsgWriteDao {

    Integer insertPrivateMessageReturnId(PrivateMessage privateMessage)throws Exception;
}
