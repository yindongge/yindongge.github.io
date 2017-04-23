package com.kjj.manage.web.controller.special;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.special.OrgSpecial;
import com.kjj.commserver.entity.special.OrgSpecialFloor;
import com.kjj.commserver.entity.special.OrgSpecialLink;
import com.kjj.commserver.entity.special.OrgSpecialLinkForm;
import com.kjj.commserver.entity.special.OrgSpecialRule;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorForm;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialFloorVo;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkConstant;
import com.kjj.commserver.entity.special.aide.OrgSpecialLinkQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialRuleQuery;
import com.kjj.commserver.entity.special.aide.OrgSpecialVo;
import com.kjj.commserver.entity.system.aide.OrgAdminUserSession;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.special.OrgSpecialFloorProductService;
import com.kjj.commserver.service.special.OrgSpecialFloorService;
import com.kjj.commserver.service.special.OrgSpecialLinkService;
import com.kjj.commserver.service.special.OrgSpecialRuleService;
import com.kjj.commserver.service.special.OrgSpecialService;
import com.kjj.commserver.service.special.OrgSpecialTimeService;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.constant.SessionConstant;
import com.kjj.manage.util.ManagePropertiesUtil;
import com.kjj.manage.util.MultipartFileUploadUtil;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/special")
public class SpecialController {

	@Resource
	private OrgSpecialService orgSpecialService;
	
	@Resource
	private OrgSpecialTimeService orgSpecialTimeService;
	
	@Resource
	private OrgSpecialRuleService orgSpecialRuleService;
	
	@Resource
	private OrgSpecialLinkService orgSpecialLinkService;
	
	@Resource
	private OrgClassService orgClassService;
	
	@Resource
	private OrgProductItemService orgProductItemService;
	
	@Resource
	private OrgSpecialFloorService orgSpecialFloorService;
	
	@Resource
	private OrgSpecialFloorProductService orgSpecialFloorProductService;


	//专题列表
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list( Model model,HttpSession session,PageReq pageReq,OrgSpecialQuery query ) {
		pageReq.setSort(new Sort(Direction.DESC,"t.special_id"));
		Page<OrgSpecial> page = orgSpecialService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		model.addAttribute("frontPath", ManagePropertiesUtil.getProperty("front.path"));
		model.addAttribute("wxPath", ManagePropertiesUtil.getProperty("wx.path"));
		return "/special/list";
	}

	//添加专题
	@RequestMapping(value = "/add", method = { RequestMethod.GET,RequestMethod.POST })
	public String addInit( Model model,HttpSession session) {
		return "special/add";
	}
	//编辑专题
	@RequestMapping(value = "/edit/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String edit( Model model,HttpSession session,@PathVariable Integer id) {
		OrgSpecialVo orgSpecial = orgSpecialService.queryVoById(id);
		model.addAttribute("orgSpecial", orgSpecial);
		return "special/edit";
	}
	//保存专题
	@RequestMapping(value = "/save", method = { RequestMethod.GET,RequestMethod.POST })
	public String save(Model model,HttpSession session,OrgSpecialVo orgSpecialVo) {
		if(orgSpecialVo.getSpecialId()==null){
			OrgAdminUserSession orgAdminUsersSession = (OrgAdminUserSession) session.getAttribute(SessionConstant.SESSION_ADMIN);
			orgSpecialVo.setCreateId(orgAdminUsersSession.getOrgAdminUser().getUserId().intValue());
			orgSpecialVo.setCreateName(orgAdminUsersSession.getOrgAdminUser().getUserName());
		}
		Integer specialId = orgSpecialService.save(orgSpecialVo);
		return "redirect:/special/editHtml/"+specialId;
	}
	//删除专题（保留功能）
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Map<String, Object> delete(@PathVariable Integer id) {
		orgSpecialService.deleteById(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	//更新专题活动启用状态
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer updateStatus(Model model,OrgSpecialQuery query) {
		orgSpecialService.updateByIdSelective(query);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	/** 编辑自定义HTML */
	@RequestMapping(value = "/editHtml/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editHtml( Model model,HttpSession session,@PathVariable Integer id) {
		OrgSpecialRuleQuery orgSpecialRuleQuery = new OrgSpecialRuleQuery();
		orgSpecialRuleQuery.setSpecialId(id);
		OrgSpecialRule orgSpecialRule = orgSpecialRuleService.queryOne(orgSpecialRuleQuery);
		model.addAttribute("orgSpecialRule", orgSpecialRule);
		return "special/edithtml";
	}

	/** 保存自定义HTML */
	@RequestMapping(value = "/saveHtml", method = { RequestMethod.GET,RequestMethod.POST })
	public String saveHtml( Model model,OrgSpecialRule orgSpecialRule) {
		orgSpecialRuleService.updateBySpecialId(orgSpecialRule);
		return "redirect:/special/picList/"+orgSpecialRule.getSpecialId();
	}
	
	/**	 活动专题图列表  */
	@RequestMapping(value = "/picList/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String picList( Model model,HttpSession session, @PathVariable("id") Integer specialId) {
		OrgSpecialLinkQuery orgSpecialLinkQuery = new OrgSpecialLinkQuery();
		orgSpecialLinkQuery.setSpecialId(specialId);
		orgSpecialLinkQuery.setNoAnchor(true);
		Sort sort = new Sort(Direction.ASC,"t.image_order");
		List<OrgSpecialLink> list = orgSpecialLinkService.queryList(orgSpecialLinkQuery,sort);
		model.addAttribute("list", list);
		model.addAttribute("specialId", specialId);
		
		return "special/picList";
	}
	
	/**
	 *  活动专题图详情
	 * @param model
	 * @param session
	 * @param specialId 专题主键
	 * @param id 专题图主键
	 * @return
	 */
	@RequestMapping(value = "/editPic/{specialId}/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editPic( Model model,HttpSession session,@PathVariable Integer specialId,@PathVariable Integer id) {
		OrgSpecialLink orgSpecialLink =null;
		if(id!=null && id!=0){
			orgSpecialLink = orgSpecialLinkService.queryVoById(id);
		}else{
			orgSpecialLink = new OrgSpecialLink();
			orgSpecialLink.setSpecialId(specialId);
		}
		model.addAttribute("orgSpecialLink", orgSpecialLink);
		
		if(orgSpecialLink.getType()==OrgSpecialLinkConstant.LINK_TYPE_PRODUCT){
			OrgProductItem orgProductItem = orgProductItemService.queryVoById(orgSpecialLink.getGoodsId());
			model.addAttribute("orgProductItem", orgProductItem);
		}
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		return "special/editPic";
	}
	
	//	 保存活动专题图详情 
	@ResponseBody
	@RequestMapping(value = "/savePic", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer savePic( Model model,OrgSpecialLink orgSpecialLink ) {
		if(orgSpecialLink.getId()==null){
			Integer maxOrder = orgSpecialLinkService.selectMaxOrder(orgSpecialLink.getSpecialId());
			if(maxOrder==null){
				maxOrder=0;
			}
			maxOrder=maxOrder+1;
			Byte maxOrderByte=maxOrder.byteValue();
			orgSpecialLink.setImageOrder(maxOrderByte);
		}
		orgSpecialLinkService.save(orgSpecialLink);
		return HttpStatusCode.CODE_SUCCESS;
	}

	//  保存分组商品
	@ResponseBody
	@RequestMapping(value = "/uploadPicture", method = { RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> uploadPicture( MultipartFile file ){
		String imagePath = MultipartFileUploadUtil.fileUpload(file, ImageConstant.SPECIAL);
        Map<String, Object> result = new HashMap<String, Object>();
        //保存到数据库的图片路径
        result.put("picUrlForSave", imagePath);
        //前台访问图片路径
        String picUrlForShow = ImageConstant.IMAGE_BASE_URL + imagePath;
        result.put("picUrlForShow", picUrlForShow);
        result.put("status", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	//保存专题图排序
	@ResponseBody
	@RequestMapping(value = "/saveImageOrder", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer saveImageOrder( Model model,Integer specialId,String ids) {
		String[] IdArr=ids.split(",");
		OrgSpecialLink orgSpecialLink =null;
		Byte curOrder=0;
		List<OrgSpecialLink> list=new ArrayList<OrgSpecialLink>();
		for (int i = 0; i < IdArr.length; i++) {
			orgSpecialLink = new OrgSpecialLink();
			curOrder=(byte)(i+1);
			orgSpecialLink.setId(Integer.parseInt(IdArr[i]));
			orgSpecialLink.setImageOrder(curOrder);
			list.add(orgSpecialLink);
		}
		orgSpecialLinkService.updateInBatch(list);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	//删除专题图
	@ResponseBody
	@RequestMapping(value = "/deletePic/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer deletePic( Model model,@PathVariable Integer id) {
		orgSpecialLinkService.deleteById(id);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
	
	//搜索商品
	@RequestMapping(value = "/searchProduct", method = { RequestMethod.GET,RequestMethod.POST })
	public String searchProduct( Model model,HttpSession session,OrgProductItemQuery query, PageReq pageReq) {
		if(StringUtils.isNotBlank(query.getKeyword())){
			query.setGoodsNameLike(query.getKeyword().trim());			
		}
		if(query.getCatId()!=null &&  query.getParentCatId()!=null && query.getCatId()==-1 ){
			query.setCatId(query.getParentCatId());
		}
		query.setIsOnSale(OrgProductConstant.IS_ON_SALE_ON);
		query.setIsDelete(OrgProductConstant.IS_NOT_DELETE);
		pageReq.setPageSize(5);
		pageReq.setSort(new Sort(Direction.DESC,"t.goods_id"));
		Page<OrgProductItem> page = orgProductItemService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		if(query.getParentCatId()!=null){
			model.addAttribute("listClassLevelTwo", orgClassService.queryListByParentId(query.getParentCatId().intValue()));
		}
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		model.addAttribute("query", query);
		return "special/searchProduct";
	}
	
	//根据第一级商品分类获得第二级商品分类
	@ResponseBody
	@RequestMapping(value = "/getClassByParentId", method = {RequestMethod.GET,RequestMethod.POST })
	public Map<String,Object> getClassByParentId(Integer parentId) {
		Map<String, Object> result = new HashMap<String, Object>();
		//二级分类
		List<OrgClass> listClassLevelTwo = orgClassService.queryListByParentId(parentId);
		result.put("listClassLevelTwo", listClassLevelTwo);
		return result;
	}
	
	// 活动商品列表 
	@RequestMapping(value = "/productList/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String productList( Model model,HttpSession session, @PathVariable("id") Integer specialId) {
		OrgSpecialFloorQuery orgSpecialFloorQuery = new OrgSpecialFloorQuery();
		orgSpecialFloorQuery.setSpecialId(specialId);
		Sort sort=new Sort(Direction.ASC,"t.floor_order");
		List<OrgSpecialFloor> list = orgSpecialFloorService.queryList(orgSpecialFloorQuery,sort);
		model.addAttribute("list", list);
		model.addAttribute("specialId", specialId);
		return "special/productList";
	}
	
	//删除分组商品楼层
	@ResponseBody
	@RequestMapping(value = "/deleteFloor/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer deleteFloor( Model model,@PathVariable Integer id) {
		if(id!=0){
			orgSpecialFloorService.deleteFloor(id);
		}
		return HttpStatusCode.CODE_SUCCESS;
	}
		
		
	/**
	 *  楼层商品详情
	 * @param model
	 * @param session
	 * @param specialId 专题主键
	 * @param id 楼层主键
	 * @return
	 */
	@RequestMapping(value = "/editProduct/{specialId}/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editProduct( Model model,HttpSession session,@PathVariable Integer specialId,@PathVariable Integer id) {
		OrgSpecialFloor orgSpecialFloor=null;
		if(id!=null && id!=0){
			orgSpecialFloor=orgSpecialFloorService.queryVoById(id);
		}else{
			orgSpecialFloor = new OrgSpecialFloorVo();
			orgSpecialFloor.setSpecialId(specialId);
		}
		model.addAttribute("orgSpecialFloor", orgSpecialFloor);
		List<OrgClass> listClassLevelOne =  orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE);
		model.addAttribute("listClassLevelOne",listClassLevelOne);
		return "special/editProduct";
	}
		
		
//	 保存活动专题图详情 
	@ResponseBody
	@RequestMapping(value = "/saveProduct", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer saveProduct( Model model,OrgSpecialFloorForm orgSpecialFloorForm) {
		orgSpecialFloorService.save(orgSpecialFloorForm);
		return HttpStatusCode.CODE_SUCCESS;
	}	
	
	//保存分组商品楼层排序
	@ResponseBody
	@RequestMapping(value = "/saveProductOrder", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer saveProductOrder( Model model,Integer specialId,String ids) {
		String[] IdArr=ids.split(",");
		OrgSpecialFloor orgSpecialFloor =null;
		Byte curOrder=0;
		List<OrgSpecialFloor> list=new ArrayList<OrgSpecialFloor>();
		for (int i = 0; i < IdArr.length; i++) {
			orgSpecialFloor = new OrgSpecialFloor();
			curOrder=(byte)(i+1);
			orgSpecialFloor.setFloorId(Integer.parseInt(IdArr[i]));
			orgSpecialFloor.setFloorOrder(curOrder);
			list.add(orgSpecialFloor);
		}
		orgSpecialFloorService.updateInBatch(list);
		return HttpStatusCode.CODE_SUCCESS;
	}
	
//	根据ID删除分组商品的活动图片
	@ResponseBody
	@RequestMapping(value = "/deleteProductPic/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer deleteProductPic( Model model,@PathVariable Integer id) {
		orgSpecialFloorProductService.deleteById(id);
		return HttpStatusCode.CODE_SUCCESS;
	}	
	
	
	/**
	 *  锚点详情
	 * @param model
	 * @param session
	 * @param specialId 专题主键
	 * @param id link主键
	 * @return
	 */
	@RequestMapping(value = "/editAnchor/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String editAnchor( Model model,HttpSession session,@PathVariable("id") Integer specialId) {
		List<OrgSpecialLink> orgSpecialLinkList =null;
		if(specialId!=null && specialId!=0){
			OrgSpecialLinkQuery orgSpecialLinkQuery = new OrgSpecialLinkQuery();
			orgSpecialLinkQuery.setSpecialId(specialId);
			orgSpecialLinkQuery.setType(OrgSpecialLinkConstant.LINK_TYPE_ANCHOR);
			orgSpecialLinkList = orgSpecialLinkService.queryList(orgSpecialLinkQuery);
		}else{
			orgSpecialLinkList = new ArrayList<OrgSpecialLink>();
		}
		model.addAttribute("specialId", specialId);
		model.addAttribute("orgSpecialLinkList", orgSpecialLinkList);
		return "special/editAnchor";
	}
	
	
//	 保存锚点
	@RequestMapping(value = "/saveAnchor/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public String saveAnchor( Model model,OrgSpecialLinkForm orgSpecialLinkForm,@PathVariable("id") Integer specialId) {
		orgSpecialLinkService.saveAllAnchor(specialId, orgSpecialLinkForm.getOrgSpecialLinkList());
		return "redirect:/special/list";
	}	
	
	//删除锚点
	@ResponseBody
	@RequestMapping(value = "/deleteAnchor/{id}", method = { RequestMethod.GET,RequestMethod.POST })
	public Integer deleteAnchor( Model model,@PathVariable Integer id) {
		if(id!=0){
			orgSpecialLinkService.deleteById(id);
		}
		return HttpStatusCode.CODE_SUCCESS;
	}
	
}