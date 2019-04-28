package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Search {
    @SerializedName("podcast_title_original")
    @Expose
    private String podcastTitleOriginal;
    @SerializedName("description_original")
    @Expose
    private String descriptionOriginal;
    @SerializedName("podcast_id")
    @Expose
    private String podcastId;
    @SerializedName("audio_length")
    @Expose
    private Long audioLength;
    @SerializedName("transcripts_highlighted")
    @Expose
    private List<Object> transcriptsHighlighted = null;
    @SerializedName("podcast_listennotes_url")
    @Expose
    private String podcastListennotesUrl;
    @SerializedName("description_highlighted")
    @Expose
    private String descriptionHighlighted;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("pub_date_ms")
    @Expose
    private Long pubDateMs;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("publisher_highlighted")
    @Expose
    private String publisherHighlighted;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("title_original")
    @Expose
    private String titleOriginal;
    @SerializedName("podcast_title_highlighted")
    @Expose
    private String podcastTitleHighlighted;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title_highlighted")
    @Expose
    private String titleHighlighted;
    @SerializedName("publisher_original")
    @Expose
    private String publisherOriginal;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;

    public String getPodcastTitleOriginal() {
        return podcastTitleOriginal;
    }

    public void setPodcastTitleOriginal(String podcastTitleOriginal) {
        this.podcastTitleOriginal = podcastTitleOriginal;
    }

    public String getDescriptionOriginal() {
        return descriptionOriginal;
    }

    public void setDescriptionOriginal(String descriptionOriginal) {
        this.descriptionOriginal = descriptionOriginal;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public Long getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(Long audioLength) {
        this.audioLength = audioLength;
    }

    public List<Object> getTranscriptsHighlighted() {
        return transcriptsHighlighted;
    }

    public void setTranscriptsHighlighted(List<Object> transcriptsHighlighted) {
        this.transcriptsHighlighted = transcriptsHighlighted;
    }

    public String getPodcastListennotesUrl() {
        return podcastListennotesUrl;
    }

    public void setPodcastListennotesUrl(String podcastListennotesUrl) {
        this.podcastListennotesUrl = podcastListennotesUrl;
    }

    public String getDescriptionHighlighted() {
        return descriptionHighlighted;
    }

    public void setDescriptionHighlighted(String descriptionHighlighted) {
        this.descriptionHighlighted = descriptionHighlighted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Long getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Long pubDateMs) {
        this.pubDateMs = pubDateMs;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getPublisherHighlighted() {
        return publisherHighlighted;
    }

    public void setPublisherHighlighted(String publisherHighlighted) {
        this.publisherHighlighted = publisherHighlighted;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public String getPodcastTitleHighlighted() {
        return podcastTitleHighlighted;
    }

    public void setPodcastTitleHighlighted(String podcastTitleHighlighted) {
        this.podcastTitleHighlighted = podcastTitleHighlighted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleHighlighted() {
        return titleHighlighted;
    }

    public void setTitleHighlighted(String titleHighlighted) {
        this.titleHighlighted = titleHighlighted;
    }

    public String getPublisherOriginal() {
        return publisherOriginal;
    }

    public void setPublisherOriginal(String publisherOriginal) {
        this.publisherOriginal = publisherOriginal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
}
