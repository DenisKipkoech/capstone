package com.example.denis.podcatch.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "podcast")
public class Podcast {
//    @SerializedName("looking_for")
//    @Expose
//    private LookingFor lookingFor;
    @SerializedName("total_episodes")
    @Expose
    private Integer totalEpisodes;
    @SerializedName("episodes")
    @Expose
    @Ignore
    private List<Episode> episodes = null;
    @SerializedName("next_episode_pub_date")
    @Expose
    private Integer nextEpisodePubDate;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("lastest_pub_date_ms")
    @Expose
    private Integer lastestPubDateMs;
    @SerializedName("earliest_pub_date_ms")
    @Expose
    private Integer earliestPubDateMs;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("genres")
    @Expose
    @Ignore
    private List<String> genres = null;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("is_claimed")
    @Expose
    private Boolean isClaimed;
//    @SerializedName("extra")
//    @Expose
//    private Extra extra;
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

//    public LookingFor getLookingFor() {
//        return lookingFor;
//    }
//
//    public void setLookingFor(LookingFor lookingFor) {
//        this.lookingFor = lookingFor;
//    }


    public Podcast(Integer totalEpisodes, List<Episode> episodes, Integer nextEpisodePubDate, String rss, String description, String title, Integer itunesId, Integer lastestPubDateMs, Integer earliestPubDateMs, String publisher, String website, List<String> genres, String listennotesUrl, String id, String image, String language, Boolean isClaimed, String email, Boolean explicitContent, String country, String thumbnail) {
        this.totalEpisodes = totalEpisodes;
        this.episodes = episodes;
        this.nextEpisodePubDate = nextEpisodePubDate;
        this.rss = rss;
        this.description = description;
        this.title = title;
        this.itunesId = itunesId;
        this.lastestPubDateMs = lastestPubDateMs;
        this.earliestPubDateMs = earliestPubDateMs;
        this.publisher = publisher;
        this.website = website;
        this.genres = genres;
        this.listennotesUrl = listennotesUrl;
        this.id = id;
        this.image = image;
        this.language = language;
        this.isClaimed = isClaimed;
        this.email = email;
        this.explicitContent = explicitContent;
        this.country = country;
        this.thumbnail = thumbnail;
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

    public Integer getNextEpisodePubDate() {
        return nextEpisodePubDate;
    }

    public void setNextEpisodePubDate(Integer nextEpisodePubDate) {
        this.nextEpisodePubDate = nextEpisodePubDate;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
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

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public Integer getLastestPubDateMs() {
        return lastestPubDateMs;
    }

    public void setLastestPubDateMs(Integer lastestPubDateMs) {
        this.lastestPubDateMs = lastestPubDateMs;
    }

    public Integer getEarliestPubDateMs() {
        return earliestPubDateMs;
    }

    public void setEarliestPubDateMs(Integer earliestPubDateMs) {
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

//    public Extra getExtra() {
//        return extra;
//    }
//
//    public void setExtra(Extra extra) {
//        this.extra = extra;
//    }

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
