/**
 * Created by fanfan on 2017/4/26.
 */
app.controller('appController',['$scope','homeService','user','$stateParams','$state',function ($scope,homeService,user,$stateParams,$state) {

    $scope.init=function () {

        $scope.id={
            // user.getId()
            userId:user.getId(),
            paramsUserId:$state.params.userId
        }
        $scope.show= {
            login: null
        };
        if((isNaN($scope.id.paramsUserId)||$scope.id.paramsUserId<=0)){
            alert("个人主页跳转出错，将返回新闻主页");
            $state.go('main');
        }
        $scope.userInfoOfLogin={};
        if ($scope.id.userId!=-1){
            $scope.uploadInformation($scope.id.userId)
            $scope.show.login=true;
            // if ($scope.id.paramsUserId=$scope.id.userId){
            //
            // }else {
            //
            // }
            //
        }else {
            $scope.show.login=false;

        }
    }

    $scope.uploadInformation=function (userId) {
        console.log(userId+"header ");
        var param = {
            userId:userId
        };

        homeService.getInfo(param,function (data) {
            $scope.userInfoOfLogin=data;

        },function (data) {
            console.info("error:  "+data)

        })

    }

    $scope.backToPersondalPage=function () {

        // $scope.init();
        $state.go('app.personalHomepage.hpTabset.myHomePage',{userId:$scope.id.userId},{reload:true});

    }

}])