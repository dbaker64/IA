package IA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    
    private static Deck mainDeck = new Deck();
    private static ArrayList<Deck> allDecks = new ArrayList<>();
    public static int currentDeckIndex = 0;
    public static int currentCardID = 0;
    
    public static void main(String[] args) {
        new View();
        allDecks.add(mainDeck);
    }
    
    public static void deleteCard(){
        int currentCardIndex = allDecks.get(currentDeckIndex).getCardIndex(currentCardID);
        allDecks.get(currentDeckIndex).removeByID(currentCardID);
        if(currentCardIndex > 0){
            currentCardIndex--;
        }else if(allDecks.get(currentDeckIndex).size() > 1){
            currentCardIndex++;
        }else{
            allDecks.get(currentDeckIndex).add(new Card());
            System.out.println("Deleted only card in deck. Added new blank card");
        }
    }
    
    public static void addCard(){
        Card c = new Card();
        allDecks.get(currentDeckIndex).add(c);
        currentCardID = c.getID();
    }
    
    public static void editCard(String topic, String inTextCitation, String citation, String data){
        allDecks.get(currentDeckIndex).getByID(currentCardID).setTopic(topic);
        allDecks.get(currentDeckIndex).getByID(currentCardID).setInTextCitation(inTextCitation);
        allDecks.get(currentDeckIndex).getByID(currentCardID).setCitation(citation);
        allDecks.get(currentDeckIndex).getByID(currentCardID).setData(data);
    }
    
    public static void updateView(){
        
    }

    public static void showState(){
        System.out.println("All Decks");
        int i = 0;
        for(Deck d : allDecks){
            System.out.println("Index: "+i);
            System.out.println(d);
        }
    }

    public static void upload(File file) throws IOException{
        String s = JsonManager.fileToString(file);
        Deck d = JsonManager.jsonToDeck(s);
        allDecks.add(d);
        currentDeckIndex = allDecks.size() -1;
    }

    public static void download(File f){
        String filePath = f.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".json")) {
                    f = new File(filePath + ".json");
                }
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write(JsonManager.deckToJson(allDecks.get(currentDeckIndex)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Error saving file: " + ex.getMessage());
                }
    }

    public static void sortByData(String parameter){
        Deck d = Sort.byData(allDecks.get(0),parameter);
        allDecks.add(d);
        currentDeckIndex = allDecks.size() -1;
    }

    public static void sortByInTextCitation(String parameter){
        Deck d = Sort.byInTextCitation(allDecks.get(0), parameter);
        allDecks.add(d);
        currentDeckIndex = allDecks.size() -1;
    }

    public static void sortByTopic(String parameter){
        Deck d = Sort.byTopic(allDecks.get(0), parameter);
        allDecks.add(d);
        currentDeckIndex = allDecks.size() -1;
    }
    
}
