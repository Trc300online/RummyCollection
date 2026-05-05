import java.util.ArrayList;

public class Deck {

    private ArrayList<Tile> upDeck;
    private static ArrayList<Tile> downDeck;

    public static void addDownDeck(Tile tile) {
        downDeck.add(tile);
    }
}
