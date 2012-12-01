function RoundController($scope) {
  console.log("Loading Round Controller");
  $scope.game = new Game();
  $scope.currentRound = new Round(1234);
}
