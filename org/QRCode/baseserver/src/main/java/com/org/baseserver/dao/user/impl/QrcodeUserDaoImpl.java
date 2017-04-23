package com.org.baseserver.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.org.baseserver.dao.user.QrcodeUserDao;
import com.org.baseserver.entity.user.QrcodeUser;
import com.org.core.dao.BaseDaoImpl;

@Repository
public class QrcodeUserDaoImpl extends BaseDaoImpl<QrcodeUser, Integer> implements QrcodeUserDao {
}