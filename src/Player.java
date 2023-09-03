import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player {
    private List<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void addCardsToHand(List<Card> cards) {
        hand.addAll(cards);
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean hasAceOfSpades() {
        for (Card card : hand) {
            if (card.getRank().equals("Ace") && card.getSuit().equals("Spades")) {
                return true;
            }
        }
        return false;
    }

    public int chooseAction(List<Card> tableCards) {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

    public boolean callBluff(List<Card> tableCards) {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public List<Card> addCardsToTable(List<Card> tableCards) {
        Random rand = new Random();
        int cardIndex = rand.nextInt(hand.size());
        Card card = hand.remove(cardIndex);
        List<Card> cardsToAdd = new ArrayList<>();
        cardsToAdd.add(card);
        return cardsToAdd;
    }
}