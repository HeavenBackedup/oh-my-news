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
        };
        if((isNaN($scope.id.paramsUserId)||$scope.id.paramsUserId<=0)){
            $scope.id.paramsUserId = user.getParamId();

        }else {
            user.setParamId($scope.id.paramsUserId);
        }
        if($scope.id.paramId==-1){
            alert("个人主页跳转出错，将返回新闻主页");
            $state.go('main');
        }

        $scope.getConcernList($scope.id.paramsUserId);

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
        $state.go('app.personalHomepage.hpTabset.history',{userId:id},{reload:true});

    }


}])
