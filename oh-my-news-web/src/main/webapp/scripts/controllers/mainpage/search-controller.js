/**
 * Created by Dzhaoooo on 17/4/18.
 */
app.controller('searchController',['$scope','$stateParams','searchService',function ($scope,$stateParams,searchService) {
    $scope.init=function () {
        $scope.searchText =$stateParams.search;  //路由传参结果显示在输入框中
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.searchItems={};
        $scope.totalItems=200;
        $scope.maxSize=5;
        $scope.currentPage=1;
        //初始化加载方法
        $scope.showSearch();
    }
    $scope.showSearch=function () {
        var param={};
        param.KeyWord=$scope.searchText;
        searchService.search(param,function (data) {
            $scope.searchItems=data.contents;
        },function (data) {
            console.info("error:"+data);
        });
    }
    //点击搜索按钮触发的事件
    $scope.search=function () {
        var param={};
        param.KeyWord=$scope.searchText;
        searchService.search(param,function (data) {
            $scope.searchItems=data.contents;
        },function (data) {
            console.info("error:"+data);
        });

    }

}]);