/**
 * Created by fanfan on 2017/4/26.
 */
app.service('concernService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var concernService = {};
    var GET_CONCERNINFO = '/concernPage/getConcern';

    concernService.getInfo = function (param,success,failed,otherwise) {
        // alert('servicefans'+angular.toJson(param));
        console.log('service'+angular.toJson(param));
        routeUtil.postUrl(GET_CONCERNINFO,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    return concernService;
}])