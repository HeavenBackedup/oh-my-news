
app.controller('progressBarController',['$scope','myWalletService',function ($scope,myWalletService) {
            $scope.init=function () {
                $scope.money=1000;
                $scope.valuenow="";

            }

            var add=0;
            var minus=0;
    myWalletService.getRecharge(param,function (data) {
                add=data;
            })
    myWalletService.getWithdraw(param,function (data) {
                minus=data;

            })
            $scope.money=1000+add-minus;
            $scope.valuenow=$scope.money/1000;


}])
app.controller('rechargeController',['$scope','myWalletService',function ($scope,myWalletService) {
    $scope.init=function () {
        $scope.input="";
        $scope.inputRes="";
    }
    $scope.recharge = function () {
        var param = {};
        param.value = $scope.input;
        myWalletService.getRecharge(param,function (data) {
            $scope.inputRes = data;
        },function(data){
            console.info("error:  "+data)
        })
    }
    alert("确认充值？")
}])
app.controller('withdrawController',['$scope','myWalletService',function ($scope,myWalletService) {
    $scope.init=function () {
        $scope.input="";
        $scope.inputRes="";
    }

    $scope.withdraw = function () {
        var param = {};
        param.value = $scope.input;
        myWalletService.getWithdraw(param,function (data) {
            $scope.inputRes = data;
        },function(data){
            console.info("error:  "+data)
        })
    }
    alert("确认提现？")

}])
app.controller('payController',['$scope','myWalletService',function ($scope,myWalletService) {
        var count=0;
    myWalletService.getWithdraw(param,function(data){
            count=data;
          })
    myWalletService.getPayevents(param,function (data) {
            $scope.events=data;

        })
        $scope.events.sum=count;


}])
app.controller('incomeController',['$scope','myWalletService',function ($scope,myWalletService) {
        var count=0;
    myWalletService.getRecharge(param,function(data){
            count=data;
        })
    myWalletService.getIncomeevents(param,function (data) {
            $scope.events=data;

        })
        $scope.events.sum=count;




}])