/**
 * Created by llf on 2017/4/16.
 */
app.service('registerService',['$http','routeUtil','ajaxRollback',function ($http,routeUtil,ajaxRollback) {
    var registerService={};
    var RESGISTER='/register/submitInfo';
    var VERIFY='/register/verifyInfo';
    registerService.submitInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(RESGISTER,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    registerService.verifyInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(VERIFY,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    return registerService;
}])