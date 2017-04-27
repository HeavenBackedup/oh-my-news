/**
 * Created by yanyue on 2017/4/23.
 */
app.service('privatemsgService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var privatemsgService = {};
    var GET_PRIVATE_MSG = '/privatemsg/getPrivateMsg';
    var GET_EX_MSG = '/privatemsg/getExMsg';
    var POST_PRIVATE_MSG = '/privatemsg/postPrivateMsg';
    //请求和所有人的私信的列表
    privatemsgService.getPrivateMsg = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_PRIVATE_MSG,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    //请求和某一个人的私信列表
    privatemsgService.getExMsg = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_EX_MSG,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    //发送一条新的私信
    privatemsgService.postPrivateMsg = function (param,success,failed,otherwise) {
        routeUtil.postUrl(POST_PRIVATE_MSG,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }



    return privatemsgService;
}])