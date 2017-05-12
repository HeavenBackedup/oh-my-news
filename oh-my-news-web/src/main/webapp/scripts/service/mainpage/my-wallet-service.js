/**
 * Created by Administrator on 2017/4/24.
 */
app.service('mywalletService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var mywalletService = {};
    var GET_PAYEVENTS='/mywallet/getPayevents';
    var GET_INCOMEEVENTS='/mywallet/getIncomeevents';
    var GET_FIGURE='/mywallet/getFigure';
    var GET_MAXFIGURE='/mywallet/getMaxFgigure';
    var SET_WITHDRAW='/mywallet/setWithdraw';
    var SET_RECHARGE='/mywallet/setRecharge';


    mywalletService.getPayevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_PAYEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.getIncomeevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INCOMEEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.getFigure = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_FIGURE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.getMaxFigure = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_MAXFIGURE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.setWithdraw = function (param,success,failed,otherwise) {
        routeUtil.postUrl(SET_WITHDRAW,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.setRecharge = function (param,success,failed,otherwise) {
        routeUtil.postUrl(SET_RECHARGE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }





    return mywalletService;
}])
