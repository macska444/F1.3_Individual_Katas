package com.company;

public class Result {
    private CardCombination cardCombination;

    public static Result of(CardCombination cardCombination){
        Result result = new Result();
        result.setCardCombination(cardCombination);
        return result;
    }

    public CardCombination getCardCombination() {
        return cardCombination;
    }

    public void setCardCombination(CardCombination cardCombination) {
        this.cardCombination = cardCombination;
    }
}
