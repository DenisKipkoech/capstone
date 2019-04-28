package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("podcast_listennotes_url")
    @Expose
    private String podcastListennotesUrl;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("transcripts_highlighted")
    @Expose
    private List<Object> transcriptsHighlighted = null;
    @SerializedName("description_highlighted")
    @Expose
    private String descriptionHighlighted;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("publisher_original")
    @Expose
    private String publisherOriginal;
    @SerializedName("podcast_title_highlighted")
    @Expose
    private String podcastTitleHighlighted;
    @SerializedName("description_original")
    @Expose
    private String descriptionOriginal;
    @SerializedName("title_highlighted")
    @Expose
    private String titleHighlighted;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("title_original")
    @Expose
    private String titleOriginal;
    @SerializedName("audio_length")
    @Expose
    private String audioLength;
    @SerializedName("publisher_highlighted")
    @Expose
    private String publisherHighlighted;
    @SerializedName("pub_date_ms")
    @Expose
    private Integer pubDateMs;
    @SerializedName("podcast_id")
    @Expose
    private String podcastId;
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("podcast_title_original")
    @Expose
    private String podcastTitleOriginal;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPodcastListennotesUrl() {
        return podcastListennotesUrl;
    }

    public void setPodcastListennotesUrl(String podcastListennotesUrl) {
        this.podcastListennotesUrl = podcastListennotesUrl;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public List<Object> getTranscriptsHighlighted() {
        return transcriptsHighlighted;
    }

    public void setTranscriptsHighlighted(List<Object> transcriptsHighlighted) {
        this.transcriptsHighlighted = transcriptsHighlighted;
    }

    public String getDescriptionHighlighted() {
        return descriptionHighlighted;
    }

    public void setDescriptionHighlighted(String descriptionHighlighted) {
        this.descriptionHighlighted = descriptionHighlighted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPublisherOriginal() {
        return publisherOriginal;
    }

    public void setPublisherOriginal(String publisherOriginal) {
        this.publisherOriginal = publisherOriginal;
    }

    public String getPodcastTitleHighlighted() {
        return podcastTitleHighlighted;
    }

    public void setPodcastTitleHighlighted(String podcastTitleHighlighted) {
        this.podcastTitleHighlighted = podcastTitleHighlighted;
    }

    public String getDescriptionOriginal() {
        return descriptionOriginal;
    }

    public void setDescriptionOriginal(String descriptionOriginal) {
        this.descriptionOriginal = descriptionOriginal;
    }

    public String getTitleHighlighted() {
        return titleHighlighted;
    }

    public void setTitleHighlighted(String titleHighlighted) {
        this.titleHighlighted = titleHighlighted;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public String getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(String audioLength) {
        this.audioLength = audioLength;
    }

    public String getPublisherHighlighted() {
        return publisherHighlighted;
    }

    public void setPublisherHighlighted(String publisherHighlighted) {
        this.publisherHighlighted = publisherHighlighted;
    }

    public Integer getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Integer pubDateMs) {
        this.pubDateMs = pubDateMs;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getPodcastTitleOriginal() {
        return podcastTitleOriginal;
    }

    public void setPodcastTitleOriginal(String podcastTitleOriginal) {
        this.podcastTitleOriginal = podcastTitleOriginal;
    }
}
