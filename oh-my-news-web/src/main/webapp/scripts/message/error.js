/**
 * Created by shj on 2017/4/12.
 */
app.factory('error',function () {
    var error = {};
    error.data = "";
    error.setData = function (data) {
        error.data = data;
    }

    error.getData = function () {
        return error.data;
    }
    error.clearData = function () {
        error.data = "";
    }
    return error;
})