/**
 * Created by shj on 2017/4/10.
 */
app.controller('draftController',['$scope','draftService','user','$state','content',function ($scope,draftService,user,$state,content) {
    $scope.init=function () {
        // $scope.selectValue = 0;
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 3;
        $scope.userId=user.getId();
        $scope.getInit();

    }
    $scope.getInit=function () {
        if($scope.userId==0){
            $state.go('login');
        }else {
            var param={};
            param.id=$scope.userId;
            draftService.getInit(param, function (data) {
                $scope.pagination.totalItems = data.pagination.totalItems;
                $scope.pagination.currentPage = data.pagination.currentPage;
                $scope.messages = data.contents;
            }, function (data) {
                console.info("error: " + data)
            });
        }

    }


    $scope.getRefreshContent=function () {
        $scope.getDraft();

    }

    $scope.getDraft=function () {
        var param = {};
        param.id=userId;
        param.currentPage = $scope.pagination.currentPage;
        // param.value = $scope.selectValue;
        draftService.getContent(param, function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            //console.info(angular.toJson(param));
            $scope.messages = data.contents;
        }, function (data) {
            console.info("error: " + data)
        });

    }

    $scope.pageChange=function () {
        $scope.getDraft();
    }

    $scope.selectTest=function () {
        $scope.getDraft();
    }

    $scope.editDraft=function (id) {
        content.setId(id);
        $state.go('app.edit');

    }
}])