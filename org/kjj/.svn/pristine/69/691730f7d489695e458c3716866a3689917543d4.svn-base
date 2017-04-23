package com.kjj.commserver.service.special.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kjj.commserver.dao.special.OrgSpecialDao;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.special.OrgSpecial;
import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;
import com.kjj.commserver.entity.special.OrgSpecialLink;
import com.kjj.commserver.entity.special.OrgSpecialRule;
import com.kjj.commserver.entity.special.OrgSpecialTime;
import com.kjj.commserver.entity.special.OrgSpecialWeek;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorProductConstant;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorProductQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorProductVo;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorVo;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkConstant;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialRuleQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialTimeQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialVo;
import com.kjj.commserver.entity.special.aide.OrgSpecialWeekQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.special.OrgSpecialFloorProductService;
import com.kjj.commserver.service.special.OrgSpecialFloorService;
import com.kjj.commserver.service.special.OrgSpecialLinkService;
import com.kjj.commserver.service.special.OrgSpecialRuleService;
import com.kjj.commserver.service.special.OrgSpecialService;
import com.kjj.commserver.service.special.OrgSpecialTimeService;
import com.kjj.commserver.service.special.OrgSpecialWeekService;
import com.kjj.commserver.util.DateUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.exception.ServiceException;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSpecialServiceImpl extends BaseServiceImpl<OrgSpecial, Integer> implements OrgSpecialService {
    @Resource
    private OrgSpecialDao orgSpecialDao;

    @Resource
	private OrgSpecialTimeService orgSpecialTimeService;
    
    @Resource
    private OrgSpecialWeekService orgSpecialWeekService;
    
    @Resource
    private OrgSpecialRuleService orgSpecialRuleService;
	
	@Resource
	OrgSpecialLinkService orgSpecialLinkService;
	
	@Resource
	OrgSpecialFloorService orgSpecialFloorService;
	
	@Resource
	OrgSpecialFloorProductService orgSpecialFloorProductService;
	
	@Resource
	OrgProductItemService orgProductItemService;
    
    @Override
    protected BaseDao<OrgSpecial, Integer> getBaseDao() {
        return orgSpecialDao;
    }

	@Override
	public Integer save(OrgSpecialVo orgSpecialVo) {
		OrgSpecialTime orgSpecialTime=orgSpecialVo.getOrgSpecialTime();
		OrgSpecialRule orgSpecialRule = orgSpecialVo.getOrgSpecialRule();
		String weeks = orgSpecialVo.getWeeks();
		String[] weekArr=null;
		if(weeks!=null){
			weekArr=weeks.split(",");
		}
		OrgSpecialWeek orgSpecialWeek=null;
		Integer weekInt=null;
		if(orgSpecialVo.getSpecialId()==null){
			//新增专题表
			add(orgSpecialVo);
			Integer specialId = queryOne(orgSpecialVo).getSpecialId();
			//新增专题时刻表
			orgSpecialTime.setSpecialId(specialId);
			orgSpecialTimeService.add(orgSpecialTime);
			//新增活动规则
			orgSpecialRule.setSpecialId(specialId);
			orgSpecialRuleService.add(orgSpecialRule);
			//新增专题星期表
			if(weeks!=null){
				for (String week : weekArr) {
					orgSpecialWeek = new OrgSpecialWeek();
					orgSpecialWeek.setSpecialId(specialId);
					weekInt=Integer.parseInt(week);
					orgSpecialWeek.setWeekCode(weekInt.byteValue());
					orgSpecialWeekService.add(orgSpecialWeek);
				}
			}
			return specialId;
		}else{
			//更新专题表
			updateByIdSelective(orgSpecialVo);
			//更新专题时刻表
			orgSpecialTime.setSpecialId(orgSpecialVo.getSpecialId());
			orgSpecialTimeService.updateBySpecialId(orgSpecialTime);
			//更新活动规则
			orgSpecialRule.setSpecialId(orgSpecialVo.getSpecialId());
			orgSpecialRuleService.updateBySpecialId(orgSpecialRule);
			//更新专题星期表
			OrgSpecialWeekQuery orgSpecialWeekQuery = new OrgSpecialWeekQuery();
			orgSpecialWeekQuery.setSpecialId(orgSpecialVo.getSpecialId());
			orgSpecialWeekService.delete(orgSpecialWeekQuery);
			if(weeks!=null){
				for (String week : weekArr) {
					orgSpecialWeek = new OrgSpecialWeek();
					orgSpecialWeek.setSpecialId(orgSpecialVo.getSpecialId());
					weekInt=Integer.parseInt(week);
					orgSpecialWeek.setWeekCode(weekInt.byteValue());
					orgSpecialWeekService.add(orgSpecialWeek);
				}
			}
			return orgSpecialVo.getSpecialId();
		}
	}

	@Override
	public void show(Model model, OrgUsersSession orgUsersSession,
			Integer specialId) {
		OrgSpecial orgSpecial = new OrgSpecial();
		orgSpecial.setSpecialId(specialId);

		String startTimeStr = "2016/7/19 15:00:00";
		String endTimeStr = "2016/7/21 18:52:59";

		
		// 根据专题主键查询专题活动表
		OrgSpecialQuery specialQuery = new OrgSpecialQuery();
		specialQuery.setSpecialId(orgSpecial.getSpecialId());
		
		orgSpecial = queryOne(specialQuery);
		
		if(null == orgSpecial){
			throw new ServiceException();
		}
		
		model.addAttribute("special", orgSpecial);
		
		// 获取当前日期，判读是否在活动有效时间内
		Date now = new Date(); 
		Date startTime = orgSpecial.getStartTime();
		Date endTime = orgSpecial.getEndTime();
		
		
		OrgSpecialWeekQuery weekQuery = new OrgSpecialWeekQuery();
		weekQuery.setSpecialId(orgSpecial.getSpecialId());
		List<OrgSpecialWeek> weekList = orgSpecialWeekService.queryList(weekQuery);
		
		
		int dayWeek = Integer.valueOf(DateUtil.getWeek(now)); // 当前时间的工作日值
		
		if(weekList.size() < 1) {
			// 没有工作日
		} else {
			// 获取定义的时间段，按先后升序
			OrgSpecialTimeQuery timeQuery = new OrgSpecialTimeQuery();
			timeQuery.setSpecialId(orgSpecial.getSpecialId());
			Sort sort=new Sort(Direction.ASC,"t.time_start");
			
			// 保证按开始时间升序
			List<OrgSpecialTime> timeList = orgSpecialTimeService.queryList(timeQuery, sort);
			
			// 目前系统只允许定义一个时间段
			OrgSpecialTime ost = timeList.get(0);
			
			// 系统定义的开始时间,便于取数据
			Calendar calendarStartTime =Calendar.getInstance();   
			calendarStartTime.setTime(ost.getTimeStart());
			
			// 系统定义的结束时间,并预
			Calendar calendarEndTime =Calendar.getInstance();   
			calendarEndTime.setTime(ost.getTimeEnd());
			
			boolean isFound = false;
			// 遍历工作日，查找与当前日期一样的工作日
			for(OrgSpecialWeek osw : weekList) {
				if(String.valueOf(dayWeek).equals(Byte.toString(osw.getWeekCode()))){
					isFound = true;
					Calendar calendar=Calendar.getInstance();   
					calendar.setTime(now);
					calendar.set(Calendar.HOUR_OF_DAY, calendarStartTime.get(Calendar.HOUR_OF_DAY));
					calendar.set(Calendar.MINUTE, calendarStartTime.get(Calendar.MINUTE));
					calendar.set(Calendar.SECOND, calendarStartTime.get(Calendar.SECOND));
					
					startTime = calendar.getTime();
					
					calendar.set(Calendar.HOUR_OF_DAY, calendarEndTime.get(Calendar.HOUR_OF_DAY));
					calendar.set(Calendar.MINUTE, calendarEndTime.get(Calendar.MINUTE));
					calendar.set(Calendar.SECOND, calendarEndTime.get(Calendar.SECOND));
					
					endTime = calendar.getTime();
				}
			}
			
			// 没有找到与当前日期一样的工作日,再次遍历工作日，并加入时间时间段，组成完整日期与当前时间比较，找到与当前时间距离最新的时间段
			if(isFound == false){
				Date preStartTime = null; // 上一个开始时间
				Date preEndTime = null;   // 上一个结束时间
				Long preDistanceSecond = 0l; // 上一个间隔
				for(OrgSpecialWeek osw : weekList) {
					// 用工作日时间减去当前时间的工作日,用差值对当前日期进行操作（增减）生成新的时间,
					// 将新的时间的时分秒用定义的时分秒替换生成新的时间段（包括开始时间和结束时间），
					// 如果差值大于0，计算当前时间与开始时间的间隔毫秒数
					// 如果差值小于0，计算当前时间与结束时间的间隔毫秒数
				    // 用间隔毫秒数与上一个间隔毫秒数比较，取最小的毫秒数
					// 保存最新的开始时间、结束时间、间隔毫秒数
					
					int WeekDiffer = Integer.parseInt(Byte.toString(osw.getWeekCode())) - dayWeek;
					
					Calendar calendar=Calendar.getInstance();   
					calendar.setTime(now);
					// 通过当前日期生成工作日时间
					calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH) + WeekDiffer);
					calendar.set(Calendar.HOUR_OF_DAY, calendarStartTime.get(Calendar.HOUR_OF_DAY));
					calendar.set(Calendar.MINUTE, calendarStartTime.get(Calendar.MINUTE));
					calendar.set(Calendar.SECOND, calendarStartTime.get(Calendar.SECOND));
					
					// 新生成的开始时间
					Date newStartTime = calendar.getTime();
					
					calendar.set(Calendar.HOUR_OF_DAY, calendarEndTime.get(Calendar.HOUR_OF_DAY));
					calendar.set(Calendar.MINUTE, calendarEndTime.get(Calendar.MINUTE));
					calendar.set(Calendar.SECOND, calendarEndTime.get(Calendar.SECOND));
					
					// 新生成的结束时间
					Date newEndTime = calendar.getTime();
					
					// 新的间隔毫秒数
					Long newDistanceSecond = 0l;
					
					// 定义的工作日晚于当前工作日(时间没到)
					if(WeekDiffer > 0) {
						newDistanceSecond = newStartTime.getTime() - now.getTime();
					} else {
						// 定义的工作日早于当前工作日(时间已过)
						newDistanceSecond = now.getTime() - newEndTime.getTime();
					}
					
					if(preDistanceSecond == 0 || newDistanceSecond < preDistanceSecond){
						preStartTime = newStartTime;
						preEndTime = newEndTime;
						preDistanceSecond = newDistanceSecond;
					} 
				}
				startTime = preStartTime;
				endTime = preEndTime;
			}
			
		}
		SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		startTimeStr = df.format(startTime);
		endTimeStr = df.format(endTime);
		
		
		model.addAttribute("startTime", startTimeStr);
		model.addAttribute("endTime", endTimeStr);
		
		// 根据专题主键查询专题活动规则表
		OrgSpecialRuleQuery ruleQuery = new OrgSpecialRuleQuery();
		ruleQuery.setSpecialId(orgSpecial.getSpecialId());
		List<OrgSpecialRule> ruleList = orgSpecialRuleService.queryList(ruleQuery);
		if(ruleList.size() > 0){
			model.addAttribute("rule", ruleList.get(0));
		}
		
		// 根据专题主键查询专题活动链接表(包括锚点)
		// 首先取出所有锚点
		OrgSpecialLinkQuery linkQuery = new OrgSpecialLinkQuery();
		linkQuery.setSpecialId(orgSpecial.getSpecialId());
		linkQuery.setType(OrgSpecialLinkConstant.LINK_TYPE_ANCHOR);
		Sort sort=new Sort(Direction.ASC,"t.image_order");
		List<OrgSpecialLink> anchorList = orgSpecialLinkService.queryList(linkQuery, sort);
		model.addAttribute("anchorList", anchorList);
		
		// 其次取出所有图片链接商品链接
		linkQuery.setType(null); // 清空类型
		linkQuery.setNoAnchor(true); // 非锚点,图片链接和商品链接
		List<OrgSpecialLink> picuteList = orgSpecialLinkService.queryList(linkQuery, sort);
		model.addAttribute("linkList", picuteList);
		
		
		// 根据专题主键查询楼层表
		OrgSpecialFloorQuery floorQuery = new OrgSpecialFloorQuery();
		floorQuery.setSpecialId(orgSpecial.getSpecialId());
		Sort floorSort=new Sort(Direction.ASC,"t.floor_order");
		List<OrgSpecialFloorVo> floorList = orgSpecialFloorService.queryList(floorQuery, floorSort);
		
		// 查询出楼层下的商品和活动
		for(OrgSpecialFloorVo osf : floorList) {
			// 取出所有非下架、非删除的商品和活动
			OrgSpecialFloorProductQuery floorProductQuery = new OrgSpecialFloorProductQuery();
			floorProductQuery.setFloorId(osf.getFloorId());
			floorProductQuery.setType(OrgSpecialFloorProductConstant.FLOOR_PRODUCT_TYPE_PRODUCT);
			floorProductQuery.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON); // 非下架
			floorProductQuery.setIsDelete(OrgProductConstant.IS_NOT_DELETE); // 非删除
			
			List<OrgSpecialFloorProduct> allProduct = new ArrayList<OrgSpecialFloorProduct>(); // 所有商品和活动
			
			// 所有商品
			List<OrgSpecialFloorProductVo> floorProductList = orgSpecialFloorProductService.queryList(floorProductQuery);
			
			for(OrgSpecialFloorProductVo osfp : floorProductList) {
				if(osfp.getType().equals(OrgSpecialFloorProductConstant.FLOOR_PRODUCT_TYPE_PRODUCT)) {
					OrgProductItemAll orgProductItemAll = orgProductItemService.query4View(orgUsersSession,osfp.getGoodsId());
					
					osfp.setOrgProductItemAll(orgProductItemAll);
				}
			}
			
			allProduct.addAll(floorProductList);
			
			// 活动
			floorProductQuery = new OrgSpecialFloorProductQuery();
			floorProductQuery.setFloorId(osf.getFloorId());
			floorProductQuery.setType(OrgSpecialFloorProductConstant.FLOOR_PRODUCT_TYPE_ACIVITY);
			List<OrgSpecialFloorProduct> floorActivityList = orgSpecialFloorProductService.queryList(floorProductQuery);
			
			allProduct.addAll(floorActivityList);
			
			osf.setProductList(allProduct);
		}
		model.addAttribute("floorList", floorList);
		
	}
}