package recorder;

import player.Player;
import player.Type;

import java.util.List;
import java.util.Map;

public interface RecorderService {
    void saveResult(Player player, int result);
    void printResult(Map<Player, Type> playerList);
}
