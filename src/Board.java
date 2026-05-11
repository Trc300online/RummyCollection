import java.util.ArrayList;

public class Board {
    private static ArrayList<ArrayList<Tile>> board = new ArrayList<>();

    public static boolean isToK(ArrayList<Tile> tiles) {

        if (tiles.size() < 3 && tiles.size() > 4) {
            return false;
        }

        for (int i = 1; i < tiles.size(); i++) {
            if ( ! (tiles.get(i).getValue() == tiles.get(i - 1).getValue())) {
                if (tiles.get(i).getValue() != 0 || tiles.get(i - 1).getValue() != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isRun(ArrayList<Tile> tiles) {

        if (tiles.size() < 3) {
            return false;
        }

        for (int i = 1; i < tiles.size(); i++) {
            if ( ! (tiles.get(i).getValue() == tiles.get(i - 1).getValue() + 1) || ! (tiles.get(i).getColor() == tiles.get(i - 1).getColor())) {
                if (tiles.get(i).getValue() != 0 || tiles.get(i - 1).getValue() != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static ArrayList<Tile> addToMeld(Tile tile, char side, int group) {

        ArrayList<ArrayList<Tile>> copy = new ArrayList<>();

        for (int i = 0; i < board.size(); i++) {
            copy.add(new ArrayList<>());
            for (int j = 0; j < board.get(i).size(); j++) {
                copy.get(i).add(new Tile(board.get(i).get(j).getValue(), board.get(i).get(j).getColor()));
            }
        }

        switch (side) {
            case 'F':
                copy.get(group).addFirst(tile);
                break;
            case 'L':
                copy.get(group).add(tile);
        }

        return copy.get(group);
    }

    public static void addGroup() {
        board.add(new ArrayList<>());
    }

    public static ArrayList<ArrayList<Tile>> getBoard() {
        return board;
    }
}
