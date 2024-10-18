package recorder;

import player.FraudPlayer;
import player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Recorder {

    public void saveResult(Player player, int result) {
        player.setTotalScore(player.getTotalScore() + result);
    }

    public void printResult(List<Player> playerList) {
        System.out.println("[" + playerList.stream()
                .map(player -> player.getName() + ":" + player.getTotalScore() +
                        (player instanceof FraudPlayer ? "[" + player.getModeOfDice() + "]" : ""))
                .collect(Collectors.joining(" ")) + "]");
    }
}
