/**
 * Created by shj on 2017/4/10.
 */
app.controller('loginController',['$scope','$state',function ($scope,$state) {
    $scope.go=function () {
        alert('fuck');
        $state.go('app.personalHomepage.hpTabset.myHomePage',{userId:1});
    }


}])