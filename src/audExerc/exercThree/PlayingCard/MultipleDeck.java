package audExerc.exercThree.PlayingCard;

import java.util.Arrays;

public class MultipleDeck {
    private Deck[] decks;

    public MultipleDeck(int deckNumber) {
        decks = new Deck[deckNumber];
        for(int i = 0; i < deckNumber; i++)
            decks[i] = new Deck();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Deck deck : decks) {
            stringBuilder.append(deck);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MultipleDeck md = new MultipleDeck(3);
        System.out.println(md);
    }
}
