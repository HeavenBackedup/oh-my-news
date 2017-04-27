/**
 * Created by fanfan on 2017/4/26.
 */
app.controller('hbTabsetController',['$scope','$controller',function ($scope,$controller){

    $controller('appController', {$scope: $scope});

}])