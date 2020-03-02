package com.example.myproject.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ModelDetail implements Serializable {

    @SerializedName("app_id")
    @Expose
    private String appId;
    @SerializedName("app_package")
    @Expose
    private String appPackage;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("privacy_policy_url")
    @Expose
    private String privacyPolicyUrl;
    @SerializedName("total_downloads")
    @Expose
    private Integer totalDownloads;
    @SerializedName("average_ratings")
    @Expose
    private Integer averageRatings;
    @SerializedName("total_ratings")
    @Expose
    private Integer totalRatings;
    @SerializedName("total_rating_1")
    @Expose
    private Integer totalRating1;
    @SerializedName("total_rating_2")
    @Expose
    private Integer totalRating2;
    @SerializedName("total_rating_3")
    @Expose
    private Integer totalRating3;
    @SerializedName("total_rating_4")
    @Expose
    private Integer totalRating4;
    @SerializedName("total_rating_5")
    @Expose
    private Integer totalRating5;
    @SerializedName("app_version_id")
    @Expose
    private Object appVersionId;
    @SerializedName("version_code")
    @Expose
    private Object versionCode;
    @SerializedName("app_size")
    @Expose
    private Object appSize;
    @SerializedName("last_update")
    @Expose
    private Object lastUpdate;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("app_images")
    @Expose
    private List<AppImage> appImages = null;
    @SerializedName("app_ratings")
    @Expose
    private List<Object> appRatings = null;
    @SerializedName("publisher_name")
    @Expose
    private String publisherName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("short_desc")
    @Expose
    private String shortDesc;
    @SerializedName("long_desc")
    @Expose
    private String longDesc;
    @SerializedName("app_icon_url")
    @Expose
    private String appIconUrl;
    @SerializedName("app_featured_url")
    @Expose
    private String appFeaturedUrl;
    @SerializedName("app_version")
    @Expose
    private AppVersion appVersion;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
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

    public Integer getTotalRating1() {
        return totalRating1;
    }

    public void setTotalRating1(Integer totalRating1) {
        this.totalRating1 = totalRating1;
    }

    public Integer getTotalRating2() {
        return totalRating2;
    }

    public void setTotalRating2(Integer totalRating2) {
        this.totalRating2 = totalRating2;
    }

    public Integer getTotalRating3() {
        return totalRating3;
    }

    public void setTotalRating3(Integer totalRating3) {
        this.totalRating3 = totalRating3;
    }

    public Integer getTotalRating4() {
        return totalRating4;
    }

    public void setTotalRating4(Integer totalRating4) {
        this.totalRating4 = totalRating4;
    }

    public Integer getTotalRating5() {
        return totalRating5;
    }

    public void setTotalRating5(Integer totalRating5) {
        this.totalRating5 = totalRating5;
    }

    public Object getAppVersionId() {
        return appVersionId;
    }

    public void setAppVersionId(Object appVersionId) {
        this.appVersionId = appVersionId;
    }

    public Object getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Object versionCode) {
        this.versionCode = versionCode;
    }

    public Object getAppSize() {
        return appSize;
    }

    public void setAppSize(Object appSize) {
        this.appSize = appSize;
    }

    public Object getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Object lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<AppImage> getAppImages() {
        return appImages;
    }

    public void setAppImages(List<AppImage> appImages) {
        this.appImages = appImages;
    }

    public List<Object> getAppRatings() {
        return appRatings;
    }

    public void setAppRatings(List<Object> appRatings) {
        this.appRatings = appRatings;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getAppIconUrl() {
        return appIconUrl;
    }

    public void setAppIconUrl(String appIconUrl) {
        this.appIconUrl = appIconUrl;
    }

    public String getAppFeaturedUrl() {
        return appFeaturedUrl;
    }

    public void setAppFeaturedUrl(String appFeaturedUrl) {
        this.appFeaturedUrl = appFeaturedUrl;
    }

    public AppVersion getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(AppVersion appVersion) {
        this.appVersion = appVersion;
    }
}
