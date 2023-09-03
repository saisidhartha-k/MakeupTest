public class App {
    public static void main(String[] args) {
        BluffGame game = new BluffGame(3);
        game.startGame();
        for (int i = 0; i < 5; i++) {
            game.playRound();
            System.out.println();
        }
    }
}
