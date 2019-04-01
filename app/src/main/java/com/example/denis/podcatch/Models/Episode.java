package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode {
    @SerializedName("maybe_audio_invalid")
    @Expose
    private Boolean maybeAudioInvalid;
    @SerializedName("pub_date_ms")
    @Expose
    private Integer pubDateMs;
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
    @SerializedName("explicit_content")
    @Expose
    private Boolean explicitContent;
    @SerializedName("audio")
    @Expose
    private String audio;
    @SerializedName("audio_length")
    @Expose
    private Integer audioLength;

    public Boolean getMaybeAudioInvalid() {
        return maybeAudioInvalid;
    }

    public void setMaybeAudioInvalid(Boolean maybeAudioInvalid) {
        this.maybeAudioInvalid = maybeAudioInvalid;
    }

    public Integer getPubDateMs() {
        return pubDateMs;
    }

    public void setPubDateMs(Integer pubDateMs) {
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

    public Boolean getExplicitContent() {
        return explicitContent;
    }

    public void setExplicitContent(Boolean explicitContent) {
        this.explicitContent = explicitContent;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public Integer getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(Integer audioLength) {
        this.audioLength = audioLength;
    }
}
