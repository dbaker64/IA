package IA;

public class Sort {
    public static Deck byTopic(Deck d, String topic){
        Deck out = new Deck();
        for(Card c : d.getCards()){
            if(c.getTopic().indexOf(topic) != -1){
                out.add(c);
            }
        }
        return out;
    }

    public static Deck byInTextCitation(Deck d, String inTextCitation){
        Deck out = new Deck();
        for(Card c : d.getCards()){
            if(c.getInTextCitation().indexOf(inTextCitation) != -1){
                out.add(c);
            }
        }
        return out;
    }

    public static Deck byData(Deck d, String data){
        Deck out = new Deck();
        for(Card c : d.getCards()){
            if(c.getData().indexOf(data) != -1){
                out.add(c);
            }
        }
        return out;
    }
}
