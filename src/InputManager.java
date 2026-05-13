import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {

    public static int getPlayers() {
        int totalPlayers = 0;

        do {
            try {
                Scanner s = new Scanner(System.in);
                Screen.askPlayers();
                totalPlayers = s.nextInt();
                if (totalPlayers < 2 || totalPlayers > 4) {
                    Screen.errorHandler(1);
                }
            } catch (InputMismatchException e) {
                Screen.errorHandler(2);
            }
        } while (totalPlayers < 2 || totalPlayers > 4);

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
        int index = -1;
        
        try {
            Scanner s = new Scanner(System.in);
            Screen.askTile();
            index = s.nextInt() - 1;
        } catch (InputMismatchException ime) {
            Screen.errorHandler(2);
        }

        return index;
    }

    public static char getMeldOff() {

        Scanner s = new Scanner(System.in);
        Screen.askMeldOff();
        char meldOff = s.next().toUpperCase().charAt(0);

        return meldOff;
    }

    public static char getSide() {
        char side;

        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                Screen.askSide();
                side = s.next().toUpperCase().charAt(0);
                break;
            } catch (InputMismatchException ime) {
                Screen.errorHandler(2);
            }
        }

        return side;
    }

    public static int getPlaceing() {
        int index;

        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                Screen.askGroup();
                index = s.nextInt() - 1;
                break;
            } catch (InputMismatchException ime) {
                Screen.errorHandler(2);
            }
        }

        return index;
    }

    public static char getEndTournament() {

        Scanner s = new Scanner(System.in);
        Screen.askFinish();
        char end = s.next().toUpperCase().charAt(0);

        return end;
    }
}
