package AlertSystem.service.Alert;

public class SlidingWindow extends AlertConfig{
    private int windowSizeInSecs;
    @Override
    boolean process() {
        // Check if the current window has passed
        LocalDateTime currentTime = LocalDateTime.now().getHour();
        int eventCount = eventList.size();

        if(eventCount > this.threshold) {
            int lastEventTime = eventList.get(eventCount - 1 - threshold).getEventTime();
            if(currentTime - lastEventTime < this.windowSizeInSecs) {
                return true
            }
        }
        
        return false;
    }
}
