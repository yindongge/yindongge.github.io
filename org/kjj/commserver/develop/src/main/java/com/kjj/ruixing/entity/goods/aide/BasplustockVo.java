package com.kjj.ruixing.entity.goods.aide;

import java.util.Date;

import com.kjj.ruixing.entity.goods.Basplustock;

public class BasplustockVo extends Basplustock {
	
	/** 瑞星数据库当前时刻 */
	private Date dbTime;

	public Date getDbTime() {
		return dbTime;
	}

	public void setDbTime(Date dbTime) {
		this.dbTime = dbTime;
	}
	
}