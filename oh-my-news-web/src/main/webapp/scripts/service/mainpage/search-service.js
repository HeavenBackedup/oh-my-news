/**
 * Created by Dzhaoooo on 17/4/18.
 */
app.service('searchService',['$http','routeUtil','ajaxRollback',function ($http,routeUtil,ajaxRollback) {
    var searchService={};
    var RESULT_LIST='/search/showResult';
    searchService.search=function (param,success,failed,otherwise) {
        routeUtil.postUrl(RESULT_LIST,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());

    }

    return searchService;
}])