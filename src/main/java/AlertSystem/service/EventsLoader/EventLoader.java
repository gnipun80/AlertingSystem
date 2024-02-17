package AlertSystem.service.EventsLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

public class EventLoader {
    public static AllEvents loadEvents(String filePath) throws IOException {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            Gson gson = new Gson();
            AllEvents allEvents = gson.fromJson(jsonContent, AllEvents.class);
            return allEvents;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
