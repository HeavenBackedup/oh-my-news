/**
 * Created by yanyue on 2017/4/24.
 */
app.service('myconcernService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback){
    var myconcernService = {};
    var GET_CONCERN_USER = '/myconcern/getConcernUser';
    var GET_HOMEPAGE = '/myconcern/getHomepage';
    //请求关注人的列表
    myconcernService.getConcernUser = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_CONCERN_USER,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    //请求某一个人的主页
    myconcernService.getHomepage = function (param,success,failed,otherwise) {
        routeUtil.postUrl(GET_HOMEPAGE,param,ajaxRollback.successRollBack(success,failed,otherwise),ajaxRollback.errorRollBack());
    }

    return myconcernService;
}])