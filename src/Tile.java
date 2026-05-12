public class Tile {

    private int value;
    private Colors color;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";


    Tile (int value, int color) {
        this.value = value;
        this.color = Colors.setColor(color);
    }

    Tile (int value, Colors color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        if (color == Colors.GREEN) {
            return (ANSI_GREEN + "[" + getValue() + "]" + ANSI_RESET);
        } else if (color == Colors.BLUE) {
            return (ANSI_BLUE + "[" + getValue() + "]" + ANSI_RESET);
        } else if (color == Colors.RED) {
            return (ANSI_RED + "[" + getValue() + "]" + ANSI_RESET);
        } else if (color == Colors.YELLOW) {
            return (ANSI_YELLOW + "[" + getValue() + "]" + ANSI_RESET);
        }
        return (ANSI_RESET + "[" + getValue() + "]" + ANSI_RESET);
    }

    public int getValue() {
        return value;
    }

    public Colors getColor() {
        return color;
    }
}
