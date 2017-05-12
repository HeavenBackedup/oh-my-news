
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
                $scope.money=data;
            },function (data) {
                console.error(data);
            })
            mywalletService.getMaxFigure(param1,function (data) {
                $scope.MaxMoney=data;
            },function (data) {
                console.error(data);
            })
            $scope.valuenow = $scope.money/MaxMoney/0.01;
            $scope.inputrecharge = "";
            $scope.inputwithdraw = "";

        }


        $scope.ballance = function () {
            var param1={};

            $scope.userId = user.getId();
            param1.userId=$scope.userId;
            mywalletService.getFigure(param1,function (data) {
                $scope.money=data;
                console.info($scope.money);
            },function (data) {
                console.error(data);
            })
            mywalletService.getMaxFigure(param1,function (data) {
               $scope.MaxMoney=data;
                console.log($scope.MaxMoney);
            },function (data) {
                console.error(data);
            })





        }



        $scope.withdraw = function () {
            var param = {};
            $scope.userId = user.getId();
            param.inputwithdraw = $scope.inputwithdraw;
            param.userId= $scope.userId;
            mywalletService.setWithdraw(param, function (data) {
                  $scope.inputOutRes=data;
                mywalletService.getPayevents(param, function (data) {

                    $scope.eventsout=data;
                },function (data) {
                    console.error("error:  "+data);
                })
                mywalletService.getFigure(param,function (data) {
                    $scope.money=data;
                },function (data) {
                    console.error(data);
                })
                mywalletService.getMaxFigure(param,function (data) {
                    $scope.MaxMoney=data;
                },function (data) {
                    console.error(data);
                })
                $scope.valuenow = $scope.money/$scope.MaxMoney/0.01;
            },function (data) {
                        console.error("error:  "+data);
            })



        }

        $scope.recharge = function () {
            var param = {};
            $scope.userId = user.getId();

            param.inputrecharge = $scope.inputrecharge;
            param.userId= $scope.userId;
            console.info( param.userId)
            mywalletService.setRecharge(param, function (data) {

                $scope.inputInRes=data;

                mywalletService.getIncomeevents(param, function (data) {
                    $scope.eventsin=data;

                },function (data) {
                    console.error("error:  "+data);
                })
                mywalletService.getFigure(param,function (data) {
                    $scope.money=data;
                },function (data) {
                    console.error(data);
                })
                mywalletService.getMaxFigure(param,function (data) {
                    $scope.MaxMoney=data;
                },function (data) {
                    console.error(data);
                })
                $scope.valuenow = $scope.money/$scope.MaxMoney/0.01;
            },function (data) {
                console.error(data);
            })



        }




}])