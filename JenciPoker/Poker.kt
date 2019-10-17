package hu.idomsoft.logging.ecs

import kotlin.random.Random

val deck = mutableListOf<Card>()

fun main(args: Array<String>) {
    val poker = Poker()
    poker.initDeck()
    val hand = poker.drawHand()
    println(hand)
    println(poker.evaluateHand(hand).title)
}

class Poker {

    /**
     * Összerakjuk a paklit
     */
    fun initDeck() {
        Suit.values().forEach { suit ->
            Rank.values().forEach { rank ->
                deck.add(Card(suit, rank))
            }
        }
    }

    /**
     * Öt lapot osztunk
     */
    fun drawHand(): MutableList<Card> {
        val hand = mutableListOf<Card>()

        for (i in 0..4) {
            hand.add(deck.removeAt(Random.nextInt(deck.size - i)))
        }

        return hand
    }

    /**
     * Lapok kiértékelése
     */
    fun evaluateHand(hand: MutableList<Card>): Hands {
        // értékük alapján sorbarendezzük a lapokat
        hand.sort()

        // azonos színek alapján elemezzük a lapokat
        val allSameSuit = allSameSuit(hand)

        if (allSameSuit) {
            if (royalFlush(hand)) {
                return Hands.ROYAL_FLUSH
            } else if (straight(hand)) {
                return Hands.STRAIGHT_FLUSH
            } else {
                return Hands.FLUSH
            }
        }

        // értékük alapján elemezzük a lapokat
        if (straight(hand)) {
            return Hands.STRAIGHT
        }

        // összeszámoljuk, hogy azonos értékű lapokból hány db van
        val numsOfSameRanks = countSameRanks(hand)
        if (numsOfSameRanks[0] == 4) {
            return Hands.FOUR_OF_A_KIND
        }

        if (numsOfSameRanks[0] == 3 && numsOfSameRanks[1] == 2) {
            return Hands.FULL_HOUSE
        }

        if (numsOfSameRanks[0] == 3 && numsOfSameRanks[1] == 1) {
            return Hands.THREE_OF_A_KIND
        }

        if (numsOfSameRanks[0] == 2 && numsOfSameRanks[1] == 2) {
            return Hands.TWO_PAIRS
        }

        if (numsOfSameRanks[0] == 2 && numsOfSameRanks[1] == 1) {
            return Hands.PAIR
        }

        return Hands.HIGH_CARD
    }

    /**
     * Megnézi, hogy az összes lap azonos színű-e
     */
    private fun allSameSuit(hand: MutableList<Card>): Boolean {
        val suit = hand[0].suit

        for (i in 1..4) {
            if (hand[i].suit != suit) {
                return false
            }
        }

        return true
    }

    private fun royalFlush(hand: MutableList<Card>): Boolean {
        return hand[0].rank == Rank.TEN
    }

    /**
     * Megnézi, hogy a lapok értékük szerint egymás után jönnek-e
     */
    private fun straight(hand: MutableList<Card>): Boolean {
        // ha a kettes a legkissebb érték, akkor meg kell nézni, hogy van-e ász
        if (hand[0].rank == Rank.TWO) {
            for(i in 1..3) {
                if (hand[i].rank.ordinal != Rank.TWO.ordinal + i) {
                    return false
                }
            }
            return hand[4].rank == Rank.ACE
        } else {
            val rank1 = hand[0].rank.ordinal
            for(i in 1..4) {
                if (hand[i].rank.ordinal != rank1 + i) {
                    return false
                }
            }

        }

        return true
    }

    /**
     * Összeszámolja, hogy egyforma értékű lapokból hány darab van
     * Egy listát ad vissza, csökkenő sorrendben, tehát A-A-K-5-5 esetén a lista 2-2-1 Int-eket fogja tartalmazni
     */
    private fun countSameRanks(hand: MutableList<Card>): List<Int> {
        val numOfSameRanks = mutableMapOf<Rank, Int>()

        hand.forEach {
            if (numOfSameRanks[it.rank] == null) {
                numOfSameRanks[it.rank] = 1
            } else {
                numOfSameRanks[it.rank] = numOfSameRanks[it.rank]!! + 1
            }
        }

        return numOfSameRanks.values.toList().sortedDescending()
    }
}

data class Card(val suit: Suit, val rank: Rank) : Comparable<Card> {
    override fun compareTo(other: Card): Int {
        return this.rank.compareTo(other.rank)
    }

    override fun toString(): String {
        return this.suit.char + this.rank.title
    }
}

enum class Rank(val title: String) {
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace"),
}

enum class Suit(val char: Char) {
    SPADE('\u2660'),
    HEART('\u2665'),
    DIAMOND('\u2666'),
    CLUB('\u2663'),
}

enum class Hands(val title: String) {
    HIGH_CARD("High card"),
    PAIR("Pair"),
    TWO_PAIRS("Two pairs"),
    THREE_OF_A_KIND("Three of a kind"),
    STRAIGHT("Straight"),
    FLUSH("Flush"),
    FULL_HOUSE("Full house"),
    FOUR_OF_A_KIND("Four of a kind"),
    STRAIGHT_FLUSH("Straight flush"),
    ROYAL_FLUSH("Royal flush")
}

