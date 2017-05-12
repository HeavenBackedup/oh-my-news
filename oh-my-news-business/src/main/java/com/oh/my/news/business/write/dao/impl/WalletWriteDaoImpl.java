package com.oh.my.news.business.write.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.write.dao.WalletWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/7.
 */
@Repository
public class WalletWriteDaoImpl implements WalletWriteDao{
@Autowired
@Qualifier(value = "sqlMapClientWrite")
private SqlMapClient sqlMapClient;
    @Override
    public Integer insertWalletByUserId(Integer userId)throws Exception{

        return (Integer)sqlMapClient.insert("wallet_sqlMap.insert_wallet_by_id",userId);


    }
    @Override
    public void updateWalletFigure(Integer userId,Integer sum)throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println("uss"+userId);
        System.out.println("suum"+sum);
        map.put("userId",userId);
        map.put("Sum",sum);
        sqlMapClient.update("wallet_sqlMap.updatefigure_wallet_by_id", map);


    }
    @Override
    public void setWalletMaxFigure(Integer userId)throws Exception{

        sqlMapClient.update("wallet_sqlMap.updateMaxfigure_wallet_by_id", userId);
    }




}
