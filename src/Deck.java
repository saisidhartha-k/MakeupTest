import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void distribute(List<Player> players) {
        int playerIndex = 0;
        for (Card card : cards) {
            players.get(playerIndex).addCardToHand(card);
            playerIndex++;
            if (playerIndex == players.size()) {
                playerIndex = 0;
            }
        }
    }
}