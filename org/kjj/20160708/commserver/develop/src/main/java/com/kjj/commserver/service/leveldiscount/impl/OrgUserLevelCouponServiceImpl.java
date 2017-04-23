package com.kjj.commserver.service.leveldiscount.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.leveldiscount.OrgUserLevelCouponDao;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCoupon;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelCouponDiscount;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponConstant;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponDiscountQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelCouponVo;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponDiscountService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelCouponService;
import com.kjj.commserver.service.leveldiscount.OrgUserLevelProductService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgUserLevelCouponServiceImpl extends BaseServiceImpl<OrgUserLevelCoupon, Integer> implements OrgUserLevelCouponService {
    @Resource
    private OrgUserLevelCouponDao orgUserLevelCouponDao;
    
    @Resource
    private OrgUserLevelCouponDiscountService orgUserLevelCouponDiscountService;
    
    @Resource
	private OrgProductItemService orgProductItemService;
    
    @Resource
    private OrgUserLevelService orgUserLevelService;
    
    @Resource
    private OrgAreaService orgAreaService;
    
    @Resource
	private OrgShopService orgShopService;
    
    @Resource
    private OrgClassService orgClassService;
    
    @Resource
    private OrgUserLevelProductService orgUserLevelProductService;
    
    private static Map<String,String> citysMap = null;
    
    private static Map<String,String> shopsMap = null;

    @Override
    protected BaseDao<OrgUserLevelCoupon, Integer> getBaseDao() {
        return orgUserLevelCouponDao;
    }


	@Override
	public Page<OrgUserLevelCouponVo> selectLevelCoupon(OrgUserLevelCouponQuery query,
			Pageable pageable) {
		Page<OrgUserLevelCouponVo> page = orgUserLevelCouponDao.selectLevelCoupon(query, pageable);
		addCouponDiscount(page.getContent());
		addCityName(page.getContent());
		addShopName(page.getContent());
		return page;
	}
	

	/**
	 * 将会员级别对应的折扣加入集合
	 * @param couponList
	 */
	private void addCouponDiscount(List<OrgUserLevelCouponVo> couponList){
		List<OrgUserLevelCouponDiscount> discountList = null;
		List<OrgUserLevelCouponDiscount>  alldiscountList = orgUserLevelCouponDiscountService.queryList(new OrgUserLevelCouponDiscount());
		
		List<OrgUserLevel> levelList = orgUserLevelService.queryList(null);
		
		if(CollectionUtils.isNotEmpty(couponList)){
			for(OrgUserLevelCouponVo couponItem : couponList){
				discountList = new ArrayList<OrgUserLevelCouponDiscount>();
				
				
				for(OrgUserLevel level : levelList){
					boolean levelExist = false; // 级别是否设置
					for(OrgUserLevelCouponDiscount discountItem : alldiscountList){
						if(level.getLevelId().equals(String.valueOf(discountItem.getLevelId())) && String.valueOf(couponItem.getLevelCouponId()).equals(String.valueOf(discountItem.getLevelCouponId()))){
							discountList.add(discountItem);
							levelExist = true;
							break;
						}
					}
					// 如果折扣表没有，这个级别一定是新建的，提示用户未设置
					if(levelExist == false){
						OrgUserLevelCouponDiscount disc = new OrgUserLevelCouponDiscount();
						disc.setId(0);
						discountList.add(disc);
					}
				}
				couponItem.setDiscountList(discountList);
			}
		}
	}
	
	private void addShopName(List<OrgUserLevelCouponVo> couponList){
		if(shopsMap == null) {
			shopsMap = new HashMap<String, String>();
			List<OrgShop> shopList = orgShopService.queryListAll();
			for(OrgShop shop : shopList){
				shopsMap.put(String.valueOf(shop.getShopCode()), shop.getShopName());
			}
		}
		for(OrgUserLevelCouponVo couponItem : couponList){
			StringBuffer shopName = new StringBuffer();
			String cityShopIdStr = String.valueOf(couponItem.getCityShopId());
			
			if(null != cityShopIdStr && cityShopIdStr.trim().length() > 0){
				String[]  cityShopIds = cityShopIdStr.split(",");
				for(String code : cityShopIds){
					if(null != code && shopsMap.containsKey(code)){
						shopName.append("&nbsp;").append(shopsMap.get(code)).append("&nbsp;|");
					}
				}
				if(shopName.indexOf("|") != -1){
					shopName.deleteCharAt(shopName.length()-1);
				}
				couponItem.setShopName(shopName.toString());
			}
		}
	}
	

	private void addCityName(List<OrgUserLevelCouponVo> couponList){
		if(citysMap == null) {
			citysMap = new HashMap<String, String>();
			List<OrgArea> areaList = orgAreaService.queryList(null);
			for(OrgArea area : areaList){
				citysMap.put(area.getCode(), area.getName());
			}
		}
		for(OrgUserLevelCouponVo couponItem : couponList){
			if(null != couponItem.getCityCode() && citysMap.containsKey(String.valueOf(couponItem.getCityCode()))){
				couponItem.setCityName(citysMap.get(String.valueOf(couponItem.getCityCode())));
			}
		}
	}

	@Override
	public void updateActive(Integer couponId) {
		OrgUserLevelCoupon coupon = new OrgUserLevelCoupon();
		coupon.setLevelCouponId(couponId);
		coupon.setStatus(OrgUserLevelCouponConstant.STATUS_VALID);
		orgUserLevelCouponDao.updateByIdSelective(coupon);
	}

	@Override
	public void updateNoActive(Integer couponId) {
		OrgUserLevelCoupon coupon = new OrgUserLevelCoupon();
		coupon.setLevelCouponId(couponId);
		coupon.setStatus(OrgUserLevelCouponConstant.STATUS_INVALID);
		orgUserLevelCouponDao.updateByIdSelective(coupon);
	}

	@Override
	public void deleteByCouponId(Integer couponId) {
		orgUserLevelCouponDao.deleteById(couponId); // 删除电商会员价格
		orgUserLevelCouponDiscountService.deleteByLevelCouponId(couponId); // 删除折扣对应表
	}

	@Override
	public void addLevelCoupon(OrgUserLevelCoupon coupon, String discountStr,
			OrgAdminUserSession admin) {
		coupon.setCreateAdminId(admin.getOrgAdminUser().getUserId());
		coupon.setCreateTime(new Date());
		
		if(coupon.getLevelCouponId() != null && !coupon.getLevelCouponId().equals("")){
			orgUserLevelCouponDao.updateById(coupon);
			
			OrgUserLevelCouponDiscountQuery query = new OrgUserLevelCouponDiscountQuery();
			query.setLevelCouponId(coupon.getLevelCouponId());
			orgUserLevelCouponDiscountService.delete(query);
		} else {
			orgUserLevelCouponDao.insert(coupon);
		}
		
		
		
		discountStr = discountStr.substring(0, discountStr.length()-1);
		String [] discountArray = discountStr.split(",");
		
		Integer couponId = coupon.getLevelCouponId();
		for(String disc : discountArray){
			String[] couponDisc = disc.split("-");
			OrgUserLevelCouponDiscount oulcd = new OrgUserLevelCouponDiscount();
			oulcd.setLevelCouponId(couponId);
			oulcd.setLevelId(Integer.parseInt(couponDisc[0]));
			if("1".equals(couponDisc[1])){
				oulcd.setDiscount(new BigDecimal(couponDisc[2]));
			} else if("2".equals(couponDisc[1])){
				oulcd.setPrice(new BigDecimal(couponDisc[2]));
			}
			orgUserLevelCouponDiscountService.add(oulcd);
		}
	}

	@Override
	public String convertShopName(String shopIds) {
		String [] shopIdArray = shopIds.split(",");
		StringBuffer shopName = new StringBuffer();
		for(String id:shopIdArray){
			if(null != id && shopsMap.containsKey(id)){
				shopName.append(shopsMap.get(id)).append(",");
			}
		}
		if(shopName.indexOf(",") != -1){
			shopName.deleteCharAt(shopName.length()-1);
		}
		return shopName.toString();
	}
	
	
	public void  queryMap4ViewTest(){
		Map<Integer, OrgUserLevelCouponDiscount> discountMap = new HashMap<Integer, OrgUserLevelCouponDiscount>(); // 返回的对象
		String currentShopCode = "008"; // 永安里店
		String currentShopCityCode = "110100"; // 区域-北京
		String userLevelId = "18";// 普通会员  24 高级VIP会员
		
		List<Integer> goodsIds = new ArrayList<Integer>();
		goodsIds.add(new Integer(139)); // 拉瓦萨咖啡豆250G金牌 
		
				
		List<OrgClass> orgClassList = null;// 商品分类
		
		OrgUserLevelCoupon queryC = new OrgUserLevelCoupon();
		queryC.setStatus(Byte.valueOf("1"));//有效的优惠
		List<OrgUserLevelCoupon> couponList = orgUserLevelCouponDao.selectCalList(queryC);// 返回的结果集一定是按商品降序，类别降序的(必须，否则取值不对)
		
		for(Integer goodsId : goodsIds){
			
			OrgUserLevelCouponDiscount discount = null;
			
			OrgUserLevelCoupon Selectcoupon = null; // 选择的优惠
			
			OrgProductItem product = orgProductItemService.queryById(goodsId);
			
			for(OrgUserLevelCoupon coupon : couponList){
				// 查找当前门店的商品的优惠信息
				if(null != coupon.getCityShopId() && !"".equals(coupon.getCityShopId()) && null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找当前门店的商品的分类优惠信息(当前类别是二级分类)
				if(orgClassList == null){
					orgClassList = orgClassService.queryListAcvtive();
				}
				List<String> productClassList = new ArrayList<String>();//当前商品的分类及父类
				getCurProductClass(String.valueOf(product.getCatId()),orgClassList, productClassList);
				
				for(String ci : productClassList){
					if(null != coupon.getCityShopId() && !"".equals(coupon.getCityShopId()) && null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
						if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				
				// 查找当前门店的“所有商品”的优惠信息
				if(null != coupon.getCityShopId() && !"".equals(coupon.getCityShopId())){
					if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && String.valueOf(coupon.getProductType()).equals("1")){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找当前门店所在区域的商品的优惠信息
				if(null != coupon.getCityCode() && !"".equals(coupon.getCityCode())  && null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(currentShopCityCode.equals(coupon.getCityCode()) && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找当前门店所在区域的商品的分类优惠信息(当前类别是二级分类)
				for(String ci : productClassList){
					if(null != coupon.getCityCode() && !"".equals(coupon.getCityCode()) && null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
						if(currentShopCityCode.equals(coupon.getCityCode()) && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				
				// 查找当前门店所在区域的“所有商品”的优惠信息
				if(null != coupon.getCityCode() && !"".equals(coupon.getCityCode())){
					if(currentShopCityCode.equals(coupon.getCityCode()) && String.valueOf(coupon.getProductType()).equals("1")){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找所有区域的商品的优惠信息
				if( null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(coupon.getShopType().toString().equals("1")  && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找所有区域的商品的分类优惠信息(当前类别是二级分类)
				if(null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
					for(String ci : productClassList){
						if(coupon.getShopType().toString().equals("1") && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				// 查找所有区域的“所有商品”的优惠信息
				
				if(coupon.getShopType().toString().equals("1") && coupon.getProductType().toString().equals("1")){
					Selectcoupon = coupon;
					break;
				}
				
			}
			if(Selectcoupon == null){
				// 查找该商品对应的有效的一体化价格信息
				OrgUserLevelProduct query = new OrgUserLevelProduct();
				query.setGoodsId(goodsId);
				List<OrgUserLevelProduct> ll = orgUserLevelProductService.queryList(query);
				
				if(ll != null && ll.size() > 0) {
					OrgUserLevel query1 = new OrgUserLevel();
					query1.setLevelId(userLevelId);
					List<OrgUserLevel> levelList = orgUserLevelService.queryList(query1);
					
					OrgUserLevel cul = levelList.get(0);
					
					discount = new OrgUserLevelCouponDiscount();
					
					discount.setDiscount(cul.getDiscount());
					
					System.out.println("****************************************************");
					System.out.println("*                                                  *");
					if(discount.getDiscount() != null) {
						System.out.println("*    根据算法，得出的折扣为:" + discount.getDiscount() + "                         *");
					}
					if(discount.getPrice() != null) {
						System.out.println("* 根据算法，得出的价格为:" + discount.getPrice()  + "                              *");
					}
					System.out.println("****************************************************");
					System.out.println("****************************************************");
					
				}
			} else {
				OrgUserLevelCouponDiscount query3 = new OrgUserLevelCouponDiscount();
				query3.setLevelCouponId(Selectcoupon.getLevelCouponId());
				query3.setLevelId(Integer.parseInt(userLevelId));
				
				List<OrgUserLevelCouponDiscount> dList = orgUserLevelCouponDiscountService.queryList(query3);
				
				discount = dList.get(0);
				System.out.println("****************************************************");
				System.out.println("*                                                  *");
				if(discount.getDiscount() != null) {
					System.out.println("*    根据算法，得出的折扣为:" + discount.getDiscount() + "                         *");
				}
				if(discount.getPrice() != null) {
					System.out.println("*    根据算法，得出的价格为:" + discount.getPrice()  + "                              *");
				}
				System.out.println("****************************************************");
				System.out.println("****************************************************");
				
			}
			
			discountMap.put(goodsId, discount);
		}
	}

	@Override
	public Map<Integer, OrgUserLevelCouponDiscount> queryMap4View(
			OrgUsersSession orgUsersSession, Collection<Integer> goodsIds,
			Map<Integer, OrgProductItemAide> mapItemAide) {
		Map<Integer, OrgUserLevelCouponDiscount> discountMap = new HashMap<Integer, OrgUserLevelCouponDiscount>(); // 返回的对象
		
		// 如果是游客时
		if(orgUsersSession.getOrgUsers() == null){
			for(Integer goodsId : goodsIds){
				discountMap.put(goodsId, null);
			}
			return discountMap;
		}
		String currentShopCode = orgUsersSession.getOrgShop().getShopCode(); // 当前店铺
		String currentShopCityCode = orgUsersSession.getOrgShop().getAreaCode().substring(0,4) + "00"; // 当前店铺所在区域
		String userLevelId = orgUsersSession.getOrgUsers().getLevelId();// 用户会员级别
		
		
		// 用户没有分配等级时，返回空对象
		if(StringUtils.isBlank(userLevelId) || StringUtils.isBlank(currentShopCityCode) || StringUtils.isBlank(userLevelId)){
			for(Integer goodsId : goodsIds){
				discountMap.put(goodsId, null);
			}
			return discountMap;
		}
		
		
		List<OrgClass> orgClassList = null;// 商品分类
		
		OrgUserLevelCoupon queryC = new OrgUserLevelCoupon();
		queryC.setStatus(Byte.valueOf("1"));//有效的优惠
		List<OrgUserLevelCoupon> couponList = orgUserLevelCouponDao.selectCalList(queryC);// 返回的结果集一定是按商品降序，类别降序的(必须，否则取值不对)
		
		for(Integer goodsId : goodsIds){
			OrgUserLevelCouponDiscount discount = null;
			OrgUserLevelCoupon Selectcoupon = null; // 选择的优惠
			
			OrgProductItem product = orgProductItemService.queryById(goodsId);
			
			for(OrgUserLevelCoupon coupon : couponList){
				// 查找当前门店的商品的优惠信息
				if(!StringUtils.isBlank(coupon.getCityShopId()) && null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
						
					}
				}
				
				// 查找当前门店的商品的分类优惠信息(当前类别是二级分类)
				if(orgClassList == null){
					orgClassList = orgClassService.queryListAcvtive();
				}
				List<String> productClassList = new ArrayList<String>();//当前商品的分类及父类
				getCurProductClass(String.valueOf(product.getCatId()),orgClassList, productClassList);
				
				for(String ci : productClassList){
					if(!StringUtils.isBlank(coupon.getCityShopId()) && null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
						if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				
				// 查找当前门店的“所有商品”的优惠信息
				if(!StringUtils.isBlank(coupon.getCityShopId())){
					if(coupon.getCityShopId().indexOf(currentShopCode) != -1 && String.valueOf(coupon.getProductType()).equals("1")){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找当前门店所在区域的商品的优惠信息
				if(!StringUtils.isBlank(coupon.getCityCode())  && null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(currentShopCityCode.equals(coupon.getCityCode()) && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找当前门店所在区域的商品的分类优惠信息(当前类别是二级分类)
				for(String ci : productClassList){
					if(!StringUtils.isBlank(coupon.getCityCode()) && null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
						if(currentShopCityCode.equals(coupon.getCityCode()) && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				
				// 查找当前门店所在区域的“所有商品”的优惠信息
				if(!StringUtils.isBlank(coupon.getCityCode())){
					if(currentShopCityCode.equals(coupon.getCityCode()) && String.valueOf(coupon.getProductType()).equals("1")){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找所有区域的商品的优惠信息
				if( null != coupon.getGoodsId() && !"".equals(String.valueOf(coupon.getGoodsId()))){
					if(coupon.getShopType().toString().equals("1")  && coupon.getGoodsId().equals(goodsId)){
						Selectcoupon = coupon;
						break;
					}
				}
				
				// 查找所有区域的商品的分类优惠信息(当前类别是二级分类)
				if(null != coupon.getClassId() && !"".equals(String.valueOf(coupon.getClassId()))){
					for(String ci : productClassList){
						if(coupon.getShopType().toString().equals("1") && coupon.getClassId().toString().equals(ci)){
							Selectcoupon = coupon;
							break;
						}
					}
				}
				
				if(Selectcoupon != null){
					break;
				}
				// 查找所有区域的“所有商品”的优惠信息
				
				if(coupon.getShopType().toString().equals("1") && coupon.getProductType().toString().equals("1")){
					Selectcoupon = coupon;
					break;
				}
				
			}
			if(Selectcoupon == null){
				// 查找该商品对应的有效的一体化价格信息
				OrgUserLevelProduct query = new OrgUserLevelProduct();
				query.setGoodsId(goodsId);
				List<OrgUserLevelProduct> ll = orgUserLevelProductService.queryList(query);
				
				if(ll != null && ll.size() > 0) {
					OrgUserLevel query1 = new OrgUserLevel();
					query1.setLevelId(userLevelId);
					List<OrgUserLevel> levelList = orgUserLevelService.queryList(query1);
					
					OrgUserLevel cul = levelList.get(0);
					
					discount = new OrgUserLevelCouponDiscount();
					
					discount.setDiscount(cul.getDiscount());
				}
			} else {
				OrgUserLevelCouponDiscount query3 = new OrgUserLevelCouponDiscount();
				query3.setLevelCouponId(Selectcoupon.getLevelCouponId());
				query3.setLevelId(Integer.parseInt(userLevelId));
				
				List<OrgUserLevelCouponDiscount> dList = orgUserLevelCouponDiscountService.queryList(query3);
				
				if(dList.size() > 0){
					discount = dList.get(0);
				}
				
				
			}
			// 如果有会员价格或一体化价格，就改变商品的实际价格
			OrgProductItemAide aide = mapItemAide.get(goodsId);

			BigDecimal calPrice = new BigDecimal(0.00);
			if(discount != null && aide.getSourcePrice() != null){
				
				if(null != discount.getDiscount()){
					calPrice = discount.getDiscount().multiply(aide.getSourcePrice()).divide(BigDecimal.valueOf(100),2,BigDecimal.ROUND_HALF_UP);
				} else if(null != discount.getPrice()){
					calPrice = discount.getPrice();
				}
				if(calPrice.compareTo(aide.getRealPrice()) == 1){
					aide.setUserLevelPrice(new BigDecimal(0.00));
					aide.setMarkUserLevelDiscount(false);
				} else {
					aide.setUserLevelPrice(calPrice);
					aide.setRealPrice(calPrice);
					aide.setMarkUserLevelDiscount(true);
				}
				mapItemAide.put(goodsId, aide);
			}
			
			discountMap.put(goodsId, discount);
		}
		return discountMap;
	}
	
	private void getCurProductClass(String catId, List<OrgClass> orgClassList, List<String> productClass){
		for(OrgClass oc : orgClassList){
			if(catId.equals(String.valueOf(oc.getClassId()))){
				productClass.add(String.valueOf(oc.getClassId()));
				getCurProductClass(String.valueOf(oc.getClassParent()),orgClassList,productClass);
			}
		}
	}
	
}