public class Tile {

    private int value;
    private Colors color;

    Tile (int value, int color) {
        this.value = value;
        this.color = Colors.setColor(color);
    }
}
