/**
 * Created by Administrator on 2017/4/24.
 */
app.service('my_wallet_Service',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var MyWalletSearvice = {};

    var GET_PAYEVENTS='/mywallet/getPayevents';
    var GET_WITHDRAW='/mywallet/getWithdraw';
    var GET_RECHAGE='/mywallet/getRecharge';
    var GET_INCOMEEVENTS='/mywallet/getIncomeevents';

    MyWalletService.getWithdraw = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_WITHDRAW,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    MyWalletService.getRecharge = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_RECHAGE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    MyWalletService.getPayevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_PAYEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    MyWalletService.getIncomeevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INCOMEEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return MyWalletService;
}])
