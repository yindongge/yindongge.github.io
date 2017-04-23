package com.kjj.commserver.entity.user.aide;

import java.util.HashMap;
import java.util.Map;

import com.kjj.commserver.entity.order.OrgCart;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.OrgUsers;

public class OrgUsersSession{
	/** 用户 */
	private OrgUsers orgUsers;
	/** 用户选择店铺 */
	private OrgShop orgShop;
	/** 用户选择送货地址 */
	private OrgUserAddress orgUserAddress;
	/** 是否登录 */
	private boolean login = false;
	/** 游客购物车 */
	private Map<Integer,OrgCart> visitorCart = new HashMap<Integer,OrgCart>();
	/** 登录来源 */
	private Byte source;
	/** 是否检查免登陆 */
	private boolean remembermeCheck = true;
	/** 是否检查店铺*/
	private boolean shopCheck = true;
	/** 企业状态 */
	private Byte enterpriseStatus;
	
	public OrgUsersSession(Byte source) {
		super();
		setSource(source);
	}
	public OrgUsers getOrgUsers() {
		return orgUsers;
	}
	public void setOrgUsers(OrgUsers orgUsers) {
		this.orgUsers = orgUsers;
	}
	public OrgShop getOrgShop() {
		return orgShop;
	}
	public void setOrgShop(OrgShop orgShop) {
		this.orgShop = orgShop;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public Map<Integer, OrgCart> getVisitorCart() {
		return visitorCart;
	}
	public void setVisitorCart(Map<Integer, OrgCart> visitorCart) {
		this.visitorCart = visitorCart;
	}
	public OrgUserAddress getOrgUserAddress() {
		return orgUserAddress;
	}
	public void setOrgUserAddress(OrgUserAddress orgUserAddress) {
		this.orgUserAddress = orgUserAddress;
	}
	public Byte getSource() {
		return source;
	}
	public void setSource(Byte source) {
		this.source = source;
	}
	public boolean isRemembermeCheck() {
		return remembermeCheck;
	}
	public void setRemembermeCheck(boolean remembermeCheck) {
		this.remembermeCheck = remembermeCheck;
	}
	public boolean isShopCheck() {
		return shopCheck;
	}
	public void setShopCheck(boolean shopCheck) {
		this.shopCheck = shopCheck;
	}
	public Byte getEnterpriseStatus() {
		return enterpriseStatus;
	}
	public void setEnterpriseStatus(Byte enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}
	
}
