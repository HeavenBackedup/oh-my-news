/**
 * Created by shj on 2017/4/19.
 */
app.factory('constant',function () {
    var constant = {};

    var imgTagName = 'img';
    var videoTagName = 'video';

    constant.getImgTagName = function () {
        return imgTagName;
    };

    constant.getVideoTagName = function () {
        return videoTagName;
    };

    constant.getUrlTagName = function () {
        return [imgTagName,videoTagName];
    };


    return constant;

})