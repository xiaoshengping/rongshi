package com.example.administrator.iclub21.bean.artist;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/5/19.
 */
public class ArtistListBean implements Serializable{
    private int artistid;
    private String name;
    private int area;
    private int sex;
    private String info;
    private String work;
    private String shows;
    private String endorse;
    private int viewCount;
    private int artistCategory;
    private int personid;
    private Person person;
    private String puttime;
    private int rank;
    private List<ArtistPicture> artistPicture;
    private List<ArtistMovie> artistMovie ;
    private List<ArtistAlbum> artistAlbum ;
    public String getPuttime() {
        return puttime;
    }

    public void setPuttime(String puttime) {
        this.puttime = puttime;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }



    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }

    public String getEndorse() {
        return endorse;
    }

    public void setEndorse(String endorse) {
        this.endorse = endorse;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getArtistCategory() {
        return artistCategory;
    }

    public void setArtistCategory(int artistCategory) {
        this.artistCategory = artistCategory;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<ArtistPicture> getArtistPicture() {
        return artistPicture;
    }

    public void setArtistPicture(List<ArtistPicture> artistPicture) {
        this.artistPicture = artistPicture;
    }

    public List<ArtistMovie> getArtistMovie() {
        return artistMovie;
    }

    public void setArtistMovie(List<ArtistMovie> artistMovie) {
        this.artistMovie = artistMovie;
    }

    public List<ArtistAlbum> getArtistAlbum() {
        return artistAlbum;
    }

    public void setArtistAlbum(List<ArtistAlbum> artistAlbum) {
        this.artistAlbum = artistAlbum;
    }


}
