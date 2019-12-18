package com.github.models;



import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GitHubModel implements Serializable{
    @SerializedName("author")
    private String author;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String description;
    @SerializedName("stars")
    private String stars;
    @SerializedName("forks")
    private String forks;
    @SerializedName("currentPeriodStars")
    private String currentPeriodStars;
    @SerializedName("builtBy")
    private List<GitHubItem> builtBy = null;
    @SerializedName("language")
    private String language;
    @SerializedName("languageColor")
    private String languageColor;


    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getCurrentPeriodStars() {
        return currentPeriodStars;
    }

    public void setCurrentPeriodStars(String currentPeriodStars) {
        this.currentPeriodStars = currentPeriodStars;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public List<GitHubItem> getBuiltBy() {
        return builtBy;
    }

    public void setBuiltBy(List<GitHubItem> builtBy) {
        this.builtBy = builtBy;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }
}
