/**
 * Created by shj on 2017/4/14.
 */
app.service('fileService',['$http','routeUtil','ajaxRollback',function($http,routeUtil,ajaxRollback,$timeout){
    var fileService = {}
    var FILE_UPLOAD = '/file/upload';

    fileService.fileUpload = function (file,success,failed,progress) {
        routeUtil.fileUpload(FILE_UPLOAD,file,ajaxRollback.successRollBack(success,failed),progress);
    }

    return fileService;

}])