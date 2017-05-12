package com.oh.my.news.web.controller;

import com.oh.my.news.business.read.manage.TransactionReadManage;
import com.oh.my.news.business.read.manage.UserReadManage;
import com.oh.my.news.business.write.dao.WalletWriteDao;
import com.oh.my.news.business.write.manage.TransactionWriteManage;
import com.oh.my.news.model.dto.Wallet;
import com.oh.my.news.model.po.Transaction;
import com.oh.my.news.model.po.TransactionPo;
import com.oh.my.news.web.util.BaseAction;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/4/23.
 */

@Controller
@RequestMapping(value = "/mywallet")
public class MyWalletAction extends BaseAction {
        @Resource
        private TransactionReadManage transactionReadManage;
        @Resource
        private TransactionWriteManage transactionWriteManage;


        @RequestMapping(value = "/setWithdraw", consumes = APPLICATION_JSON, method = RequestMethod.POST)
        //将提现金额写入Wallet表，将该提现事项写入Transaction表，并返回成功或不成功的提示
        public
        @ResponseBody
        Object setWithdraw(@RequestBody Map inputMap) throws Exception{
                int WithdrawMoney= Integer.parseInt(inputMap.get("inputwithdraw").toString());
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                String res = "";
                int code;
                //将该提现事项写入Transaction表

                        transactionWriteManage.addEvents(UserId, null, WithdrawMoney, 0, "提现");

                //将提现金额写入Wallet表

                        code = transactionWriteManage.setWithDraw(UserId, WithdrawMoney);

                        if (code == 1) {
                                res = "提现失败";

                        } else {
                                res = "提现成功";
                        }



                return successReturnObject(res);


        }
        // 将充值金额写入Wallet表，将该充值事项写入Transaction表，并返回成功或不成功的提示

        @RequestMapping(value = "/setRecharge", consumes = APPLICATION_JSON, method = RequestMethod.POST)

        public
        @ResponseBody
        Object setRecharge(@RequestBody Map inputMap)throws Exception {

                int RechargeMoney = Integer.parseInt(inputMap.get("inputrecharge").toString());
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                String res = "";
                int code;
                //将该充值事项写入Transaction表
                        transactionWriteManage.addEvents(UserId, null, RechargeMoney, 0, "充值");

                //将充值金额写入Wallet表
                        code = transactionWriteManage.setRecharge(UserId, RechargeMoney);
                        if (code == 0) {
                                res = "充值成功";

                        } else {
                                res = "充值失败";
                        }

                return successReturnObject(res);

        }


        //读支出事项
        @RequestMapping(value = "/getPayevents", consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public
        @ResponseBody
        Object getPayevents(@RequestBody Map inputMap)throws Exception {
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                List<TransactionPo> PaylistSelf = new ArrayList<TransactionPo>();
                List<TransactionPo> Paylist = new ArrayList<TransactionPo>();
                PaylistSelf= transactionReadManage.getPayeventsSelf(UserId);
                Paylist=transactionReadManage.getPayevents(UserId);
                Paylist.addAll(PaylistSelf);

                return successReturnObject(Paylist);
        }

        //读收入事项
        @RequestMapping(value = "/getIncomeevents", consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public
        @ResponseBody
        Object getIncomeevents(@RequestBody Map inputMap) throws Exception {
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                List<TransactionPo> Incomelist = new ArrayList<TransactionPo>();
                List<TransactionPo> IncomelistSelf = new ArrayList<TransactionPo>();
                System.out.println("action"+UserId);
                IncomelistSelf=transactionReadManage.getIncomeeventsSelf(UserId);
                System.out.println(IncomelistSelf);
                Incomelist = transactionReadManage.getIncomeevents(UserId);
                Incomelist.addAll(IncomelistSelf);
                System.out.println(Incomelist);

                return successReturnObject(Incomelist);
        }

        //从Wallet表得到用户余额
        @RequestMapping(value = "/getFigure", consumes = APPLICATION_JSON, method = RequestMethod.POST)
        public
        @ResponseBody
        Object getFigure(@RequestBody Map inputMap) throws Exception {
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                float figure = 1000;

                        figure = transactionReadManage.getFigure(UserId);

                return successReturnObject(figure);
        }

        //从Wallet表取用户历史最高余额
        @RequestMapping(value = "/getMaxFgigure", consumes = APPLICATION_JSON, method = RequestMethod.POST)

        public
        @ResponseBody
        Object getMaxFigure(@RequestBody Map inputMap) throws Exception{
                int UserId = Integer.parseInt(inputMap.get("userId").toString());
                float maxFigure = 1000;
                        maxFigure = transactionReadManage.getMaxFigure(UserId);

                return successReturnObject(maxFigure);

        }


}
