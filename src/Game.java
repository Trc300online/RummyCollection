import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<>();

    public void play() {

        playerSetUp(playerList);
        tileSetUp(playerList.size());
        dealTiles();

        int turnCount = playerList.size();

        while (true) {
            while (true) {
                Player currPlayer = playerList.get(turnCount % playerList.size());

                playerAction(currPlayer); // draw (up or down), meld (select tiles and meld place or cancel meld), discard

                if (winCheck(currPlayer)) {
                    currPlayer.addScore(givePoints(playerList, turnCount));
                    Screen.roundWinMsg(currPlayer);
                    break;
                }
                turnCount++;
            }
            if (endTournament()) {
                Screen.announceWinner(getFinalWinner(playerList));
                break;
            }
        }

        //currPlayer = playerList(turnCount % playerList.size());

    }

    private Player getFinalWinner(ArrayList<Player> playerList) {

        int topScore = 0;
        Player topPlayer = null;

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getScore() > topScore) {
                topScore = playerList.get(i).getScore();
                topPlayer = playerList.get(i);
            }
        }

        return topPlayer;
    }

    private boolean endTournament() {
        switch (InputManager.getEndTournament()) {
            case 'Y':
                Screen.finishingTournamentMsg();
                return true;
            case 'N':
                return false;
        }

        return false;
    }

    private int givePoints(ArrayList<Player> playerList, int turnCount) {
        int points = 0;

        for (int i = 0; i < playerList.size(); i++) {
            if (i != (turnCount % playerList.size())) {
                for (int j = 0; j < playerList.get(i).getHand().size(); j++) {
                    points += playerList.get(i).getHand().get(j).getValue();
                }
            }
        }

        return points;
    }

    private boolean winCheck(Player player) {
        return player.getHand().isEmpty();
    }

    private void playerAction(Player player) {
        boolean endTurn = false;

        Screen.printGame(player);

        draw(player); //here get asked up or down
        while (!endTurn) {
            Screen.printGame(player);
            switch (InputManager.getAction()) {
                case 'M':
                    meld(player);
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

    private void meld(Player player) {
        /// maybe hashmap?
        ArrayList<Tile> tileSelected = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();


        switch (InputManager.getMeldOff()) {
            case 'M':
                /// getMeldSelection()
                while (true) {
                    int index = InputManager.getSelectTile();
                    if (index == -1) {
                        break;
                    }
                    Tile tmp = player.getHand().get(index);
                    tileSelected.add(tmp);
                    indexes.add(index);
                }

                /// playMeld()
                if (Board.isToK(tileSelected) || Board.isRun(tileSelected)) {
                    Board.addGroup();

                    for (Tile tile : tileSelected) {
                        Board.getBoard().getLast().add(tile);
                    }

                    indexes.sort(Collections.reverseOrder());

                    for (int index : indexes) {
                        player.removeFromHand(index);
                    }

                } else {
                    tileSelected.clear();
                    Screen.errorHandler(3);
                }
                break;
            case 'L':
                if (Board.getBoard().isEmpty()) {
                    break;
                }
                    int index = -1;
                    Tile tmp;
                    char side;
                    int group;
                    /// getLayOffSelection()
                    while (true) {
                        try {
                            index = InputManager.getSelectTile();
                            if (index == -1) {
                                continue;
                            }
                            tmp = player.getHand().get(index);
                            side = InputManager.getSide();
                            group = InputManager.getPlaceing();
                            break;
                        } catch (IndexOutOfBoundsException ioobe) {
                            Screen.errorHandler(4);
                        }
                    }


                    /// playLayOff()
                if (Board.isToK(Board.addToMeld(tmp, side, group)) || Board.isRun(Board.addToMeld(tmp, side, group))) {
                    switch (side) {
                        case 'F':
                            Board.getBoard().get(group).addFirst(tmp);
                            break;
                        case 'L':
                            Board.getBoard().get(group).add(tmp);
                            break;
                        default:
                            Screen.errorHandler(2);
                    }
                    player.removeFromHand(index);
                } else {
                    Screen.errorHandler(3);
                }
                break;
            default:
                Screen.errorHandler(2);
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
                    player.addToHand(Deck.grabUpDeck());
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
                    Deck.addDownDeck(new Tile( (k + 1), j));
                }
            }
        }

        for (int i = 0; i < jokers; i++) {
            Deck.addDownDeck(new Tile(0, i));
        }
    }

    private void playerSetUp(ArrayList<Player> playerList) {
        int totalPlayers = InputManager.getPlayers();

        for (int i = 0; i < totalPlayers; i++) {
            playerList.add(new Player(InputManager.getName()));
        }
    }
}
