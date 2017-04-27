/**
 * Created by fanfan on 2017/4/23.
 */
app.service('fansService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var fansService = {};
    var GET_FANSINFO = '/fansPage/getFans';

    fansService.getInfo = function (param,success,failed,otherwise) {
        // alert('servicefans'+angular.toJson(param));
        console.log('service'+angular.toJson(param));
        routeUtil.postUrl(GET_FANSINFO,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    return fansService;
}])