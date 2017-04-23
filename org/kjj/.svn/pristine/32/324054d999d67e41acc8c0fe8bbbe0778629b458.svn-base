package com.kjj.commserver.service.shop.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.shop.OrgShopPageImgDao;
import com.kjj.commserver.entity.shop.OrgShopPageImg;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.shop.aide.OrgShopImgConstant;
import com.kjj.commserver.entity.shop.aide.OrgShopImgForm;
import com.kjj.commserver.entity.shop.aide.OrgShopPageImgQuery;
import com.kjj.commserver.service.shop.OrgShopPageImgService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgShopPageImgServiceImpl extends BaseServiceImpl<OrgShopPageImg, Integer> implements OrgShopPageImgService {
	@Resource
	private OrgShopPageImgDao orgShopPageImgDao;

	@Override
	protected BaseDao<OrgShopPageImg, Integer> getBaseDao() {
		return orgShopPageImgDao;
	}

	@Override
	public void updatePageImg(OrgShopForm shopForm,OrgShopImgForm shopImgForm) {
		// 店铺图片的更新
		OrgShopPageImg shopPageImgIcon = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgIconId())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgIcon())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgIconId()));
			}
			shopPageImgIcon.setId(Integer.parseInt(shopImgForm.getPageImgIconId()));
			shopPageImgIcon.setPageImg(shopImgForm.getPageImgIcon());
			updateByIdSelective(shopPageImgIcon);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgIcon())){
			shopPageImgIcon.setShopId(shopForm.getShopId());
			shopPageImgIcon.setType(OrgShopImgConstant.SHOP_IMG_TYPE_ICON);
			shopPageImgIcon.setPageImg(shopImgForm.getPageImgIcon());
			add(shopPageImgIcon);
		}
		
		OrgShopPageImg shopPageImgMobile = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgImgMapMobileId())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgImgMapMobile())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgImgMapMobileId()));
			}
			shopPageImgMobile.setId(Integer.parseInt(shopImgForm.getPageImgImgMapMobileId()));
			shopPageImgMobile.setPageImg(shopImgForm.getPageImgImgMapMobile());
			updateByIdSelective(shopPageImgMobile);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgImgMapMobile())){
			shopPageImgMobile.setShopId(shopForm.getShopId());
			shopPageImgMobile.setType(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP);
			shopPageImgMobile.setDevice(OrgShopImgConstant.SHOP_IMG_DEVICE_WECHAT);
			shopPageImgMobile.setPageImg(shopImgForm.getPageImgImgMapMobile());
			add(shopPageImgMobile);
		}
		
		OrgShopPageImg shopPageImgPc = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgImgMapPcId())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgImgMapPc())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgImgMapPcId()));
			}
			shopPageImgPc.setId(Integer.parseInt(shopImgForm.getPageImgImgMapPcId()));
			shopPageImgPc.setPageImg(shopImgForm.getPageImgImgMapPc());
			updateByIdSelective(shopPageImgPc);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgImgMapPc())){
			shopPageImgPc.setShopId(shopForm.getShopId());
			shopPageImgPc.setType(OrgShopImgConstant.SHOP_IMG_TYPE_IMG_MAP);
			shopPageImgPc.setPageImg(shopImgForm.getPageImgImgMapPc());
			shopPageImgPc.setDevice(OrgShopImgConstant.SHOP_IMG_DEVICE_PC);
			add(shopPageImgPc);
		}
		
		OrgShopPageImg shopPageImgInterior1 = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgInterior1Id())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgInterior1())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgInterior1Id()));
			}
			shopPageImgInterior1.setId(Integer.parseInt(shopImgForm.getPageImgInterior1Id()));
			shopPageImgInterior1.setPageImg(shopImgForm.getPageImgInterior1());
			updateByIdSelective(shopPageImgInterior1);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgInterior1())){
			shopPageImgInterior1.setShopId(shopForm.getShopId());
			shopPageImgInterior1.setType(OrgShopImgConstant.SHOP_IMG_TYPE_INTERIOR);
			shopPageImgInterior1.setPageImg(shopImgForm.getPageImgInterior1());
			add(shopPageImgInterior1);
		}
		
		OrgShopPageImg shopPageImgInterior2 = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgInterior2Id())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgInterior2())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgInterior2Id()));
			}
			shopPageImgInterior2.setId(Integer.parseInt(shopImgForm.getPageImgInterior2Id()));
			shopPageImgInterior2.setPageImg(shopImgForm.getPageImgInterior2());
			updateByIdSelective(shopPageImgInterior2);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgInterior2())){
			shopPageImgInterior2.setShopId(shopForm.getShopId());
			shopPageImgInterior2.setType(OrgShopImgConstant.SHOP_IMG_TYPE_INTERIOR);
			shopPageImgInterior2.setPageImg(shopImgForm.getPageImgInterior2());
			add(shopPageImgInterior2);
		}
		
		OrgShopPageImg shopPageImgOutDoor1 = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor1Id())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor1())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgOutDoor1Id()));
			}
			shopPageImgOutDoor1.setId(Integer.parseInt(shopImgForm.getPageImgOutDoor1Id()));
			shopPageImgOutDoor1.setPageImg(shopImgForm.getPageImgOutDoor1());
			updateByIdSelective(shopPageImgOutDoor1);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor1())){
			shopPageImgOutDoor1.setShopId(shopForm.getShopId());
			shopPageImgOutDoor1.setType(OrgShopImgConstant.SHOP_IMG_TYPE_OUTDOOR);
			shopPageImgOutDoor1.setPageImg(shopImgForm.getPageImgOutDoor1());
			add(shopPageImgOutDoor1);
		}
		
		OrgShopPageImg shopPageImgOutDoor2 = new OrgShopPageImg();
		if (StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor2Id())) {
			if(!StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor2())){
				deleteById(Integer.parseInt(shopImgForm.getPageImgOutDoor2Id()));
			}
			shopPageImgOutDoor2.setId(Integer.parseInt(shopImgForm.getPageImgOutDoor2Id()));
			shopPageImgOutDoor2.setPageImg(shopImgForm.getPageImgOutDoor2());
			updateByIdSelective(shopPageImgOutDoor2);
		}else if(StringUtils.isNotBlank(shopImgForm.getPageImgOutDoor2())){
			shopPageImgOutDoor2.setShopId(shopForm.getShopId());
			shopPageImgOutDoor2.setType(OrgShopImgConstant.SHOP_IMG_TYPE_OUTDOOR);
			shopPageImgOutDoor2.setPageImg(shopImgForm.getPageImgOutDoor2());
			add(shopPageImgOutDoor2);
		}

	}

	@Override
	public OrgShopPageImg queryImgByType(Integer shopId, byte type) {
		OrgShopPageImgQuery query = new OrgShopPageImgQuery(); 
		if(OrgShopImgConstant.SHOP_IMG_TYPE_ICON == type){
			query.setType(type);
			query.setShopId(shopId);
		}
		return queryOne(query);
	}

	
}