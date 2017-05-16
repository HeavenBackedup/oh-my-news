
app.controller('myWalletController',['$scope','mywalletService','user',function ($scope,mywalletService,user) {

    $scope.init = function () {
            var param1={};
            $scope.index = {};
            $scope.index.curIndex = 0;
            $scope.inputwithdraw=0;
            $scope.inputrecharge=0;
            var MaxMoney;
            $scope.userId = user.getId();
            param1.userId=$scope.userId;
            $scope.maxSize = 5;
            $scope.eventInPagination = {};
            $scope.eventOutPagination = {};
            $scope.eventInPagination.totalItems = 1;
            $scope.eventInPagination.currentPage = 10;
            $scope.eventOutPagination.totalItems = 1;
            $scope.eventOutPagination.currentPage = 10;
            $scope.incomeEventInit();
            $scope.payEventInit();


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

        $scope.incomeEventInit = function () {
            $scope.eventOutPagination.totalItems = 1;
            $scope.eventOutPagination.currentPage = 10;
            pageParam = {
                userId:$scope.userId,
                currentPage:1
            }
            mywalletService.getIncomeEventAll(pageParam,function (data) {
                $scope.eventsin=data.transactionPos;
                $scope.eventInPagination = data.pagination;
            },function (data) {
                console.error(data);
            })

        }

        $scope.payEventInit = function () {
            $scope.eventOutPagination.totalItems = 1;
            $scope.eventOutPagination.currentPage = 10;
            pageParam = {
                userId:$scope.userId,
                currentPage:1
            }
            mywalletService.getPayEventsAll(pageParam,function(data){
                $scope.eventsout=data.transactionPos;
                $scope.eventOutPagination = data.pagination;
            },function (data) {
                console.error(data);
            })
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
                $scope.payEventInit();
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
                $scope.incomeEventInit();
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

        $scope.pageChange = function (type) {
            if(type==0){
                mywalletService.getPayEventsAll({
                    userId:$scope.userId,
                    currentPage:$scope.eventOutPagination.currentPage
                },function(data){
                    $scope.eventsout=data.transactionPos;
                    $scope.eventOutPagination = data.pagination;
                },function (data) {
                    console.error(data);
                })
            }else {
                mywalletService.getIncomeEventAll({
                    userId:$scope.userId,
                    currentPage:$scope.eventInPagination.currentPage
                },function (data) {
                    $scope.eventsin=data.transactionPos;
                    $scope.eventInPagination = data.pagination;
                },function (data) {
                    console.error(data);
                })
            }


        }





}])