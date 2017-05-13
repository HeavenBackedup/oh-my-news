/**
 * Created by llf on 2017/4/10.
 */
app.controller('loginController',['$scope','loginService','$state','user',function ($scope,loginService,$state,user) {
    $scope.init=function () {
        $scope.inputRes="";
        $scope.pwd="";
        $scope.usernameOremail="";
        $scope.userId=0;
        $scope.isform=true;
        $scope.remind="";
    }
    $scope.verifyInfo=function () {
        var verifyInfo={username:"",email:""};
        var reg=new RegExp("^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$");
        if(reg.test($scope.usernameOremail)){
            verifyInfo.email=$scope.usernameOremail;
        }else{
            verifyInfo.username=$scope.usernameOremail;
        }
        loginService.verifyInfo(verifyInfo,function (data) {
             $scope.isform=data;
        },function (data) {

        })
    }
    $scope.submitInfo=function () {
        var userInfo={username:"",password:"",email:""};
        var reg=new RegExp("^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$");
        if(reg.test($scope.usernameOremail)){
            userInfo.email=$scope.usernameOremail;
        }else{
           userInfo.username=$scope.usernameOremail;
            console.info(userInfo.username);
        }
        userInfo.password=$scope.pwd;
        loginService.submitInfo(userInfo,function (data) {
            $scope.userId=data;
            if($scope.userId==-1){
                $scope.remind="用户名或邮箱或密码错误";
                $('#remindModal').modal();
            }else{
                 user.setId($scope.userId);
                 $state.go("app.personalHomepage.hpTabset.history",{userId:$scope.userId});
                // $location.reload('personal_home_page')
            }
        },function (data) {

        });
    }
}])