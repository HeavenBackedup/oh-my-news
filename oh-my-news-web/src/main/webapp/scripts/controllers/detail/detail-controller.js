/**
 * Created by shj on 2017/4/10.
 */
app.controller('detailController',['$scope','$state','$location','$anchorScroll','detailService','user','content',function ($scope,$state,$location,$anchorScroll,detailService,user,content) {
    $scope.init = function () {
        $scope.userId = user.getId();
        // $scope.topic = content.getTemplate().topic;
        // $scope.htmlContent = content.getTemplate().htmlContent;
        // console.info("info: "+$scope.topic);

        // $scope.topic = undefined;
        // $scope.htmlContent = undefined;
        $scope.articalId = 1;
        $scope.category = undefined;
        $scope.author = undefined;
        $scope.authorPost = undefined;
        $scope.relatedPost = undefined;
        $scope.labels = undefined;


        $scope.thumbupNum = 100;
        $scope.readed = 1000;
        $scope.articalTime = "23 Agustus 2017";
        $scope.commentNum = 3;
        $scope.articalScore = 1.5;

        $scope.articalRequest();

        $scope.submitInfo = {};
        $scope.submitInfo.comment ={};
        $scope.submitInfoCommentContentHeader = "";
        $scope.formerComment = {};
        $scope.formerComment.replier = {};

        $scope.pagination = {};
        $scope.totalMoney = 1000.00;
        $scope.reward = 0.00;

        $scope.collected = false;
        $scope.score = undefined;
        $scope.thumbup = false;
        $scope.report = false;

        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 1;
        $scope.pagination.maxSize = 10;
        $scope.pageChange();
        var now = getNowFormatDate();
        console.info("info: "+now);
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
        param.submitInfo.comment = {};
        $scope.submitInfo.comment.userId = $scope.userId;
        param.submitInfo.userId = $scope.submitInfo.comment.userId;

        console.info("info: smysmysmy"+data);
        if (type == 1){
            str = $scope.submitInfo.comment.content;
            // $scope.submitInfoCommentContentHeader///
            str = str.substring($scope.submitInfoCommentContentHeader.length);
            console.info("info: "+str);
            param.submitInfo.comment.content = str;
            param.submitInfo.comment.formerComment = data;
            param.submitInfo.comment.date = getNowFormatDate();
            param.submitInfo.comment.articalId = $scope.articalId;
            param.type = 1;
            $scope.formerComment = {};
            $scope.submitInfo.comment.content = "";
        }else if (type == 2){
            var radios = document.getElementsByName("radio");
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
            param.submitInfo.donation = data;
            param.type = 4;
        }else if (type == 5){
            param.submitInfo.thumbUp = data;
            param.type = 5;
        }else if (type == 6){
            param.submitInfo.colleted = data;
            param.type = 6;
        }

        detailService.submit(param,function (data) {
            console.info("info: "+data);
        },function (data) {
            console.info("error: "+data);
        });
    }


    // 请求文章
    $scope.articalRequest = function () {
        var param = {};
        param.articalId = $scope.articalId;

        detailService.articalRequest(param,function (data) {
            $scope.category = data.artical.category.catName;
            $scope.author = data.artical.user.name;

            $scope.topic = data.artical.articalInfo.catName;
            $scope.htmlContent = data.artical.articalInfo.htmlContent;
            $scope.thumbupNum = data.artical.articalInfo.thumbupNum;
            $scope.readed = data.artical.articalInfo.readed;
            $scope.articalTime = data.artical.articalInfo.articalTime;
            $scope.commentNum = data.artical.articalInfo.commentNum;
            $scope.articalScore = data.artical.articalInfo.articalScore;
            $scope.labels = data.artical.articalInfo.labels;
            $scope.authorPost = data.artical.articalInfo.authorPost;
            $scope.relatedPost = data.artical.articalInfo.relatedPost;

            console.info("info: "+angular.toJson(data));
        },function (data) {
            console.info("error: "+data);
        });
    }





    // 分页处理逻辑
    $scope.pageChange = function () {
        var param = {};
        param.currentPage = $scope.pagination.currentPage;
        detailService.pageChange(param,function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            $scope.pageComments = data.comments;
            // $scope.tempComments = $scope.x.comments;
            // angular.forEach($scope.pageComments,function (item, index,array) {
            //     item.showReplyComment =false;
            // })

            console.info("info: "+angular.toJson(data));
            console.info('comment: '+angular.toJson(data.comments));
        },function (data) {
            console.info("error: "+data);
        });
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
        $('#myModal').modal('show');
    };
    //隐藏模板函数
    $scope.closeModal = function () {
        $('#myModal').modal('hide');
    };




}]);