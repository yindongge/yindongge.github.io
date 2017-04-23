package com.kjj.commserver.service.goods;

import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.goods.OrgProductPropertyValue;
import com.kjj.commserver.entity.goods.aide.OrgProductPropertyValueVo;
import com.kjj.core.service.BaseService;

public interface OrgProductPropertyValueService extends BaseService<OrgProductPropertyValue, Integer> {
	
	List<OrgProductPropertyValueVo> queryVoByClassId(Integer classId);
	
	List<Map<String,Object>> queryListByClassId(Integer classId);
}