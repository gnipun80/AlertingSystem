package AlertSystem.service.ConfigLoader;

import AlertSystem.Enums.ConfigType;

public class AlertConfig {
    private ConfigType type;
    private int count;
    private int windowSizeInSecs;
    public AlertConfig(ConfigType type, int count, int windowSizeInSecs) {
        this.type = type;
        this.count = count;
        this.windowSizeInSecs = windowSizeInSecs;
    }
    public ConfigType getType() {
        return type;
    }
    public int getCount() {
        return count;
    }
    public int getWindowSizeInSecs() {
        return windowSizeInSecs;
    }
}
