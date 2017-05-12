/**
 * Created by shj on 2017/4/10.
 */
app.controller('likeCollectController',['$scope','likeCollectService','user','$state','content',function ($scope,likeCollectService,user,$state,content) {
    $scope.init=function () {
        $scope.selectValue = 0;
        $scope.userId = user.getId();
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 3;
        $scope.getInit();

    }
    $scope.getInit=function () {

        if($scope.userId==0){
            $state.go('login');
        }else {
            param = {};
            param.id = $scope.userId;
            likeCollectService.getInit(param, function (data) {
                console.info(angular.toJson(data));
                $scope.pagination.totalItems = data.pagination.totalItems;
                $scope.pagination.currentPage = data.pagination.currentPage;
                $scope.messages = data.contents;
            }, function (data) {
                console.info("error: " + data)
            });
        }

    }
    $scope.getCollect=function () {
        var param = {};
        param.id = $scope.userId;
        param.currentPage = $scope.pagination.currentPage;
        param.value = $scope.selectValue;
        likeCollectService.getContent(param, function (data) {
            console.info(angular.toJson(data));
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            //console.info(angular.toJson(param));
            $scope.messages = data.contents;
        }, function (data) {
            console.info("error: " + data)
        });
    }
    $scope.getRefreshContent=function () {
        $scope.getCollect();


    }
    $scope.selectTest=function () {
        $scope.getCollect();
    }

    $scope.pageChange=function () {
        $scope.getCollect();
    }

    $scope.editCollect=function (id) {
        $state.go('app.detail',{articleId:id});
    }
}])