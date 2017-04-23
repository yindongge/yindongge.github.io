package com.kjj.touch.web.controller.goods;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductDetailAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.goods.aide.OrgProductItemConstant;
import com.kjj.commserver.entity.goods.aide.OrgProductItemQuery;
import com.kjj.commserver.entity.goods.aide.OrgProductLinkSalespecQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.discount.OrgDiscountAllowService;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.goods.OrgProductItemService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.touch.constant.SessionConstant;
import com.kjj.touch.util.PathUtil;
import com.kjj.touch.util.QrcodeUtil;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Resource
	OrgProductItemService orgProductItemService;
	
	@Resource
	OrgUsersService orgUsersService;	

	@Resource
	OrgClassService orgClassService;
	
	@Resource
	OrgDiscountAllowService orgDiscountAllowService;
	
	@RequestMapping(value="/{goodsId}/{flag}",method={RequestMethod.GET,RequestMethod.POST})
	public String detail(Model model,HttpSession session,HttpServletRequest request, HttpServletResponse response,@PathVariable Integer flag,
			OrgProductLinkSalespecQuery orgProductLinkSalespecQuery){
		if(flag.equals(1)){
			model.addAttribute("flag", 1);
		}

		OrgUsersSession orgUsersSession = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		
		//此sku已删除，则根据goodSn去获取最新的sku，若获取不到，则以下架形式展示
		OrgProductItem orgProductItem = orgProductItemService.queryVoById(orgProductLinkSalespecQuery.getGoodsId());
		if(orgProductItem.getIsDelete()==OrgProductItemConstant.STAUTS_DELETE){
			OrgProductItemQuery query=new OrgProductItemQuery();
			query.setGoodsSn(orgProductItem.getGoodsSn());
			query.setIsDelete(OrgProductItemConstant.STAUTS_NOT_DELETE);
			OrgProductItem itemNew = orgProductItemService.queryOne(query);
			if(itemNew!=null){
				orgProductLinkSalespecQuery.setGoodsId(itemNew.getGoodsId());
			}
		}
		
		//分类信息
	    List<OrgClass> listClass = orgClassService.queryListShowAsTree();
	    model.addAttribute("listClass", listClass);
		//商品信息
		OrgProductItemAll orgProductItemAll = orgProductItemService.query4View(orgUsersSession,orgProductLinkSalespecQuery.getGoodsId());
		OrgProductDetailAll orgProductDetailAll = orgProductItemService.queryDetail4View(orgProductLinkSalespecQuery.getGoodsId());
		model.addAttribute("orgProductLinkSalespecQuery", orgProductLinkSalespecQuery);
		model.addAttribute("orgProductItemAll", orgProductItemAll);
		model.addAttribute("orgProductDetailAll", orgProductDetailAll);
		return "/item/detail";
	
	}
	
	//商品详情二维码
	@RequestMapping(value = "/code/{itemId}", method = { RequestMethod.GET,RequestMethod.POST })
	public void code(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer itemId) {
		String basePath = PathUtil.getBasePath(request);
		String codeUrl=basePath+"/item/"+itemId;
		QrcodeUtil.encodeQrcode(codeUrl, response);
	}

}

