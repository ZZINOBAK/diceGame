import dice.FraudDice;
import dice.NormalDice;
import judge.Judge;
import player.FraudPlayer;
import player.NormalPlayer;
import player.Player;
import recorder.Recorder;

public class GameMain {

    public static void main(String[] args) {
        Judge judge = new Judge();
        Recorder recorder = new Recorder();

        // 기본 유저
        String name = "김하은천재";
        Player player = new NormalPlayer(name, new NormalDice(), "normal");
        judge.registration(player);

        // 사기 유저
        name = "김하은만재";
        player = new FraudPlayer(name, new FraudDice(), "normal");
        judge.registration(player);

        judge.gameStart(5, recorder);
    }
}
