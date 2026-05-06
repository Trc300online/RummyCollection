public class Screen {

    public static void askPlayers() {
        System.out.println("How many players are going to play? (min 2, max 4)");
    }

    public static void askNames() {
        System.out.println("How do you want to be called?");
    }

    public static void errorHandler(int i) {
        switch (i) {
            case 1:
                System.out.println("Invalid amount of players, please try again");
                break;
            case 2:
                System.out.println("Unexpected input, please try again");
                break;
        }
    }

    public static void askAction() {

        System.out.println("What do you want to do?");
        System.out.println("[M]eld  |  [D]iscard");
    }

    public static void askDeck() {
        System.out.println("From where do you want to draw?");
        System.out.println("[U]p deck  |  [D]own deck");
    }

    public static void askTile() {
        System.out.println("What tile do you want to discard?");
    }
}
