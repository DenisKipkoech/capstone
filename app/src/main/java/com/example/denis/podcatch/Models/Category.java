package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    @SerializedName("source_domain")
    @Expose
    private String sourceDomain;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("pub_date_ms")
    @Expose
    private Long pubDateMs;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("podcasts")
    @Expose
    private List<Podcast> podcasts = null;
    @SerializedName("title")
    @Expose
    private String title;

    public Category(String sourceDomain, String listennotesUrl, Long pubDateMs, String sourceUrl, String id, String description, List<Podcast> podcasts, String title) {
        this.sourceDomain = sourceDomain;
        this.listennotesUrl = listennotesUrl;
        this.pubDateMs = pubDateMs;
        this.sourceUrl = sourceUrl;
        this.id = id;
        this.description = description;
        this.podcasts = podcasts;
        this.title = title;
    }

    public String getSourceDomain() {
        return sourceDomain;
    }

    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public Long getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Long  pubDateMs) {
        this.pubDateMs = pubDateMs;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
