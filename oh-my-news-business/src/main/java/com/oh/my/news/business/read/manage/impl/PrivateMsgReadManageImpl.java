package com.oh.my.news.business.read.manage.impl;

import com.oh.my.news.business.read.dao.PrivateMsgReadDao;
import com.oh.my.news.business.read.manage.PrivateMsgReadManage;
import com.oh.my.news.model.dto.PrivateMessage;
import com.oh.my.news.model.po.PrivateMsgSnapshot;
import com.oh.my.news.model.vo.PrivateMsg;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/5/7.
 */
@Service
public class PrivateMsgReadManageImpl implements PrivateMsgReadManage {
    @Autowired
    private PrivateMsgReadDao privateMsgReadDao;
   public List<PrivateMessage> getPrivateMsg(int userId)throws Exception{
//       return privateMsgReadDao.queryPrivateMessage(userId);

//       List<PrivateMsgSnapshot> privateMsgSnapshotTargets = privateMsgReadDao.queryTargetIdsByUserId(userId,null);
       List<PrivateMsgSnapshot> privateMsgSnapshotSources = privateMsgReadDao.querySouceIdsByUserId(userId,null);
       List<PrivateMessage> res = privateMsgReadDao.querySourceMessageByIds(distinctTargetId(privateMsgSnapshotSources));
       return res;
   }
   public List<PrivateMessage> getExMsg(int sourceUserId,int targetUserId)throws Exception{
       List<PrivateMessage> targetPrivateMsg = privateMsgReadDao.querySourceMsgBySourceIdAndTargetId(sourceUserId,targetUserId);
       List<PrivateMessage> sourcePrivateMsg = privateMsgReadDao.querySourceMsgBySourceIdAndTargetId(targetUserId,sourceUserId);
       if(targetPrivateMsg.size()==0)throw new Exception("source private Msg is null");
       PrivateMessage target = targetPrivateMsg.get(0);
       List<PrivateMessage> res = new ArrayList<PrivateMessage>();
       for(PrivateMessage t:sourcePrivateMsg){
           if(t.getDate().getTime()<=target.getDate().getTime()){
               res.add(t);
           }
       }
        res.addAll(targetPrivateMsg);
       Collections.sort(res, new Comparator<PrivateMessage>() {
           @Override
           public int compare(PrivateMessage o1, PrivateMessage o2) {
               return o1.getDate().compareTo(o2.getDate());
           }
       });
       res.remove(0);
       return res;
   }


    @Override
    public List<PrivateMessage> getReadedPrivateMsg(int userId) throws Exception {
//        List<PrivateMsgSnapshot> privateMsgSnapshotSources = privateMsgReadDao.querySouceIdsByUserId(userId,1);
//        List<PrivateMsgSnapshot> privateMsgSnapshotTargets = privateMsgReadDao.queryTargetIdsByUserId(userId,1);
//        List<PrivateMessage> privateMessageSource = privateMsgReadDao.querySourceMessageByIds(distinctTargetId(privateMsgSnapshotSources));
//        privateMessageSource.addAll(privateMsgReadDao.queryTargetMessageByIds(distinctTargetId(privateMsgSnapshotTargets)));
//        return privateMessageSource;
        List<PrivateMsgSnapshot> privateMsgSnapshotSources = privateMsgReadDao.querySouceIdsByUserId(userId,1);
        List<PrivateMessage> res = privateMsgReadDao.querySourceMessageByIds(distinctTargetId(privateMsgSnapshotSources));
        return res;


    }

    @Override
    public List<PrivateMessage> getUnReadedPrivateMsg(int userId) throws Exception {
//        List<PrivateMsgSnapshot> privateMsgSnapshotSources = privateMsgReadDao.querySouceIdsByUserId(userId,0);
//        List<PrivateMsgSnapshot> privateMsgSnapshotTargets = privateMsgReadDao.queryTargetIdsByUserId(userId,0);
//        List<PrivateMessage> privateMessageSource = privateMsgReadDao.querySourceMessageByIds(distinctTargetId(privateMsgSnapshotSources));
//        privateMessageSource.addAll(privateMsgReadDao.queryTargetMessageByIds(distinctTargetId(privateMsgSnapshotTargets)));
//        return privateMessageSource;
        List<PrivateMsgSnapshot> privateMsgSnapshotSources = privateMsgReadDao.querySouceIdsByUserId(userId,0);
        List<PrivateMessage> res = privateMsgReadDao.querySourceMessageByIds(distinctTargetId(privateMsgSnapshotSources));
        return res;
    }

    private List<Integer> distinctTargetId(List<PrivateMsgSnapshot> sourcePrivateMsgSnapshots ){
        Map<Integer,PrivateMsgSnapshot> map = new HashedMap();
        for(PrivateMsgSnapshot msgSnapshot:sourcePrivateMsgSnapshots){
            if(map.get(msgSnapshot.getTargetId())==null){
                map.put(msgSnapshot.getTargetId(),msgSnapshot);
            }else if(map.get(msgSnapshot.getTargetId()).getDate().getTime()>msgSnapshot.getDate().getTime()){
                map.put(msgSnapshot.getTargetId(),msgSnapshot);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(PrivateMsgSnapshot p:map.values()){
            res.add(p.getId());
        }
        if(CollectionUtils.isEmpty(res))
            res.add(-1);
        return res;
    }
}
