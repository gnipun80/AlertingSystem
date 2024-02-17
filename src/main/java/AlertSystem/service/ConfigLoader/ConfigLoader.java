package AlertSystem.service.ConfigLoader;

import java.io.IOException;
import java.nio.file.Paths;

import java.nio.file.Files;
import com.google.gson.Gson;

public class ConfigLoader {
    public static ConfigClass loadConfig(String filePath) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
            Gson gson = new Gson();
            ConfigClass config = gson.fromJson(jsonContent, ConfigClass.class);
            return config;
        } catch (IOException e) {
            System.err.println("Hello bitch");
            e.printStackTrace();
            return null;
        }
    }
}
