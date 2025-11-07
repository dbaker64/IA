package IA;

import java.util.ArrayList;

public class Deck{
    private ArrayList<Card> cards;
    
    public Deck(){
        cards = new ArrayList<>();
        cards.add(new Card());
    }
    
    public Deck(Deck d){
        cards = d.getCards();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }
    
    public void add(Card c){
        cards.add(c);
    }
    
    public void removeByID(int ID){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getID() == ID){
                cards.remove(i);
            }
        }
    }
    
    public void removeByIndex(int index){
        cards.remove(index);
    }
    
    public Card getByID(int ID){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getID() == ID){
                return cards.get(i);
            }
        }
        System.out.println("ERROR, INVALID CARD ID IN GET CARD FROM DECK");
        return new Card();
    }
    
    public Card getByIndex(int index){
        return cards.get(index);
    }
    
    public int getCardIndex(int ID){
        for(int i = 0; i < cards.size(); i++){
            if(cards.get(i).getID() == ID){
                return i;
            }
        }
        System.out.println("ERROR, INVALID CARD ID IN GET CARD INDEX");
        return -1;
    }
    
    public int size(){
        return cards.size();
    }
    
    @Override
    public String toString(){
        String out = "";
        for(Card c : cards){
            out += c.toString() + " ";
        }
        return out;
    }
}
