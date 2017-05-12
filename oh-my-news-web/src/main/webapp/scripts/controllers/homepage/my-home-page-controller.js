/**
 * Created by fanfan on 2017/4/15.
 */
app.controller('myHomePageController',['$scope','homeService','user','$stateParams','$state','$controller',function ($scope,homeService,user,$stateParams,$state,$controller) {
    $controller('appController', {$scope: $scope});

    $scope.init=function () {

        $scope.id={
            // user.getId()
            userId:user.getId(),
            paramsUserId:$state.params.userId
        }

        $scope.confirmInfo={
            code:null
        }
        $scope.confirmTurn={
            turnOfCode:null,
            showForY:null,
            showForLogin:null

        }

        $scope.index={
            curIndex:null
        }

        // $scope.indexOfTab={
        //     index:0
        // }

        $scope.infoCache={
            signature:null,
            announcement:null,


        }

        $scope.userInfo={};
        $scope.show={
            editable:null,
            privateMsg:false
        }
        $scope.private={
            privateLetter:''
        }

        if((isNaN($scope.id.paramsUserId)||$scope.id.paramsUserId<=0)){
            alert("个人主页跳转出错，将返回新闻主页");
            $state.go('main');
        }
        $scope.uploadInformation($scope.id.paramsUserId);






        if ($scope.id.userId!=-1){
            $scope.confirmTurn.showForLogin=true;
            if ($scope.id.userId==$scope.id.paramsUserId){
                $scope.show.editable=true;
            }else {
                $scope.show.editable=false;
                $scope.getConfirmInfo();
            }
        }else {
            $scope.confirmTurn.showForLogin=false;
            $scope.show.editable=false;

        }


    };



    $scope.uploadInformation=function (userId) {
        console.log(userId+"test");
        var param = {
            userId:userId
        };

        homeService.getInfo(param,function (data) {

            $scope.infoCache.signature=data.signature;
            $scope.infoCache.announcement=data.announcement;
            $scope.userInfo=data;

        },function (data) {
            console.info("error:  "+data)

        })

    }

    $scope.sendSignature=function () {
        var param={
            code:0,
            userId:$scope.id.userId,
            signature:$scope.userInfo.signature
        }

        console.log("sendInfo"+angular.toJson(param))

        if($scope.infoCache.signature!=$scope.userInfo.signature){
            $scope.sendInfo(param)

            console.log("sendInfo000"+angular.toJson(param))
        }

    };

    $scope.sendAnnouncement=function () {
        var param={
            code:1,
            userId:$scope.id.userId,
            announcement:$scope.userInfo.announcement
        }
        if ($scope.infoCache.announcement!=$scope.userInfo.announcement){
            $scope.sendInfo(param);
        }

    }




    $scope.getConfirmInfo=function () {
        var param={
            userIdOfLogin:$scope.id.userId,
            userIdOfShow:$scope.id.paramsUserId
        }


        homeService.getConfirmInfo(param,function (data) {
            $scope.confirmInfo.code=data;


            switch ($scope.confirmInfo.code){
                case 0:
                    $scope.confirmTurn.turnOfCode="已关注";

                    $scope.confirmTurn.showForY=false;

                    break;
                case 1:
                    $scope.confirmTurn.turnOfCode="未关注";

                    $scope.confirmTurn.showForY=true;

                    break;
                default:
                    break;

            }
        },function (data) {
            alert("错误")

        })

    }

    $scope.sendInfo=function (param) {
        homeService.confirmInformation(param,function (data) {

            alert("发送成功")

        },function (data) {
            alert("请重新编辑")

        })

    }

    $scope.unfollow=function () {
        var param={
            code:2,
            userIdOfLogin:$scope.id.userId,
            userIdOfShow:$scope.id.paramsUserId
        };
        $scope.sendInfo(param)
    }

    $scope.follow=function () {
        var param={
            code:3,
            userIdOfLogin:$scope.id.userId,
            userIdOfShow:$scope.id.paramsUserId
        }
        $scope.sendInfo(param)

    }

    $scope.showMsg=function () {
        $scope.show.privateMsg=!$scope.show.privateMsg

    }
    $scope.sendPrivateMsg=function () {
        console.log("fanfan")
        console.log($scope.private.privateLetter);
        if ($scope.private.privateLetter!=null){
            var param={
                code:4,
                userIdOfLogin:$scope.id.userId,
                userIdOfShow:$scope.id.paramsUserId,
                privateMsg:$scope.private.privateLetter
            }
            $scope.sendInfo(param);
            $scope.private.privateLetter='';
        }

    }

    $scope.linkToFans=function () {
        $state.go('app.personalHomepage.hpTabset.myFans',{userId:$scope.id.paramsUserId});
        $scope.index.curIndex=3;

    }
    $scope.linkToConcern=function () {
        $state.go('app.personalHomepage.hpTabset.myConcern',{userId:$scope.id.paramsUserId});
        $scope.index.curIndex=2;

    }

}])