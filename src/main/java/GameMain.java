import dice.Dice;
import dice.FraudDice;
import dice.NormalDice;
import judge.JudgeService;
import player.Player;
import player.Type;
import recorder.RecorderService;

public class GameMain {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        JudgeService judgeService = appConfig.judgeService();
        RecorderService recorderService = appConfig.recorderService();

        Dice normalDice = new NormalDice(), fraudDice = new FraudDice();

        // 기본 유저
        String name = "김하은천재";
        Player player = new Player(name,  Type.NORMAL, 0, normalDice, "normal");
        judgeService.registration(player);

        // 사기 유저
        name = "김하은만재";
        player = new Player(name, Type.FRAUD, 0, fraudDice, "normal");
        judgeService.registration(player);

        judgeService.gameStart(5, recorderService);
    }
}
