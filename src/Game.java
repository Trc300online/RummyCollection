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

            playerAction(currPlayer); // draw (up or down), meld (select tiles and meld place or cancel meld), discard

                if (gameContinue == false) {
                    //win cond?
                    break;
                }
            turnCount++;
        }

        //currPlayer = playerList(turnCount % playerList.size());

    }

    private void playerAction(Player player) {
        boolean endTurn = false;

        draw(player); //here get asked up or down
        while (!endTurn) {
            switch (InputManager.getAction()) {
                case 'M':
                    meld();
                    break;
                case 'D':
                    discard(player);
                    endTurn = true;
                    break;
                default:
                    Screen.errorHandler(2);
            }
        }
    }

    private void discard(Player player) {
        Deck.addUpDeck(player.removeFromHand(InputManager.getTile()));
    }

    private void draw(Player player) {
        boolean drawn = false;

        while (!drawn){
            switch (InputManager.getDeck()) {
                case 'U':
                    player.addToHand(Deck.getUpDeck());
                    drawn = true;
                    break;
                case 'D':
                    player.addToHand(Deck.getRandTile());
                    drawn = true;
                    break;
                default:
                    Screen.errorHandler(2);
            }
        }
    }

    private void dealTiles() {
        for (int i = 0; i < playerList.size(); i++) {
            for (int j = 0; j < 14; j++) {
                playerList.get(i).addToHand(Deck.getRandTile());
            }
        }

        Deck.addUpDeck(Deck.getRandTile());
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
