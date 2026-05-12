import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private static ArrayList<Tile> upDeck = new ArrayList<>();
    private static ArrayList<Tile> downDeck = new ArrayList<>();

    public static void addDownDeck(Tile tile) {
        downDeck.add(tile);
    }

    public static void addUpDeck(Tile tile) {
        upDeck.addFirst(tile);
    }

    public static Tile getRandTile() {
        int i = new Random().nextInt(downDeck.size());
        Tile tile = downDeck.get(i);
        downDeck.remove(i);

        return tile;
    }

    public static Tile grabUpDeck() {
        Tile tile = upDeck.get(0);
        upDeck.remove(0);

        return tile;
    }

    public static Tile getUpDeck() {
        if (upDeck.isEmpty()) {
            return null;
        }
        return upDeck.getFirst();
    }
}
