
app.controller('myWalletController',['$scope','mywalletService','user',function ($scope,mywalletService,user) {

    $scope.init = function () {
            var param1={};
            var MaxMoney;
            $scope.userId = user.getId();
            param1.userId=$scope.userId;
            mywalletService.getPayevents(param1,function(data){
                $scope.eventsout=data.Paylist
            },function (data) {
                console.error(data);
            })
            mywalletService.getIncomeevents(param1,function (data) {
                $scope.eventsin=data.Incomelist
            },function (data) {
                console.error(data);
            })
            mywalletService.getFigure(param1,function (data) {
                $scope.money=data.figure;
            },function (data) {
                console.error(data);
            })
            mywalletService.getMaxFigure(param1,function (data) {
                MaxMoney=data.maxFigure
            },function (data) {
                console.error(data);
            })
            $scope.valuenow = $scope.money/MaxMoney/0.01;
            $scope.inputrecharge = "";
            $scope.inputwithdraw = "";

        }


        $scope.ballance = function () {

            mywalletService.getFigure(param1,function (data) {
                $scope.money=data.figure;
            },function (data) {
                console.error(data);
            })
            mywalletService.getMaxFigure(param1,function (data) {
                MaxMoney=data.maxFigure
            },function (data) {
                console.error(data);
            })

            $scope.valuenow = $scope.money/MaxMoney/0.01;

        }



        $scope.withdraw = function () {
            var param = {};
            $scope.userId = user.getId();
            param.inputwithdraw = $scope.inputwithdraw;
            param.userId= $scope.userId;
            mywalletService.setWithdraw(param, function (data) {
                  $scope.eventsout=data.Paylist;
                 },function (data) {
                        console.error(data);
            })

            mywalletService.getPayevents(param, function (data) {

                $scope.inputOutRes=data;
            },function (data) {
                console.error("error:  "+data);
            })

        }

        $scope.recharge = function () {
            var param = {};
            $scope.userId = user.getId();
            param.inputrecharge = $scope.inputrecharge;
            param.userId= $scope.userId;
            mywalletService.getIncomeevents(param, function (data) {

                $scope.eventsin=data.Incomelist;
            },function (data) {
                console.error(data);
            })
            mywalletService.setRecharge(param, function (data) {

                $scope.inputInRes=data;
            },function (data) {
                console.error("error:  "+data);
            })


        }




}])