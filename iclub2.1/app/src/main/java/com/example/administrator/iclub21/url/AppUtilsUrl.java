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
    public static String getLoginData(String uid,String pwd){

        return BaseUrl+"login_V2.action?"+"uid="+uid+"&pwd="+pwd;

    }

    public static String getRegisterData(String uid,String pwd,String vcode){
        //SignUp_V2.action? uid=13800138000&pwd=abc123&vcode=888888
        return BaseUrl+"SignUp_V2.action?"+"uid="+uid+"&pwd="+pwd+"&vcode="+vcode;

    }
    public static String getVcodeData(String phone){
        //sendVcode.action? phone=13800138000
        return BaseUrl+"sendVcode.action?"+"phone="+phone;

    }
    public static String getForgetData(String uid,String pwd,String vcode){
        //Reset_V2.action? uid=13800138000&pwd=abc123&vcode=888888
        return BaseUrl+"Reset_V2.action?"+"uid="+uid+"&pwd="+pwd+"&vcode="+vcode;

    }


    public static String getRecruitmentImage(){
        return ImageBaseUrl+"getJobTopPicture.action";
    }

    public static String getRecruitmentList(/*int jobCategory ,int offset , int limit*/){//jobCategory(��Ƹ����),offset(�Ӷ�������ʼ) ,limit(һ��ȡ������)
//        return BaseUrl+"getJobList_V2_1.action?jobCategory="+jobCategory+"&offset="+offset+"&limit="+limit;
        return BaseUrl+"getJobList_V2_1.action?jobCategory=0&offset=0&limit=5";
    }

}
