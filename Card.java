package IA;

public class Card {
    private String topic;
    private String data;
    private String citation;
    private String inTextCitation;
    private int ID;
    private static int IDCounter = 0;

    //CONSTRUCTORS
    public Card(){
        this.topic = "No Topic";
        this.data = "No Data";
        this.citation = "No Citation";
        this.inTextCitation = "No In Text Citation";
        this.ID = Card.IDCounter;
        Card.IDCounter++;
    }

    public Card(String topic, String data, String citation, String inTextCitation){
        this.topic = topic;
        this.data = data;
        this.citation = citation;
        this.inTextCitation = inTextCitation;
        this.ID = Card.IDCounter;
        Card.IDCounter++;
    }

    //GETTERS AND SETTERS
    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getCitation() {
        return citation;
    }
    
    public void setCitation(String citation) {
        this.citation = citation;
    }
    
    public String getInTextCitation(){
        return inTextCitation;
    }
    
    public void setInTextCitation(String inTextCitation){
        this.inTextCitation = inTextCitation;
    }
    
    public int getID(){
        return ID;
    }
    
    @Override
    public String toString(){
        String out = String.format("ID: %d%nTopic: %s%nData: %s%nCitation: %s%nIn Text Citation: %s%n",ID,topic,data,citation,inTextCitation);
        return out;
    }
    
}