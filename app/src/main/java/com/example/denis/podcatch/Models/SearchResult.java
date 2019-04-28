package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("took")
    @Expose
    private Double took;
    @SerializedName("episodes")
    @Expose
    private List<Search> episodes = null;
    @SerializedName("next_offset")
    @Expose
    private Integer nextOffset;

    public SearchResult(Integer total, Integer count, Double took, List<Search> episodes, Integer nextOffset) {
        this.total = total;
        this.count = count;
        this.took = took;
        this.episodes = episodes;
        this.nextOffset = nextOffset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTook() {
        return took;
    }

    public void setTook(Double took) {
        this.took = took;
    }

    public List<Search> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Search> episodes) {
        this.episodes = episodes;
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }
}
