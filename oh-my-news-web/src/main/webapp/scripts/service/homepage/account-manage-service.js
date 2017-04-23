/**
 * Created by wangyan on 2017/4/11.
 */
app.service('accountManageService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){

    var accountManageService = {};
    var GET_USER='/accountManage/getUser';
    var GET_VERIFYINFO='/accountManage/getVerifyInfo';
    var GET_INPUT_USER = '/accountManage/getInputUser';

    //请求用户初始信息
    accountManageService.getUser= function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_USER,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }
    //验证用户名是否存在
    accountManageService.getVerifyInfo = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_VERIFYINFO,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }


    //提交用户修改信息
    accountManageService.getInputUser = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_INPUT_USER,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    //获取本地静态地址文件
    accountManageService.getAddressJson = function (success,failed) {
        routeUtil.getResource('address.json',success,failed);

    }

     // 访问静态资源
    // accountManageService.updateAddress=function(success){
    //     $http({
    //         method: 'GET',
    //         url: 'resource/address.json',
    //     }).then(function(data, status, headers, config) {
    //         console.info('success:  '+success);
    //         console.log("success...");
    //         console.log(data);
    //         success(data);
    //     },function(data, status, headers, config) {
    //         console.log("error...");
    //     });
    // };

    return accountManageService;
}])