package com.kjj.commserver.entity.goods.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.commserver.entity.goods.OrgSaleSpec;

public class OrgProductTypeVo extends OrgProductType {
	/**类型分组名称*/
	private String groupName;
	/**关联的销售规格*/
	private List<OrgSaleSpec> saleSpecList = new ArrayList<OrgSaleSpec>();
	/**关联的属性*/
	private List<OrgProductProperty> productProperty = new ArrayList<OrgProductProperty>();
	
	private long propertyNum;
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<OrgSaleSpec> getSaleSpecList() {
		return saleSpecList;
	}

	public void setSaleSpecList(List<OrgSaleSpec> saleSpecList) {
		this.saleSpecList = saleSpecList;
	}

	public List<OrgProductProperty> getProductProperty() {
		return productProperty;
	}

	public void setProductProperty(List<OrgProductProperty> productProperty) {
		this.productProperty = productProperty;
	}

	public long getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(long propertyNum) {
		this.propertyNum = propertyNum;
	}
	
	
}