package com.qf.advertising.dto;

import com.qf.advertising.pojo.TbAdvertising;

import java.util.List;

public class SlidingDto {
    private List<TbAdvertising> list;

    public SlidingDto() {
    }

    public SlidingDto(List<TbAdvertising> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SlidingDto{" +
                "list=" + list +
                '}';
    }

    public List<TbAdvertising> getList() {
        return list;
    }

    public void setList(List<TbAdvertising> list) {
        this.list = list;
    }
}
