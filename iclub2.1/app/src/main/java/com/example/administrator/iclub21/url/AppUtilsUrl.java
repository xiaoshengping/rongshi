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

}
