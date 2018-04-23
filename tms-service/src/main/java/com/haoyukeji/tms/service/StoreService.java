package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.Store;

public interface StoreService {

    /**
     * 添加新的销售点
     * @param store
     */
    void saveNewStore(Store store);
}
