/**
 * Created by fanfan on 2017/4/22.
 */
app.controller('myFansController',['$scope','fansService','user','$stateParams','$state','hbTabSet',function ($scope,fansService,user,$stateParams,$state,hbTabSet) {
    // alert('fuck shj');
    $scope.init=function () {
        hbTabSet.curIndex = 3;
        $scope.id={
            userId:user.getId(),
            paramsUserId:$state.params.userId
        }

        $scope.fansInformation={
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

        $scope.getFansList($scope.id.paramsUserId);

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
        $state.go('app.personalHomepage.hpTabset.history',{userId:id},{reload:true});

    }



}])