package AlertSystem;

import java.io.IOException;

import AlertSystem.service.EventsLoader.EventLoader;
import AlertSystem.service.Event.EventInfo;
import AlertSystem.service.EventsLoader.AllEvents;
import AlertSystem.service.serviceInit.Service;
import AlertSystem.service.serviceInit.ServiceInit;

public class App {
    public static void main(String[] args) {
        try {
            Service service = ServiceInit.initService("src/main/resources/alert-config.json");
            if(service != null) {
                AllEvents allEvents = EventLoader.loadEvents("src/main/resources/incoming-events.json");
                if(allEvents != null) {
                    for (EventInfo event : allEvents.getEventList()) {
                        service.addEvent(event);
                    }
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
