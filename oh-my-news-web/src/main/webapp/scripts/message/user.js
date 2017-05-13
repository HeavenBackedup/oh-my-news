/**
 * Created by shj on 2017/4/15.
 */
app.factory('user',function ($localStorage) {
    var user = {};

    // var user = {};
    // var userId = -1;
    user.setId = function (id) {
        $localStorage.userId = id;
    };
    user.setParamId = function (id) {
        $localStorage.paramId = id;
    };
    user.getParamId = function () {
        try {
            var res= parseInt($localStorage.paramId);
            if(isNaN(res))
                $localStorage.paramId=-1;
            return $localStorage.paramId;
        }catch (e){
            $localStorage.paramId = -1;
            return $localStorage.paramId;
        }
    }

    user.getId = function () {
        try {
            var res= parseInt($localStorage.userId);
            if(isNaN(res))
                $localStorage.userId=-1;
            return $localStorage.userId;
        }catch (e){
            $localStorage.userId = -1;
            return $localStorage.userId;
        }

    };
    user.clearData = function () {
        $localStorage.userId= -1;
    };
    return user;
})