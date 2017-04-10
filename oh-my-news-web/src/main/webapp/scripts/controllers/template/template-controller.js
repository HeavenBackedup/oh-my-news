/**
 * Created by shj on 2017/4/11.
 */
app.controller('templateController',['$scope','templateService',function ($scope,templateService) {



    $scope.init = function () {
        $scope.input = "";
        $scope.inputRes = "";
    }


    $scope.inputCommit = function () {
        var param = {};
        param.value = $scope.input;
       templateService.getInput(param,function (data) {
           $scope.inputRes = data;
       },function(data){
           console.info("error:  "+data)
       })
    }

    $scope.paramTest = function () {
        $scope.inputCommitTest(1);
        $scope.inputCommitTest(2,'yes');
        $scope.inputCommitTest($scope.testFunciont);
        $scope.inputCommitTest(1,2,3,4,5,6);
    }

    $scope.testFunciont = function () {
        alert('function exec');
    }
    $scope.inputCommitTest = function (p1,p2,p3) {
        alert('p1'+p1);
        alert('p2'+p2);
        alert('p3'+p3);
    }

}])