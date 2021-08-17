package model;

import java.util.List;

public class Album {
    private int id;
    private String name;
    private String singer;
    private List<String> type;
    private String link;

    public Album() {
    }

    public Album(int id, String name, String singer, List<String> type, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
