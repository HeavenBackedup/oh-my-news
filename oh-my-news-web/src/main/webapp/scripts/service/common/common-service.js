/**
 * Created by shj on 2017/4/15.
 */
app.service('commonService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){

    var commonService = {};
    var GET_CATEGORIES = '/common/getCategories';

    commonService.getCategories = function (success,failed,otherwise) {
        routeUtil.postUrl(GET_CATEGORIES,null,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    return commonService;
}])