import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class JsonHelp {
    static String pathIn = "src/PolEngTestIn.json";
    static String pathOut;
    static Gson gson = new Gson();

    public static String ReadJson() {
        StringBuilder builder = new StringBuilder();
        String text;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathIn));
            while ((text = reader.readLine()) != null) {
                builder.append(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static void WriteJson(Set<Question> questions) {
        JsonParser parser = new JsonParser();
        JsonArray json = parser.parse(gson.toJson(questions)).getAsJsonArray();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String preetyJson = gson.toJson(json);
        try {
            FileWriter file = new FileWriter(pathOut);
            file.write(preetyJson);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Question> GetQeestions() {
        String input = ReadJson();
        Type targetClassType = new TypeToken<List<Question>>() {
        }.getType();
        return gson.fromJson(input, targetClassType);
    }
}
