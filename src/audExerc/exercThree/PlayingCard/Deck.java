package audExerc.exercThree.PlayingCard;

public class Deck {
    private PlayingCard[] cards;
    private boolean[] picked;
    private int total;

    public Deck() {
        total = 0;
        cards = new PlayingCard[52];
        picked = new boolean[52];
        for (int i = 0; i < PlayingCardType.values().length; i++) {
            for (int j = 0; j < 13; j++) {
                cards[i * 13 + j] = new PlayingCard(j + 2, PlayingCardType.values()[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PlayingCard playingCard : cards) {
            result.append(playingCard);
            result.append("\n");
        }
        return result.toString();
    }

    public PlayingCard dealCard() {
        if (total == 52) return null;
        int card = (int) (Math.random() * 52);
        if (!picked[card]) {
            ++total;
            picked[card] = true;
            return cards[card];
        }
        return dealCard();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        PlayingCard card;
        while ((card = deck.dealCard()) != null) {
            System.out.println(card);
        }
    }
}
