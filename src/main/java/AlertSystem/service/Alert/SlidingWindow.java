package AlertSystem.service.Alert;

public class SlidingWindow extends AlertConfig{
    private int windowSizeInSecs;
    @Override
    boolean process() {
        return false;
    }
}
