package com.haoyukeji.tms.service.impl;

import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.entity.StoreAccount;
import com.haoyukeji.tms.mapper.StoreAccountMapper;
import com.haoyukeji.tms.mapper.StoreMapper;
import com.haoyukeji.tms.service.StoreService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private StoreAccountMapper storeAccountMapper;

    /**
     * 添加新的销售点
     * @param store
     */
    @Override
    public void saveNewStore(Store store) {
        store.setStoreCreateTime(new Date());
        storeMapper.insertSelective(store);

        //创建销售点账号
        StoreAccount storeAccount = new StoreAccount();
        storeAccount.setId(store.getId());
        storeAccount.setStoreAccountName(store.getStoreName());
        storeAccount.setStoreAccountMobile(store.getStoreMobile());
        //截取手机号后六位作为默认密码
        storeAccount.setStoreAccountPassword(DigestUtils.md5Hex(storeAccount.getStoreAccountMobile().substring(5)));
        //默认账号的状态为正常
        storeAccount.setStoreAccountState(StoreAccount.ACCOUNT_STATE_NORMAL);
        storeAccount.setStoreAccountCreateTime(new Date());

        storeAccountMapper.insertSelective(storeAccount);

    }
}
