package com.example.administrator.iclub21.url;

/**
 * Created by Administrator on 2015/5/18.
 */
public class AppUtilsUrl  {

    public static final String BaseUrl="http://www.iclubapps.com/";
    public  static final String ImageBaseUrl="http://www.iclubapps.com/upload/";

    public static String getArtistHead(){
        return BaseUrl+"getArtistTopPicture.action";

    }
    public static String getArtistList(){
        return BaseUrl+"artistFind.action?"+"limit=4&"+"offset=0";

    }
    public static String getTalentList(){

        return BaseUrl+"getPersonResume.action?offset=0&limit=10";

    }

    public static String getRecruitmentImage(){
        return ImageBaseUrl+"getJobTopPicture.action";
    }

    public static String getRecruitmentList(/*int jobCategory ,int offset , int limit*/){//jobCategory(招聘分类),offset(从多少条开始) ,limit(一共取多少条)
//        return BaseUrl+"getJobList_V2_1.action?jobCategory="+jobCategory+"&offset="+offset+"&limit="+limit;
        return BaseUrl+"getJobList_V2_1.action?jobCategory=0&offset=0&limit=5";
    }

}
