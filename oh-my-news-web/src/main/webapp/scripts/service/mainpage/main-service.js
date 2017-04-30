/**
 * Created by Dzhaoooo on 17/4/13.
 */

app.service('mainService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var mainService = {};
    var SHOW_PAGE = '/mainpage/showPage';
    var COLLECT_LIST='/mainpage/collectList';
    var MARK_LIST='/mainpage/markList';
    var LAST_LIST='/mainpage/lastList';
    mainService.showOtherPage = function (param,success,failed,otherwise) {
        routeUtil.postUrl(SHOW_PAGE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    mainService.collectList=function (param,success,failed,otherwise) {
        routeUtil.postUrl(COLLECT_LIST,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    mainService.markList=function (param,success,failed,otherwise) {
        routeUtil.postUrl(MARK_LIST,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());

    }
    mainService.lastList=function (param,success,failed,otherwise) {
        routeUtil.postUrl(LAST_LIST,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());

    }
    return mainService;
}])