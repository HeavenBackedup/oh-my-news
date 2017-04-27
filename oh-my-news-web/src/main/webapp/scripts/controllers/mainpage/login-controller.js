/**
 * Created by llf on 2017/4/10.
 */
app.controller('loginController',['$scope','loginService','$state','user',function ($scope,loginService,$state,user) {
    $scope.init=function () {
        $scope.inputRes="";
        $scope.pwd="";
        $scope.usernameOremail="";
        $scope.userId=0;
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
        console.info(userInfo);
        loginService.submitInfo(userInfo,function (data) {
            $scope.userId=data;
            if($scope.userId==-1){
                $scope.inputRes="用户名或邮箱或密码错误";
                alert($scope.inputRes);
            }else{
                 user.setId($scope.userId);
                 $state.go("app.personalHomepage.hpTabset.myHomePage",{userId:$scope.userId});
                // $location.reload('personal_home_page')
            }
        },function (data) {


}])