/**
 * Created by shj on 2017/4/15.
 */
app.service('editService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){

    var editService = {};
    var GET_PICS = '/edit/getPics';
    var EDIT_COMMIT = '/edit/editCommit';
    var PUBLISH = '/edit/publish';
    var GET_ARTICLE = '/edit/getArticle';

    editService.getPics = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_PICS,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    editService.commit = function (param,success,failed,otherwise) {
        routeUtil.postUrl(EDIT_COMMIT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    editService.publish = function (param,success,failed,otherwise) {
        routeUtil.postUrl(PUBLISH,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    editService.getArticle = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_ARTICLE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return editService;
}])