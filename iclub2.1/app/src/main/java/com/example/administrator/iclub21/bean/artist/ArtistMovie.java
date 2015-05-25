package com.example.administrator.iclub21.bean.artist;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ArtistMovie implements Serializable{
    private int artistmovieid;
    private String moviename;
    private String path;
    private String puttime;
    private int artistid;

    public int getArtistmovieid() {
        return artistmovieid;
    }

    public void setArtistmovieid(int artistmovieid) {
        this.artistmovieid = artistmovieid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPuttime() {
        return puttime;
    }

    public void setPuttime(String puttime) {
        this.puttime = puttime;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    @Override
    public String toString() {
        return "ArtistMovie{" +
                "artistmovieid=" + artistmovieid +
                ", moviename='" + moviename + '\'' +
                ", path='" + path + '\'' +
                ", puttime='" + puttime + '\'' +
                ", artistid=" + artistid +
                '}';
    }
}
