package AlertSystem.service.Dispatcher;

public class ConsoleDispatch implements DispatchConfig{
    private String displayMsg;

    public ConsoleDispatch(String displayMsg) {
        this.displayMsg = displayMsg;
    }

    @Override
    public void dispatch() {
        System.out.println(displayMsg);
    }
}
