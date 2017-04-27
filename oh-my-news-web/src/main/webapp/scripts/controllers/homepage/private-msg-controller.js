/**
 * Created by shj on 2017/4/10.
 */
app.controller('privateMsgController',['$scope','privatemsgService','Upload','fileService','$timeout',function ($scope,privatemsgService,Upload,fileService,$timeout) {
    //初始化
    $scope.init=function () {

        $scope.selectedValue=0;
        $scope.privateMsgs=[];
        $scope.exMsgs=[];
        // $scope.rMessage="123";

        $scope.userId=123456;
        $scope.name="DDD";
        $scope.avatar="images/hpic.jpeg";
        $scope.time="20170428";

        //向服务器请求初始的私信列表，默认为未读私信列表
        $scope.getPrivateMsg();

        // //以下为测试用代码
        // $scope.um=[
        //     {name:"AAA",detail:[{userID:1,avatar:"images/hpic.jpeg", name:"AAA", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"},{avatar:"images/hpic.jpeg", name:"AAA", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"}]},
        //     {name:"BBB",detail:[{userID:2,avatar:"images/hpic.jpeg", name:"BBB", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"},{avatar:"images/hpic.jpeg", name:"AAA", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"}]},
        //     {name:"CCC",detail:[{userID:3,avatar:"images/hpic.jpeg", name:"CCC", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"},{avatar:"images/hpic.jpeg", name:"AAA", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum",time:"20120607"}]}
        // ];
        //
        // for(var i=0;i<$scope.um.length;i++){
        //     $scope.privateMsgs.push({isExp:true,isres:false,responseMessage:"",message:$scope.um[i].detail[0]});
        // }

    };

    //向服务器请求私信，参数为该用户自己的ID请求私信的内容的类型：0：已读，1：未读，2：全部
    $scope.getPrivateMsg=function () {

        var param = {};
        param.userId=$scope.userId;
        param.selectedValue =$scope.selectedValue;
        privatemsgService.getPrivateMsg(param,function (data) {
            // console.info(angular.toJson($scope.selectedValue));
            $scope.privateMsgs=[];
            console.info(angular.toJson(data));
            for(var i=0;i<data.length;i++){
                var privateMsg={
                    isUnfold:true,
                    isReply:false,
                    rMessage:"123",
                    id:data[i].id,
                    username:data[i].username,
                    avatar:data[i].avatar,
                    message:data[i].message,
                    time:data[i].time
                };
                $scope.privateMsgs.push(privateMsg);

            }
        },function(data){
            console.info("error:  "+data)
        });
    }


    $scope.unfold=function (uId) {
        // $scope.exMsgs=[];
        //将之前的展开收起，将新的展开展开
        for(var i=0;i<$scope.privateMsgs.length;i++){
            var id=$scope.privateMsgs[i].id;
            if(id==$scope.previousUser){
                $scope.privateMsgs[i].isUnfold=true;
            }
            if(id==uId){
                $scope.privateMsgs[i].isUnfold=false;
                // for(var j=1;j<$scope.um[i].detail.length;j++){
                //     $scope.exMsgs.push($scope.um[i].detail[j]);
                // }
            }
        }
        //以上均为测试时用的代码

        //向服务器请求某一个人的所有的私信内容
        $scope.getExMsg(uId);
        $scope.previousUser=uId;
        console.info(angular.toJson($scope.exMsgs));
    };

    //向服务器请求某一个人的所有的私信内容，传过去的参数是用户自己的ID以及对话的用户的ID
    $scope.getExMsg=function (otherUserId) {
        $scope.exMsgs=[];
        var param = {};
        param.userId=$scope.userId;
        param.otherUserId =otherUserId;
        privatemsgService.getExMsg(param,function (data) {
            console.info(angular.toJson(data));
            for(var i=0;i<data.length;i++){
                var exMsg={
                    id:data[i].id,
                    username:data[i].username,
                    avatar:data[i].avatar,
                    message:data[i].message,
                    time:data[i].time
                }
                $scope.exMsgs.push(exMsg);
            }
        },function(data){
            console.info("error:  "+data)
        });
    };


    $scope.packUp=function (uId) {
        for(var i=0;i<$scope.privateMsgs.length;i++){
            var id=$scope.privateMsgs[i].id;
            if(id==uId){
                $scope.privateMsgs[i].isUnfold=true;
                break;
            }
        }
        $scope.exMsgs=[];
    };


    $scope.reply=function (uId) {
        for(var i=0;i<$scope.privateMsgs.length;i++){
            var id=$scope.privateMsgs[i].id;
            if(id==uId){
                // alert($scope.privateMsgs[i].isReply);
                $scope.privateMsgs[i].isReply=!$scope.privateMsgs[i].isReply;
                // alert($scope.privateMsgs[i].isReply);
                break;
            }
        }
    }


    $scope.privateMsgReply=function (uId) {

        var param = {};
        param.userId=$scope.userId;
        param.otherUserId =uId;
        param.privateMsg="错误信息";
        for(var i=0;i<$scope.privateMsgs.length;i++){
            var id=$scope.privateMsgs[i].id;
            if(id==uId){
                // alert($scope.privateMsgs[i].isReply);
                param.privateMsg=$scope.privateMsgs[i].rMessage;
                alert($scope.privateMsgs[i].rMessage);
                break;
            }
        }
        // param.privateMsg=$scope.rMessage;
        // alert($scope.rMessage);
        privatemsgService.postPrivateMsg(param,function (data) {
            if(data==true){
                // if(!$scope.exMsgs.isEmptyObject()){
                //     var msg={
                //         id:$scope.userId,
                //         username:$scope.name,
                //         avatar:$scope.avatar,
                //         message:$scope.replyMsg,
                //         time:$scope.time
                //     }
                //     $scope.exMsgs.push(msg);
                // }
                $scope.privateMsgs[i].rMessage="";
                // alert(document.getElementById("rMessage").toString());
                // $scope.rMessage="";
                // alert(document.getElementById("rMessage").toString());
            }else{
                $scope.privateMsgReply(uId);
            }
        },function(data){
            console.info("error:  "+data)
        });



        // console.info(angular.toJson($scope.um[i].detail));

    }

}])









// $scope.userList=["AAA","BBB","CCC"];
// $scope.privateMsgs=[
//     {avatar:"images/hpic.jpeg", name:"AAA", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum"},
//     {avatar:"images/hpic.jpeg", name:"BBB", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum"},
//     {avatar:"images/hpic.jpeg", name:"CCC", message:"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum"}
// ];
// $scope.isExp=true;
// $scope.isPackUp=false;



// privatemsgService.getUm(null,function (data) {
//     $scope.privateMsgs = data;
// },function(data){
//     console.info("error:  "+data)
// })

// $scope.isExp.push(true);
// $scope.isPackUp.push(false);



// $scope.chooseUser=function (username) {
//     $scope.hasMsg=true;
//     for(var i=0;i<$scope.um.length;i++){
//         var name=$scope.um[i].name;
//         if(name==username){
//             $scope.privateMsgs=$scope.um[i].detail;
//             break;
//         }
//     }
// }

// $scope.privateMsgs=[];
// $scope.resp="";
// $scope.hasMsg=false;