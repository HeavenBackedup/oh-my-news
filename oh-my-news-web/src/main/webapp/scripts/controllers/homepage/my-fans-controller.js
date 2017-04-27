/**
 * Created by fanfan on 2017/4/22.
 */
app.controller('myFansController',['$scope','fansService','user','$stateParams','$state',function ($scope,fansService,user,$stateParams,$state) {
    // alert('fuck shj');
    $scope.init=function () {
        $scope.id={
            userId:user.getId(),
            paramsUserId:$state.params.userId
        }

        $scope.fansInformation={
            // userId:'',
            // avatarPath:'',
            // nickName:'',
            // signature:''
        }

        $scope.getFansList($scope.id.paramsUserId)

    }
    
    $scope.getFansList=function (userId) {
        var param={
            userId:userId
        }
        fansService.getInfo(param,function (data) {
            $scope.fansInformation=data;

            
        },function (data) {
            console.log("getFansList error"+data);

        })

    }
    $scope.skipPage=function (id) {
        $state.go('app.personalHomepage.hpTabset.myHomePage',{userId:id},{reload:true});

    }



}])