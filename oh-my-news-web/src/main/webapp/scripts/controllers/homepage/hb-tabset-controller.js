/**
 * Created by fanfan on 2017/4/26.
 */
app.controller('hbTabsetController',['$scope','$controller','hbTabSet',function ($scope,$controller,hbTabSet){

    $controller('appController', {$scope: $scope});
    $scope.index = hbTabSet;

}])