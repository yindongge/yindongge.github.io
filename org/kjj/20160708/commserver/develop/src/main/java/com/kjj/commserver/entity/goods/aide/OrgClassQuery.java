package com.kjj.commserver.entity.goods.aide;

import java.util.Collection;

import com.kjj.commserver.entity.goods.OrgClass;

public class OrgClassQuery extends OrgClass {
	/**父类ids*/
	private Collection<Integer> classParentIds;
	
	private boolean classShowmenuMark = false;
	
	private boolean classShowhighlightMark = false;
	
	private Integer brandId;
	
	/** 顶层ID,用于取得本身及所有子类 */
	private Integer topId;

	public Integer getTopId() {
		return topId;
	}

	public void setTopId(Integer topId) {
		this.topId = topId;
	}

	public boolean isClassShowmenuMark() {
		return classShowmenuMark;
	}

	public void setClassShowmenuMark(boolean classShowmenuMark) {
		this.classShowmenuMark = classShowmenuMark;
	}

	public boolean isClassShowhighlightMark() {
		return classShowhighlightMark;
	}

	public void setClassShowhighlightMark(boolean classShowhighlightMark) {
		this.classShowhighlightMark = classShowhighlightMark;
	}

	public Collection<Integer> getClassParentIds() {
		return classParentIds;
	}

	public void setClassParentIds(Collection<Integer> classParentIds) {
		this.classParentIds = classParentIds;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
}