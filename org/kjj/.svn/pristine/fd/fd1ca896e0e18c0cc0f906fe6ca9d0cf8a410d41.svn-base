package com.kjj.commserver.service.article.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.article.OrgArticleClassDao;
import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.aide.OrgArticleClassConstant;
import com.kjj.commserver.entity.article.aide.OrgArticleClassQuery;
import com.kjj.commserver.entity.article.aide.OrgArticleClassVo;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgArticleClassServiceImpl extends BaseServiceImpl<OrgArticleClass, Integer> implements OrgArticleClassService {
	
    @Resource
    private OrgArticleClassDao orgArticleClassDao;
    @Resource
    private OrgArticleService orgArticleService;

    @Override
    protected BaseDao<OrgArticleClass, Integer> getBaseDao() {
        return orgArticleClassDao;
    }

    @Override
	public OrgArticleClass queryClassByClassName(String className) {
    	OrgArticleClassQuery query = new OrgArticleClassQuery();
    	query.setIsvalide(OrgArticleClassConstant.ISVALIDE_YES);
    	query.setParentid(OrgArticleClassConstant.PARENT_ID_ROOT);
    	query.setClassName(className);
		return queryOne(query);
	}

	@Override
	public List<OrgArticleClass> queryListByParentid(Integer parentId) {
		OrgArticleClassQuery query = new OrgArticleClassQuery();
		query.setParentid(parentId);
		query.setIsvalide(OrgArticleClassConstant.ISVALIDE_YES);
		return queryList(query);
	}

	@Override
	public List<OrgArticleClass> queryListByParentidAndShopIdWithArticle(Integer parentId, Integer shopId) {
		List<OrgArticleClass> listArticleClass = queryListByParentid(parentId);
		if(CollectionUtils.isNotEmpty(listArticleClass)){
			Map<Integer,OrgArticleClassVo> mapArticleClass = new HashMap<Integer,OrgArticleClassVo>();
			OrgArticleClassVo orgArticleClassVo = null;
			for(OrgArticleClass articleClass : listArticleClass){
				orgArticleClassVo = (OrgArticleClassVo)articleClass;
				mapArticleClass.put(orgArticleClassVo.getId(), orgArticleClassVo);
			}
			
			List<OrgArticle> listArticle = orgArticleService.queryListByParentClassIdAndShopId(parentId, shopId);
			for(OrgArticle article : listArticle){
				mapArticleClass.get(article.getClassid().intValue()).getListArticle().add(article);
			}
		}
		return listArticleClass;
	}

	@Override
	public List<OrgArticleClass> queryListByParentidWithSubList(Integer parentid) {
		//子分类信息
		List<OrgArticleClass> listArticleClass = queryListByParentid(parentid);
		Map<Integer,OrgArticleClassVo> mapArticleClass = new LinkedHashMap<Integer,OrgArticleClassVo>();
		if(CollectionUtils.isNotEmpty(listArticleClass)){
			for(OrgArticleClass articleClass : listArticleClass){
				mapArticleClass.put(articleClass.getId(), (OrgArticleClassVo)articleClass);
			}
		}
		//孙分类信息
		OrgArticleClassQuery query = new OrgArticleClassQuery();
		query.setRootId(parentid);
		query.setIsvalide(OrgArticleClassConstant.ISVALIDE_YES);
		List<OrgArticleClass> listArticleClassChild = queryList(query);
		if(CollectionUtils.isNotEmpty(listArticleClassChild)){
			for(OrgArticleClass articleClass : listArticleClassChild){
				mapArticleClass.get(articleClass.getParentid()).getListSubClass().add(articleClass);
			}
		}
		return listArticleClass;
	}

	@Override
	public OrgArticleClass getRootClass(OrgArticleClass articleClassChildren) {
		if(articleClassChildren != null && articleClassChildren.getParentid() != OrgArticleClassConstant.PARENT_ID_ROOT 
				&& !articleClassChildren.getParentid().equals(articleClassChildren.getId())){
			articleClassChildren = queryById(articleClassChildren.getParentid());
			if(articleClassChildren != null && articleClassChildren.getParentid() != OrgArticleClassConstant.PARENT_ID_ROOT 
					&& !articleClassChildren.getParentid().equals(articleClassChildren.getId())){
				articleClassChildren = getRootClass(articleClassChildren);
			}
		}
		return articleClassChildren;
	}

	@Override
	public List<OrgArticleClass> getArticleClassTree(int articleClassId) {
		List<OrgArticleClass> list = queryListByParentid(articleClassId);
		List<OrgArticleClass> subList =null;
		if(CollectionUtils.isNotEmpty(list)){
			for(int i=0;i<list.size();i++){
				OrgArticleClassVo oacVo = (OrgArticleClassVo) list.get(i);
				if(oacVo.getId()!=null){
					//递归遍历
					subList= getArticleClassTree(oacVo.getId());
					if(CollectionUtils.isEmpty(subList)){
						//0没有后续节点（叶子节点）
						oacVo.setFlag(OrgArticleClassConstant.FLAG_ZERO);						
					}else{
						oacVo.setFlag(OrgArticleClassConstant.FLAG_ONE);
					}
					oacVo.setListSubClass(subList);
				}
			}
			return list;
		}else{
			return null;
		}
	}
}