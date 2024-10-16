package recorder;

import player.FraudPlayer;
import player.Player;

import java.util.List;

public class Recorder {

    public void saveResult(Player player, int result) {
        player.setTotalScore(player.getTotalScore() + result);
    }

    public void printResult(List<Player> playerList) {
        System.out.print("[ ");
        for (Player player : playerList) {
            System.out.print(player.getName() + ":" + player.getTotalScore() + " ");
            if (player instanceof FraudPlayer) {
                System.out.print("[" + player.getModeOfDice() + "]");
            }
        }
        System.out.println("]");
    }
}
