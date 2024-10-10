
import judge.JudgeService;
import judge.JudgeServiceImpl;
import recorder.RecorderService;
import recorder.RecorderServiceImpl;

public class AppConfig {

    public JudgeService judgeService() {
        return new JudgeServiceImpl();
    }

    public RecorderService recorderService() {
        return new RecorderServiceImpl();
    }
}
