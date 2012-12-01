console.log('Starting Main!');
requirejs.config({
  //By default load any module IDs from js
  baseUrl: 'js'
  ,paths: {
    jquery: 'libs/jquery'
    ,bootstrap: 'libs/bootstrap'
    ,angular: 'libs/angular'
    ,tango: 'controller/app'
  }
    ,priority: [
      "jquery"
      ,"angular"
    ]

});

// Start the main app logic.
requirejs(
  ['angular'
    ,'jquery'
    ,'tango'
    ,'controller/roundController'
    ,'controller/bingoController'
    ,'model/Game'
    ,'model/Round'
    ,'model/Money'
  ],
  function(angular, $, tango) {
    console.log("App Main : " + tango);
    tango.initialize();


  }
);
