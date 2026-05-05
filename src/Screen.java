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
        }
    }
}
