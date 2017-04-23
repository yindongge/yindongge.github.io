package com.kjj.commserver.service.user.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgUsersDao;
import com.kjj.commserver.entity.discount.aide.OrgDiscountTriggerConstant;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgShopConstant;
import com.kjj.commserver.entity.system.aide.OrgLocation;
import com.kjj.commserver.entity.user.OrgUserAddress;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.entity.user.aide.OrgUserAddressConstant;
import com.kjj.commserver.entity.user.aide.OrgUserLevelConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersConstant;
import com.kjj.commserver.entity.user.aide.OrgUsersQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.entity.user.aide.OrgUsersVo;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.discount.OrgDiscountTriggerService;
import com.kjj.commserver.service.order.OrgCartService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgUserAddressService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.commserver.util.IdUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.entity.user.Basvip;
import com.kjj.ruixing.service.user.BasvipService;

@Service
public class OrgUsersServiceImpl extends BaseServiceImpl<OrgUsers, Integer> implements OrgUsersService {
    @Resource
    private OrgUsersDao orgUsersDao;
    @Resource
    private OrgCartService orgCartService;
    @Resource
    private OrgShopService orgShopService;
    @Resource
    private OrgUserAddressService orgUserAddressService;
    @Resource
    private OrgDiscountTriggerService orgDiscountTriggerService;
    @Resource
    private BasvipService basvipService;
    @Resource
    private OrgUserLevelService orgUserLevelService;
    @Resource
    private OrgEnterpriseService orgEnterpriseService;
    @Resource 
    private OrgAccountDepositService orgAccountDepositService;
    
    
    
    @Override
    protected BaseDao<OrgUsers, Integer> getBaseDao() {
        return orgUsersDao;
    }

	@Override
	public OrgUsers queryByLoginName(String loginName) {
		OrgUsersQuery query = new OrgUsersQuery();
		query.setLoginName(loginName);
		return queryOne(query);
	}

	@Override
	public void add(OrgUsers orgUsers){
		orgUsers.setSerialnumber(String.valueOf(new IdUtil(1,1).nextId()));
		orgUsers.setStatus(OrgUsersConstant.STATUS_VALID);
		orgUsers.setRegTime(new Date());
		// 个人用户默认会员类型和会员等级
		if(orgUsers.getLevelType() == null){
			// 个人用户
			orgUsers.setLevelType(OrgUserLevelConstant.LEVEL_TYPE_USER); 
		}
		if(orgUsers.getLevelId() == null){
			// 普通个人用户
			orgUsers.setLevelId(OrgUserLevelConstant.LEVEL_USER_TYPE_NORMAL_USER);
		}
		
		super.add(orgUsers);
		orgUsers.setUserCode(createUserCode(String.valueOf(orgUsers.getUserId())));// 创建用户编码，与瑞星系统交互做唯一标识
		//修改名称
		if(orgUsers.getUserName() == null){
			orgUsers.setUserName(getDefaultUserName(orgUsers.getUserId()));
		}
		updateByIdSelective(orgUsers);
		orgAccountDepositService.addDeposit(orgUsers); // 新增会员账户
		
		//mergeToRuiXing(orgUsers, true);
		//注册触发
		orgDiscountTriggerService.updateTrigger(OrgDiscountTriggerConstant.TYPE_REGISTER_LIMIT, orgUsers);
	}
	
	/**
	 * 重新updateByIdSelective方法
	 */
	public int updateByIdSelective(OrgUsers user){
		int result = super.updateByIdSelective(user);
		
		if(hasModifyField(user)){
			OrgUsers u = super.queryVoById(user.getUserId());
			user.setUserCode(u.getUserCode());
			mergeToRuiXing(user, false);
		}
		return result;
	}
	
	private boolean hasModifyField(OrgUsers user){
		// 一个一个字段判断
		return false;
	}
	
	public void mergeToRuiXing(OrgUsers user, boolean isNew)  {
		Basvip bv = new Basvip();
		// ***********************未完成************************************
		bv.setIdno(user.getUserCode());
		// 添加userCode
		// ****************************************************************
		if(!StringUtils.isBlank(user.getAddresshome())){
			bv.setAddr(user.getAddresshome());
		}
		
		// 生日
		if(!StringUtils.isBlank(user.getBirthday())){
			Date d = convertBirthday(user.getBirthday());
			if(null != d){
				bv.setBorn(d);
			}
			
		}
		// 邮箱
		if(!StringUtils.isBlank(user.getEmail())){
			bv.setEmail(user.getEmail());
		}
		// 性别
		if(null != user.getSex()){
			if(user.getSex().equals(1)){
				bv.setSex(new BigDecimal(0));
			}
			if(user.getSex().equals(2)){
				bv.setSex(new BigDecimal(1));
			}
		}
		
		bv.setFlag(new BigDecimal(1));
		if(!StringUtils.isBlank(user.getHomePhone())){
			bv.setTel(user.getHomePhone());
		}
		if(!StringUtils.isBlank(user.getUserName())){
			bv.setVipname(user.getUserName());
		}
		if(!StringUtils.isBlank(user.getLevelId())){
			bv.setType(new BigDecimal(Integer.parseInt(user.getLevelId())));
		}
		if(isNew){
			basvipService.add(bv);
		} else {
			basvipService.updateByIdSelective(bv);
		}
			
	}
	
	private String createUserCode(String userId) {
		StringBuffer code = new StringBuffer("10");

		code.append(DateFormatUtil.getDateNumber());

		Random random = new Random();
		
		int len = 5 - userId.length();
		
		if( len <= 5 && len > 0){
			for (int i = 0; i < len; i++) {
				code.append(random.nextInt(10));
			}
			code.append(userId);
		} else {
			for (int i = 0; i < 5; i++) {
				code.append(random.nextInt(10));
			}
		}

		return code.toString();
	}
	
	public static void main(String[] args){
		Set<String> mySet = new HashSet<String>();
		for(int j = 0; j < 1000; j++ ){
			StringBuffer code = new StringBuffer("10");
	
			code.append(DateFormatUtil.getDateNumber());
	
			Random random = new Random();
	
			for (int i = 0; i < 6; i++) {
				code.append(random.nextInt(10));
			}
			mySet.add(code.toString());
			System.out.println(code.toString());
		}
		System.out.println("集合大小:" + mySet.size());
	}
	
	/**
	 * 根据userId获取用户默认名称
	 * @param userId
	 * @return
	 */
	private String getDefaultUserName(Integer userId){
		StringBuffer sb = new StringBuffer("kjj");
		int num0 = 9 - userId.toString().length();
		for(int i = 0;i<num0;i++){
			sb.append("0");
		}
		sb.append(userId);
		return sb.toString();
	}

	@Override
	public void updateLogin(OrgUsersSession oldUsersSession,OrgUsers orgUsers, String ipAddress) {
		//修改用户登录信息
		orgUsers.setLastLogin(new Date());
		orgUsers.setLastIp(ipAddress);
		updateById(orgUsers);
		oldUsersSession.setOrgUsers(orgUsers);
		oldUsersSession.setLogin(true);
		//设置用户企业状态
		setEnterpriseStatus(oldUsersSession);
		//合并购物车
		orgCartService.mergeVisitorCart(oldUsersSession);
	}

	/**
	 * 设置企业状态
	 * @param OrgUsersSession
	 */
	private void setEnterpriseStatus(OrgUsersSession usersSession) {
		if(usersSession.getOrgUsers().getLevelType() == OrgUserLevelConstant.LEVEL_TYPE_ENTERPRISE){
			usersSession.setEnterpriseStatus(orgEnterpriseService.queryByUserId(usersSession.getOrgUsers().getUserId()).getStatus());
		}
	}

	@Override
	public OrgUsers queryByOpenId(String openId) {
		OrgUsersQuery query = new OrgUsersQuery();
		query.setOpenId(openId);
		return queryOne(query);
	}
	
	@Override
	public void updateUserShop4Take(OrgUsersSession orgUsersSession,OrgShop orgShop) {
		//默认店铺
		if(orgShop == null){
			orgShop = orgShopService.getDefaultShop();
		}
		OrgUsers user = new OrgUsers();
		boolean update = false;
		//修改用户当前店铺
		if(orgUsersSession != null && orgUsersSession.getOrgUsers() != null && !orgShop.getShopId().equals(orgUsersSession.getOrgUsers().getServiceId())){
			user.setUserId(orgUsersSession.getOrgUsers().getUserId());
			user.setServiceId(orgShop.getShopId().shortValue());
			update = true;
		}
		orgUsersSession.setOrgShop(orgShop);
		
		//修改用户配送方式
		if(orgUsersSession != null && orgUsersSession.getOrgUsers() != null && OrgUsersConstant.LAST_SEND_STYLE_TAKE != orgUsersSession.getOrgUsers().getLastSendStyle()){
			user.setUserId(orgUsersSession.getOrgUsers().getUserId());
			user.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
			update = true;
			
		}
		
		if(orgUsersSession.getOrgUsers() != null){
			orgUsersSession.getOrgUsers().setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
		}else{
			OrgUsers orgUser = new OrgUsers();
			orgUser.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
			orgUsersSession.setOrgUsers(orgUser);
		}
		
		//有变更
		if(update){
			updateByIdSelective(user);
		}
	}
	
	@Override
	public void updateUserAddress4Send(OrgUsersSession orgUsersSession,OrgUserAddress orgUserAddress) {
		OrgUsers user = new OrgUsers();
		boolean update = false;
		//修改用户送货地址
		if(orgUsersSession != null && orgUsersSession.getOrgUsers() != null && !orgUserAddress.getAddressId().equals(orgUsersSession.getOrgUsers().getAddressId())){
			user.setUserId(orgUsersSession.getOrgUsers().getUserId());
			user.setAddressId(orgUserAddress.getAddressId());
			update = true;
		}
		orgUsersSession.setOrgUserAddress(orgUserAddress);
		//改变该送货地址的店铺
		orgUsersSession.setOrgShop(orgShopService.queryVoById(orgUserAddress.getShopId()));
		//修改用户配送方式
		if(orgUsersSession != null && orgUsersSession.getOrgUsers() != null && OrgUsersConstant.LAST_SEND_STYLE_SEND != orgUsersSession.getOrgUsers().getLastSendStyle()){
			user.setUserId(orgUsersSession.getOrgUsers().getUserId());
			user.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_SEND);
			update = true;
			
		}
		orgUsersSession.getOrgUsers().setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_SEND);
		//有变更
		if(update){
			updateByIdSelective(user);
		}
	}
	
	@Override
	public void updateMobileLogin(OrgUsersSession orgUsersSession,OrgUsers orgUsers, String ipAddress) {
		//切换账号时，解绑其他账号和本openId的关联
		String openId = orgUsers.getOpenId();
		updateOpenId4User(openId);
		
		orgUsersSession.setOrgUsers(orgUsers);
		orgUsersSession.setSource(OrgUsersConstant.SOURCE_MOBILE);
		//默认自提
		if(orgUsers.getLastSendStyle() == null){
			orgUsers.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
		}
		
		if(orgUsers.getLastSendStyle() == OrgUsersConstant.LAST_SEND_STYLE_SEND){
			//送货
			if(orgUsers.getAddressId() != null && orgUsers.getAddressId() > 0){
				OrgUserAddress address = orgUserAddressService.queryVoById(orgUsers.getAddressId());
				if(address.getStatus() == OrgUserAddressConstant.STATUS_VALID){
					OrgShop shop = orgShopService.queryVoById(orgUsers.getServiceId().intValue());
					if(shop.getStatus() == OrgShopConstant.STATUS_SHOW){
						updateUserAddress4Send(orgUsersSession,address);
					}else{
						//店铺无效
						orgUsers.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
					}
				}else{
					//收货地址无效
					orgUsers.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
				}
			}else{
				//无默认收货地址
				orgUsers.setLastSendStyle(OrgUsersConstant.LAST_SEND_STYLE_TAKE);
			}
		}
		
		if(orgUsers.getLastSendStyle() == OrgUsersConstant.LAST_SEND_STYLE_TAKE){
			//自提
			if(orgUsers.getServiceId() != null && orgUsers.getServiceId() > 0){
				OrgShop shop = orgShopService.queryVoById(orgUsers.getServiceId().intValue());
				if(shop.getStatus() == OrgShopConstant.STATUS_SHOW){
					updateUserShop4Take(orgUsersSession,orgShopService.queryVoById(orgUsers.getServiceId().intValue()));
				}else{
					//改为默认店铺
					updateUserShop4Take(orgUsersSession,null);
				}
			}
		}
		updateLogin(orgUsersSession,orgUsers,ipAddress);
	}

	@Override
	public int updateStatus(Integer userId, Integer status) {
		OrgUsers orgUsers = new OrgUsers();
		orgUsers.setStatus(status);
		orgUsers.setUserId(userId);
		return updateByIdSelective(orgUsers);
	}

	@Override
	public void syncUserLevelToRuiXing() {
		
		Map<?, ?> basvipsMap = basvipService.queryMap(null, "mtel");
		
		List<OrgUsers> usersList = orgUsersDao.selectList(null);
		
		List<Basvip> addList = new ArrayList<Basvip>();
		
		List<Basvip> updateList = new ArrayList<Basvip>();
		
		Set<String> mobileSet = new HashSet<String>();
		
		for(OrgUsers user:usersList){
			if(null != user.getMobilePhone() && !"".equals(user.getMobilePhone())){
				if(basvipsMap.containsKey(user.getMobilePhone())){
					Basvip bv = (Basvip)basvipsMap.get(user.getMobilePhone());
					bv.setAddr(user.getAddresshome());
					// 生日
					if(user.getBirthday() != null){
						Date d = convertBirthday(user.getBirthday());
						if(null != d){
							bv.setBorn(d);
						}
						
					}
					bv.setEmail(user.getEmail());
					bv.setFlag(new BigDecimal(1));
					// 性别
					if(user.getSex().equals(1)){
						bv.setSex(new BigDecimal(0));
					}
					if(user.getSex().equals(2)){
						bv.setSex(new BigDecimal(1));
					}
					bv.setTel(user.getHomePhone());

					if(null != user.getUserName() && !"".equals(user.getUserName())){
						bv.setVipname(user.getUserName());
					}
					if(null != user.getLevelId()){
						bv.setType(new BigDecimal(Integer.parseInt(user.getLevelId())));
					}
					
					updateList.add(bv);
				} else if(!mobileSet.contains(user.getMobilePhone())){
					mobileSet.add(user.getMobilePhone());
					Basvip bv = new Basvip();
					
					bv.setMtel(user.getMobilePhone());
					bv.setAddr(user.getAddresshome());
					// 生日
					if(user.getBirthday() != null){
						Date d = convertBirthday(user.getBirthday());
						if(null != d){
							bv.setBorn(d);
						}
						
					}
					bv.setEmail(user.getEmail());
					bv.setFlag(new BigDecimal(1));
					// 性别
					if(user.getSex().equals(1)){
						bv.setSex(new BigDecimal(0));
					}
					if(user.getSex().equals(2)){
						bv.setSex(new BigDecimal(1));
					}
					bv.setTel(user.getHomePhone());

					if(null != user.getUserName() && !"".equals(user.getUserName())){
						bv.setVipname(user.getUserName());
					}
					
					if(null != user.getLevelId()){
						bv.setType(new BigDecimal(Integer.parseInt(user.getLevelId())));
					}
					
					addList.add(bv);
				}
			}
		}
		
		
		basvipService.addInBatch(addList);
		
		basvipService.updateInBatch(updateList);
	}

	/**
	 * 在通过userCode与瑞星同步数据时启用
	 */
//	public void syncUserLevelToRuiXing() {
//		
//		Map<?, ?> basvipsMap = basvipService.queryMap(null, "mtel");
//		
//		List<OrgUsers> usersList = orgUsersDao.selectList(null);
//		
//		List<Basvip> updateList = new ArrayList<Basvip>();
//		
//		for(OrgUsers user:usersList){
//			if(null != user.getMobilePhone() && !"".equals(user.getMobilePhone())){
//				if(basvipsMap.containsKey(user.getMobilePhone())){
//					Basvip bvv = (Basvip)basvipsMap.get(user.getMobilePhone());
//					Basvip bv = new Basvip();
//					
//					if(!user.getLevelId().equals(String.valueOf(bvv.getType()))){
//						//bv.setuserCode()
//						bv.setType(new BigDecimal(Integer.parseInt(user.getLevelId())));
//						updateList.add(bv);
//					}
//				} 
//			}
//		}
//		basvipService.updateInBatch(updateList);
//	}
	
	private static Date convertBirthday(String dateString){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(dateString);
		} catch(Exception e){
			return null;
		}
	}

	@Override
	public List<OrgUsersVo> queryEnterpriseUsers(Integer enterpriseId) {
		return orgUsersDao.queryEnterpriseUsers(enterpriseId);
	}

	@Override
	public List<OrgLocation> getListLocalHistory(String localHistory) {
		List<OrgLocation> listOrgLocation = new ArrayList<OrgLocation>();
		if(StringUtils.isNotBlank(localHistory)){
			String[] arrayLocalHistory = localHistory.split(",");
			OrgLocation orgLocation = null;
			String[] arrayLocal = null;
			for(String local : arrayLocalHistory){
				if(StringUtils.isBlank(local)){
					break;
				}
				arrayLocal = local.split("&");
				if(arrayLocal.length != 3){
					break;
				}
				orgLocation = new OrgLocation(Double.parseDouble(arrayLocal[0]),Double.parseDouble(arrayLocal[1]),arrayLocal[2]);
				listOrgLocation.add(orgLocation);
			}
		}
		return listOrgLocation;
	}

	@Override
	public OrgLocation getLastLocalHistory(String localHistory) {
		List<OrgLocation> listOrgLocation = getListLocalHistory(localHistory);
		return CollectionUtils.isEmpty(listOrgLocation) ? null : listOrgLocation.get(0);
	}

	@Override
	public void mergeTX() {
		Basvip bv = new Basvip();
		bv.setMtel("15566663333");
		bv.setVipname("3333");
		bv.setType(new BigDecimal(1));
		basvipService.add(bv);
		
		
		
		OrgUsers user = new OrgUsers();
		user.setUserId(51);
		user.setUserName("bbb");
		super.updateByIdSelective(user);
		//int i = 1/0;
	}

	@Override
	public List<OrgUsersVo> queryDiscountAndPoint(Integer userId) {
		return orgUsersDao.queryDiscountAndPoint(userId);
	}

	@Override
	public int updateOpenId4User(String openId) {
		return orgUsersDao.updateOpenId4User(openId);
	}
}