/**
 * Created by shj on 2017/4/10.
 */
app.controller('editController',['$scope','$state','textAngularManager','commonService','user','editService','fileService','content',function ($scope,$state,textAngular,commonService,user,editService,fileService,content) {

    //初始化函数
    $scope.init = function () {

        $scope.userId = user.getId();
        $scope.version = textAngular.getVersion();
        $scope.versionNumber = $scope.version.substring(1);
        $scope.orightml = '在这里编辑您的新闻...';
        $scope.htmlContent = $scope.orightml;
        $scope.disabled = false;
        $scope.topic = '';
        $scope.labels='';
        $scope.categories={};
        $scope.categorySelected = null;
        $scope.chosenPic = null;
        $scope.allPics = {};
        $scope.isPreview = false;
        $scope.categoriesInIt(true);

    }



    //初始化文章，判断是否是新增还是修改
    $scope.EditContentInit = function () {
        var editContent = content.getTemplate();
        if(editContent.id == -1){
            $scope.articleId = -1;
            $scope.categorySelected = $scope.categories[0];
            return;
        }
        $scope.articleId = editContent.id;
        $scope.topic = editContent.topic;
        $scope.htmlContent = editContent.htmlContent;
        $scope.labels = editContent.labels;
        angular.forEach($scope.categories,function (item, index,array) {
            if(item.id==editContent.categoryId){
                $scope.categorySelected = item;
                return;
            }
        })

    }

    //判断用户是否已登录
    $scope.userValidation = function () {
        if($scope.userId==-1){
            $state.go('login');
        }
    }

    //初始化分类选项
    $scope.categoriesInIt = function (isInit) {
        $scope.getCategories(isInit);
    }


    //向服务器请求获取分类选项
    $scope.getCategories = function (isInit) {

        commonService.getCategories(function (data) {

                $scope.categories = data;
                $scope.categories = [{id: -1,parent:null,catName:"请选择类别"}].concat($scope.categories);
                if(isInit){
                    $scope.EditContentInit();
                }else {
                    $scope.categorySelected = $scope.categories[0];
                }

        },function () {
            console.error("error: "+data);
        })

    }
    //向服务器请求获取该用户的所有图片
    $scope.picManage = function () {
        var param = {userId:$scope.userId,articleId:$scope.articleId};
        // console.info(angular.toJson(param));
        editService.getPics(param,function (data) {

            angular.forEach(data,function (item,index,array) {
                item.isChosen = false;
            });
            $scope.allPics = data;
            // console.info(angular.toJson(data));
            $scope.openModal();
        },function (data) {
            console.error("error: "+data)
        })
    }

    //粘贴板函数
    $scope.copyClipboard = function (pic) {
        console.info(angular.toJson(pic))
        pic.isChosen = true;

        if($scope.chosenPic==null){
            $scope.chosenPic = pic;
        }else {
            $scope.chosenPic.isChosen = false;
            $scope.chosenPic = pic;
        }

    }
    //点击预览触发事件
    $scope.preview = function () {
        $scope.isPreview =true;
    }
    //点击编辑触发事件
    $scope.returnEdit = function () {
        $scope.isPreview = false;
    }
    //文件上传函数
    $scope.fileUpload = function (file,errfile) {
        console.info('file: '+file);
        fileService.fileUpload(file,function (data) {
            console.info('file_data: '+angular.toJson(data));
            if(angular.isUndefined(data)){
                console.error("error: "+angular.toJson(data));
                return;
            }
            data.isChosen=false;
            $scope.allPics.push(data);
        },function (data) {
            console.error('error: '+angular.toJson(data));
        })

    }


    //点击提交上传函数，0为保存草稿箱，1为直接发布
    $scope.commit = function (index) {
        var param = {
            topic: $scope.topic,
            htmlContent: $scope.htmlContent,
            labels: $scope.labels,
            categoryId : $scope.categorySelected.id
        }
        if(index==0){

            editService.commit(param,function (data) {
                alert("保存成功");
            },function (data) {
                console.error("error: "+angular.toJson(data));
            })
        }else {
            editService.publish(param,function (data) {
                alert("发表成功");
            },function (data) {
               console.error("publish error: "+angular.toJson(data))
            })
        }


    };

    //显示模板函数
    $scope.openModal = function () {
        $('#myModal').modal('show');
    };
    //隐藏模板函数
    $scope.closeModal = function () {
        $('#myModal').modal('hide');
    };

    //清空缓存，当脱离该页面时，执行该方法
    $scope.$on("$destroy",function(){
        console.info("error destroyed");
        content.destroy();
    })








}])