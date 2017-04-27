/**
 * Created by llf on 2017/4/10.
 */
app.controller('registerController', ['$scope', 'registerService', function ($scope, registerService) {
    $scope.init = function () {
        $scope.username = "";
        $scope.pwd = "";
        $scope.repwd = "";
        $scope.inputRes="";
        $scope.isform=true;
    }
    $scope.verify=function () {
        var inputusername={};
        if($scope.username!=null){
        inputusername.value=$scope.username;
        registerService.verifyInfo(inputusername,function (data) {
            $scope.isform=data;
            if($scope.isform==false){
                $scope.inputRes="！该用户已经存在"
            }

        },function (data) {

        })}
    }
    $scope.submit = function () {
        var user = {username: "", password: "",email:""};

        user.username = $scope.username;
        user.password = $scope.pwd;
        user.email=$scope.email;
        registerService.submitInfo(user, function (data) {
           $scope.isform=data;
            if($scope.isform==true){
                console.info("注册成功")
                alert("注册成功")
            }
        }, function (data) {
            console.info("error" + data)
        });
    }
}])