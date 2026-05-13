public enum Colors {

    RED,
    GREEN,
    BLUE,
    YELLOW;

    public static Colors setColor(int i) {

        return switch (i) {
            case 0 -> RED;
            case 1 -> GREEN;
            case 2 -> BLUE;
            case 3 -> YELLOW;
            default -> null;
        };
    }
}
