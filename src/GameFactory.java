public class GameFactory {

    public static Game createGame(int numPlayers, char gameType) {
        switch (gameType) {
            case 'R':
                return new RummyClassic(numPlayers, gameType);
            case 'G':
                return new GinRummy(numPlayers, gameType);
            case 'K':
                return new RummiKub(numPlayers, gameType);
            case 'A':
                return new RummyArg(numPlayers, gameType);
        }
    }
}
