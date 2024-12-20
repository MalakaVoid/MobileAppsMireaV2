package ru.mirea.azbukindu.domain.models;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Book {
    private String id;
    private String kind;
    private String etag;
    private String selfLink;
    private Map<String, Object> saleInfo;
    private Map<String, Object> accessInfo;

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public Map<String, Object> getSaleInfo() {
        return saleInfo;
    }

    public Map<String, Object> getAccessInfo() {
        return accessInfo;
    }

    private Map<String, Object> volumeInfo;
    private Map<String, Object> searchInfo;

    public Book(String id, Map<String, Object> volumeInfo, Map<String, Object> searchInfo) {
        this.id = id;
        this.volumeInfo = volumeInfo;
        this.searchInfo = searchInfo;
    }

    public String getId() {
        return id;
    }

    public Map<String, Object> getVolumeInfo() {
        return volumeInfo;
    }

    public Map<String, Object> getSearchInfo() {
        return searchInfo;
    }

    public static Book getBookForTest(){
        return new Book("1", new HashMap<String, Object>(), new HashMap<String, Object>());
    }

    public String getTitle(){
        return volumeInfo.get("title").toString();
    }

    public String getCoverImage(){
        if (volumeInfo.containsKey("imageLinks") == false){
            return "http://books.google.com/books/content?id=a-UCAAAAMBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api";
        }
        return ((Map<String, Object>)volumeInfo.get("imageLinks")).get("thumbnail").toString();
    }

    public String getAuthor(){
        if (volumeInfo.containsKey("authors") == false){
            return "Нет автора";
        }
        return ((ArrayList<String>)volumeInfo.get("authors")).get(0);
    }
}
