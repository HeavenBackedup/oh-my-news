package com.oh.my.news.business.read.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.oh.my.news.business.read.dao.WalletReadDao;
import com.oh.my.news.business.write.dao.WalletWriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/5/5.
 */
@Repository
public class WalletReadDaoImpl implements WalletReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public float getFigure(int userId) throws Exception{

        float figure=(Float) sqlMapClient.queryForObject("wallet_sqlMap.queryfigure_wallet_by_id",userId);

        return figure;
    }

    public float getMaxFigure(int userId) throws Exception{
        System.out.println(sqlMapClient);
        System.out.println(sqlMapClient.queryForObject("wallet_sqlMap.queryMaxfigure_wallet_by_id",userId));

        float maxFigure=(Float) sqlMapClient.queryForObject("wallet_sqlMap.queryMaxfigure_wallet_by_id",userId);

        return maxFigure;
    }


}
