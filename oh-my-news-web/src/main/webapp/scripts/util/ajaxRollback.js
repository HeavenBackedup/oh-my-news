/**
 * Created by shj on 2017/4/11.
 */
app.factory('ajaxRollback',function () {
        var ajaxRollback = {};
        ajaxRollback.successRollBack = function (success,failed,otherwise) {
            return function (result) {
                if(result.code=='0'){
                    if(angular.isDefined(success)){
                        success(result.data);
                    }

                }else if(result.code=='-1'){
                    if(angular.isDefined(failed)){
                        failed(result.data);
                    }

                }else {
                    if(angular.isDefined(otherwise)){
                        otherwise(result.data);
                    }
                }
            }
        }
        ajaxRollback.errorRollBack = function () {
            return function (error) {
                console.error(error)
            }
        }

        return ajaxRollback;
})