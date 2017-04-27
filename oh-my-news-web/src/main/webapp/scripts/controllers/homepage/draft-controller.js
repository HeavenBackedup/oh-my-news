/**
 * Created by shj on 2017/4/10.
 */
app.controller('draftController',['$scope','draftService',function ($scope,draftService) {
    $scope.init=function () {
        $scope.selectValue = 0;
        $scope.getInit();
        $scope.pagination = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 3;
    }
    $scope.getInit=function () {
        draftService.getInit(null, function (data) {
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
        draftService.getContent(param, function (data) {
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
    // $scope.pageChange = function () {
    //     var param = {};
    //     param.currentPage = $scope.pagination.currentPage;
    //     draftService.pageChange(param,function (data) {
    //         $scope.pagination.totalItems = data.pagination.totalItems;
    //         $scope.pagination.currentPage = data.pagination.currentPage;
    //         $scope.pageItems = data.items;
    //     },function (data) {
    //         console.info("error: "+data)
    //     });
    // }

   /* $scope.time= function (aa) {
        var param = {};
        param.value =aa;
        draftService.getContent(param, function (data) {
            console.info(angular.toJson(data));
            //console.info(angular.toJson(param));
            $scope.messages = data;
        }, function (data) {
            console.info("error: " + data)
        });
    }*/
app.controller('draftController',['$scope',function ($scope) {
}])