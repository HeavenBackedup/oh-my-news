/**
 * Created by shj on 2017/4/15.
 */
app.factory('user',function ($sessionStorage) {
    var user = {};

    // var user = {};
    // var userId = -1;
    user.setId = function (id) {
        $sessionStorage.userId = id;
    };

    user.getId = function () {
        try {
            var res= parseInt($sessionStorage.userId);
            if(isNaN(res))
                $sessionStorage.userId=-1;
            return $sessionStorage.userId;
        }catch (e){
            $sessionStorage.userId = -1;
            return $sessionStorage.userId;
        }

    };
    user.clearData = function () {
        $sessionStorage.userId= -1;
    };
    return user;
})