package com.example.denis.podcatch.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "podcast")
public class Podcast {

    @SerializedName("total_episodes")
    private Integer totalEpisodes;
    @SerializedName("episodes")
    @Ignore
    private List<Episode> episodes = null;
    @SerializedName("next_episode_pub_date")
    private Long nextEpisodePubDate;

    @SerializedName("description")
    private String description;
    @SerializedName("title")
    private String title;

    @SerializedName("lastest_pub_date_ms")
    private Long lastestPubDateMs;
    @SerializedName("earliest_pub_date_ms")
    private Long earliestPubDateMs;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("website")
    private String website;
    @SerializedName("listennotes_url")
    private String listennotesUrl;

    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public Podcast() {
    }

    public Podcast(List<Episode> episodes, String title, String publisher, @NonNull String id) {
        this.episodes = episodes;
        this.title = title;
        this.publisher = publisher;
        this.id = id;
    }


    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public Long getNextEpisodePubDate() {
        return nextEpisodePubDate;
    }

    public void setNextEpisodePubDate(Long nextEpisodePubDate) {
        this.nextEpisodePubDate = nextEpisodePubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Long getLastestPubDateMs() {
        return lastestPubDateMs;
    }

    public void setLastestPubDateMs(Long lastestPubDateMs) {
        this.lastestPubDateMs = lastestPubDateMs;
    }

    public Long getEarliestPubDateMs() {
        return earliestPubDateMs;
    }

    public void setEarliestPubDateMs(Long earliestPubDateMs) {
        this.earliestPubDateMs = earliestPubDateMs;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }



    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
