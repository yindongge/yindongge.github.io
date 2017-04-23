package com.kjj.commserver.service.user.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgUserActiveDao;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.aide.OrgUserActiveConstant;
import com.kjj.commserver.entity.user.aide.OrgUserActiveQuery;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.util.EmailUtil;
import com.kjj.commserver.util.SmsUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgUserActiveServiceImpl extends BaseServiceImpl<OrgUserActive, Integer> implements OrgUserActiveService {
    @Resource
    private OrgUserActiveDao orgUserActiveDao;

    @Override
    protected BaseDao<OrgUserActive, Integer> getBaseDao() {
        return orgUserActiveDao;
    }
    
    @Override
    public void add(OrgUserActive orgUserActive){
    	orgUserActive.setIsactive(OrgUserActiveConstant.STATUS_ACTIVE);
    	orgUserActive.setCreatetime(new Date());
    	super.add(orgUserActive);
    }

	@Override
	public OrgUserActive queryLastByMobilePhone(String mobilePhone) {
		OrgUserActiveQuery query = new OrgUserActiveQuery();
		query.setPhone(mobilePhone);
		Sort sort = new Sort(Direction.DESC,"t.id");
		return queryOne(query,sort);
	}

	@Override
	public void addRegisterCodeByMobilePhone(String mobilePhone) {
		String registerCode = RandomStringUtils.randomNumeric(4);
		OrgUserActive userActive = new OrgUserActive();
		userActive.setPhone(mobilePhone);
		userActive.setVcode(registerCode);
		userActive.setFlag(OrgUserActiveConstant.FLAG_MOBILE);
		add(userActive);
		SmsUtil.sendVerificationMessage(mobilePhone,registerCode);
	}

	@Override
	public void addBindCodeByEmai(String email,String orgUsersName) {
		String emailCode = RandomStringUtils.randomNumeric(6);
		OrgUserActive userActive = new OrgUserActive();
		userActive.setEmail(email);
		userActive.setVcode(emailCode);
		userActive.setFlag(OrgUserActiveConstant.FLAG_EMAIL);
		add(userActive);
		EmailUtil.sendEmailCode(email,orgUsersName,emailCode);
	}
}