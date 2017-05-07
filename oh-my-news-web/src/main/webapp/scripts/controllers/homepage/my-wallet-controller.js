
app.controller('myWalletController',['$scope','mywalletService',function ($scope,mywalletService) {
                $scope.init=function () {
                    $scope.money=Number(1000.0);
                    $scope.valuenow=0;
                    $scope.inputrecharge="";
                    $scope.inputwithdraw="";

                }

                $scope.ballance=function () {
                    var add=0.0;
                    var minus=0.0;
                    add=Number($scope.inputrecharge);
                    minus=Number($scope.inputwithdraw);
                    $scope.money=Number(1000+add-minus);
                    $scope.valuenow=$scope.money/1000;

            }

                $scope.withdraw=function(){
                    var param={};
                    param.value=$scope.inputwithdraw;
                    alert('get');
                    mywalletService.getPayevents(param,function (data) {
                        alert('dataget');
                        console.info(angular.toJson(data));
                        $scope.eventsout = data.myWallet;
                    },function (data) {
                        console.error(data);
                    })
                }

                $scope.recharge=function(){
                    var param={};
                    param.value=$scope.inputrecharge;
                    mywalletService.getIncomeevents(param,function (data) {
                        $scope.eventsin = data.myWallet;
                    })


                }




}])