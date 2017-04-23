package com.kjj.commserver.dao.goods.impl;

import com.kjj.commserver.dao.goods.OrgProductDao;
import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrgProductDaoImpl extends BaseDaoImpl<OrgProduct, Integer> implements OrgProductDao {
}