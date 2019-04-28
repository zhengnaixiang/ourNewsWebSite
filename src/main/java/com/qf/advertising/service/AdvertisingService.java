package com.qf.advertising.service;

import com.qf.advertising.pojo.TbAdvertising;

import java.util.List;

public interface AdvertisingService {
    /**
     * 加载普通广告
     * @return
     */
    public TbAdvertising ordinary();

    /**
     * 加载滑动广告
     * @return
     */
    public List<TbAdvertising> sliding();
}
