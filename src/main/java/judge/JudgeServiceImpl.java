package judge;

import dice.FraudDice;
import player.Player;
import player.Type;
import recorder.RecorderService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class JudgeServiceImpl implements JudgeService{
    private final Map<Player, Type> playerList = new HashMap<>();

    int result = 0;
    int gap = 0;

    @Override
    public void registration(Player player) {
        playerList.put(player, player.getTypeOfPlayer());
    }

    @Override
    public void gameStart(int turns, RecorderService recorderService) {
        while(turns-- > 0) {
            playerList.forEach((player, type) -> {
                result = (type == Type.FRAUD)
                        ? rollFraudDice(player, (FraudDice) player.getTypeOfDice(), gap)
                        : player.getTypeOfDice().roll();
                recorderService.saveResult(player, result);
            });
            gap = getTheGap(playerList);
            recorderService.printResult(playerList);
        }
        determineWinner(playerList);
    }

    private int rollFraudDice(Player player, FraudDice fraudDice, int gap) {
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

    private int getTheGap(Map<Player, Type> playerList) {
        int fraudUser = 0;
        int normalUser = 0;
        for (Map.Entry<Player, Type> entry : playerList.entrySet()) {
            if (entry.getValue() == Type.FRAUD) {
                fraudUser = entry.getKey().getTotalScore(); // FRAUD 플레이어의 점수 저장
            } else if (entry.getValue() == Type.NORMAL) {
                normalUser = entry.getKey().getTotalScore(); // NORMAL 플레이어의 점수 저장
            }
        }
        return fraudUser - normalUser;
    }

    @Override
    public void determineWinner(Map<Player, Type> playerList) {
        Player winner = playerList.keySet().stream()
                .max(Comparator.comparingInt(Player::getTotalScore))
                .orElse(null);

        System.out.println("\n승자를 기록합니다.\n");
        System.out.println(winner != null ? winner.getName() + "가(이) 승리했습니다!" : "무승부");
    }
}
