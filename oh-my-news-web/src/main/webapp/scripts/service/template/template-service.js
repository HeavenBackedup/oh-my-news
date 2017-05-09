 /**
 * Created by shj on 2017/4/11.
 */
app.service('templateService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var templateService = {};
    var GET_INPUT = '/template/getInput';
    var PAGE_REQ = '/template/pageReq';
    templateService.getInput = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INPUT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    templateService.pageChange = function (param,success,failed,otherwise) {
        routeUtil.postUrl(PAGE_REQ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    templateService.getTemplateJson = function (success,failed) {
        routeUtil.getResource('template.json',success,failed);

    }



    return templateService;
}])