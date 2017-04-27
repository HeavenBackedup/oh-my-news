/**
 * Created by leilei on 2017/4/20.
 */
app.service('likeCollectService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var likeCollectService = {};
    var GET_CONTENT = '/like_collect/getContent';
    var GET_INIT = '/like_collect/getInit';
    likeCollectService.getContent = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_CONTENT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    likeCollectService.getInit= function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INIT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return likeCollectService;
}])
