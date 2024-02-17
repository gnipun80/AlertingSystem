package AlertSystem.service.serviceInit;
import java.util.Map;

import AlertSystem.service.Event.EventConfig;
import AlertSystem.service.Event.EventInfo;

public class Service {
    private Map<String, Client> clientMap;
    public Service(Map<String, Client> clientMap) {
        this.clientMap = clientMap;
    }
    public void addEvent(EventInfo event) {
        String clientName = event.getClient();
        Client client = clientMap.get(clientName);
        if (client != null) {
            EventConfig eventConfig = client.getEventConfigMap().get(event.getEventType());
            if (eventConfig != null) {
                eventConfig.addEvent(event);
            }
        }
    }
}
