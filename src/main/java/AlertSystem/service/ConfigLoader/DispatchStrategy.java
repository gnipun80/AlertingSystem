package AlertSystem.service.ConfigLoader;

import AlertSystem.Enums.DispatchType;

public class DispatchStrategy {
    private DispatchType type;
    private String message;
    private String subject;
    public DispatchType getType() {
        return type;
    }
    public String getMessage() {
        return message;
    }
    public String getSubject() {
        return subject;
    }
}
