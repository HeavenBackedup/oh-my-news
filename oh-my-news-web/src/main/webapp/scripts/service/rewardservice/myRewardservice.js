/**
 * Created by Administrator on 2017/4/21.
 */
app.service('my_rewardService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var my_rewardService= {};
    var GET_INPUT = '/my_reward/getInput';
   // var PAGE_REQ = '/my_reward/pageReq';
    my_rewardService.getInput = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INPUT,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    // templateService.pageChange = function (param,success,failed,otherwise) {
    //     routeUtil.postUrl(PAGE_REQ,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    // }



    return my_rewardService;
}])