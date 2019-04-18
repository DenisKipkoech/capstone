package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode {

    @SerializedName("pub_date_ms")
    @Expose
    private Long pubDateMs;
    @SerializedName("listennotes_url")
    @Expose
    private String listennotesUrl;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("listennotes_edit_url")
    @Expose
    private String listennotesEditUrl;

    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("audio_length")
    @Expose
    private Long audioLength;

    public Episode(Long pubDateMs, String listennotesUrl, String id, String image, String description, String title, String thumbnail, String listennotesEditUrl, String audio, Long audioLength) {

        this.pubDateMs = pubDateMs;
        this.listennotesUrl = listennotesUrl;
        this.id = id;
        this.image = image;
        this.description = description;
        this.title = title;
        this.thumbnail = thumbnail;
        this.listennotesEditUrl = listennotesEditUrl;

        this.audio = audio;
        this.audioLength = audioLength;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getListennotesEditUrl() {
        return listennotesEditUrl;
    }

    public void setListennotesEditUrl(String listennotesEditUrl) {
        this.listennotesEditUrl = listennotesEditUrl;
    }


    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Long getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(Long audioLength) {
        this.audioLength = audioLength;
    }
}
