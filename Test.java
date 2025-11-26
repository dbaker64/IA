package IA;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //TESTING BACKEND UPLOAD AND DOWNLOAD FUNCTIONALITY
        File test2 = new File("IA/test2.json");
        Controller.upload(test2);
        Controller.showState();

        File test1 = new File("IA/test1.json");
        Controller.download(test1);

        //TESTING SORT FUNCTIONALITY
        Deck deck1 = JsonManager.jsonToDeck(test2);
        Deck sorted1 = Sort.byTopic(deck1, "Berlin");
        System.out.println("Sorted1: "+sorted1);
        Deck sorted2 = Sort.byInTextCitation(deck1, "Solyom-Fekete");
        System.out.println("Sorted2: "+sorted2);
        Deck sorted3 = Sort.byData(deck1, "flag orders");
        System.out.println("Sorted3: "+sorted3);
    }
}