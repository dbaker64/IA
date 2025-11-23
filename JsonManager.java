package IA;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.*;

public class JsonManager {
    public static String deckToJson(Deck d){
        Gson gson = new Gson();
        String json = gson.toJson(d);
        return json;
    }

    public static Deck jsonToDeck(String json){
        Gson gson = new Gson();
        Deck d = gson.fromJson(json, Deck.class);
        return d;
    }

    public static String fileToString(File file) throws IOException{
        String fileContent = Files.readString(Paths.get(file.getPath())); //Google AI on how to get String from a file efficiently
        return fileContent;
    }
}
