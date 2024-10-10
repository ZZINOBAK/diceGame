package judge;

import player.Player;
import player.Type;
import recorder.RecorderService;
import java.util.Map;

public interface JudgeService {
    void registration(Player player);
    void gameStart(int turns, RecorderService recorderService);
    void determineWinner(Map<Player, Type> playerList);
}
