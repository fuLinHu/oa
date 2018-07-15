package com.hacker.oa.bean;

import java.util.List;

public class PageResult<T> {
    //new PageResult<TResource>(tResourceWhere, total, imageList);
    private long total;
    private List<T> imageList;
    public PageResult(T t,long total,List<T> imageList){
        this.imageList=imageList;
        this.total=total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getImageList() {
        return imageList;
    }

    public void setImageList(List<T> imageList) {
        this.imageList = imageList;
    }
}
