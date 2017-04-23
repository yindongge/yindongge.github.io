package com.kjj.commserver.service.special;

import com.kjj.commserver.entity.special.OrgSpecialTime;
import com.kjj.core.service.BaseService;

public interface OrgSpecialTimeService extends BaseService<OrgSpecialTime, Integer> {
	
	void updateBySpecialId(OrgSpecialTime orgSpecialTime);
}