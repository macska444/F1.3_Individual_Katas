package com.company;

import java.util.*;

public class PokerHand {

    private final List<Card> cards;

    public PokerHand(List<Card> pokerHandCards){
        if(pokerHandCards == null){
            throw new NullPointerException("lapok");
        }
        if(pokerHandCards.size() != 5){
            throw new IllegalArgumentException("lapok száma nem 5");
        }

        this.cards = pokerHandCards;
    }

    public Result evaluate(){
        Collections.sort(cards);
        Optional<Result> result = evaluateByOccurrence(cards);
        if(!result.isPresent()){
            result = evaluateByStraightAndColor(cards);
        }
        return result.orElse(Result.of(CardCombination.NONE));
    }

    private Optional<Result> evaluateByStraightAndColor(List<Card> cards) {
        boolean isStraight = isStraight(cards);
        boolean isFlush = cards.stream().allMatch(c -> c.getColor().equals(cards.get(0).getColor()));
        boolean isRoyalFlush = isFlush && cards.get(0).getCardSign().equals(CardSign.TEN);
        if(isRoyalFlush){
            return Optional.of(Result.of(CardCombination.ROYAL_FLUSH));
        }else if(isStraight && isFlush){
            return Optional.of(Result.of(CardCombination.STRAIGHT_FLUSH));
        }else if(isFlush){
            return Optional.of(Result.of(CardCombination.FLUSH));
        }else if(isStraight){
            return Optional.of(Result.of(CardCombination.STRAIGHT));
        }

        return Optional.empty();
    }

    private boolean isStraight(List<Card> cards) {
        boolean isStraight = true;
        boolean hasAce = cards.stream().anyMatch(c -> c.getCardSign().equals(CardSign.ACE));
        boolean aceCanFirst = hasAce && cards.get(0).getCardSign().getSorszam() == 2;


        int lastIndex = cards.size()-1;
        for(int i = 1; i < cards.size() && isStraight; i++){
            if(aceCanFirst && i == lastIndex){
                isStraight = true;
            }else {
                isStraight = isNextCardBySign(cards.get(i - 1), cards.get(i));
            }
        }
        return isStraight;
    }

    private boolean isNextCardBySign(Card card, Card nextCard) {
        return card.getCardSign().getSorszam() - nextCard.getCardSign().getSorszam() == -1;
    }

    private Optional<Result> evaluateByOccurrence(List<Card> cards) {
        Map<CardSign, Integer> signsWithCount = getCardSignWithCountMap(cards);
        boolean hasFourOfKind = signsWithCount.entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 4);
        // a többit ki se értékeljük, ha 4 ugyanaz, ez a legmagasabb hand ami értelmezhető
        if(hasFourOfKind){
            return Optional.of(Result.of(CardCombination.FOUR_OF_KIND));
        }

        boolean hasThreeOfKind = signsWithCount.entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 3);
        boolean hasPair = signsWithCount.entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 2);
        boolean hasTwoPair = signsWithCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .count() == 2;
        if(hasPair && hasThreeOfKind){
            return Optional.of(Result.of(CardCombination.FULL_HOUSE));
        }else if(hasThreeOfKind){
            return Optional.of(Result.of(CardCombination.THREE_OF_KIND));
        }else if(hasTwoPair){
            return Optional.of(Result.of(CardCombination.TWO_PAIR));
        }else if(hasPair){
            return Optional.of(Result.of(CardCombination.ONE_PAIR));
        }
        return Optional.empty();
    }

    private Map<CardSign, Integer> getCardSignWithCountMap(List<Card> cards) {
        Map<CardSign,Integer> signsWithCount = new HashMap<>();

        for(Card card : cards){
            if(!signsWithCount.containsKey(card.getCardSign())){
                signsWithCount.put(card.getCardSign(),1);
            }else{
                signsWithCount.computeIfPresent(
                        card.getCardSign(),
                        (cardFromMap, count) -> ++count);
            }
        }
        return signsWithCount;
    }

}
