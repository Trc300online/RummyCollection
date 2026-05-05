import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<>();

    public void play() {

        playerSetUp(playerList);
        tileSetUp(playerList.size());
        dealTiles();

        boolean gameContinue = true;
        int turnCount = 0;

        while (gameContinue) {
            Player currPlayer = playerList.get(turnCount % playerList.size());

            playerAction();

                if (gameContinue == false) {
                    //win cond?
                    break;
                }
            turnCount++;
        }

        //currPlayer = playerList(turnCount % playerList.size());

    }

    private void tileSetUp(int size) {
        int deckAmount;
        int jokers;

        if (size == 2) {
            deckAmount = 1;
            jokers = 2;
        } else {
            deckAmount = 2;
            jokers = 4;
        }

        for (int i = 0; i < deckAmount; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 13; k++) {
                    Deck.addDownDeck(new Tile(k, j));
                }
            }
        }

        for (int i = 0; i < jokers; i++) {
            Deck.addDownDeck(new Tile(0, i));
        }
    }

    private void playerSetUp(ArrayList<Player> playerList) {
        int totalPlayers = InputManager.getPlayers();

        for (int i = 0; i > totalPlayers; i++) {
            playerList.add(new Player(InputManager.getName()));
        }
    }
}
