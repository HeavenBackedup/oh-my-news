/**
 * Created by wangyan on 2017/4/10.
 */
app.controller('accountManageController',['$scope','accountManageService',function ($scope,accountManageService) {

    $scope.init = function () {
        $scope.all=true;
        $scope.isTrue=false;
        $scope.myaddrCtrl="未设置";
        $scope.address=[];
        $scope.User={
            username:"wangyan",

        }

    }


    $scope.rename = function () {
        $scope.all = false;
    }

    $scope.inputCommit=function(){
        $scope.all=true;
        var User = {
            username:"",
        };
        User.username = $scope.User.username;
        accountManageService.getInputUsername(User,function (data) {
            $scope.isTrue = data;
           if($scope.isTrue==true){
               alert("保存成功！");
           }else {
               alert("保存失败！");
           }

        },function(data){
            console.log("error:  "+data);
        })
        console.log($scope.inputusername);
        // console.log($scope.myaddrCtrl);
        // console.log($scope.myemailaddr);
        // console.log($scope.mypwd);
    }


    $scope.updateAddress= function(){
        accountManageService.updateAddress(function(data){
            $scope.address=data;
        });
    }
    $scope.province=function(){
        $scope.mycity="";
        $scope.myarea="";
    }
    $scope.city=function(){
        $scope.myarea="";
    }
    $scope.area=function(){}
    $scope.dataConserve=function(){
        if($scope.myprovince.name==$scope.mycity.name){

            $scope.myaddrCtrl=$scope.myprovince.name+$scope.myarea.value;
        }
        else{
            $scope.myaddrCtrl=$scope.myprovince.name+$scope.mycity.name+$scope.myarea.value;
        }
        console.log($scope.myprovince);
        console.log($scope.mycity);
        console.log($scope.myarea);
    }




}])
app.directive("myaddress",function(){
    return{
        restrict:'AE',
        scope:{
            myaddr:'@'
        },
        template:'<p ng-bind="myaddr"><div ng-transclude></div></p>',
        transclude:true
    }
});