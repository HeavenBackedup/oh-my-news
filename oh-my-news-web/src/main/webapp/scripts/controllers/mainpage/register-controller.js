/**
 * Created by llf on 2017/4/10.
 */
app.controller('registerController', ['$scope', '$state','registerService', function ($scope,$state, registerService) {
    $scope.init = function () {
        $scope.username = "";
        $scope.pwd = "";
        $scope.repwd = "";
        $scope.inputRes="";
        $scope.email="";
        $scope.isform=true;
        $scope.isform1=true;
        $scope.remind="";
    }
    $scope.verifyusername=function () {
        var inputusername={};
        if($scope.username!=null){
        inputusername.value=$scope.username;
        registerService.verifynameInfo(inputusername,function (data) {
            $scope.isform=data;
            if($scope.isform==false){
                $scope.inputRes="！该用户已经存在";
            }

        },function (data) {
            console.info("error" + data)
        })}
    }
    $scope.verifyemail=function () {
        // console.info("email");
        var inputemail={};
        if($scope.email!=null){
            inputemail.value=$scope.email;
            registerService.verifyemailInfo(inputemail,function (data) {
                $scope.isform1=data;
                if($scope.isform1==false){
                    $scope.inputRes="该邮箱已经被注册过!";
                }
            },function (data) {
                console.info("error" + data)
            })
        }
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
                $scope.remind="注册成功！"
                $('#remindModal').modal('show');
                $('#remindModal').on('hidden.bs.modal',function () {
                    $state.go("login");
                })

            }
        }, function (data) {
            console.info("error" + data)
        });
    }
}])