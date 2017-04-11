/**
 * Created by shj on 2017/4/11.
 */
app.controller('templateController',['$scope','templateService',function ($scope,templateService) {



    $scope.init = function () {
        $scope.input = "";
        $scope.inputRes = "";
        $scope.pagination = {};
        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 2;
        $scope.pagination.maxSize = 5;
        moment.locale("zh-cn");
    }


    $scope.inputCommit = function () {
        var param = {};
        param.value = $scope.input;
       templateService.getInput(param,function (data) {
           $scope.inputRes = data;
       },function(data){
           console.info("error:  "+data)
       })
    }

    $scope.pageChange = function () {
        var param = {};
        param.currentPage = $scope.pagination.currentPage;
        templateService.pageChange(param,function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            $scope.pageItems = data.items;
        },function (data) {
            console.info("error: "+data)
        });
    }





}])