package hu.idomsoft.logging.ecs

import spock.lang.Specification

class PokerTest extends Specification {
    private poker = new Poker()

    def "EvaluateHand-Royal flush"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.TEN))
        hand.add(new Card(Suit.CLUB, Rank.JACK))
        hand.add(new Card(Suit.CLUB, Rank.QUEEN))
        hand.add(new Card(Suit.CLUB, Rank.KING))
        hand.add(new Card(Suit.CLUB, Rank.ACE))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.ROYAL_FLUSH
    }

    def "EvaluateHand-Straight flush"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.EIGHT))
        hand.add(new Card(Suit.CLUB, Rank.NINE))
        hand.add(new Card(Suit.CLUB, Rank.TEN))
        hand.add(new Card(Suit.CLUB, Rank.JACK))
        hand.add(new Card(Suit.CLUB, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.STRAIGHT_FLUSH
    }

    def "EvaluateHand-Four of a kind"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.EIGHT))
        hand.add(new Card(Suit.SPADE, Rank.EIGHT))
        hand.add(new Card(Suit.HEART, Rank.EIGHT))
        hand.add(new Card(Suit.DIAMOND, Rank.EIGHT))
        hand.add(new Card(Suit.CLUB, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.FOUR_OF_A_KIND
    }

    def "EvaluateHand-Full house"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.EIGHT))
        hand.add(new Card(Suit.SPADE, Rank.EIGHT))
        hand.add(new Card(Suit.HEART, Rank.EIGHT))
        hand.add(new Card(Suit.DIAMOND, Rank.QUEEN))
        hand.add(new Card(Suit.CLUB, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.FULL_HOUSE
    }

    def "EvaluateHand-Flush"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.EIGHT))
        hand.add(new Card(Suit.CLUB, Rank.ACE))
        hand.add(new Card(Suit.CLUB, Rank.TWO))
        hand.add(new Card(Suit.CLUB, Rank.TEN))
        hand.add(new Card(Suit.CLUB, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.FLUSH
    }

    def "EvaluateHand-Straight"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.SEVEN))
        hand.add(new Card(Suit.DIAMOND, Rank.FOUR))
        hand.add(new Card(Suit.CLUB, Rank.SIX))
        hand.add(new Card(Suit.HEART, Rank.FIVE))
        hand.add(new Card(Suit.SPADE, Rank.THREE))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.STRAIGHT
    }

    def "EvaluateHand-Straight-ace"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.FIVE))
        hand.add(new Card(Suit.DIAMOND, Rank.TWO))
        hand.add(new Card(Suit.CLUB, Rank.FOUR))
        hand.add(new Card(Suit.HEART, Rank.THREE))
        hand.add(new Card(Suit.SPADE, Rank.ACE))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.STRAIGHT
    }

    def "EvaluateHand-Three of a kind"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.THREE))
        hand.add(new Card(Suit.SPADE, Rank.THREE))
        hand.add(new Card(Suit.DIAMOND, Rank.THREE))
        hand.add(new Card(Suit.CLUB, Rank.TEN))
        hand.add(new Card(Suit.HEART, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.THREE_OF_A_KIND
    }

    def "EvaluateHand-Two pairs"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.THREE))
        hand.add(new Card(Suit.SPADE, Rank.THREE))
        hand.add(new Card(Suit.DIAMOND, Rank.FOUR))
        hand.add(new Card(Suit.HEART, Rank.FOUR))
        hand.add(new Card(Suit.HEART, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.TWO_PAIRS
    }

    def "EvaluateHand-Pair"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.THREE))
        hand.add(new Card(Suit.SPADE, Rank.THREE))
        hand.add(new Card(Suit.DIAMOND, Rank.FOUR))
        hand.add(new Card(Suit.HEART, Rank.FIVE))
        hand.add(new Card(Suit.HEART, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.PAIR
    }

    def "EvaluateHand-High card"() {
        given:
        def hand = new ArrayList<Card>(5)
        hand.add(new Card(Suit.CLUB, Rank.THREE))
        hand.add(new Card(Suit.SPADE, Rank.NINE))
        hand.add(new Card(Suit.DIAMOND, Rank.FOUR))
        hand.add(new Card(Suit.HEART, Rank.FIVE))
        hand.add(new Card(Suit.HEART, Rank.QUEEN))
        when:
        def value = poker.evaluateHand(hand)
        then:
        value == Hands.HIGH_CARD
    }
}
