package judge;

import player.FraudPlayer;
import player.Player;
import recorder.Recorder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Judge {
    private final List<Player> playerList = new ArrayList<>();

    private int gap = 0;

    public void registration(Player player) {
        playerList.add(player);
    }

    public void gameStart(int turns, Recorder recorder) {
        while (turns-- > 0) {
            for (Player player : playerList) {
                player.rollDice(player, gap);
                recorder.saveResult(player, player.getTypeOfDice().getRandomNumber());
            }
            getTheGap(playerList);
            recorder.printResult(playerList);
        }
        determineWinner(playerList);
    }

    private void getTheGap(List<Player> playerList) {
        gap = playerList.stream()
                .mapToInt(player -> player instanceof FraudPlayer ? player.getTotalScore() : -player.getTotalScore())
                .sum();
    }

    public void determineWinner(List<Player> playerList) {
        Player winner = playerList.stream()
                .max(Comparator.comparingInt(Player::getTotalScore))
                .orElse(null);

        System.out.println("\n승자를 기록합니다.\n");
        System.out.println(winner != null ? winner.getName() + "가(이) 승리했습니다!" : "무승부");
    }
}
