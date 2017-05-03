/**
 * Created by fanfan on 2017/4/26.
 */
app.controller('assetHomePageController',['$scope','$controller',function ($scope,$controller){

        $controller('appController', {$scope: $scope});

        $scope.userInfo=$scope.userInfoOfLogin;
        if($scope.show==undefined){
                $scope.show = {};
        }

        $scope.show.editable=false;

}])