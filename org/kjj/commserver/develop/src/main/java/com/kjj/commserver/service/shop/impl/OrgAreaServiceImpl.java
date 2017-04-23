package com.kjj.commserver.service.shop.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgAreaDao;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.aide.OrgAreaConstant;
import com.kjj.commserver.entity.shop.aide.OrgAreaQuery;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgAreaServiceImpl extends BaseServiceImpl<OrgArea, String> implements OrgAreaService {
    @Resource
    private OrgAreaDao orgAreaDao;

    @Override
    protected BaseDao<OrgArea, String> getBaseDao() {
        return orgAreaDao;
    }

	@Override
	public List<OrgArea> queryListProvince() {
		OrgAreaQuery query = new OrgAreaQuery();
		query.setLevel(OrgAreaConstant.LEVEL_PROVINCE);
		return queryList(query);
	}

	@Override
	public List<OrgArea> queryListByParentCode(String parentCode) {
		OrgAreaQuery query = new OrgAreaQuery();
		query.setParentCode(parentCode);
		return queryList(query);
	}

	@Override
	public String getSearchCode(String code) {
		if (StringUtils.isBlank(code) || "-1".equals(code)) {
			//查询条件为空
			code = null;
		}else if(code.endsWith("0000")){
			//查询条件为省
			code = code.replace("0000", "");
		}else if(code.endsWith("00")){
			//查询条件为市
			code = code.replace("00", "");
		}else{
			//查询条件为县
		}
		return code;
	}

	@Override
	public List<OrgArea> queryListByLevel(Byte level) {
		OrgAreaQuery query = new OrgAreaQuery();
		query.setLevel(level);
		return queryList(query);
	}
}