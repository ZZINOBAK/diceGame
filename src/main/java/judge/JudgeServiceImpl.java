package judge;

import dice.Dice;
import dice.FraudDice;
import player.Player;
import player.Type;
import recorder.RecorderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JudgeServiceImpl implements JudgeService{
    private Map<Player, Type> playerList = new HashMap<>();

    FraudDice fraudDice;
    int result = 0;
    int gap = 0;

    @Override
    public void registration(Player player) {
        playerList.put(player, player.getTypeOfPlayer());
    }

    @Override
    public void gameStart(int turns, RecorderService recorderService) {
        while(turns > 0) {
             for (Map.Entry<Player, Type> entry : playerList.entrySet()) {
                Player player = entry.getKey();
                Type type = entry.getValue();
                if(type == Type.NORMAL) {
                    result = player.getTypeOfDice().roll();
                } else if (type == Type.FRAUD) {
                    fraudDice = (FraudDice) player.getTypeOfDice();  // player.getTypeOfDice()가 Dice 타입이므로 캐스팅이 필요
                    result = rollFraudDice(player, gap);
                }
                recorderService.saveResult(player, result);
            }
            gap = getTheGap(playerList);
            recorderService.printResult(playerList);
            turns--;
        }
        determineWinner(playerList);
    }

    private int rollFraudDice(Player player, int gap) {
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
        Player winner = null;
        for (Map.Entry<Player, Type> entry : playerList.entrySet()) {
            Player player = entry.getKey();
            if (winner == null || player.getTotalScore() > winner.getTotalScore()) {
                winner = player;
            }
        }
        System.out.println("\n승자를 기록합니다.\n");
        if (winner != null) {
            System.out.println(winner.getName() + "가(이) 승리했습니다!");
        } else {
            System.out.println("무승부");
        }
    }
}
