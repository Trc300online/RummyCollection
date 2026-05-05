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
}
