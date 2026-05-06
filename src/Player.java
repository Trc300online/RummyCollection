import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Tile> hand;

    Player (String name) {
        this.name = name;
        this.hand = null;
    }

    public void addToHand(Tile tile) {
        hand.add(tile);
    }

    public Tile removeFromHand(int i) {
        Tile tile = hand.get(i);
        hand.remove(i);

        return tile;
    }
}
