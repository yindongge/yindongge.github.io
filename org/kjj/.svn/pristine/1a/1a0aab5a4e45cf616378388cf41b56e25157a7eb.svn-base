package com.kjj.commserver.entity.order.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.shop.OrgShop;

public class OrgOrderVo extends OrgOrder {
	
	/** 订单对应商品列表 */
	private List<OrgOrderGoods> listOrderGoods = new ArrayList<OrgOrderGoods>();
	
	/** 订单对应店铺信息 */
	private OrgShop orgShop;
	
	/** 用户名 */
	private String userName;
	
	/**所在地区*/
	private String show;
	
	/** 待解决问题订单数 */
	private Integer waitSolveCount;
	
	/** 已解决问题订单数 */
	private Integer finishSolveCount;
	
	/** 订单中商品总数量  */
    private Integer totalNum;
    
	public List<OrgOrderGoods> getListOrderGoods() {
		return listOrderGoods;
	}

	public void setListOrderGoods(List<OrgOrderGoods> listOrderGoods) {
		this.listOrderGoods = listOrderGoods;
	}

	public OrgShop getOrgShop() {
		return orgShop;
	}

	public void setOrgShop(OrgShop orgShop) {
		this.orgShop = orgShop;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public int getFinishSolveCount() {
		return finishSolveCount;
	}

	public void setFinishSolveCount(int finishSolveCount) {
		this.finishSolveCount = finishSolveCount;
	}

	public int getWaitSolveCount() {
		return waitSolveCount;
	}

	public void setWaitSolveCount(int waitSolveCount) {
		this.waitSolveCount = waitSolveCount;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	
}