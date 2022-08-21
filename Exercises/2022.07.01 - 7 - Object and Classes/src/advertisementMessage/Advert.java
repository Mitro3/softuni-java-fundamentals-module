package advertisementMessage;

public class Advert {
    private String phrase;
    private String event;
    private String author;
    private String city;

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return this.phrase + " " + this.event + " " + this.author + " - " + this.city;
    }
}
