package com.kjj.commserver.service.goods.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.goods.OrgProductLinkPropertyDao;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkPropertyQuery;
import com.kjj.commserver.service.goods.OrgProductLinkPropertyService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgProductLinkPropertyServiceImpl extends BaseServiceImpl<OrgProductLinkProperty, Integer> implements OrgProductLinkPropertyService {
    @Resource
    private OrgProductLinkPropertyDao orgProductLinkPropertyDao;

    @Override
    protected BaseDao<OrgProductLinkProperty, Integer> getBaseDao() {
        return orgProductLinkPropertyDao;
    }

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Integer> queryGoodsIdsByUrlParam(String url) {
		
		Collection<Integer> goodsIds = null;
		Collection<String> valuesStr = null;
		if(StringUtils.isEmpty(url)){
			return null;
		}
		String[] params = url.split("&");
		if(params.length>0){
			int j=0;
			for(int i=0;i<params.length;i++){
				Collection<Integer> goodsIdsTmp=null;
				if(params[i].indexOf("fid")>-1 && params[i].indexOf("brand")==-1){
					j++;
					String[] kv = params[i].split("=");
					Integer key=Integer.parseInt(kv[0].substring(3));
					if(StringUtils.isNotEmpty(kv[1])){
						valuesStr=new ArrayList<String>();
						if(kv[1].indexOf(",")>-1){
							String[] values = kv[1].split(",");
							valuesStr.addAll(Arrays.asList(values));
						}else{
							valuesStr.add(kv[1]);
						}
						goodsIdsTmp = queryGoodsIdsByProps(key,valuesStr);
					}
					if(j==1){
						goodsIds=goodsIdsTmp;
					}else{
						goodsIds = CollectionUtils.intersection(goodsIds, goodsIdsTmp);  
					}	
				}
			}
		}
		return goodsIds;
	}

	private Collection<Integer> queryGoodsIdsByProps(Integer key, Collection<String> valuesInt) {
		OrgProductLinkPropertyQuery query=new OrgProductLinkPropertyQuery();
		query.setPropertyId(key);
		query.setPropertyValueIds(valuesInt);
//		query.setIsActive(true);
//		query.setIsDelete(false);
		return orgProductLinkPropertyDao.queryGoodsIdsByProps(query);
	}

	@Override
	public Collection<Integer> queryBrandsByUrlParam(String url) {
		Collection<Integer> brands = null;
		if(StringUtils.isEmpty(url)){
			return null;
		}
		String[] params = url.split("&");
		if(params.length>0){
			for(String param :params){
				if(param.indexOf("fidbrand")>-1){
					String[] kv = param.split("=");
					if(StringUtils.isNotEmpty(kv[1])){
						brands=new ArrayList<Integer>();
						if(kv[1].indexOf(",")>-1){
							String[] values = kv[1].split(",");
							for (String value : values) {
								brands.add(Integer.parseInt(value));
							}
						}else{
							brands.add(Integer.parseInt(kv[1]));
						}
					}
				}
			}
		}
		return brands;
	}
	
}