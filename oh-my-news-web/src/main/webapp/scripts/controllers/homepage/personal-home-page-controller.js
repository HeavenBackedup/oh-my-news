/**
 * Created by fanfan on 2017/4/15.
 */
app.controller('personalHomePageController',['$scope','homeService','user','$stateParams','$state',function ($scope,homeService,user,$stateParams,$state) {
    $scope.init=function () {

        $scope.userId = user.getId();
        alert($scope.userId +"fanfan");
        // $scope.userId=1;
        $scope.userInfo={};
        $scope.avatarPath="";
        $scope.nickName="";
        $scope.signature="";
        $scope.announcement="";
        $scope.followers=undefined;
        $scope.fans=undefined;
        $scope.date="";
        $scope.showForS=false;
        $scope.showForA=false;

        $scope.paramsUserId=$state.params.userId;
        alert($state.params.userId+"fadjkdfaierajfldfg")
        alert($scope.paramsUserId+"fanfafanfafa");
        // alert($state.params.userId+$scope.userId);
        // alert($scope.userId);
        $scope.uploadInformation($scope.paramsUserId);
    if ($scope.userId!=-1){
        $scope.login=true;
        if($scope.userId==$scope.paramsUserId){

            $scope.personal=true;
            $scope.others=false;

        }else {

            $scope.personal=false;
            $scope.others=true;
        }

    }else {

        $scope.personal=false;
        $scope.others=true;
        $scope.login=false;


    }




        // if ($state.params.code==0){
        //
        // }else {
        //
        // }


    };


    $scope.changeShowForS=function(){
        console.info('get');
        $scope.showForS=!$scope.showForS;

    };

    $scope.changeShowForA=function () {
        $scope.showForA=!$scope.showForA;

    }
    $scope.uploadInformation=function (userId) {
        console.log($scope.userId);
        var param = {
            userId:userId
        };
        alert(angular.toJson(param)+"fafjdfjhdhf")
        homeService.getInfo(param,function (data) {


            $scope.userInfo=data[0];
            $scope.avatarPath=$scope.userInfo.avatarPath;


            $scope.nickName=$scope.userInfo.nickName;

            $scope.signature=$scope.userInfo.signature;
            $scope.announcement=$scope.userInfo.announcement;
            $scope.followers=$scope.userInfo.followers;
            $scope.fans=$scope.userInfo.fans;
            $scope.date=$scope.userInfo.date;

       },function (data) {
            console.info("error:  "+data)

        })

    }

    $scope.sendSignature=function (signature) {
        var param={
            userId:$scope.userId,
            signature:signature
        }
        if(signature!=$scope.signature){
            homeService.confirmInformation(param,function(data){
                alert(signature)
            },function(data){
                alert("请重新编辑")
            })


        }


    };

    $scope.sendAnnouncement=function (announcement) {
        var param={
            userId:$scope.userId,
            announcement:announcement
        }
        if (announcement!=$scope.announcement){
            homeService.confirmInformation(param,function (data) {
                alert(announcement)

            },function (data) {
                alert("请重新编辑")

            })
        }

    }
}])