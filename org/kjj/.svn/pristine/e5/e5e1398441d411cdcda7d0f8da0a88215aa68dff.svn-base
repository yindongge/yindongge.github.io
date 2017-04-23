package com.kjj.commserver.service.special.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.special.OrgSpecialFloorDao;
import com.kjj.commserver.entity.special.OrgSpecialFloor;
import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorForm;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorProductConstant;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorProductQuery;
import com.kjj.commserver.service.special.OrgSpecialFloorProductService;
import com.kjj.commserver.service.special.OrgSpecialFloorService;
import com.kjj.commserver.util.ImageUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgSpecialFloorServiceImpl extends BaseServiceImpl<OrgSpecialFloor, Integer> implements OrgSpecialFloorService {
    @Resource
    private OrgSpecialFloorDao orgSpecialFloorDao;
	
	@Resource
	private OrgSpecialFloorProductService orgSpecialFloorProductService;
	
    @Override
    protected BaseDao<OrgSpecialFloor, Integer> getBaseDao() {
        return orgSpecialFloorDao;
    }

	@Override
	public void deleteFloor(Integer floorId) {
		deleteById(floorId);
		OrgSpecialFloorProductQuery orgSpecialFloorProductQuery = new OrgSpecialFloorProductQuery();
		orgSpecialFloorProductQuery.setFloorId(floorId);
		orgSpecialFloorProductService.delete(orgSpecialFloorProductQuery);
	}

	@Override
	public void save(OrgSpecialFloorForm orgSpecialFloorForm) {
		if(orgSpecialFloorForm.getSpecialId()!=null){
			if(orgSpecialFloorForm.getFloorId()!=null){
				//更新楼层
				orgSpecialFloorForm.setImgPath(ImageUtil.setSavePath(orgSpecialFloorForm.getImgPath()));
				updateByIdSelective(orgSpecialFloorForm);
				//删除原楼层商品
				OrgSpecialFloorProductQuery orgSpecialFloorProductQuery = new OrgSpecialFloorProductQuery();
				orgSpecialFloorProductQuery.setFloorId(orgSpecialFloorForm.getFloorId());
				orgSpecialFloorProductService.delete(orgSpecialFloorProductQuery);
			}else{
				//新增楼层
				Byte defaultOrder=99;
				orgSpecialFloorForm.setFloorOrder(defaultOrder);
				add(orgSpecialFloorForm);
			}
			//新增楼层商品
			Integer floorId = orgSpecialFloorForm.getFloorId();
			List<OrgSpecialFloorProduct> productList = orgSpecialFloorForm.getProductList();
			for (OrgSpecialFloorProduct orgSpecialFloorProduct : productList) {
				orgSpecialFloorProduct.setFloorId(floorId);
				orgSpecialFloorProduct.setSpecialId(orgSpecialFloorForm.getSpecialId());
				if(orgSpecialFloorProduct.getGoodsId()!=null){
					orgSpecialFloorProduct.setType(OrgSpecialFloorProductConstant.FLOOR_PRODUCT_TYPE_PRODUCT);					
				}else{
					orgSpecialFloorProduct.setType(OrgSpecialFloorProductConstant.FLOOR_PRODUCT_TYPE_ACIVITY);	
					orgSpecialFloorProduct.setImagePath(ImageUtil.setSavePath(orgSpecialFloorProduct.getImagePath()));
				}
			}
			orgSpecialFloorProductService.addInBatch(productList);
		}
		
	}
}



