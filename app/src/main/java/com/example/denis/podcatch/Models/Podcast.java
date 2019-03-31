package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Podcast {
    @SerializedName("audio_length")
    @Expose
    private String audioLength;
    @SerializedName("transcripts_highlighted")
    @Expose
    private List<Object> transcriptsHighlighted = null;
    @SerializedName("title_original")
    @Expose
    private String titleOriginal;
    @SerializedName("podcast_id")
    @Expose
    private String podcastId;
    @SerializedName("publisher_highlighted")
    @Expose
    private String publisherHighlighted;
    @SerializedName("description_original")
    @Expose
    private String descriptionOriginal;
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("podcast_listennotes_url")
    @Expose
    private String podcastListennotesUrl;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("description_highlighted")
    @Expose
    private String descriptionHighlighted;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("genres")
    @Expose
    private List<Integer> genres = null;
    @SerializedName("podcast_title_original")
    @Expose
    private String podcastTitleOriginal;
    @SerializedName("podcast_title_highlighted")
    @Expose
    private String podcastTitleHighlighted;
    @SerializedName("pub_date_ms")
    @Expose
    private Integer pubDateMs;
    @SerializedName("publisher_original")
    @Expose
    private String publisherOriginal;
    @SerializedName("rss")
    @Expose
    private String rss;
    @SerializedName("itunes_id")
    @Expose
    private Integer itunesId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title_highlighted")
    @Expose
    private String titleHighlighted;

    public String getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(String audioLength) {
        this.audioLength = audioLength;
    }

    public List<Object> getTranscriptsHighlighted() {
        return transcriptsHighlighted;
    }

    public void setTranscriptsHighlighted(List<Object> transcriptsHighlighted) {
        this.transcriptsHighlighted = transcriptsHighlighted;
    }

    public String getTitleOriginal() {
        return titleOriginal;
    }

    public void setTitleOriginal(String titleOriginal) {
        this.titleOriginal = titleOriginal;
    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getPublisherHighlighted() {
        return publisherHighlighted;
    }

    public void setPublisherHighlighted(String publisherHighlighted) {
        this.publisherHighlighted = publisherHighlighted;
    }

    public String getDescriptionOriginal() {
        return descriptionOriginal;
    }

    public void setDescriptionOriginal(String descriptionOriginal) {
        this.descriptionOriginal = descriptionOriginal;
    }

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getListennotesUrl() {
        return listennotesUrl;
    }

    public void setListennotesUrl(String listennotesUrl) {
        this.listennotesUrl = listennotesUrl;
    }

    public String getPodcastListennotesUrl() {
        return podcastListennotesUrl;
    }

    public void setPodcastListennotesUrl(String podcastListennotesUrl) {
        this.podcastListennotesUrl = podcastListennotesUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescriptionHighlighted() {
        return descriptionHighlighted;
    }

    public void setDescriptionHighlighted(String descriptionHighlighted) {
        this.descriptionHighlighted = descriptionHighlighted;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public String getPodcastTitleOriginal() {
        return podcastTitleOriginal;
    }

    public void setPodcastTitleOriginal(String podcastTitleOriginal) {
        this.podcastTitleOriginal = podcastTitleOriginal;
    }

    public String getPodcastTitleHighlighted() {
        return podcastTitleHighlighted;
    }

    public void setPodcastTitleHighlighted(String podcastTitleHighlighted) {
        this.podcastTitleHighlighted = podcastTitleHighlighted;
    }

    public Integer getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Integer pubDateMs) {
        this.pubDateMs = pubDateMs;
    }

    public String getPublisherOriginal() {
        return publisherOriginal;
    }

    public void setPublisherOriginal(String publisherOriginal) {
        this.publisherOriginal = publisherOriginal;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public Integer getItunesId() {
        return itunesId;
    }

    public void setItunesId(Integer itunesId) {
        this.itunesId = itunesId;
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

}
