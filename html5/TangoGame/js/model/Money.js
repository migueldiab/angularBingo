Money = (function () {
    var amount = 0;
    var currency = "BRL";
    var symbol = "R$";

    function Money(amount, currency) {
        this.amount = amount;
        this.currency = currency;
    }

    return Money;
})();