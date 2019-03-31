package com.example.denis.podcatch.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("took")
    @Expose
    private Double took;
    @SerializedName("next_offset")
    @Expose
    private Integer nextOffset;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("results")
    @Expose
    private List<Podcast> results = null;
    @SerializedName("previous_page_number")
    @Expose
    private Integer previousPageNumber;
    @SerializedName("next_page_number")
    @Expose
    private Integer nextPageNumber;
    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("has_previous")
    @Expose
    private Boolean hasPrevious;

    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;

    public Integer getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public Integer getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(Boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }


    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
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

    public Integer getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Podcast> getResults() {
        return results;
    }

    public void setResults(List<Podcast> results) {
        this.results = results;
    }

}

