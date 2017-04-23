package com.kjj.ruixing.service.goods;

import java.util.Date;
import java.util.List;

import com.kjj.core.service.BaseService;
import com.kjj.ruixing.entity.goods.Basplustock;

public interface BasplustockService extends BaseService<Basplustock, Short> {

	/**
	 * 查询上次更新以后变更的库存
	 * @param lastUpdateTime
	 * @return
	 */
	List<Basplustock> queryListByLastUpdateTime(Date lastUpdateTime);
}