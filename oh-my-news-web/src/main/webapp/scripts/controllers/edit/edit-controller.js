/**
 * Created by shj on 2017/4/10.
 */
app.controller('editController',['$scope','$state','textAngularManager','commonService','user','editService','fileService','content','htmlParseService',function ($scope,$state,textAngular,commonService,user,editService,fileService,content,htmlParseService) {

    //初始化函数
    $scope.init = function () {

        $scope.userId = user.getId();
        $scope.version = textAngular.getVersion();
        $scope.versionNumber = $scope.version.substring(1);
        $scope.updatePic = [];
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
        if($scope.userId==undefined||$scope.userId==null||$scope.userId<1){
            alert("未登陆，将跳转登陆页面");
            $state.go('login');
        }
        $scope.categoriesInIt(true);

    }



    //初始化文章，判断是否是新增还是修改
    $scope.editContentInit = function () {
        // var editContent = content.getTemplate();
        var articleId = content.getEditContent().id;
        var editContent;
        if(articleId == -1){
            $scope.articleId = -1;
            $scope.categorySelected = $scope.categories[0];
            return;
        }else {
            param = {
                articleId:articleId
            }
            editService.getArticle(param,function (data) {
              editContent = data;
              $scope.articleId = articleId;
              $scope.topic = editContent.topic;
              $scope.htmlContent = editContent.htmlContent;
              $scope.labels = editContent.labels;
              $scope.categoryId = editContent.categoryId;
                angular.forEach($scope.categories,function (item, index,array) {
                    if(item.id==$scope.categoryId){
                        $scope.categorySelected=item;
                        return;
                    }
                });
            },function (data) {
                console.error(angular.toJson(data));
            })
        }



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
                $scope.categories = [{id: -1,parentId:null,name:"请选择类别"}].concat($scope.categories);
                if(isInit){
                    $scope.editContentInit();
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
        $scope.temp = null;
        editService.getPics(param,function (data) {

            angular.forEach(data,function (item,index,array) {
                item.isChosen = false;
            });
            $scope.allPics = data;
            $scope.temp = data;
            // console.info(angular.toJson(data));
            $scope.openModal();
        },function (data) {
            console.error("error: "+data)
        })
    }

    //粘贴板函数
    $scope.copyClipboard = function (pic) {
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
            $scope.updatePic.push(data);
        },function (data) {
            console.error('error: '+angular.toJson(data));
        })




    }


    //点击提交上传函数，0为保存草稿箱，1为直接发布
    $scope.commit = function (index) {
        var mediaIds = [];
        angular.forEach($scope.updatePic,function (item,index,array) {
            mediaIds.push(item.id);
        });
        var param = {
            id:$scope.articleId,
            userId : $scope.userId,
            topic: $scope.topic,
            htmlContent: $scope.htmlContent,
            labels: $scope.labels,
            categoryId : $scope.categorySelected.id,
            contentSnapshot: htmlParseService.parseHtml($scope.htmlContent).text,
            mediaIds: mediaIds
        };

        if(index==0){

            editService.commit(param,function (data) {
                alert("保存成功");
                $state.go('app.personalHomepage.hpTabset.draft',{userId:$scope.userId});
            },function (data) {
                console.error("error: "+angular.toJson(data));
            })
        }else {
            editService.publish(param,function (data) {
                alert("发表成功");
                $state.go('app.detail',{articleId:parseInt(data)});
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