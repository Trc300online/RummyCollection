import java.util.Scanner;

public class InputManager {

    public static int getPlayers() {
        int totalPlayers;
        Scanner s = new Scanner(System.in);

        //try {
            do {
                Screen.askPlayers();
                totalPlayers = s.nextInt();
                if (totalPlayers < 2 || totalPlayers > 4) {
                    Screen.errorHandler(1);
                }
            } while (totalPlayers < 2 || totalPlayers > 4);
        //} catch ()

        return totalPlayers;
    }

    public static String getName() {

        Scanner s = new Scanner(System.in);
        Screen.askNames();
        String name = s.next().trim();

        return name;
    }

    public static char getAction() {

        Scanner s = new Scanner(System.in);
        Screen.askAction();
        char action = s.next().toUpperCase().charAt(0);

        return action;
    }

    public static char getDeck() {

        Scanner s = new Scanner(System.in);
        Screen.askDeck();
        char deck = s.next().toUpperCase().charAt(0);

        return deck;
    }

    public static int getTile() {

        Scanner s = new Scanner(System.in);
        Screen.askTile();
        int index = s.nextInt() - 1;

        return index;
    }

    public static int getSelectTile() {

        Scanner s = new Scanner(System.in);
        Screen.askTile();
        int index = s.nextInt() - 1;

        return index;
    }

    public static char getMeldOff() {

        Scanner s = new Scanner(System.in);
        Screen.askMeldOff();
        char meldOff = s.next().toUpperCase().charAt(0);

        return meldOff;
    }

    public static char getSide() {

        Scanner s = new Scanner(System.in);
        Screen.askSide();
        char side = s.next().toUpperCase().charAt(0);

        return side;
    }

    public static int getPlaceing() {

        Scanner s = new Scanner(System.in);
        Screen.askGroup();
        int index = s.nextInt() - 1;

        return index;
    }

    public static char getEndTournament() {

        Scanner s = new Scanner(System.in);
        Screen.askFinish();
        char end = s.next().toUpperCase().charAt(0);

        return end;
    }
}
