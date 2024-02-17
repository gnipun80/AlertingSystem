package AlertSystem.service.serviceInit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AlertSystem.Enums.ConfigType;
import AlertSystem.Enums.DispatchType;
import AlertSystem.service.Alert.AlertConfig;
import AlertSystem.service.Alert.SimpleCount;
import AlertSystem.service.Alert.SlidingWindow;
import AlertSystem.service.Alert.TumblingWindow;
import AlertSystem.service.ConfigLoader.Config;
import AlertSystem.service.ConfigLoader.ConfigClass;
import AlertSystem.service.ConfigLoader.ConfigLoader;
import AlertSystem.service.ConfigLoader.DispatchStrategy;
import AlertSystem.service.Dispatcher.ConsoleDispatch;
import AlertSystem.service.Dispatcher.DispatchConfig;
import AlertSystem.service.Dispatcher.EmailDispatcher;
import AlertSystem.service.Event.EventConfig;

public class ServiceInit {
    public static Service initService(String filePath) throws IOException{
        ConfigClass config = ConfigLoader.loadConfig(filePath);
        System.err.println(config);
        List<Config> configList = config.getConfigList();
        Map<String, Client> clientMap = new HashMap<String, Client>();

        for (Config configEntry : configList) {
            Client client = clientMap.get(configEntry.getClient());
            if (client == null) {
                client = new Client(configEntry.getClient());
                clientMap.put(client.getName(), client);
            }
            List<DispatchConfig> dispatchConfigList = new ArrayList<>();
            for (DispatchStrategy dispatchStrategy : configEntry.getDispatchStrategyList()) {
                if (dispatchStrategy.getType() == DispatchType.EMAIL) {
                    dispatchConfigList.add(new EmailDispatcher(client.getName() + " " + dispatchStrategy.getSubject()));
                }
                else {
                    dispatchConfigList.add(new ConsoleDispatch(client.getName() + " " + dispatchStrategy.getMessage()));
                }
            }
            AlertConfig alertConfig = null;
            if(configEntry.getAlertConfig().getType() == ConfigType.SIMPLE_COUNT) {
                alertConfig = new SimpleCount(configEntry.getAlertConfig().getType(), configEntry.getAlertConfig().getCount());
            }
            else if(configEntry.getAlertConfig().getType() == ConfigType.SLIDING_WINDOW){
                alertConfig = new SlidingWindow(configEntry.getAlertConfig().getType(), configEntry.getAlertConfig().getCount(), configEntry.getAlertConfig().getWindowSizeInSecs());
            }
            else if(configEntry.getAlertConfig().getType() == ConfigType.TUMBLING_WINDOW){
                alertConfig = new TumblingWindow(configEntry.getAlertConfig().getType(), configEntry.getAlertConfig().getCount(), configEntry.getAlertConfig().getWindowSizeInSecs());
            }
            EventConfig eventConfig = new EventConfig(configEntry.getEventType(), alertConfig, dispatchConfigList);
            client.addEventConfig(eventConfig);
        }

        // Initialize service with the clients
        Service service = new Service(clientMap);
        return service;
    }
}
