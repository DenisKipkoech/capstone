package com.example.denis.podcatch.Models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "podcast")
public class Podcast implements Parcelable {

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

    public Podcast(Integer totalEpisodes, List<Episode> episodes, Long nextEpisodePubDate, String description, String title, Long lastestPubDateMs, Long earliestPubDateMs, String publisher, String website, String listennotesUrl, @NonNull String id, String image, String email, Boolean explicitContent, String country, String thumbnail) {
        this.totalEpisodes = totalEpisodes;
        this.episodes = episodes;
        this.nextEpisodePubDate = nextEpisodePubDate;
        this.description = description;
        this.title = title;
        this.lastestPubDateMs = lastestPubDateMs;
        this.earliestPubDateMs = earliestPubDateMs;
        this.publisher = publisher;
        this.website = website;
        this.listennotesUrl = listennotesUrl;
        this.id = id;
        this.image = image;
        this.email = email;
        this.explicitContent = explicitContent;
        this.country = country;
        this.thumbnail = thumbnail;
    }

    protected Podcast(Parcel in) {
        if (in.readByte() == 0) {
            totalEpisodes = null;
        } else {
            totalEpisodes = in.readInt();
        }
        episodes = in.createTypedArrayList(Episode.CREATOR);
        if (in.readByte() == 0) {
            nextEpisodePubDate = null;
        } else {
            nextEpisodePubDate = in.readLong();
        }
        description = in.readString();
        title = in.readString();
        if (in.readByte() == 0) {
            lastestPubDateMs = null;
        } else {
            lastestPubDateMs = in.readLong();
        }
        if (in.readByte() == 0) {
            earliestPubDateMs = null;
        } else {
            earliestPubDateMs = in.readLong();
        }
        publisher = in.readString();
        website = in.readString();
        listennotesUrl = in.readString();
        id = in.readString();
        image = in.readString();
        email = in.readString();
        byte tmpExplicitContent = in.readByte();
        explicitContent = tmpExplicitContent == 0 ? null : tmpExplicitContent == 1;
        country = in.readString();
        thumbnail = in.readString();
    }

    public static final Creator<Podcast> CREATOR = new Creator<Podcast>() {
        @Override
        public Podcast createFromParcel(Parcel in) {
            return new Podcast(in);
        }

        @Override
        public Podcast[] newArray(int size) {
            return new Podcast[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (totalEpisodes == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalEpisodes);
        }
        dest.writeTypedList(episodes);
        if (nextEpisodePubDate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(nextEpisodePubDate);
        }
        dest.writeString(description);
        dest.writeString(title);
        if (lastestPubDateMs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(lastestPubDateMs);
        }
        if (earliestPubDateMs == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(earliestPubDateMs);
        }
        dest.writeString(publisher);
        dest.writeString(website);
        dest.writeString(listennotesUrl);
        dest.writeString(id);
        dest.writeString(image);
        dest.writeString(email);
        dest.writeByte((byte) (explicitContent == null ? 0 : explicitContent ? 1 : 2));
        dest.writeString(country);
        dest.writeString(thumbnail);
    }
}
