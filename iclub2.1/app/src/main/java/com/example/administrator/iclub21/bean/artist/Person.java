package com.example.administrator.iclub21.bean.artist;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/5/19.
 */
public class Person implements Serializable{
    private int id;
    private String pwd;
    private int sex;
    private String username;
    private String interest;
    private String speciality;
    private String lovestyle;
    private String birthday;
    private String star;
    private String info;
    private String uid;
    private String usericon;
    private String lastTime;
    private String regTime;
    private String breakTime;
    private int state;
    private int breakCount;
    private double longitude, latitude;
    private int belongCompany;
    private int  year;
    private int rank;
    private String mobile;

    private String openid;
    private String weibouid;


    private List<Resume> resume;

    private String resumeZhName;
    private String resumeEnName;
    private int resumeSex;
    private String resumeWorkPlace;
    private int resumeCityId;
    private String resumeWorkExperience;
    private String resumeQq;
    private String resumeEmail;
    private String resumeMobile;
    private int resumeJobCategory;
    private String resumeJobName;
    private int resumeAge;
    private String resumeLabel;

    private String resumeUserbg;
    private int resumeViewCount;
    private String resumeInfo;
    private City city;
    private List<PersonPicture> resumePicture ;
    private List<PersonMovie> resumeMovie ;
    private List<PersonMusic> resumeMusic ;


    private String BEcompanyName;
    private String BEname;
    private String BEmobile;
    private String BEphone;
    private String BEcompanyInfo;
    private String BEqq;// QQ
    private String BEemail;// email
    private String BEweb;
    private String BEaddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLovestyle() {
        return lovestyle;
    }

    public void setLovestyle(String lovestyle) {
        this.lovestyle = lovestyle;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getBreakCount() {
        return breakCount;
    }

    public void setBreakCount(int breakCount) {
        this.breakCount = breakCount;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(int belongCompany) {
        this.belongCompany = belongCompany;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getWeibouid() {
        return weibouid;
    }

    public void setWeibouid(String weibouid) {
        this.weibouid = weibouid;
    }

    public List<Resume> getResume() {
        return resume;
    }

    public void setResume(List<Resume> resume) {
        this.resume = resume;
    }

    public String getResumeZhName() {
        return resumeZhName;
    }

    public void setResumeZhName(String resumeZhName) {
        this.resumeZhName = resumeZhName;
    }

    public String getResumeEnName() {
        return resumeEnName;
    }

    public void setResumeEnName(String resumeEnName) {
        this.resumeEnName = resumeEnName;
    }

    public int getResumeSex() {
        return resumeSex;
    }

    public void setResumeSex(int resumeSex) {
        this.resumeSex = resumeSex;
    }

    public String getResumeWorkPlace() {
        return resumeWorkPlace;
    }

    public void setResumeWorkPlace(String resumeWorkPlace) {
        this.resumeWorkPlace = resumeWorkPlace;
    }

    public int getResumeCityId() {
        return resumeCityId;
    }

    public void setResumeCityId(int resumeCityId) {
        this.resumeCityId = resumeCityId;
    }

    public String getResumeWorkExperience() {
        return resumeWorkExperience;
    }

    public void setResumeWorkExperience(String resumeWorkExperience) {
        this.resumeWorkExperience = resumeWorkExperience;
    }

    public String getResumeQq() {
        return resumeQq;
    }

    public void setResumeQq(String resumeQq) {
        this.resumeQq = resumeQq;
    }

    public String getResumeEmail() {
        return resumeEmail;
    }

    public void setResumeEmail(String resumeEmail) {
        this.resumeEmail = resumeEmail;
    }

    public String getResumeMobile() {
        return resumeMobile;
    }

    public void setResumeMobile(String resumeMobile) {
        this.resumeMobile = resumeMobile;
    }

    public int getResumeJobCategory() {
        return resumeJobCategory;
    }

    public void setResumeJobCategory(int resumeJobCategory) {
        this.resumeJobCategory = resumeJobCategory;
    }

    public String getResumeJobName() {
        return resumeJobName;
    }

    public void setResumeJobName(String resumeJobName) {
        this.resumeJobName = resumeJobName;
    }

    public int getResumeAge() {
        return resumeAge;
    }

    public void setResumeAge(int resumeAge) {
        this.resumeAge = resumeAge;
    }

    public String getResumeLabel() {
        return resumeLabel;
    }

    public void setResumeLabel(String resumeLabel) {
        this.resumeLabel = resumeLabel;
    }

    public String getResumeUserbg() {
        return resumeUserbg;
    }

    public void setResumeUserbg(String resumeUserbg) {
        this.resumeUserbg = resumeUserbg;
    }

    public int getResumeViewCount() {
        return resumeViewCount;
    }

    public void setResumeViewCount(int resumeViewCount) {
        this.resumeViewCount = resumeViewCount;
    }

    public String getResumeInfo() {
        return resumeInfo;
    }

    public void setResumeInfo(String resumeInfo) {
        this.resumeInfo = resumeInfo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<PersonPicture> getResumePicture() {
        return resumePicture;
    }

    public void setResumePicture(List<PersonPicture> resumePicture) {
        this.resumePicture = resumePicture;
    }

    public List<PersonMovie> getResumeMovie() {
        return resumeMovie;
    }

    public void setResumeMovie(List<PersonMovie> resumeMovie) {
        this.resumeMovie = resumeMovie;
    }

    public List<PersonMusic> getResumeMusic() {
        return resumeMusic;
    }

    public void setResumeMusic(List<PersonMusic> resumeMusic) {
        this.resumeMusic = resumeMusic;
    }

    public String getBEcompanyName() {
        return BEcompanyName;
    }

    public void setBEcompanyName(String BEcompanyName) {
        this.BEcompanyName = BEcompanyName;
    }

    public String getBEname() {
        return BEname;
    }

    public void setBEname(String BEname) {
        this.BEname = BEname;
    }

    public String getBEmobile() {
        return BEmobile;
    }

    public void setBEmobile(String BEmobile) {
        this.BEmobile = BEmobile;
    }

    public String getBEphone() {
        return BEphone;
    }

    public void setBEphone(String BEphone) {
        this.BEphone = BEphone;
    }

    public String getBEcompanyInfo() {
        return BEcompanyInfo;
    }

    public void setBEcompanyInfo(String BEcompanyInfo) {
        this.BEcompanyInfo = BEcompanyInfo;
    }

    public String getBEqq() {
        return BEqq;
    }

    public void setBEqq(String BEqq) {
        this.BEqq = BEqq;
    }

    public String getBEemail() {
        return BEemail;
    }

    public void setBEemail(String BEemail) {
        this.BEemail = BEemail;
    }

    public String getBEweb() {
        return BEweb;
    }

    public void setBEweb(String BEweb) {
        this.BEweb = BEweb;
    }

    public String getBEaddress() {
        return BEaddress;
    }

    public void setBEaddress(String BEaddress) {
        this.BEaddress = BEaddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", interest='" + interest + '\'' +
                ", speciality='" + speciality + '\'' +
                ", lovestyle='" + lovestyle + '\'' +
                ", birthday='" + birthday + '\'' +
                ", star='" + star + '\'' +
                ", info='" + info + '\'' +
                ", uid='" + uid + '\'' +
                ", usericon='" + usericon + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", regTime='" + regTime + '\'' +
                ", breakTime='" + breakTime + '\'' +
                ", state=" + state +
                ", breakCount=" + breakCount +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", belongCompany=" + belongCompany +
                ", year=" + year +
                ", rank=" + rank +
                ", mobile='" + mobile + '\'' +
                ", openid='" + openid + '\'' +
                ", weibouid='" + weibouid + '\'' +
                ", resume=" + resume +
                ", resumeZhName='" + resumeZhName + '\'' +
                ", resumeEnName='" + resumeEnName + '\'' +
                ", resumeSex=" + resumeSex +
                ", resumeWorkPlace='" + resumeWorkPlace + '\'' +
                ", resumeCityId=" + resumeCityId +
                ", resumeWorkExperience='" + resumeWorkExperience + '\'' +
                ", resumeQq='" + resumeQq + '\'' +
                ", resumeEmail='" + resumeEmail + '\'' +
                ", resumeMobile='" + resumeMobile + '\'' +
                ", resumeJobCategory=" + resumeJobCategory +
                ", resumeJobName='" + resumeJobName + '\'' +
                ", resumeAge=" + resumeAge +
                ", resumeLabel='" + resumeLabel + '\'' +
                ", resumeUserbg='" + resumeUserbg + '\'' +
                ", resumeViewCount=" + resumeViewCount +
                ", resumeInfo='" + resumeInfo + '\'' +
                ", city=" + city +
                ", resumePicture=" + resumePicture +
                ", resumeMovie=" + resumeMovie +
                ", resumeMusic=" + resumeMusic +
                ", BEcompanyName='" + BEcompanyName + '\'' +
                ", BEname='" + BEname + '\'' +
                ", BEmobile='" + BEmobile + '\'' +
                ", BEphone='" + BEphone + '\'' +
                ", BEcompanyInfo='" + BEcompanyInfo + '\'' +
                ", BEqq='" + BEqq + '\'' +
                ", BEemail='" + BEemail + '\'' +
                ", BEweb='" + BEweb + '\'' +
                ", BEaddress='" + BEaddress + '\'' +
                '}';
    }
}
