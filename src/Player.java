import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Tile> hand = new ArrayList<>();
    private int score;

    Player (String name) {
        this.name = name;
        this.score = 0;
    }

    public void addToHand(Tile tile) {
        hand.add(tile);
    }

    public Tile removeFromHand(int i) {
        Tile tile = hand.get(i);
        hand.remove(i);

        return tile;
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }
}
