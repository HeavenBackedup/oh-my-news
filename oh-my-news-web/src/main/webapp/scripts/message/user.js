/**
 * Created by shj on 2017/4/15.
 */
app.factory('user',function () {
    var user = {};
    var userId = 1;
    user.setId = function (id) {
        userId = id;
    }

    user.getId = function () {
        return userId;
    }
    user.clearData = function () {
        userId = -1;
    }
    return user;
})