package com.haoyukeji.tms.service;

import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.entity.StoreAccount;
import com.haoyukeji.tms.entity.StoreAccountLog;

import java.util.List;

public interface StoreService {

    /**
     * 添加新的销售点
     * @param store
     */
    void saveNewStore(Store store);

    /**
     * 查询所有的销售点
     */
    List<Store> findAllStore();

    /**
     * 根据售票点id查询售票点信息以及售票点账户信息
     * @param id
     */
    Store findStoreById(Integer id);

    /**
     * 修改售票点信息
     * @param store
     */
    void updateStore(Store store);

    /**
     * 删除售票点以及售票点账号
     * @param id
     */
    void delStoreWithAccountById(Integer id);

    /**
     * 根据手机号查询登陆对象
     * @param userMobile
     * @return
     */
    StoreAccount findStoreAccountByName(String userMobile);

    /**
     * 根据ID售票点账户Id查询售票点信息
     * @param id
     * @return
     */
    Store findAStoreById(Integer id);

    /**
     * 登陆日志
     * @param storeAccountLog
     */
    void saveAccountLoginLog(StoreAccountLog storeAccountLog);
}
