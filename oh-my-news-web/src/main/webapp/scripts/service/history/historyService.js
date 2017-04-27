/**
 * Created by leilei on 2017/4/19.
 */
app.service('historyService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var historyService = {};
    var GET_CONTENT = '/history/getContent';
    var GET_INIT = '/history/getInit';
    historyService.getContent = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_CONTENT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    historyService.getInit= function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INIT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return historyService;
}])
