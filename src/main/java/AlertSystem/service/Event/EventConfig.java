package AlertSystem.service.Event;

import AlertSystem.service.Alert.AlertConfig;
import AlertSystem.service.Dispatcher.DispatchConfig;

import java.util.List;

public class EventConfig {
    private String type;
    private List<AlertSystem.service.Event.EventInfo> EventInfo;
    private AlertConfig alertConfig;
    private List<DispatchConfig> dispatchConfigList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AlertSystem.service.Event.EventInfo> getEventInfo() {
        return EventInfo;
    }

    public void setEventInfo(List<AlertSystem.service.Event.EventInfo> eventInfo) {
        EventInfo = eventInfo;
    }

    public AlertConfig getAlertConfig() {
        return alertConfig;
    }

    public void setAlertConfig(AlertConfig alertConfig) {
        this.alertConfig = alertConfig;
    }

    public List<DispatchConfig> getDispatchConfigList() {
        return dispatchConfigList;
    }

    public void setDispatchConfigList(List<DispatchConfig> dispatchConfigList) {
        this.dispatchConfigList = dispatchConfigList;
    }

    public void addEvent(EventInfo event) {
        EventInfo.add(event);
        boolean isThresholdBreach = alertConfig.process(EventInfo);

        if(true == isThresholdBreach) {
            for(DispatchConfig d : dispatchConfigList) {
                d.dispatch();
            }
        }
    }
}
