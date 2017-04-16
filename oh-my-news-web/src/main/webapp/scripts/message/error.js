/**
 * Created by shj on 2017/4/12.
 */
app.factory('error',function () {
    var error = {};
    var data = "";
    error.setData = function (data) {
        this.data = data;
    }

    error.getData = function () {
        return this.data;
    }
    error.clearData = function () {
        this.data = "";
    }
    return error;
})