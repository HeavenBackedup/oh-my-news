
app.controller('progressBarController',['$scope','my-wallet-Service',function ($scope,my_wallet_Service) {
            $scope.init=function () {
                $scope.money=1000;
                $scope.valuenow="";

            }

            var add=0;
            var minus=0;
            my_wallet_Service.getRecharge(param,function (data) {
                add=data;
            })
            my_wallet_Service.getWithdraw(param,function (data) {
                minus=data;

            })
            $scope.money=1000+add-minus;
            $scope.valuenow=$scope.money/1000;


}])
app.controller('rechargeController',['$scope','my_wallet_Service',function ($scope,my_wallet_Service) {
    $scope.init=function () {
        $scope.input="";
        $scope.inputRes="";
    }
    $scope.recharge = function () {
        var param = {};
        param.value = $scope.input;
        my_wallet_Service.getRecharge(param,function (data) {
            $scope.inputRes = data;
        },function(data){
            console.info("error:  "+data)
        })
    }
    alert("确认充值？")
}])
app.controller('withdrawController',['$scope','my_wallet_Service',function ($scope,my_wallet_Service) {
    $scope.init=function () {
        $scope.input="";
        $scope.inputRes="";
    }

    $scope.withdraw = function () {
        var param = {};
        param.value = $scope.input;
        my_wallet_Service.getWithdraw(param,function (data) {
            $scope.inputRes = data;
        },function(data){
            console.info("error:  "+data)
        })
    }
    alert("确认提现？")

}])
app.controller('payController',['$scope','my_wallet_service',function ($scope,my_wallet_Service) {
        var count=0;
        my_wallet_Service.getWithdraw(param,function(data){
            count=data;
          })
        my_wallet_Service.getPayevents(param,function (data) {
            $scope.events=data;

        })
        $scope.events.sum=count;


}])
app.controller('incomeController',['$scope','my_wallet_service',function ($scope,my_wallet_Service) {
        var count=0;
        my_wallet_Service.getRecharge(param,function(data){
            count=data;
        })
        my_wallet_Service.getIncomeevents(param,function (data) {
            $scope.events=data;

        })
        $scope.events.sum=count;




}])