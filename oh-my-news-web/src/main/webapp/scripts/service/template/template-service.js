/**
 * Created by shj on 2017/4/11.
 */
app.service('templateService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var templateService = {};
    var GET_INPUT = '/template/getInput';

    templateService.getInput = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INPUT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }



    return templateService;
}])