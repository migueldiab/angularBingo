/**
 * Created with JetBrains WebStorm.
 * User: migueldiab
 * Date: 28/05/12
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
var GLOBAL_SCOPE;
function BingoCountdown($scope) {
  GLOBAL_SCOPE = $scope;
    $scope.lbl_next_round = "PROXIMA RONDA";
    $scope.next_round = "03:56";
    $scope.lbl_next_round_prizes = "TOTAL DE PREMIOS";
    $scope.next_round_prizes = "U$S 15.70";
    $scope.lbl_time = "HORA";
    $scope.next_round_time = "16:35:00";
}


angular.module('cards', [])
  .directive('card', function() {
    var directiveDefinitionObject = {
      restrict: 'E',
      replace: false,
      scope: {
        card: 'bind'
      },
      
      templateUrl: './partials/card.html'
    };
    return directiveDefinitionObject;
  });
  
angular.module('round-info', [])
  .directive('roundInfo', function() {
    var directiveDefinitionObject = {
      restrict: 'E',
      replace: false,      
      templateUrl: './partials/roundInfo.html'
    };
    return directiveDefinitionObject;
  });
  
angular.module('player-info', [])
  .directive('playerInfo', function() {
    var directiveDefinitionObject = {
      restrict: 'E',
      replace: false,      
      templateUrl: './partials/playerInfo.html'
    };
    return directiveDefinitionObject;
  });
  
angular.module('chat-panel', [])
  .directive('chatPanel', function() {
    var directiveDefinitionObject = {
      restrict: 'E',
      replace: false,      
      templateUrl: './partials/chatPanel.html'
    };
    return directiveDefinitionObject;
  });
  
angular.module('navigation-bar', [])
  .directive('navigationBar', function() {
    var directiveDefinitionObject = {
      restrict: 'E',
      replace: false,      
      templateUrl: './partials/navigationBar.html'
    };
    return directiveDefinitionObject;
  });
  
angular.module('tangoBingo', ['navigation-bar', 'cards', 'round-info', 'player-info', 'chat-panel']);

