package IA;

import com.google.gson.*;
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
        System.out.println(mainDeck);
    }
    
}
