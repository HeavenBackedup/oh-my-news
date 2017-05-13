
app.controller('myWalletController',['$scope','mywalletService','user',function ($scope,mywalletService,user) {

    $scope.init = function () {
            var param1={};
            $scope.inputwithdraw=0;
            $scope.inputrecharge=0;
            var MaxMoney;
            $scope.userId = user.getId();
            param1.userId=$scope.userId;

            mywalletService.getPayevents(param1,function(data){
                $scope.eventsout=data;
            },function (data) {
                console.error(data);
            })
            mywalletService.getIncomeevents(param1,function (data) {
                $scope.eventsin=data;
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

        }


        $scope.ballance = function () {
            var param1={};

            $scope.userId = user.getId();
            param1.userId=$scope.userId;
            mywalletService.getFigure(param1,function (data) {
                $scope.money=data;
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
            param.inputwithdraw = $scope.inputwithdraw;
            param.userId= $scope.userId;
            mywalletService.setWithdraw(param, function (data) {
                alert(data);
                mywalletService.getPayevents(param, function (data) {

                    $scope.eventsout=data;
                },function (data) {
                    console.error("error:  "+data);
                })
                mywalletService.getFigure(param,function (data) {
                    $scope.money=data;
                    mywalletService.getMaxFigure(param,function (data) {
                        $scope.MaxMoney=data;
                        $scope.valuenow = $scope.money/$scope.MaxMoney/0.01;
                    },function (data) {
                        console.error(data);
                    })
                },function (data) {
                    console.error(data);
                })


            },function (data) {
                        console.error("error:  "+data);
            })



        }

        $scope.recharge = function () {
            var param = {};
            $scope.userId = user.getId();

            param.inputrecharge = $scope.inputrecharge;
            param.userId= $scope.userId;
            mywalletService.setRecharge(param, function (data) {

                // $scope.inputInRes=data;
                alert(data);
                mywalletService.getIncomeevents(param, function (data) {
                    $scope.eventsin=data;

                },function (data) {
                    console.error("error:  "+data);
                })
                mywalletService.getFigure(param,function (data) {
                    $scope.money=data;
                    mywalletService.getMaxFigure(param,function (data) {
                        $scope.MaxMoney=data;
                        $scope.valuenow = $scope.money/$scope.MaxMoney/0.01;
                    },function (data) {
                        console.error(data);
                    })
                },function (data) {
                    console.error(data);
                })


            },function (data) {
                console.error(data);
            })



        }




}])