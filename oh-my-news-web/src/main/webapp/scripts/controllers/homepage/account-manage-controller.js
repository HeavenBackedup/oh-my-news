/**
 * Created by wangyan on 2017/4/10.
 */
app.controller('accountManageController',['$scope','accountManageService','Upload','fileService','user','registerService',function ($scope,accountManageService,Upload,fileService,user,registerService) {

    $scope.init = function () {
        $scope.userId=user.getId();
        $scope.isExitUsername=false;//判断用户名是否存在
        $scope.isAddressConserve=false;  //是否点击地址保存按钮(由于地址是以数组形式传送，以字符形式显示)
        $scope.isTrue=false;  //保存信息后的返回值
        $scope.all=true;   //控制输入框是否可编辑
        $scope.address=[];   //传地址的json数据
        $scope.myprovince="";
        $scope.myrepwd="";
        $scope.myemailaddr="";
        $scope.isEmailRegist = false;
        var myaddrCtrlInput=[];//数组，用来接收地址和上传地址
        $scope.userValidation();
        $scope.User= {
            username: "",     //刷新姓名
            path:"",   //刷新图片
            myaddrCtrl:"",          //刷新地址
            myemCtrl:"",   //刷新邮箱
            mypwd:"",
        }
        $scope.getUserList();


    }

    //判断用户是否已登录
    $scope.userValidation = function () {
        if($scope.userId==-1){
            alert('用户未登陆');
            $state.go('login');
        }
    }
    //刷新地址
    $scope.RefreshAddress=function (myaddrCtrlInput) {
        if (myaddrCtrlInput[0]==myaddrCtrlInput[1]){
            return myaddrCtrlInput[0]+myaddrCtrlInput[2];
        }else{
           return myaddrCtrlInput[0]+myaddrCtrlInput[1]+myaddrCtrlInput[2];
        }

    }



    //数据请求
    $scope.getUserList=function () {
        var userIdMap = {};
         userIdMap.userId = $scope.userId;
         accountManageService.getUser(userIdMap,function(data){
             for (var key in data){
                 console.log(key+"..."+data[key]);
             }
             myaddrCtrlInput = data.address;
             console.log(myaddrCtrlInput[0]);
             $scope.User= {
                 username: data.username,     //刷新姓名
                 path:data["url"],   //刷新图片
                 myaddrCtrl:$scope.RefreshAddress(myaddrCtrlInput),          //刷新地址
                 myemCtrl:data.email,   //刷新邮箱
                 myPassword: data.password,
                 photoid:data.photoid
                 // mypwd:"123",
             }
             // $scope.User.myaddrCtrlInput =  data.address;
         },function (data) {
             alert("error:"+angular.toJson(data));
         })

    }

    //判断用户名是否存在
    $scope.verifyInfo=function () {
        if ($scope.User.username != null){
            var usernameMap={};
            usernameMap.username = $scope.User.username;
            accountManageService.getVerifyInfo(usernameMap,function (data) {
                $scope.isExitUsername = data;
                if ($scope.isExitUsername==false){
                    alert("该用户名已存在！");
                }else {
                }

            },function (data) {

            })
        }else {
            alert("用户名不能为空！");
        }

    }

   // 用户修改后信息上传
    $scope.inputCommit=function(){
        var User={
            id: $scope.userId,
            username:"",
            photoid:"",
            address:[],
            email:"",
            password:""
        }
        $scope.all=true;
        //需要进行判断，如果没有输入内容，默认将接收的数组复制给它
        if ($scope.isAddressConserve == true){
            myaddrCtrlInput = [$scope.myprovince.name, $scope.mycity.name, $scope.myarea.value];
            User.address = myaddrCtrlInput;
        }else {
            User.address = myaddrCtrlInput;
        }
            User.username = $scope.User.username;
            User.photoid = $scope.User.photoid;
            User.email = $scope.User.myemCtrl;
            User.password = $scope.User.myPassword;
        accountManageService.getInputUser(User,function (data) {
            $scope.isTrue = data;
           if($scope.isTrue==true){
               alert("保存成功！");
           }else {
               alert("保存失败！");
           }
        },function(data){
            console.log("error:  "+data);
        })
        console.log($scope.User.username);
        console.log($scope.User.photoid);
        console.log(myaddrCtrlInput);
        // console.log($scope.User.myaddrCtrl);
        console.log($scope.User.myemCtrl);
        console.log($scope.User.mypwd);
    }

    // 修改控制标签input
    $scope.rename = function () {
        $scope.all = false;
    }
    // 图片上传
    $scope.uploadFiles = function(file, errFiles) {
        fileService.fileUpload(file,
            // 图片上传成功处理逻辑，data包含两个属性，id，数据库存储id,url图片访问的url
            function (data) {
                var name= file.name;
                $scope.fileName = name;
                $scope.User.path = data.url;
                $scope.User.photoid=data.id;

            },
            //图片上传失败树立逻辑
            function (data) {
                alert(angular.toJson(data));
            });
    }
    // 修改地址
    $scope.updateAddress = function () {

        accountManageService.getAddressJson(function (data) {
            // console.log(angular.toJson(data));
            $scope.address=data.data;
        },function (data) {
            console.error(data);
            console.log("error......");
        })
    }

// 访问静态资源
    // $scope.updateAddress= function(){
    //     accountManageService.updateAddress(function(data){
    //         $scope.address=data;
    //     });
    // }
    $scope.province=function(){
        $scope.mycity="";
        $scope.myarea="";
    }
    $scope.city=function(){
        $scope.myarea="";
    }
    $scope.area=function(){

    }
    $scope.dataConserve=function(){
        $scope.isAddressConserve = true;
        if($scope.myprovince.name==$scope.mycity.name){
            $scope.User.myaddrCtrl=$scope.myprovince.name+$scope.myarea.value;
        }
        else{
            $scope.User.myaddrCtrl=$scope.myprovince.name+$scope.mycity.name+$scope.myarea.value;
        }
        console.log($scope.User.myaddrCtrl);
    }

    // 修改邮箱
    $scope.dataConserve2=function(){
        registerService.verifyemailInfo({
            value:$scope.myemailaddr
        },function (data) {
            if(data){
                alert("保存成功");
                $scope.User.myemCtrl=$scope.myemailaddr;
                $('#mymodal2').modal('hide');
                $scope.isEmailRegist=false;
            }else {
                $scope.isEmailRegist=true;
            }

        },function (data) {
            console.error(angular.toJson(data));
        })

    }


    $scope.dataConserve3 = function () {
        $scope.User.myPassword = $scope.User.mypwd;
    }

    $scope.closeEmailModal = function () {
        $('#mymodal2').modal('hide');
        $scope.isEmailRegist=false;
    }

    $('#mymodal2').on('hide.bs.modal', function () {
        $scope.isEmailRegist=false;});

}])
