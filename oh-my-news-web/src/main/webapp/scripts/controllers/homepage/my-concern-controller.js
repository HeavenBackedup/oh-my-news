/**
 * Created by fanfan on 2017/4/26.
 */
app.controller('myConcernController',['$scope','concernService','user','$stateParams','$state',function ($scope,concernService,user,$stateParams,$state) {

    $scope.init=function () {
        $scope.id={
            userId:user.getId(),
            paramsUserId:$state.params.userId
        }

        $scope.concernInformation={
            // userId:'',
            // avatarPath:'',
            // nickName:'',
            // signature:''
        }

        $scope.getConcernList($scope.id.paramsUserId)

    }

    $scope.getConcernList=function (userId) {
        var param={
            userId:userId
        }
        concernService.getInfo(param,function (data) {
            $scope.concernInformation=data;


        },function (data) {
            console.log("getConcernList error"+data);

        })

    }
    $scope.skipPage=function (id) {
        $state.go('app.personalHomepage.hpTabset.myHomePage',{userId:id},{reload:true});

    }


}])
