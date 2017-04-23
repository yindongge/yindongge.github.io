package com.kjj.commserver.service.discount.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kjj.commserver.dao.discount.OrgReachConditionDao;
import com.kjj.commserver.entity.discount.OrgReachCondition;
import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.commserver.entity.discount.aide.OrgReachConditionQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachCouponQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachDiscountQuery;
import com.kjj.commserver.entity.discount.aide.OrgReachGiveQuery;
import com.kjj.commserver.service.discount.OrgReachConditionService;
import com.kjj.commserver.service.discount.OrgReachCouponService;
import com.kjj.commserver.service.discount.OrgReachDiscountService;
import com.kjj.commserver.service.discount.OrgReachGiveService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.exception.ServiceException;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgReachConditionServiceImpl extends BaseServiceImpl<OrgReachCondition, Integer> implements OrgReachConditionService {
    @Resource
    private OrgReachConditionDao orgReachConditionDao;
    
    @Resource
    private OrgReachDiscountService orgReachDiscountService;
    
    @Resource
    private OrgReachCouponService orgReachCouponService;
    
    @Resource
    private OrgReachGiveService orgReachGiveService;
    
    
    
    @Override
    protected BaseDao<OrgReachCondition, Integer> getBaseDao() {
        return orgReachConditionDao;
    }

	@Override
	public List<OrgReachCondition> queryByReachId(Integer reachId) {
		OrgReachConditionQuery query = new OrgReachConditionQuery();
		query.setReachId(reachId);
		Sort sort = new Sort(Direction.DESC,"t.reach_condition");
		return queryList(query,sort);
	}
	
	@Override
	public Integer updateSet(String jsonStr) {
		//解析json
		Map<String,Object> data=JSON.parseObject(jsonStr, new TypeReference<Map<String,Object>>(){});  
		Integer newConditionId=0; 
		try {
			int id =  Integer.parseInt((String) data.get("id"));
			newConditionId=id;
			int reachId =  Integer.parseInt((String) data.get("reachId"));
			BigDecimal reachCondition = NumberUtils.createBigDecimal((String) data.get("reachCondition"));
			
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> discountList = (List<Map<String, Object>>) data.get("discountArr");
			OrgReachConditionQuery query = new OrgReachConditionQuery();
			query.setReachId(reachId);
			query.setReachCondition(reachCondition);
			//新增一级优惠
			if(id==0){
				//保存condition
				add(query);
				newConditionId = queryOne(query).getId();
				//保存discount
				saveDiscount(discountList, query,id);
				
			}else{
				//更新一级优惠
				OrgReachCondition UpdateEntity=new OrgReachCondition();
				UpdateEntity.setId(id);
				UpdateEntity.setReachCondition(reachCondition);
				updateByIdSelective(UpdateEntity);
				//处理优惠表的数据
				saveDiscount(discountList, query,id);
			}
			
		} catch (Exception e) {
			throw new ServiceException(e.getCause());
//			e.printStackTrace();
		}
		return  newConditionId;
	}

	private void saveDiscount(List<Map<String, Object>> discountList, OrgReachConditionQuery query,int id) {
		OrgReachDiscount reachDiscountQuery=new OrgReachDiscount();
		reachDiscountQuery.setRcId(id);
		
		List<OrgReachDiscount> oldReachDiscountList = orgReachDiscountService.queryList(reachDiscountQuery);
		Set<Byte> oldTypeIds=new HashSet<Byte>();
		Map<Byte, OrgReachDiscount> oldDiscountMap=new HashMap<Byte, OrgReachDiscount>();
		for (OrgReachDiscount oldReachDiscount : oldReachDiscountList) {
			oldTypeIds.add(oldReachDiscount.getTypeId());
			oldDiscountMap.put(oldReachDiscount.getTypeId(), oldReachDiscount);
		}
		
		List<OrgReachDiscount> reachDiscountList = new ArrayList<OrgReachDiscount>();
		Set<Byte> newTypeIds =new HashSet<Byte>();
		Map<Byte, Map<String, Object>> newDiscountMap=new HashMap<Byte, Map<String, Object>>();
		for (Map<String, Object> map : discountList) {
			newTypeIds.add(((Integer) map.get("typeId")).byteValue());
			newDiscountMap.put(((Integer) map.get("typeId")).byteValue(), map);
		}
		
		Byte itrator=0;
		OrgReachDiscount reachDiscount=null;
		for (int i=0;i<3;i++) {
			itrator++;
			//新勾选的类型组包含此类型
			if(newTypeIds.contains(itrator)){
				Map<String, Object> map = newDiscountMap.get(itrator);
				//原勾选的类型组包含此类型
				if(oldTypeIds.contains(itrator)){
					reachDiscount = oldDiscountMap.get(itrator);
					reachDiscount.setRcId(queryOne(query).getId());
					reachDiscount.setTypeId(((Integer) map.get("typeId")).byteValue());
					reachDiscount.setIsloop(((Number) map.get("isloop")).byteValue());
					reachDiscount.setCommon(NumberUtils.createBigDecimal((String) map.get("common")));
					orgReachDiscountService.updateById(reachDiscount);
				}else{
					//原勾选的类型组不包含此类型
					reachDiscount = new OrgReachDiscount();
					reachDiscount.setRcId(queryOne(query).getId());
					reachDiscount.setTypeId(((Integer) map.get("typeId")).byteValue());
					reachDiscount.setIsloop(((Number) map.get("isloop")).byteValue());
					reachDiscount.setCommon(NumberUtils.createBigDecimal((String) map.get("common")));
					reachDiscountList.add(reachDiscount);
				}
			}else{
				//新勾选的类型组不包含此类型，原勾选的类型组包含此类型
				if(oldTypeIds.contains(itrator)){
					//删除
					reachDiscount = new OrgReachDiscount();
					reachDiscount.setRcId(queryOne(query).getId());
					reachDiscount.setTypeId(itrator);
					//删除copon(赠送的优惠券)
					OrgReachCouponQuery orgReachCouponQuery = new OrgReachCouponQuery();
					orgReachCouponQuery.setRdId(orgReachDiscountService.queryOne(reachDiscount).getId());
					orgReachCouponService.delete(orgReachCouponQuery);
					//删除give(赠送的商品)
					OrgReachGiveQuery orgReachGiveQuery = new OrgReachGiveQuery();
					orgReachGiveQuery.setRdId(orgReachDiscountService.queryOne(reachDiscount).getId());
					orgReachGiveService.delete(orgReachGiveQuery);
					//删除discout(优惠表)
					orgReachDiscountService.delete(reachDiscount);
				}
			}
		}
		orgReachDiscountService.addInBatch(reachDiscountList);
	}

	@Override
	public void deleteSet(Integer conditionId) {
		if(conditionId!=null){
			
			OrgReachDiscountQuery orgReachDiscountQuery=new OrgReachDiscountQuery();
			orgReachDiscountQuery.setRcId(conditionId);
			List<OrgReachDiscount> OrgReachDiscountList = orgReachDiscountService.queryList(orgReachDiscountQuery);
			List<Integer> OrgReachDiscountIdList=new ArrayList<Integer>();
			for (OrgReachDiscount orgReachDiscount : OrgReachDiscountList) {
				OrgReachDiscountIdList.add(orgReachDiscount.getId());
			}
			OrgReachCouponQuery orgReachCouponQuery =new OrgReachCouponQuery();
			orgReachCouponQuery.setRdIds(OrgReachDiscountIdList);
			orgReachCouponService.delete(orgReachCouponQuery);
			
			OrgReachGiveQuery orgReachGiveQuery =new OrgReachGiveQuery();
			orgReachGiveQuery.setRdIds(OrgReachDiscountIdList);
			orgReachGiveService.delete(orgReachGiveQuery);
			
			orgReachDiscountService.delete(orgReachDiscountQuery);
			deleteById(conditionId);
			
			
		}
	}
	
}