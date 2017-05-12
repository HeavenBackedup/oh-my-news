/**
 * Created by shj on 2017/4/15.
 */
app.factory('user',['$cookieStore',function ($cookieStore) {
    var user = {};

    // var user = {};
    // var userId = -1;
    user.setId = function (id) {
        $cookieStore.userId = id;
    };

    user.getId = function () {
        try {
            return parseInt($cookieStore.userId);
        }catch (e){
            $cookieStore.userId = -1;
            return $cookieStore.userId;
        }

    };
    user.clearData = function () {
        $cookieStore.userId= -1;
    };
    return user;
}])