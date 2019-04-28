package com.example.denis.podcatch.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episode implements Parcelable {

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
    @SerializedName(value = "title", alternate = "title_original")
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

    public Episode(Long pubDateMs, String listennotesUrl, String id, String image, String title, String thumbnail, String audio, Long audioLength) {

        this.pubDateMs = pubDateMs;
        this.listennotesUrl = listennotesUrl;
        this.id = id;
        this.image = image;

        this.title = title;
        this.thumbnail = thumbnail;


        this.audio = audio;
        this.audioLength = audioLength;
    }


    protected Episode(Parcel in) {
        if (in.readByte() == 0) {
            pubDateMs = null;
        } else {
            pubDateMs = in.readLong();
        }
        listennotesUrl = in.readString();
        id = in.readString();
        image = in.readString();
        description = in.readString();
        title = in.readString();
        thumbnail = in.readString();
        listennotesEditUrl = in.readString();
        audio = in.readString();
        if (in.readByte() == 0) {
            audioLength = null;
        } else {
            audioLength = in.readLong();
        }
    }

    public static final Creator<Episode> CREATOR = new Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (pubDateMs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(pubDateMs);
        }
        dest.writeString(listennotesUrl);
        dest.writeString(id);
        dest.writeString(image);
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(thumbnail);
        dest.writeString(listennotesEditUrl);
        dest.writeString(audio);
        if (audioLength == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(audioLength);
        }
    }
}
