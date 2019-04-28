package com.qf.advertising.pojo;

import javax.persistence.*;

@Table(name = "advertising")
public class TbAdvertising {
    /**
     * 广告id
     */
    @Id
    @Column(name = "advertising_id")
    private Integer advertisingId;

    /**
     * 图片地址
     */
    private String picture;

    /**
     * 点击广告所进入的超链接
     */
    private String links;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 1代表普通广告/2代表滑动广告
     */
    private Integer category;

    /**
     * 获取广告id
     *
     * @return advertising_id - 广告id
     */
    public Integer getAdvertisingId() {
        return advertisingId;
    }

    /**
     * 设置广告id
     *
     * @param advertisingId 广告id
     */
    public void setAdvertisingId(Integer advertisingId) {
        this.advertisingId = advertisingId;
    }

    /**
     * 获取图片地址
     *
     * @return picture - 图片地址
     */
    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "TbAdvertising{" +
                "advertisingId=" + advertisingId +
                ", picture='" + picture + '\'' +
                ", links='" + links + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                '}';
    }

    /**
     * 设置图片地址
     *
     * @param picture 图片地址
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 获取点击广告所进入的超链接
     *
     * @return links - 点击广告所进入的超链接
     */
    public String getLinks() {
        return links;
    }

    /**
     * 设置点击广告所进入的超链接
     *
     * @param links 点击广告所进入的超链接
     */
    public void setLinks(String links) {
        this.links = links == null ? null : links.trim();
    }

    /**
     * 获取新闻标题
     *
     * @return title - 新闻标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置新闻标题
     *
     * @param title 新闻标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取1代表普通广告/2代表滑动广告
     *
     * @return category - 1代表普通广告/2代表滑动广告
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置1代表普通广告/2代表滑动广告
     *
     * @param category 1代表普通广告/2代表滑动广告
     */
    public void setCategory(Integer category) {
        this.category = category;
    }
}
