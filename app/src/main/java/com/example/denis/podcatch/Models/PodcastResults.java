package com.example.denis.podcatch.Models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PodcastResults {
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("next_episode_pub_date")
    @Expose
    private Long nextEpisodePubDate;
    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("is_claimed")
    @Expose
    private Boolean isClaimed;

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("earliest_pub_date_ms")
    @Expose
    private Long earliestPubDateMs;
    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = null;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("total_episodes")
    @Expose
    private Integer totalEpisodes;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("lastest_pub_date_ms")
    @Expose
    private Long lastestPubDateMs;
    @SerializedName("image")
    @Expose
    private String image;

    public PodcastResults() {
    }

    public PodcastResults(Integer itunesId, Boolean explicitContent, Long nextEpisodePubDate, String language, String title, String listennotesUrl, String thumbnail, Boolean isClaimed, String id, Long earliestPubDateMs, List<Episode> episodes, String publisher, String website, Integer totalEpisodes, String description, String country, String rss, List<String> genres, String email, Long lastestPubDateMs, String image) {
        this.itunesId = itunesId;
        this.explicitContent = explicitContent;
        this.nextEpisodePubDate = nextEpisodePubDate;
        this.language = language;
        this.title = title;
        this.listennotesUrl = listennotesUrl;
        this.thumbnail = thumbnail;
        this.isClaimed = isClaimed;
        this.id = id;
        this.earliestPubDateMs = earliestPubDateMs;
        this.episodes = episodes;
        this.publisher = publisher;
        this.website = website;
        this.totalEpisodes = totalEpisodes;
        this.description = description;
        this.country = country;
        this.rss = rss;
        this.genres = genres;
        this.email = email;
        this.lastestPubDateMs = lastestPubDateMs;
        this.image = image;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public Long getNextEpisodePubDate() {
        return nextEpisodePubDate;
    }

    public void setNextEpisodePubDate(Long nextEpisodePubDate) {
        this.nextEpisodePubDate = nextEpisodePubDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEarliestPubDateMs() {
        return earliestPubDateMs;
    }

    public void setEarliestPubDateMs(Long earliestPubDateMs) {
        this.earliestPubDateMs = earliestPubDateMs;
    }

    @NonNull
    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLastestPubDateMs() {
        return lastestPubDateMs;
    }

    public void setLastestPubDateMs(Long lastestPubDateMs) {
        this.lastestPubDateMs = lastestPubDateMs;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
