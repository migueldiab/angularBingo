Game = (function () {
  var name;
  var jackpot;
  var jackpotBalls;

  function Game() {
    this.name = "Un Nuevo Juego";
    this.jackpot = new Money(0, "BRL");
    this.jackpotBalls = 50;

  };
  return Game;
})();
