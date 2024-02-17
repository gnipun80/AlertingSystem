package AlertSystem.service.Event;

public class EventInfo {
    private int eventTime;
    private String eventType;
    private String clientName;
    public EventInfo(int ingestTimeStamp, String eventType, String client) {
        this.eventTime = ingestTimeStamp;
        this.eventType = eventType;
        this.clientName = client;
    }
    public int getEventTime() {
        return eventTime;
    }
    public String getEventType() {
        return eventType;
    }
    public String getClient() {
        return clientName;
    }
}
