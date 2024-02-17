package AlertSystem.service;

import AlertSystem.service.Alert.AlertConfig;
import AlertSystem.service.Dispatcher.DispatchConfig;

import java.util.List;

public class EventConfig {
    private String type;
    private List<AlertSystem.service.EventInfo> EventInfo;
    private AlertConfig alertConfig;
    private List<DispatchConfig> dispatchConfigList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AlertSystem.service.EventInfo> getEventInfo() {
        return EventInfo;
    }

    public void setEventInfo(List<AlertSystem.service.EventInfo> eventInfo) {
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
}
