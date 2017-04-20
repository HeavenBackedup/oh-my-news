/**
 * Created by fanfan on 2017/4/17.
 */
app.service('homeService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var homeService = {};
    var GET_USERINFO = '/homePage/common';
    var CONFIRM_SIGNATURE='/homePage/sendInformation'
    homeService.getInfo = function (param,success,failed,otherwise) {
        alert('service'+angular.toJson(param));
        console.log('service'+angular.toJson(param));
        routeUtil.postUrl(GET_USERINFO ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    homeService.confirmInformation=function (param,success,failed,otherwise) {
        routeUtil.postUrl(CONFIRM_SIGNATURE ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return homeService;
}])