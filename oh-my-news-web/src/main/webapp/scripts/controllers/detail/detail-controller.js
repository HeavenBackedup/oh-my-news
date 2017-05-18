/**
 * Created by shj on 2017/4/10.
 */
app.controller('detailController',['$scope','$state','$location','$anchorScroll','detailService','user','content','$stateParams',function ($scope,$state,$location,$anchorScroll,detailService,user,content,$stateParams) {
    $scope.init = function () {
        $scope.userId = user.getId();
        // $scope.topic = content.getTemplate().topic;
        // $scope.htmlContent = content.getTemplate().htmlContent;
        // console.info("info: "+$scope.topic);

        // $scope.topic = undefined;
        // $scope.htmlContent = undefined;
        // alert("$stateParams:"+angular.toJson($stateParams));
        // alert("$state"+angular.toJson($state.params));
        $scope.articleId = -1;
        $scope.category = undefined;
        $scope.author = undefined;
        $scope.authorPost = undefined;
        $scope.relatedPost = undefined;
        $scope.labels = undefined;
        $scope.categoyId = -1;
        $scope.articleReader;


        $scope.thumbupNum = 0;
        $scope.readed = 0;
        $scope.articleTime = "";
        $scope.commentNum = 0;
        $scope.articleScore = 0;

        $scope.submitInfo = {};
        $scope.submitInfo.comment ={};
        $scope.submitInfoCommentContentHeader = "";
        $scope.formerComment = {};
        $scope.formerComment.replier = {};

        $scope.pagination = {};
        $scope.totalMoney = 1000.00;
        $scope.donated = 0.00;
        $scope.reward = {};
        $scope.reward.num = 0;
        $scope.reward.rewardmessage = "";

        $scope.collected = false;
        $scope.score = -1;
        $scope.thumbup = false;
        $scope.report = false;

        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 10;

        if($stateParams.articleId==undefined||$stateParams.articleId==null||$stateParams==-1){
            alert('文章跳转出错，将跳回主页')
            $state.go('main');
        }
        $scope.articleId = parseInt($stateParams.articleId);


        $scope.articleRequest();
        $scope.pageChange();
        var now = getNowFormatDate();
        console.info("info: "+now);
        // $scope.submit(7,$scope.readed+1);
    }

    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
        return currentdate;
    }

    // 点击评论
    $scope.gotoReply = function (formerComment) {
        $scope.goto('create-comment');
        $scope.formerComment = formerComment;
        $scope.submitInfo.comment.content = "Reply to "+$scope.formerComment.replier.name +":";
        $scope.submitInfoCommentContentHeader = "Reply to "+$scope.formerComment.replier.name +":";
        // $scope.formerCommentUserName = formerComment.replier.name;
        // $scope.submit(1,formerComment);
    };


    // 提交信息
    $scope.submit = function (type,data) {
        var param = {};
        var str = "";
        param.submitInfo = {};

        if($scope.userId==-1||$scope.userId==null||$scope.userId==undefined){
            alert("用户没有登陆，请先登陆");
            return;
        }
        param.submitInfo.userId = $scope.userId;
        param.submitInfo.articleId = $scope.articleId;
        if (type == 1){
            param.submitInfo.comment = {};
            $scope.submitInfo.comment.userId = $scope.userId;
            str = $scope.submitInfo.comment.content;
            // $scope.submitInfoCommentContentHeader///
            str = str.substring($scope.submitInfoCommentContentHeader.length);
            console.info("info: "+str);
            if(str==''){
                alert('评论不能为空');
                return;
            }
            param.submitInfo.comment.content = str;
            param.submitInfo.comment.formerCommentId = data.id;
            param.submitInfo.comment.date = getNowFormatDate();
            param.submitInfo.comment.articleId = $scope.articleId;
            param.type = 1;
            $scope.formerComment = {};
            $scope.submitInfo.comment.content = "";
        }else if (type == 2){
            var radios = document.getElementsByName("score");//getElementsByName
            var radio;
            console.info("info: radios.length："+radios.length);
            for (var i=0; i<radios.length; i++) {
                radio = radios[i];
                if (radio.checked === true) {
                    param.submitInfo.score = radio.value;
                }
            }
            param.type = 2;
        }else if (type == 3){
            param.submitInfo.report = data;
            param.type = 3;
        }else if (type == 4){
            $scope.closeModal();
            var donation = {
                num:data.num,
                rewardmessage:data.rewardmessage
            }
            param.submitInfo.donation = donation;
            // param.submitInfo.rewardmessage = data.rewardmessage;
            param.type = 4;
        }else if (type == 5){
            param.submitInfo.thumbUp = data;
            param.type = 5;
        }else if (type == 6){
            param.submitInfo.collected = data;
            param.type = 6;
        }else if (type == 7){
            param.submitInfo.readed = data;
            param.type = 7;
        }
        detailService.submit(param,function (data) {
            if(data){
                alert("操作成功");
                switch(param.type){
                    case 1:
                        $scope.formerComment = {};
                        $scope.submitInfo.comment.content = "";
                        $scope.pageChange();
                        break;
                    case 2:
                        $scope.articleReader.score = param.submitInfo.score;
                        break;
                    case 3:
                        $scope.articleReader.report = true;
                        break;
                    case 4:
                            $scope.totalMoney = $scope.totalMoney-$scope.reward.num;
                        $scope.donated = $scope.donated+$scope.reward.num;
                        $scope.reward.num = 0;
                        $scope.reward.rewardmessage = "";
                        break;
                    case 5:
                        $scope.articleReader.thumbUp = true;
                        break;
                    case 6:
                        $scope.articleReader.collected = true;
                        break;
                }
            }else {
                alert("操作失败，请重试");
            }


            console.info("info: "+data);
        },function (data) {
            console.info("error: "+data);
        });
    }


    // 请求文章
    $scope.articleRequest = function () {
        var param = {};
        if($scope.articleId ==-1){
            $state.go('main');
        }
        param.articleId = $scope.articleId;
        param.userId = $scope.userId;

        detailService.articleRequest(param,function (data) {
            $scope.category = data.article.category;
            $scope.author = data.article.user;

            $scope.topic = data.article.articleInfo.topic;
            $scope.htmlContent = data.article.articleInfo.htmlContent;
            $scope.thumbupNum = data.article.articleInfo.thumbupNum;
            $scope.readed = data.article.articleInfo.readed;
            $scope.articleTime = data.article.articleInfo.articleTime;
            $scope.commentNum = data.article.articleInfo.commentNum;
            $scope.articleScore = data.article.articleInfo.articleScore;
            $scope.labels = data.article.articleInfo.labels;
            $scope.authorPost = data.article.articleInfo.authorPost;
            $scope.relatedPost = data.article.articleInfo.relatedPost;

            if($scope.userId==-1)
                return;
            $scope.totalMoney = data.articleReader.reader.totalMoney;
            $scope.donated = data.articleReader.donation;
            $scope.articleReader = data.articleReader;

        },function (data) {
            console.info("error: "+data);
        });
    }





    // 分页处理逻辑
    $scope.pageChange = function () {
        var param = {};
        param.currentPage = $scope.pagination.currentPage;
        param.articleId = $scope.articleId;
        detailService.pageChange(param,function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems*10;
            $scope.pagination.currentPage = data.pagination.currentPage;
            $scope.pageComments = data.comments;
            // $scope.tempComments = $scope.x.comments;
            // angular.forEach($scope.pageComments,function (item, index,array) {
            //     item.showReplyComment =false;
            // })

        },function (data) {
            console.info("error: "+data);
        });
    }


    $scope.goPage = function (state) {
        $state.go(state);
    };



    $scope.userValidation = function () {
        if($scope.userId==-1){
            $state.go('login');
        }
    };


    $scope.goto = function (id) {
        $location.hash(id);
        $anchorScroll();
    };

    //显示模板函数
    $scope.openModal = function () {
        if($scope.userId==-1||$scope.userId==null||$scope.userId==undefined){
            alert("用户没有登陆，请先登陆");
            return;
        }
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

    $scope.gotoMain = function (id) {
        $state.go('main',{categoryId:id});
    }

    $scope.goOtherDetail = function (id) {
        var url = $state.href('app.detail',{articleId:id});
        window.open(url,'_blank');

    }

    $scope.gotoPersonalHomepage = function (id) {
        $state.go('app.personalHomepage.hpTabset.history',{userId:id});
    }

}]);