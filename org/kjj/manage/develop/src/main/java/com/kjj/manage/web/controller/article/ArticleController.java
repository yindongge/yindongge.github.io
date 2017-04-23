package com.kjj.manage.web.controller.article;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.constant.UploadConstant;
import com.kjj.commserver.entity.article.OrgArticle;
import com.kjj.commserver.entity.article.OrgArticleClass;
import com.kjj.commserver.entity.article.OrgArticleShop;
import com.kjj.commserver.entity.article.aide.OrgArticleClassConstant;
import com.kjj.commserver.entity.article.aide.OrgArticleConstant;
import com.kjj.commserver.entity.article.aide.OrgArticleQuery;
import com.kjj.commserver.entity.article.aide.OrgArticleShopQuery;
import com.kjj.commserver.entity.article.aide.OrgArticleShopVo;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.aide.OrgAreaVo;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.article.OrgArticleClassService;
import com.kjj.commserver.service.article.OrgArticleService;
import com.kjj.commserver.service.article.OrgArticleShopService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.ManagePropertiesUtil;
import com.kjj.manage.util.PageReq;


@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private OrgArticleClassService orgArticleClassService;
	
	@Resource
	private OrgArticleService orgArticleService;
	
	@Resource 
	private OrgShopService orgShopService;
	
	@Resource 
	private OrgArticleShopService orgArticleShopService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
	
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String articlelist(Model model,PageReq pageReq,OrgArticleQuery query){
	
		List<OrgArticleClass> list = orgArticleClassService.getArticleClassTree(OrgArticleClassConstant.PARENT_ID_ROOT);
		model.addAttribute("classList", list);
		//获取文章列表
		Page<OrgArticle> page = orgArticleService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		//查询文章审核及未审核数量
		OrgArticleQuery orgArticleQuery=new OrgArticleQuery();
		orgArticleQuery.setStatus(OrgArticleConstant.STATUS_APPROVE_YES);
		long approveYesCount=orgArticleService.queryCount(orgArticleQuery);
		orgArticleQuery.setStatus(OrgArticleConstant.STATUS_APPROVE_NO);
		long approveNoCount = orgArticleService.queryCount(orgArticleQuery);
		
		model.addAttribute("approveYesCount",approveYesCount);
		model.addAttribute("approveNoCount",approveNoCount);
		//前台访问地址path
		String frontPath = (String) ManagePropertiesUtil.getProperty("front.path");
		model.addAttribute("frontPath", frontPath);
		model.addAttribute("query",query);
		
		return "article/list";
	}
	
	@RequestMapping(value ="/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(Model model){
		List<OrgArticleClass> list = orgArticleClassService.getArticleClassTree(OrgArticleClassConstant.PARENT_ID_ROOT);
		model.addAttribute("classList", list);
		return "article/add";
	}
	
	
	@RequestMapping(value ="/edit/{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String edit(@PathVariable Integer id,Model model){
		List<OrgArticleClass> list = orgArticleClassService.getArticleClassTree(OrgArticleClassConstant.PARENT_ID_ROOT);
		model.addAttribute("classList", list);
		OrgArticle orgArticle= orgArticleService.queryVoById(id);
		model.addAttribute("obj", orgArticle);
		
		//获取当前文章 所属门店列表
		OrgArticleShopQuery query=new OrgArticleShopQuery();
		query.setArticleid(id);
		List<OrgArticleShop> articleShop = orgArticleShopService.queryList(query);
		OrgArticleShopVo articleShopVo=null;
		
		StringBuilder sbid = new StringBuilder();
		StringBuilder sbname = new StringBuilder();
		for(int i=0;i<articleShop.size();i++){
			sbid.append(articleShop.get(i).getShopid()).append(",");
			articleShopVo=(OrgArticleShopVo) articleShop.get(i);
			sbname.append(articleShopVo.getShopName()).append(",");
		}
		
		model.addAttribute("shopsid", sbid.toString());
		model.addAttribute("shopsname", sbname.toString());
		
		return "article/edit";
	}
	
	@RequestMapping(value ="/save", method = { RequestMethod.GET, RequestMethod.POST })
	public void save(HttpSession session,MultipartHttpServletRequest request,HttpServletResponse response,OrgArticle orgArticle) throws IOException {
		OrgAdminUserSession orgAdminUserSession = (OrgAdminUserSession)session.getAttribute(SessionConstant.SESSION_ADMIN);
		OrgAdminUser orgAdminUser =orgAdminUserSession.getOrgAdminUser();
		String order = request.getParameter("order");
		String shops = request.getParameter("shops");
		String fileName="";
		if(!StringUtils.isEmpty(orgArticle.getContent())){
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			orgArticle.setContent(orgArticle.getContent().replace(basePath, ""));
			orgArticle.setContent(orgArticle.getContent().replace("src=\"", "src=\""+basePath));
			orgArticle.setContent(orgArticle.getContent().replace(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL, ""));			
		}
		
		if(request.getFile("file") !=null && request.getFile("file").getSize() != 0){
			fileName = new Date().getTime()+".jpg";
			File file = new  File(ImageConstant.IMAGE_BASE_PATH+ImageConstant.ARTICLE+fileName);
			InputStream inputStream = request.getFile("file").getInputStream();
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int length = 0;
			while ((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			outputStream.close();
			inputStream.close();
			fileName=ImageConstant.ARTICLE+fileName;
		}else{
			fileName = request.getParameter("image");
			if(fileName==null){ 
				fileName="";
			}
		}
		orgArticle.setImage(fileName);
		String articleId = request.getParameter("articleId");
		if(order==null||order.equals("")){
			orgArticle.setPrivelege((short)255);
		}else{
			orgArticle.setPrivelege(Short.parseShort(order));
		}
		if(articleId != null && !articleId.equals("")){
			//修改
			orgArticle.setId(Integer.parseInt(articleId));
			orgArticleService.updateByIdSelective(orgArticle);
			//删除门店关联信息（先删除再添加）
//			orgArticleShopService.deleteById(Integer.parseInt(articleId));
			OrgArticleShop deleteByArticle =new OrgArticleShop();
			deleteByArticle.setArticleid(Integer.parseInt(articleId));
			orgArticleShopService.delete(deleteByArticle);
		}else{
			//新增
			orgArticle.setUserid(orgAdminUser.getUserId().intValue());;
			orgArticle.setStatus((short)1);
			orgArticleService.add(orgArticle);
		}
		//添加门店关联信息
		String[] ids = shops.split(",");
		List<OrgArticleShop> list=new ArrayList<OrgArticleShop>();
		OrgArticleShop orgArticleShop=null;
		Integer articleIdNew=null;
		if(articleId==null){
			articleIdNew = orgArticle.getId();								
		}else{
			articleIdNew=Integer.parseInt(articleId);										
		}
		for(int i=0;i<ids.length;i++){
			orgArticleShop=new OrgArticleShop();
			if(!ids[i].equals("")){
				orgArticleShop.setArticleid(articleIdNew);
				orgArticleShop.setShopid(Integer.parseInt(ids[i]));
				list.add(orgArticleShop);
			}
		}
		orgArticleShopService.addInBatch(list);
		
	}

	@ResponseBody
	@RequestMapping(value ="/getshop", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String,Object> getshop(HttpSession session,HttpServletResponse response){
		Map<String,Object>	result = new HashMap<String, Object>();
		//获取所有区域
		List<OrgArea> list = orgAreaService.queryListProvince();
		List<OrgArea> listArea = new ArrayList<OrgArea>();
		OrgAreaVo orgArea=null;
		for(int i=0;i<list.size();i++){
			orgArea = (OrgAreaVo) list.get(i);
			List<OrgShop> listShop = orgShopService.queryShopListByCode(orgArea.getCode().substring(0, 2));
			if(CollectionUtils.isNotEmpty(listShop)){
				orgArea.setListShop(listShop);
				listArea.add(orgArea);
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("listArea",listArea);
		return result;
		
	}
	
	@ResponseBody
	@RequestMapping(value ="/updatestatus", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String,Object> updatestatus(OrgArticle orgArticle){
			
		Map<String,Object>	result = new HashMap<String, Object>();
		
		orgArticleService.updateByIdSelective(orgArticle);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String,Object> delete(Integer articleId){
		Map<String,Object>	result = new HashMap<String, Object>();
		orgArticleService.delete4Article(articleId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
}
