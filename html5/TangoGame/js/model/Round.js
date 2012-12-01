Round = (function () {
  var id;
  var cardsInGame;
  var startTime;

  function Round(id) {
      this.id = id;
      this.cardsInGame = 0;
      this.startTime = "prueba";
  }

  return Round;
})();