package com.example.administrator.iclub21.bean.artist;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ArtistAlbum implements Serializable{

    private int artistalbumid;
    private String albumname;
    private String albumdate;
    private String albumicon;
    private String puttime;
    private int artistid;
    private List<ArtistMusic> artistMusic;

    public int getArtistalbumid() {
        return artistalbumid;
    }

    public void setArtistalbumid(int artistalbumid) {
        this.artistalbumid = artistalbumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getAlbumdate() {
        return albumdate;
    }

    public void setAlbumdate(String albumdate) {
        this.albumdate = albumdate;
    }

    public String getAlbumicon() {
        return albumicon;
    }

    public void setAlbumicon(String albumicon) {
        this.albumicon = albumicon;
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

    public List<ArtistMusic> getArtistMusic() {
        return artistMusic;
    }

    public void setArtistMusic(List<ArtistMusic> artistMusic) {
        this.artistMusic = artistMusic;
    }


}
