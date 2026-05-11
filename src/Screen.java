public class Screen {

    public static void errorHandler(int i) {
        switch (i) {
            case 1:
                System.out.println("Invalid amount of players, please try again");
                break;
            case 2:
                System.out.println("Unexpected input, please try again");
                break;
            case 3:
                System.out.println("Invalid meld/lay off, please try again");
        }
    }

    public static void askPlayers() {
        System.out.println("How many players are going to play? (min 2, max 4)");
    }

    public static void askNames() {
        System.out.println("How do you want to be called?");
    }

    public static void askAction() {

        System.out.println("What do you want to do?");
        System.out.println("[M]eld/Lay Off  |  [D]iscard");
    }

    public static void askDeck() {
        System.out.println("From where do you want to draw?");
        System.out.println("[U]p deck  |  [D]own deck");
    }

    public static void askTile() {
        System.out.println("What tile do you want to select?");
    }

    public static void askGroup() {
        System.out.println("Choose where to lay off your card");
    }

    public static void askSide() {
        System.out.println("Where do you want to lay off?");
        System.out.println("[F]irst  |  [L]ast");
    }

    public static void askMeldOff() {
        System.out.println("Do you want to [M]eld or [L]ay off");
    }
}
