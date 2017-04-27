/**
 * Created by leilei on 2017/4/18.
 */
app.service('draftService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var draftService = {};

    var GET_INIT = '/draft/getInit';
    var GET_CONTENT = '/draft/getContent';
    // var PAGE_REQ = '/draft/pageReq';
    draftService.getInit= function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INIT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    draftService.getContent= function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_CONTENT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    // draftService.pageChange = function (param,success,failed,otherwise) {
    //     routeUtil.postUrl(PAGE_REQ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    // }
    return draftService;
}])