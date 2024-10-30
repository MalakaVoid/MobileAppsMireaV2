package ru.mirea.azbukindu.scrollviewapp_v2;

public class HistoryEvent {

    private String title;
    private String image;

    public HistoryEvent(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
