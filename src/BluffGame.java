
import java.util.*;

public class BluffGame {
    private List<Player> players;
    private Deck deck;
    private List<Card> tableCards;
    private int currentPlayerIndex;
    private int passesInARow;

    public BluffGame(int numPlayers) {
        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
        }
        deck = new Deck();
        tableCards = new ArrayList<>();
        currentPlayerIndex = 0;
        passesInARow = 0;
    }

    public void startGame() {
        deck.shuffle();
        deck.distribute(players);
        currentPlayerIndex = findFirstPlayer();
    }

    public void playRound() {
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("Current player: " + currentPlayerIndex);
        System.out.println("Current player's hand: " + currentPlayer.getHand());
        System.out.println("Cards on the table: " + tableCards);

        int action = currentPlayer.chooseAction(tableCards);
        if (action == 1) {
            passesInARow++;
            if (passesInARow == players.size()) {
                tableCards.clear();
                passesInARow = 0;
            }
        } else if (action == 2) {
            boolean bluffCalled = currentPlayer.callBluff(tableCards);
            if (bluffCalled) {
                Player previousPlayer = players.get(getPreviousPlayerIndex());
                previousPlayer.addCardsToHand(tableCards);
                tableCards.clear();
            } else {
                currentPlayer.addCardsToHand(tableCards);
                tableCards.clear();
            }
            passesInARow = 0;
        } else if (action == 3) {
            List<Card> cardsToAdd = currentPlayer.addCardsToTable(tableCards);
            tableCards.addAll(cardsToAdd);
            passesInARow = 0;
        }

        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) {
            currentPlayerIndex = 0;
        }
    }

    private int findFirstPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).hasAceOfSpades()) {
                return i;
            }
        }
        return -1;
    }

    private int getPreviousPlayerIndex() {
        int index = currentPlayerIndex - 1;
        if (index < 0) {
            index = players.size() - 1;
        }
        return index;
    }

  
}





