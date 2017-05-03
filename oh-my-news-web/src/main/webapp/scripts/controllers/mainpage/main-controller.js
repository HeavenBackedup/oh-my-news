
app.controller('mainController',['$scope','$state','$stateParams','mainService','htmlParseService',function ($scope,$state,$stateParams,mainService,htmlParseService) {
    $scope.init = function () {
        $scope.pageIndex=0;
        $scope.newsItems={}; //新闻列表
        $scope.searchContent=""; //搜索框输入内容
        $scope.pagination = {};
        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 5;
        $scope.picNumber=0;
        $scope.collectItems={}; //收藏排行列表
        $scope.markItems={};    //评论排行列表
        $scope.lastItems={};    //最新动态列表
        //初始化加载函数
        initParams();
        $scope.collectList();
        $scope.markList();
        $scope.lastList();
        $scope.myInterval = 5000;
        $scope.noWrapSlides = true;
        $scope.active = 0;
        $scope.slides = [];
        $scope.topic={};
        $scope.author={};
        $scope.date={};
        $scope.picUrl={};
        $scope.text={};

        $scope.totalItems=200;
        $scope.maxSize=5;
        $scope.currentPage=1;
        $scope.index=0;
        $scope.categoryId=$stateParams.categoryId;


    };

    var initParams=function () {
        if($stateParams.categoryId==null){
            $scope.changePage(0,1);
        }else {
            $scope.changePage(categoryId,1);
        }
    };
    //搜索模块
    $scope.search=function () {
        //带参跳转到search.html
        $state.go('search',{search:$scope.searchContent});
    };

    $scope.changePage=function (index,currentPage) {
        var param = {};
        param.pageIndex=index;
        param.currentPage=currentPage;
        mainService.showOtherPage(param,function (data) {
            console.info(angular.toJson(data));
            $scope.currentPage=data.pagination.currentPage;
            $scope.index=data.pageIndex;
            $scope.totalItems=data.pagination.totalItems;
            $scope.newsItems=data.newList;
            angular.forEach($scope.newsItems,function (item, index,array) {
                var parseRes=htmlParseService.parseHtml(item.htmlContent);
                item.picUrl = parseRes.img;
                item.text = parseRes.text;
            })

        },function (data) {
            console.info("error: "+data)
        });

    }


  //收藏排行模块
    $scope.collectList=function () {
        var param={};
        param.index=1;
        console.info('mainService: '+angular.toJson(mainService));
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