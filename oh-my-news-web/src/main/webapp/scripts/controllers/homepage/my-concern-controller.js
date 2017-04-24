/**
 * Created by shj on 2017/4/10.
 */
app.controller('myConcernController',['$scope','myconcernService','Upload','fileService','$timeout',function ($scope,myconcernService,Upload,fileService,$timeout) {

    // $scope.userList=[
    //     {avatar:"images/hpic.jpeg", name:"AAA",address:"上海",signature:"少一点套路，多一些真诚"},
    //     {avatar:"images/hpic.jpeg", name:"BBB",address:"上海",signature:"少一点套路，多一些真诚"},
    //     {avatar:"images/hpic.jpeg", name:"CCC",address:"上海",signature:"少一点套路，多一些真诚"}
    // ];

    //初始化
    $scope.init=function () {

        $scope.userList=[];

        $scope.userId=123456;

        //向服务器请求初始的私信列表，默认为未读私信列表
        $scope.getConcernUsers();

    };

    $scope.getConcernUsers=function () {
        var param = {};
        param.userId=$scope.userId;
        myconcernService.getConcernUser(param,function (data) {
            // console.info(angular.toJson($scope.selectedValue));
            $scope.userList=[];
            console.info(angular.toJson(data));
            for(var i=0;i<data.length;i++){
                var concernUser={
                    id:data[i].id,
                    name:data[i].username,
                    avatar:data[i].avatar,
                    address:data[i].address,
                    signature:data[i].signature
                };
                $scope.userList.push(concernUser);

            }
        },function(data){
            console.info("error:  "+data)
        });
    };

    $scope.getHomepage=function (uId) {
        var param = {};
        param.id=uId;
        myconcernService.getHomepage(param,function (data) {
            console.info(angular.toJson(data));
        },function(data){
            console.info("error:  "+data)
        });
    };

}])