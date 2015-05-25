package com.example.administrator.iclub21.bean.artist;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ArtistPicture implements Serializable{
    private int artistpictureid;
    private String name;
    private String title;
    private int artistid;

    public int getArtistpictureid() {
        return artistpictureid;
    }

    public void setArtistpictureid(int artistpictureid) {
        this.artistpictureid = artistpictureid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    @Override
    public String toString() {
        return "ArtistPicture{" +
                "artistpictureid=" + artistpictureid +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", artistid=" + artistid +
                '}';
    }
}
