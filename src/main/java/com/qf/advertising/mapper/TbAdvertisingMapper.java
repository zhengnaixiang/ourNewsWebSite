package com.qf.advertising.mapper;

import com.qf.advertising.pojo.TbAdvertising;

import java.util.List;

public interface TbAdvertisingMapper{
    /**
     * 加载普通广告
     * @return
     */
    public List<TbAdvertising> ordinary();

    /**
     * 加载滑动广告
     * @return
     */
    public List<TbAdvertising> sliding();
}
