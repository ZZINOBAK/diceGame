package judge;

import dice.FraudDice;
import player.FraudPlayer;
import player.NormalPlayer;
import player.Player;
import recorder.Recorder;

import java.util.*;

public class Judge{
    private final List<Player> playerList = new ArrayList<>();

    int result = 0;
    int gap = 0;

    public void registration(Player player) {
        playerList.add(player);
    }

    public void gameStart(int turns, Recorder recorder) {
        while(turns-- > 0) {
            for (Player player : playerList) {
                if (player instanceof FraudPlayer) {
                    result = rollFraudDice(player, gap);
                } else {
                    result = player.getTypeOfDice().roll();
                }
                recorder.saveResult(player, result);
            }
            gap = getTheGap(playerList);
            recorder.printResult(playerList);
        }
        determineWinner(playerList);
    }

    private int rollFraudDice(Player player, int gap) {
        FraudDice fraudDice = (FraudDice) player.getTypeOfDice();
        if (gap < 0) {
            player.setModeOfDice("strong");
            return fraudDice.strongRoll();  // FraudDice에만 있는 메서드 호출
        } else if (gap >= 3) {
            player.setModeOfDice("weak");
            return fraudDice.weakRoll();
        } else {
            player.setModeOfDice("normal");
            return fraudDice.roll();
        }
    }

    private int getTheGap(List<Player> playerList) {
        int fraudUser = 0;
        int normalUser = 0;
        for (Player player : playerList) {
            if (player instanceof FraudPlayer) {
                fraudUser = player.getTotalScore(); // FRAUD 플레이어의 점수 저장
            } else if (player instanceof NormalPlayer) {
                normalUser = player.getTotalScore(); // NORMAL 플레이어의 점수 저장
            }
        }
        return fraudUser - normalUser;
    }

    public void determineWinner(List<Player>  playerList) {
        Player winner = playerList.stream()
                .max(Comparator.comparingInt(Player::getTotalScore))
                .orElse(null);

        System.out.println("\n승자를 기록합니다.\n");
        System.out.println(winner != null ? winner.getName() + "가(이) 승리했습니다!" : "무승부");
    }
}
