/**
 * Created by Prometheus on 2017/4/20.
 */
app.service('detailService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){

    var detailService = {};
    var PAGE_REQ = '/detail/pageReq';
    var ARTICAL_REQ = '/detail/articalReq';
    var SUBMIT = '/detail/submit';

    detailService.pageChange = function (param,success,failed,otherwise) {
        routeUtil.postUrl(PAGE_REQ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    };
    detailService.articalRequest = function (param,success,failed,otherwise) {
        routeUtil.postUrl(ARTICAL_REQ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    };
    detailService.submit = function (param,success,failed,otherwise) {
        routeUtil.postUrl(SUBMIT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    };


    return detailService;
}]);