/**
 * Created by shj on 2017/4/10.
 */
app.controller('myRewardController',['$scope','my_rewardService',function ($scope,my_rewardService) {
        //noinspection JSAnnotator
            $scope.init=function(){
                $scope.inputRes="";
                $scope.input="";

            }



           //noinspection JSAnnotator
    $scope.inputCommit=function () {
        var param={};
        param.value=$scope.input;
        my_rewardService.getInput(param,function (data) {

            $scope.inputRes=data;}, function (data) {
            console.info("error:  "+data)})

    }












}])