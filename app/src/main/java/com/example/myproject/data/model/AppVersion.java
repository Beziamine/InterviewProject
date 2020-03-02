package com.example.myproject.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AppVersion implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("total_downloads")
    @Expose
    private Integer totalDownloads;
    @SerializedName("average_ratings")
    @Expose
    private Integer averageRatings;
    @SerializedName("total_ratings")
    @Expose
    private Integer totalRatings;
    @SerializedName("version_name")
    @Expose
    private String versionName;
    @SerializedName("version_code")
    @Expose
    private Integer versionCode;
    @SerializedName("whats_news_en")
    @Expose
    private Object whatsNewsEn;
    @SerializedName("whats_news_ar")
    @Expose
    private Object whatsNewsAr;
    @SerializedName("app_size")
    @Expose
    private String appSize;
    @SerializedName("apk_url")
    @Expose
    private String apkUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(Integer totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public Integer getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(Integer averageRatings) {
        this.averageRatings = averageRatings;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public Object getWhatsNewsEn() {
        return whatsNewsEn;
    }

    public void setWhatsNewsEn(Object whatsNewsEn) {
        this.whatsNewsEn = whatsNewsEn;
    }

    public Object getWhatsNewsAr() {
        return whatsNewsAr;
    }

    public void setWhatsNewsAr(Object whatsNewsAr) {
        this.whatsNewsAr = whatsNewsAr;
    }

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }
}
