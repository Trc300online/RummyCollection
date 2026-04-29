import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playerList = new ArrayList<>();

    public void play() {

        playerSetUp(playerList);
        tileSetUp();
        dealTiles();

        boolean gameContinue = true;
        int turnCount = 0;

        while (gameContinue) {
            for (int i = 0; i < playerList.size(); i++) {
                playerList.get(i);


                if (gameContinue == false) {
                    //win cond?
                    break;
                }
                if (i + 1 == playerList.size()) {
                    i = -1;
                }
            }
        }

        //currPlayer = playerList(turnCount % playerList.size());

    }
}
