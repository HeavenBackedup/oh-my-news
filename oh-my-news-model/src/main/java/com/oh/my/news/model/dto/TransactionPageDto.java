package com.oh.my.news.model.dto;

import com.oh.my.news.model.po.TransactionPo;

import java.util.List;

/**
 * Created by shj on 2017/5/16.
 */
public class TransactionPageDto {

    List<TransactionPo> transactionPos;
    Pagination pagination;

    public TransactionPageDto(List<TransactionPo> transactionPos, Pagination pagination) {
        this.transactionPos = transactionPos;
        this.pagination = pagination;
    }

    public TransactionPageDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionPageDto that = (TransactionPageDto) o;

        if (transactionPos != null ? !transactionPos.equals(that.transactionPos) : that.transactionPos != null)
            return false;
        return pagination != null ? pagination.equals(that.pagination) : that.pagination == null;
    }

    @Override
    public int hashCode() {
        int result = transactionPos != null ? transactionPos.hashCode() : 0;
        result = 31 * result + (pagination != null ? pagination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransactionPageDto{" +
                "transactionPos=" + transactionPos +
                ", pagination=" + pagination +
                '}';
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<TransactionPo> getTransactionPos() {
        return transactionPos;
    }

    public void setTransactionPos(List<TransactionPo> transactionPos) {
        this.transactionPos = transactionPos;
    }
}
