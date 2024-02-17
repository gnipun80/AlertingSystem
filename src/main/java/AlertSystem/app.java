package AlertSystem;

public class App {
    public static void main(String[] args) {
        try {
            Game game = GameInit.createGame("app/src/main/resources/init.json");
            if (game != null) {
                game.playGame();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
