package recorder;

import player.Player;
import player.Type;

import java.util.Map;

public class RecorderServiceImpl implements RecorderService {

    @Override
    public void saveResult(Player player, int result) {
        player.setTotalScore(player.getTotalScore() + result);
    }

    @Override
    public void printResult(Map<Player, Type> playerList) {
        System.out.print("[ ");
        df
                df
                dfdf

                        ㅇㄹㅇㄹㅇ


        for (Map.Entry<Player, Type> entry : playerList.entrySet()) {
            Player player = entry.getKey();
            System.out.print(player.getName() + ":" + player.getTotalScore());
            if (player.getTypeOfPlayer() == Type.FRAUD) {
                System.out.print("[" + player.getModeOfDice() + "] ");
            }
        }
        System.out.println("]");
    }
}
