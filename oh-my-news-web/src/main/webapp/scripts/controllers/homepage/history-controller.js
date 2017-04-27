/**
 * Created by shj on 2017/4/10.
 */
app.controller('historyController',['$scope','historyService',function ($scope,historyService) {
    $scope.init=function () {
        $scope.selectValue = 0;
        $scope.getInit();
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 3;
    }
    $scope.getInit=function () {
        historyService.getInit(null, function (data) {
            console.info(angular.toJson(data));
            //console.info(angular.toJson(param));
            $scope.messages = data;
        }, function (data) {
            console.info("error: " + data)
        });
    }
    $scope.getRefreshContent=function () {
        var param = {};
        param.currentPage = $scope.pagination.currentPage;
        param.value = $scope.selectValue;
        historyService.getContent(param, function (data) {
            console.info(angular.toJson(data));
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            //console.info(angular.toJson(param));
            $scope.messages = data.content;
        }, function (data) {
            console.info("error: " + data)
        });


    }
    $scope.selectTest=function () {
        $scope.getRefreshContent();
        $scope.pageChange = function () {
            $scope.getRefreshContent();
        }
    }
}])