
app.controller('mainController',['$scope','$state','mainService',function ($scope,$state,mainService) {
    $scope.init = function () {
        $scope.pageIndex=0;
        $scope.newsItems={}; //新闻列表
        $scope.searchContent=""; //搜索框输入内容
        $scope.pagination = {};
        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 2;
        $scope.pagination.maxSize = 5;
        $scope.picNumber=0;
        $scope.collectItems={}; //收藏排行列表
        $scope.markItems={};    //评论排行列表
        $scope.lastItems={};    //最新动态列表
        //初始化加载函数
        $scope.collectList();
        $scope.markList();
        $scope.lastList();
        $scope.showOtherPage(0);
        $scope.myInterval = 5000;
        $scope.noWrapSlides = true;
        $scope.active = 0;
        $scope.slides = [];

    };
    //搜索模块
    $scope.search=function () {
        //带参跳转到search.html
        $state.go('search',{search:$scope.searchContent});
    };
    //分页模块
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
    };
    //新闻显示模块
    $scope.showOtherPage=function (index) {
        var param={};
        param.pageIndex=index;
        mainService.showOtherPage(param,function (data) {
            console.info(angular.toJson(data));
            $scope.newsItems=data.newList;

        },function (data) {
            console.info("error: "+data)
        });

    }

  //收藏排行模块
    $scope.collectList=function () {
        var param={};
        param.index=1;
        mainService.collectList(param,function (data) {
            $scope.collectItems=data.collectList;

        },function (data) {
            console.info("error: "+data)
        });
    }
    //评论排行模块
    $scope.markList=function () {
        var param={};
        param.index=2;
        mainService.markList(param,function (data) {
            $scope.markItems=data.markList;
        },function (data) {
            console.info("error: "+data)
        });
    }
    //最新动态模块
    $scope.lastList=function () {
        var param={};
        param.index=3;
        mainService.lastList(param,function (data) {
            $scope.lastItems=data.lastList;
        },function (data) {
            console.info("error: "+data)
        });
    }
    //点击刷新模块
    $scope.refreshAll=function () {
        $scope.collectList();
        $scope.markList();
        $scope.lastList();
    }
}]);