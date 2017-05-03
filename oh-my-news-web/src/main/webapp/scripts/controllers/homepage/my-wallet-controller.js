
app.controller('my-wallet-controller',['$scope','my-wallet-Service',function ($scope,my_wallet_Service) {
                $scope.init=function () {
                    $scope.money=1000;
                    $scope.valuenow="";
                    $scope.input="";
                    $scope.inputrecharge="";
                    $scope.inputwithdraw="";

                }

                $scope.ballance=function () {
                    var add=0;
                    var minus=0;
                    add=$scope.inputrecharge;
                    minus=$scope.inputwithdraw;
                    $scope.money=1000+add-minus;
                    $scope.valuenow=$scope.money/1000;

            }
                $scope.payeventschange=function() {
                     var param={};
                     param.rmb= $scope.inputwithdraw;
                     my_wallet_Service.getPayevents(param,function (data) {
                        $scope.events = data.myWallet;
                     })
                }

                $scope.incomeeventschange=function() {
                    var param={};
                    param.rmb= $scope.inputrecharge;
                    my_wallet_Service.getIncomeevents(param, function (data) {
                        $scope.events = data.myWallet;
                    })

                }
}])