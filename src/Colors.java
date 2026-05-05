public enum Colors {

    RED,
    GREEN,
    BLUE,
    YELLOW;

    public static Colors setColor(int i) {

        switch (i) {
            case 0:
                return RED;
            case 1:
                return GREEN;
            case 2:
                return BLUE;
            case 3:
                return YELLOW;
        }
        return null;
    }
}
