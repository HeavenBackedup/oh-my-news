package com.oh.my.news.model.dto;

import com.oh.my.news.model.vo.mainpage.*;
import com.oh.my.news.model.vo.mainpage.EditContent;

import java.util.List;

/**
 * Created by Dzhaoooo on 17/5/10.
 */
public class EditContentDto {
    private Pagination pagination;
    private List<com.oh.my.news.model.vo.mainpage.EditContent> contents;

    public EditContentDto(Pagination pagination, List<EditContent> contents) {
        this.pagination = pagination;
        this.contents = contents;
    }

    public EditContentDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EditContentDto that = (EditContentDto) o;

        if (pagination != null ? !pagination.equals(that.pagination) : that.pagination != null) return false;
        return contents != null ? contents.equals(that.contents) : that.contents == null;
    }

    @Override
    public int hashCode() {
        int result = pagination != null ? pagination.hashCode() : 0;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EditContentDto{" +
                "pagination=" + pagination +
                ", contents=" + contents +
                '}';
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<EditContent> getContents() {
        return contents;
    }

    public void setContents(List<EditContent> contents) {
        this.contents = contents;
    }
}
