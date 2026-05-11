public class Tile {

    private int value;
    private Colors color;

    Tile (int value, int color) {
        this.value = value;
        this.color = Colors.setColor(color);
    }

    Tile (int value, Colors color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public Colors getColor() {
        return color;
    }
}
