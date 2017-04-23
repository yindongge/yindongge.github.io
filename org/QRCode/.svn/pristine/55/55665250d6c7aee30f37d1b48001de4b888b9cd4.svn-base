package com.org.baseserver.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.baseserver.dao.user.QrcodeUserDao;
import com.org.baseserver.entity.user.QrcodeUser;
import com.org.baseserver.service.user.QrcodeUserService;
import com.org.core.dao.BaseDao;
import com.org.core.service.BaseServiceImpl;

@Service
public class QrcodeUserServiceImpl extends BaseServiceImpl<QrcodeUser, Integer> implements QrcodeUserService {
    @Resource
    private QrcodeUserDao qrcodeUserDao;

    @Override
    protected BaseDao<QrcodeUser, Integer> getBaseDao() {
        return qrcodeUserDao;
    }
}