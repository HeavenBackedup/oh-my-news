/**
 * Created by Administrator on 2017/4/24.
 */
app.service('mywalletService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var mywalletService = {};
    var GET_PAYEVENTS='/mywallet/getPayevents';
    var GET_INCOMEEVENTS='/mywallet/getIncomeevents';

    mywalletService.getPayevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_PAYEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mywalletService.getIncomeevents = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INCOMEEVENTS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return mywalletService;
}])
