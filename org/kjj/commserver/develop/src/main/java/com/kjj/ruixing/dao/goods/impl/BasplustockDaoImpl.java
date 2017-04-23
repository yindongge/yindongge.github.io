package com.kjj.ruixing.dao.goods.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.kjj.core.dao.RuiXingDaoImpl;
import com.kjj.ruixing.dao.goods.BasplustockDao;
import com.kjj.ruixing.entity.goods.Basplustock;

@Repository
public class BasplustockDaoImpl extends RuiXingDaoImpl<Basplustock, Short> implements BasplustockDao {
	
	private static final String SQL_ID_SELECTSYNCSTOCK = "selectSyncStock";
	
	@Override
	public void querySyncStock() {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		this.sqlSessionRuiXing.selectOne(SQL_ID_SELECTSYNCSTOCK, map);
		
		System.out.print("执行瑞星存储过程返回结果:" + map.get("state").toString());
	}
}