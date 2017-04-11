/**
 * Created by shj on 2017/4/12.
 */
app.controller('errorController',function ($scope,$state,error) {

    $scope.init = function () {
        $scope.data = error.getData();
    }



    $scope.destroy = function () {
        error.clearData();
    }

    $scope.$on("$destroy",function(){
        console.info("error destroyed");
        $scope.destroy();
    })

})