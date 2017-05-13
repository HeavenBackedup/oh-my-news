/**
 * Created by shj on 2017/4/10.
 */
app.controller('privateMsgController',['$scope','privatemsgService','Upload','fileService','$timeout','user',function ($scope,privatemsgService,Upload,fileService,$timeout,user) {
    //初始化
    $scope.init=function () {

        $scope.selectedValue=0;
        $scope.privateMsgs=[];
        $scope.exMsgs=[];
        $scope.userId=user.getId();
        //向服务器请求初始的私信列表，默认为未读私信列表
        $scope.getPrivateMsg();

    };

    //向服务器请求私信，参数为该用户自己的ID请求私信的内容的类型：0:未读，1：已读，2：全部
    $scope.getPrivateMsg=function () {

        var param = {};
        param.userId=$scope.userId;
        param.selectedValue =$scope.selectedValue;
        privatemsgService.getPrivateMsg(param,function (data) {
            // console.info(angular.toJson($scope.selectedValue));
            $scope.privateMsgs=data;
            angular.forEach($scope.privateMsgs,function (item,index,array) {
                item.isUnfold = true;
            })
            console.info(angular.toJson(data));
        },function(data){
            console.info("error:  "+data)
        });
    }


    $scope.unfold=function (privateMsg) {
        // $scope.exMsgs=[];
        //将之前的展开收起，将新的展开展开
        // for(var i=0;i<$scope.privateMsgs.length;i++){
        //     var id=$scope.privateMsgs[i].id;
        //     if(id==$scope.previousUser){
        //         $scope.privateMsgs[i].isUnfold=true;
        //     }
        //     if(id==uId){
        //         $scope.privateMsgs[i].isUnfold=false;
        //         // for(var j=1;j<$scope.um[i].detail.length;j++){
        //         //     $scope.exMsgs.push($scope.um[i].detail[j]);
        //         // }
        //     }
        // }
        //以上均为测试时用的代码
        angular.forEach($scope.privateMsgs,function (item,index,array) {
            item.isUnfold = true;
        })

        //向服务器请求某一个人的所有的私信内容
        $scope.getExMsg(privateMsg.id);
        $scope.previousUser=privateMsg.id;
        privateMsg.isUnfold = false;
    };

    //向服务器请求某一个人的所有的私信内容，传过去的参数是用户自己的ID以及对话的用户的ID
    $scope.getExMsg=function (otherUserId) {
        $scope.exMsgs=[];
        var param = {};
        param.userId=$scope.userId;
        param.otherUserId =otherUserId;
        privatemsgService.getExMsg(param,function (data) {
            // for(var i=0;i<data.length;i++){
            //     var exMsg={
            //         id:data[i].id,
            //         username:data[i].username,
            //         avatar:data[i].avatar,
            //         message:data[i].message,
            //         time:data[i].time
            //     }
            //     $scope.exMsgs.push(exMsg);
            // }
            $scope.exMsgs = data;
        },function(data){
            console.info("error:  "+data)
        });
    };


    $scope.packUp=function (privateMsg) {
        privateMsg.isUnfold = true;
        $scope.exMsgs=[];
    };


    $scope.reply=function (privateMsg) {
        privateMsg.isReply=!privateMsg.isReply;
    }


    $scope.privateMsgReply=function (privateMsg) {
        var param = {};
        param.userId=$scope.userId;
        param.otherUserId =privateMsg.id;
        param.privateMsg="错误信息";
        param.privateMsg=privateMsg.rMessage;
        // param.privateMsg=$scope.rMessage;
        // alert($scope.rMessage);
        privatemsgService.postPrivateMsg(param,function (data) {
            if(data==false){
                alert('私信发送失败，请联系客服');
            }
            alert('发送成功');

            privateMsg.rMessage="";
            $scope.getPrivateMsg();
        },function(data){
            console.info("error:  "+data)
        });



        // console.info(angular.toJson($scope.um[i].detail));

    }

}])









