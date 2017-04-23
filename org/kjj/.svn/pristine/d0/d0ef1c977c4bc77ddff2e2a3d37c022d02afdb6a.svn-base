package com.kjj.commserver.service.user.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgUserLevelDao;
import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;
import com.kjj.ruixing.entity.user.Basviptyp;
import com.kjj.ruixing.service.user.BasviptypService;

@Service
public class OrgUserLevelServiceImpl extends BaseServiceImpl<OrgUserLevel, String> implements OrgUserLevelService {
    @Resource
    private OrgUserLevelDao orgUserLevelDao;
    
    @Resource
	private BasviptypService basviptypServivce;

    @Override
    protected BaseDao<OrgUserLevel, String> getBaseDao() {
        return orgUserLevelDao;
    }

	@Override
	public String updateLevelBySync() {
		String resultStr = "200";
		List<Basviptyp> viptypes =  basviptypServivce.queryList(new Basviptyp());
		
		if(null == viptypes || viptypes.size() == 0) {
			resultStr = "501";
			return resultStr;
		}
		
		List<OrgUserLevel> userLevels = orgUserLevelDao.selectList(new OrgUserLevel());
		
		Map<String,Basviptyp> vipTypeMap = new HashMap<String,Basviptyp>();
		Map<String,OrgUserLevel> userLevelMap = new HashMap<String,OrgUserLevel>();
		
		for(Basviptyp bvt : viptypes) {
			vipTypeMap.put(bvt.getRuid().toString(), bvt);
		}
		
		for(OrgUserLevel oul : userLevels) {
			userLevelMap.put(oul.getLevelId(), oul);
		}
		
		Set<OrgUserLevel> addUserLevelSet = new HashSet<OrgUserLevel>();
		Set<OrgUserLevel> modifyUserLevelSet = new HashSet<OrgUserLevel>();
		//Set<String> deluserLevel = new HashSet<String>();
		
		for(Basviptyp bvt : viptypes) {
			OrgUserLevel userLevel = new OrgUserLevel();
			
			if(userLevelMap.containsKey(bvt.getRuid().toString())){
				// 更新
				userLevel = userLevelMap.get(bvt.getRuid().toString());
				userLevel.setLevelName(bvt.getTypname());

				userLevel.setIsIntegral((byte)bvt.getTypflag().intValue());
				userLevel.setIsDiscount((byte)bvt.getIsdiscnt().intValue());
				userLevel.setIntegral(new BigDecimal(0));
				userLevel.setDiscount(new BigDecimal(bvt.getDiscnt()));
				
				modifyUserLevelSet.add(userLevel);
			} else {
				// 添加
				userLevel.setLevelId(bvt.getRuid().toString());
				userLevel.setLevelName(bvt.getTypname());

				userLevel.setIsIntegral((byte)bvt.getTypflag().intValue());
				userLevel.setIsDiscount((byte)bvt.getIsdiscnt().intValue());
				userLevel.setIntegral(new BigDecimal(0));
				userLevel.setDiscount(new BigDecimal(bvt.getDiscnt()));
				addUserLevelSet.add(userLevel);
			}
			
			
		}
		if(addUserLevelSet.size() > 0) {
			orgUserLevelDao.insertInBatch(addUserLevelSet);
		}
		
		if(modifyUserLevelSet.size() > 0) {
			orgUserLevelDao.updateInBatch(modifyUserLevelSet);
		}
		
		// 在瑞星表里不存在的数据就是已经删除的数据,目前不考虑这类数据
//		for(OrgUserLevel oul : userLevels){
//			if(!vipTypeMap.containsKey(oul.getLevelId())){
//				deluserLevel.add(oul.getLevelId());
//			}
//		}
//		orgUserLevelDao.deleteByIdInBatch(deluserLevel);
		
		
		return resultStr;
	}

	@Override
	public String updateLevelByEdit(OrgUserLevel userLevel) {
		String result = "false";
		
		OrgUserLevel oldUserLevel = orgUserLevelDao.selectById(userLevel.getLevelId());
		
		oldUserLevel.setLevelType(userLevel.getLevelType());
//		oldUserLevel.setIntegral(userLevel.getIntegral()); // 积分字段暂时不使用
		oldUserLevel.setConsumeDown(userLevel.getConsumeDown());
		oldUserLevel.setConsumeTop(userLevel.getConsumeTop());
		
		int r = orgUserLevelDao.updateById(oldUserLevel);
		if(r > 0) {
			result = "true";
		}
		return result;
	}
    
}