 /**
 * Created by shj on 2017/4/11.
 */
app.controller('templateController',['$scope','templateService',function ($scope,templateService) {



    $scope.init = function () {
        $scope.input = "";
        $scope.inputRes = "";
        $scope.pagination = {};
        $scope.pageItems = {};
        $scope.pagination.totalItems = 200;
        $scope.pagination.currentPage = 2;
        $scope.pagination.maxSize = 5;
        moment.locale("zh-cn");
    }


    $scope.inputCommit = function () {
        var param = {};
        param.value = $scope.input;
       templateService.getInput(param,function (data) {
           $scope.inputRes = data;
       },function(data){
           console.info("error:  "+data);
       });
    }

    $scope.pageChange = function () {
        var param = {};
        param.currentPage = $scope.pagination.currentPage;
        templateService.pageChange(param,function (data) {
            $scope.pagination.totalItems = data.pagination.totalItems;
            $scope.pagination.currentPage = data.pagination.currentPage;
            $scope.pageItems = data.items;
        },function (data) {
            console.info("error: "+data);
        });
    }

    // 图片上传代码
    $scope.uploadFiles = function(file, errFiles) {
        // $scope.file = file;
        // $scope.errFile = errFiles && errFiles[0];
        // if (file) {
        //
        //     file.upload = Upload.upload({
        //         url: 'http://localhost:8080/oh-my-news-web/template/upload.do',
        //         data: {file: file}
        //     });
        //
        //     file.upload.then(function (response) {
        //         $timeout(function () {
        //             file.result = response.data;
        //         });
        //     }, function (response) {
        //         if (response.status > 0)
        //             $scope.errorMsg = response.status + ': ' + response.data;
        //     }, function (evt) {
        //         file.progress = Math.min(100, parseInt(100.0 *
        //             evt.loaded / evt.total));
        //     });
        // }
        fileService.fileUpload(file,
            // 图片上传成功处理逻辑，data包含两个属性，id，数据库存储id,url图片访问的url
            function (data) {
           var name= file.name;
            console.info("file data: "+angular.toJson(data));
            $scope.fileName = name;
            $scope.path = data.url;

        },
           //图片上传失败树立逻辑
            function (data) {
            alert(angular.toJson(data));
        });
    }



    $scope.myInterval = 5000;
    $scope.noWrapSlides = true;
    $scope.active = 0;
    var slides = $scope.slides = [];
    $scope.addSlide = function () {
        var newWidth = 600 + slides.length + 1;
        slides.push({
            image: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94OfEh0bOlAlopvOVPAWe3GEKAgj6ULuupkVhtYZ0pIxzzk5gY59xSWJ95SOIxsbCuJg/1280x800',
            text: 'nsfocus',
        });
        slides.push({
            image: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94PqYvguSpXFVwv-URAD3mGBHRgzaceuqqk1BlN5IrcUvxlp8d5t8BX595SOKdq0CMpw/1280x800',
            text: 'nsfocus',
        });
        slides.push({
            image: 'http://cdn.steamcommunity.com/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94PqUrgrStA1tw6OZBXGTgH0fQ1j-WeOeskQUxYcYuI02hkpgYuNZRW595SOLioa6j6w/1280x800',
            text: 'nsfocus',
        });
        slides.push({
            image: 'http://steamcommunity-a.akamaihd.net/economy/image/U8721VM9p9C2v1o6cKJ4qEnGqnE7IoTQgZI-VTdwyTBeimAcIoxXpgK8bPeslY9pPJIvB5IWW2-452kaM8heLSRgleGArrBBwe94aqAq0-T4CVtyvLEUV2C1F0jU3mOTfrqqwlM0McZ9cBv0yckdvNxTUJ95SOId8xoS5w/1280x800',
            text: 'nsfocus',
        });
    };
    $scope.addSlide();


    $scope.parse = function () {
        alert(angular.toJson(htmlParseService.parseHtml(content.getTemplate().htmlContent)));
    };


    $scope.getResource = function () {
        templateService.getTemplateJson(function (data) {
            alert(angular.toJson(data));
        },function (data) {
            console.error(data);
        });
    }


    $scope.goto = function (id) {
        $location.hash(id);
        $anchorScroll();
    };





}])