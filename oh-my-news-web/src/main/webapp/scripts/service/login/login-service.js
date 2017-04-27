/**
 * Created by llf on 2017/4/18.
 */
app.service('loginService',['$http','routeUtil','ajaxRollback',function ($http,routeUtil,ajaxRollback) {
    var loginService={};
    var LOGIN='/login/submitInfo';
    loginService.submitInfo=function (param,success,failed,otherwise) {
        routeUtil.postUrl(LOGIN,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack())
    }
    return loginService;
}])