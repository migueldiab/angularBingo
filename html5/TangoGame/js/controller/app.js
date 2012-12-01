/**
 * Created with JetBrains WebStorm.
 * User: migueldiab
 * Date: 28/05/12
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
console.log("Loading App");
define([
    "jquery"
    ,"angular"
  ],
  function (jquery, angular) {

  var initialize = function () {

    angular.module('game-cards', [])
      .directive('gameCards', function() {
        var directiveDefinitionObject = {
          restrict: 'E',
          replace: false,
          templateUrl: './partials/gameCards.html'
         };
        return directiveDefinitionObject;
    });


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
      .directive('navigationBar',
      function() {
        var directiveDefinitionObject = {
          restrict: 'E',
          replace: false,
          templateUrl: './partials/navigationBar.html'
        };
        return directiveDefinitionObject;
    });

    angular.module('tangoBingo',
      ['navigation-bar'
        , 'game-cards'
        , 'cards'
        , 'round-info'
        , 'player-info'
        , 'chat-panel'
      ]);
    };

  return {
    initialize: initialize
  };
});