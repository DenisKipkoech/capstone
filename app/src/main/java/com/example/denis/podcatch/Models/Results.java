package com.example.denis.podcatch.Models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {
    @SerializedName("next_page_number")
    @Expose
    private Integer nextPageNumber;
    @SerializedName("previous_page_number")
    @Expose
    private Integer previousPageNumber;
    @SerializedName("has_next")
    @Expose
    private Boolean hasNext;
    @SerializedName("page_number")
    @Expose
    private Integer pageNumber;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("curated_lists")
    @Expose
    private List<Category> categories = null;

    public Results() {
    }

    public Results(Integer nextPageNumber, Integer previousPageNumber, Boolean hasNext, Integer pageNumber, Integer total, List<Category> categories) {
        this.nextPageNumber = nextPageNumber;
        this.previousPageNumber = previousPageNumber;
        this.hasNext = hasNext;
        this.pageNumber = pageNumber;
        this.total = total;
        this.categories = categories;
    }

    public Integer getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(Integer nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public Integer getPreviousPageNumber() {
        return previousPageNumber;
    }

    public void setPreviousPageNumber(Integer previousPageNumber) {
        this.previousPageNumber = previousPageNumber;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @NonNull
    public List<Category> getCategories() {
        return categories;
    }

    public void setCuratedLists(List<Category> categories) {
        this.categories = categories;
    }
}

