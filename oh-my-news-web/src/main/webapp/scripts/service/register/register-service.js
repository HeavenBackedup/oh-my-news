/**
 * Created by llf on 2017/4/16.
 */
app.service('registerService',['$http','routeUtil','ajaxRollback',function ($http,routeUtil,ajaxRollback) {
    var registerService={};
    var RESGISTER='/register/submitInfo';
    var VERIFYNAME='/register/verifynameInfo';
    var VERIFYEMAIL='/register/verifyemailInfo';
    registerService.submitInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(RESGISTER,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    registerService.verifynameInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(VERIFYNAME,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    registerService.verifyemailInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(VERIFYEMAIL,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    return registerService;
}])