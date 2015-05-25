package com.example.administrator.iclub21.bean.artist;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ArtistMusic {
    private int artistmusicid;
    private String musicname;
    private String path;
    private String puttime;
    private int albumid;

    public int getArtistmusicid() {
        return artistmusicid;
    }

    public void setArtistmusicid(int artistmusicid) {
        this.artistmusicid = artistmusicid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
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

    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    @Override
    public String toString() {
        return "ArtistMusic{" +
                "artistmusicid=" + artistmusicid +
                ", musicname='" + musicname + '\'' +
                ", path='" + path + '\'' +
                ", puttime='" + puttime + '\'' +
                ", albumid=" + albumid +
                '}';
    }
}
