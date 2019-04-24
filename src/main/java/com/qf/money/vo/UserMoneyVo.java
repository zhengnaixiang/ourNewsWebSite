package com.qf.money.vo;

import io.swagger.annotations.ApiModelProperty;

public class UserMoneyVo {

    @ApiModelProperty("当前页码")
    private int pageNum;
    @ApiModelProperty("分页数")
    private int pageSize=3;
    @ApiModelProperty("排序字段")
    private String order;
    @ApiModelProperty("排序方式")
    private String dir;
    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("搜索关键词")
    private String search;


    public UserMoneyVo() {
    }

    public UserMoneyVo(int pageNum, int pageSize, String order, String dir, Integer userId, String search) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.order = order;
        this.dir = dir;
        this.userId = userId;
        this.search = search;
    }

    @Override
    public String toString() {
        return "UserMoneyVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", order='" + order + '\'' +
                ", dir='" + dir + '\'' +
                ", userId=" + userId +
                ", search='" + search + '\'' +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
