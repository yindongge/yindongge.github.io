package com.kjj.commserver.dao.discount;

import java.util.Date;

import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.core.dao.BaseDao;

public interface OrgReachDao extends BaseDao<OrgReach, Integer> {
	Date getDbTime();
}