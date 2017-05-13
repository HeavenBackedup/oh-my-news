/**
 * Created by shj on 2017/4/10.
 */
app.controller('historyController',['$scope','historyService','user','$state','content',function ($scope,historyService,user,$state,content) {
    $scope.init=function () {
        $scope.selectValue = 0;
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 3;
        $scope.userId=$state.params.userId;
        $scope.getInit();

    }
    $scope.getInit=function () {
        if((isNaN($scope.userId)||$scope.userId<=0)){
            $scope.id.paramsUserId = user.getParamId();

        }else {
            user.setParamId($scope.userId);
        }
        if($scope.userId==-1){
            alert("个人主页跳转出错，将返回新闻主页");
            $state.go('main');
        }
        if($scope.userId==0){
            $state.go('login');
        }else{
            var param={};
            param.id=$scope.userId;
            historyService.getInit(param, function (data) {
                $scope.pagination.totalItems = data.pagination.totalItems;
                $scope.pagination.currentPage = data.pagination.currentPage;
                $scope.messages = data.contents;
            }, function (data) {
                console.info("error: " + data)
            });
        }

    }
    $scope.getRefreshContent=function () {
        $scope.getHistory();


    }



    $scope.getHistory = function () {
        var param = {};
        param.id=$scope.userId;
        param.currentPage = $scope.pagination.currentPage;
        param.value = $scope.selectValue;
        historyService.getContent(param, function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            //console.info(angular.toJson(param));
            $scope.messages = data.contents;
        }, function (data) {
            console.info("error: " + data)
        });
    }

    $scope.pageChange =function () {
        $scope.getHistory();
    }

    $scope.selectTest=function () {
        $scope.getHistory();
    }

    $scope.editHistory=function (id) {
        $state.go('app.detail',{articleId:id});
    }
}])