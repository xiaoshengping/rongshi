package com.example.administrator.iclub21.bean.recruitment;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/5/25.
 */
public class RecruitmentListBean implements Serializable {

    private int jobId;//id
    private int rank;//����Խ����Խǰ��
    private String position;//ְλ��
    private float star;// 3, �Ǽ���������ʾ�����ǣ�
    private String puttime;//��2014-10-10��, ����ʱ��
    private int viewCount;// �����
    private String workPay;// ��18888Ԫ��, н��
    private String companyName;// ���㶫��Ʒ��Ʒ�����̡�, ��˾��
    private String workPlace;//�����ݡ�, �����ص�
    private int recruitingNumbers;// ��1��, ��Ƹ����
    private String jobRequirements;// ������ǲ���DJĬ��ͼ�ģ���, ����Ҫ��
    private String jobInfo;//��ְλ����Ŷ��, ְλ����
    private String label;//��hot�� ��ǩ
    private String phone;// ��020-56984756��, �绰
    private String email;// ��iclubapps@163.com��, Email
    private String web;//��www.iclubapps.com��, ����
    private String address;//���㶫����Խ������ɽ��·148��907�ҡ�, ��ַ
    private int jobcategory;// 1

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkPay() {
        return workPay;
    }

    public void setWorkPay(String workPay) {
        this.workPay = workPay;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public float getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getRecruitingNumbers() {
        return recruitingNumbers;
    }

    public void setRecruitingNumbers(int recruitingNumbers) {
        this.recruitingNumbers = recruitingNumbers;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPuttime() {
        return puttime;
    }

    public void setPuttime(String puttime) {
        this.puttime = puttime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getJobRequirements() {
        return jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    public int getJobcategory() {
        return jobcategory;
    }

    public void setJobcategory(int jobcategory) {
        this.jobcategory = jobcategory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJobId() {

        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "RecruitmentListBean{" +
                "address='" + address + '\'' +
                ", jobId=" + jobId +
                ", rank=" + rank +
                ", position='" + position + '\'' +
                ", star=" + star +
                ", puttime='" + puttime + '\'' +
                ", viewCount=" + viewCount +
                ", workPay='" + workPay + '\'' +
                ", companyName='" + companyName + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", recruitingNumbers=" + recruitingNumbers +
                ", jobRequirements='" + jobRequirements + '\'' +
                ", jobInfo='" + jobInfo + '\'' +
                ", label='" + label + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", web='" + web + '\'' +
                ", jobcategory=" + jobcategory +
                '}';
    }
}
