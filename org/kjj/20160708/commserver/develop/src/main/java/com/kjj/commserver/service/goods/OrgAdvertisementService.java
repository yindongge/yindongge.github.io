package com.kjj.commserver.service.goods;

import com.kjj.commserver.entity.goods.OrgAdvertisement;
import com.kjj.core.service.BaseService;

public interface OrgAdvertisementService extends BaseService<OrgAdvertisement, Integer> {
	/**
	 * 添加主表及子表数据
	 * @param advertisement
	 */
	void addAdvertisementAndItem(OrgAdvertisement advertisement);
	/**
	 * 删除主表及子表数据
	 * @param id 热门推荐id
	 */
	void deleteAdvertisementAndItem(Integer id);
}