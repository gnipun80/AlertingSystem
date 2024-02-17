package AlertSystem.service.Dispatcher;

public class EmailDispatcher implements DispatchConfig{
    private String subject;

    public EmailDispatcher(String subject) {
        this.subject = subject;
    }

    @Override
    public void dispatch() {
        System.out.println(subject);
    }
}
