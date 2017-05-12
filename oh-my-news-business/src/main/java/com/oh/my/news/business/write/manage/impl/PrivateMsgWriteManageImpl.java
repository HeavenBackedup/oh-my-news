package com.oh.my.news.business.write.manage.impl;

import com.oh.my.news.business.write.dao.PrivateMsgWriteDao;
import com.oh.my.news.business.write.manage.PrivateMsgWriteManage;
import com.oh.my.news.model.po.PrivateMessagePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class PrivateMsgWriteManageImpl implements PrivateMsgWriteManage {
    @Autowired
    private PrivateMsgWriteDao privateMsgWriteDao;


    @Override
     public void sendMsg(int sourceId,int targetId,String content)throws Exception {
         PrivateMessagePo privateMessagePo=new PrivateMessagePo();
         privateMessagePo.setTargetId(targetId);
         privateMessagePo.setSourceId(sourceId);
         privateMessagePo.setContent(content);
        System.out.println(privateMessagePo);
         privateMsgWriteDao.insertPrivateMessageReturnId(privateMessagePo);

     }

}
