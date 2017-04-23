package com.kjj.manage.web.controller.shop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.goods.aide.OrgClassConstant;
import com.kjj.commserver.entity.shop.OrgArea;
import com.kjj.commserver.entity.shop.OrgShop;
import com.kjj.commserver.entity.shop.OrgShopBanner;
import com.kjj.commserver.entity.shop.OrgShopPage;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;
import com.kjj.commserver.entity.shop.OrgShopPageFloorProduct;
import com.kjj.commserver.entity.shop.OrgShopRecommand;
import com.kjj.commserver.entity.shop.aide.OrgShopForm;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorProductVo;
import com.kjj.commserver.entity.shop.aide.OrgShopPageFloorVo;
import com.kjj.commserver.entity.shop.aide.OrgShopPageForm;
import com.kjj.commserver.entity.shop.aide.OrgShopPageQuery;
import com.kjj.commserver.service.goods.OrgClassService;
import com.kjj.commserver.service.shop.OrgAreaService;
import com.kjj.commserver.service.shop.OrgShopBannerService;
import com.kjj.commserver.service.shop.OrgShopPageFloorProductService;
import com.kjj.commserver.service.shop.OrgShopPageFloorService;
import com.kjj.commserver.service.shop.OrgShopPageService;
import com.kjj.commserver.service.shop.OrgShopRecommandService;
import com.kjj.commserver.service.shop.OrgShopService;
import com.kjj.commserver.util.FileUtil;
import com.kjj.commserver.util.UUIDUtils;
import com.kjj.manage.constant.HttpStatusCode;
import com.kjj.manage.util.PageReq;

@Controller
@RequestMapping("/shopPage")
public class ShopPageController {
	
	@Resource
	private OrgShopService shopService;
	
	@Resource
	private OrgAreaService orgAreaService;
	
    @Resource
    private OrgShopPageService orgShopPageService;
    
    @Resource
    private OrgClassService orgClassService;
    
    @Resource
    private OrgShopPageFloorService orgShopPageFloorService;
    
    @Resource
    private OrgShopPageFloorProductService orgShopPageFloorProductService;
	
    @Resource
    private OrgShopBannerService orgShopBannerService;
    
    @Resource
    private OrgShopRecommandService orgShopRecommandService;
    
    
	/**
	 * 店铺首页列表
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String pageList(Model model,PageReq pageReq,OrgShopPageQuery query){
		pageReq.setPageSize(10);
		query.setIsdelete(1);// 未删除的记录
		//区域搜索条件
		Page<OrgShopPage> page = orgShopPageService.queryPageList(query, pageReq);
		model.addAttribute("page", page);
		model.addAttribute("query", query);// 保留查询条件

		return "shopPage/shopPageList";
	}
	
	@RequestMapping(value = "/add", method = { RequestMethod.POST,RequestMethod.GET })
	public String addpage(Model model,OrgShopForm shopForm){
		//省
		List<OrgArea> listProvince =  orgAreaService.queryListProvince();
		model.addAttribute("listProvince",listProvince);

		return "shopPage/shopPageAdd";
	}
	
	/**
	 * 保存店铺首页		
	 * @param model
	 * @param shopForm
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/savePage", method = { RequestMethod.POST,RequestMethod.GET })
	public String savePage(Model model,OrgShopPageForm shopPageForm,MultipartHttpServletRequest request,PageReq pageReq) throws Exception {
		
		// 是否删除 1:未删除 0:已经删除
		shopPageForm.setIsdelete(1);
		// 保存店铺首页
		orgShopPageService.add(shopPageForm);
		List<OrgShopBanner> bannerList = new ArrayList<OrgShopBanner>();//banner
		List<OrgShopRecommand> recommandList = new ArrayList<OrgShopRecommand>(); // 推荐商品
		//保存图片
		Iterator<String> it = request.getFileNames();
		int bannerOrder=0;
		while(it.hasNext()){
			String key = it.next();
			String filename = UUIDUtils.create() +".jpg";
			File f = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE +filename);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			if(key.contains("file")){
				if (request.getFile(key).getSize() != 0) {
					FileUtil.copy(request.getFile(key).getInputStream(), new FileOutputStream(f));
					//生成的是banner 图片
					String path = ImageConstant.SHOP_PAGE + filename;
					String url  = request.getParameter("url_"+key.substring(5));
					OrgShopBanner shopBanner = new OrgShopBanner();
					shopBanner.setPageid(shopPageForm.getId());
					shopBanner.setOrgShopBanner(path);
					shopBanner.setOrgShopBannerUrl(url);
					bannerOrder++;
					shopBanner.setOrgShopBannerOrder(bannerOrder+"");
					bannerList.add(shopBanner);
				}
			}
			if(key.contains("f_")){
				
				if (request.getFile(key).getSize() != 0&&key.length()==3) {
					FileUtil.copy(request.getFile(key).getInputStream(), new FileOutputStream(f));
				}
				String filename_ ="";
				File f_ = null;
				
				//获取第二个图片
				if(request.getFile(key+"_") !=null && request.getFile(key+"_").getSize() != 0){
					filename_ = UUIDUtils.create() + ".jpg";
					f_ = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE + filename_);
					//在向下循环一位
					it.next();
					FileUtil.copy(request.getFile(key+"_").getInputStream(), new FileOutputStream(f_));
				}
				//生成的是banner 图片
				String path_1 = ImageConstant.SHOP_PAGE + filename;
				String path_2 ="";
				
				if(filename_.equals("")){
					path_2="";
				}else{
					path_2 = ImageConstant.SHOP_PAGE + filename_;
				}
				String url  = request.getParameter("u_"+key.substring(2));
				
				OrgShopRecommand osr = new OrgShopRecommand();
				
				osr.setPageid(shopPageForm.getId());
				osr.setRecommandImg1(path_1);
				osr.setRecommandImg2(path_2);
				osr.setRecommendImgUrl(url);
				
				recommandList.add(osr);
			}
		}
		// 保存banner
		orgShopBannerService.addInBatch(bannerList);
		
		// 保存宣传产品
		orgShopRecommandService.addInBatch(recommandList);
		
		//保存楼层信息
		//目前最多 8 层
		String floorArrayStr = request.getParameter("floorNumbers");
		if(!StringUtils.isBlank(floorArrayStr)){
			String[] floorArray = floorArrayStr.split(",");
			for(String index : floorArray){
				if(!StringUtils.isBlank(index)){
					int i = Integer.parseInt(index);
					//获取楼层分类
					String classid = request.getParameter("class_"+i);
					if(classid !=null && !classid.equals("")){
						//获取该分类title 图片
						String key = "classtitle_"+i;
						String path = "";
						if (request.getFile(key) !=null &&request.getFile(key).getSize() != 0) {
							String filename = UUIDUtils.create() + ".jpg";
							File f = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE + filename);
							
							if (!f.getParentFile().exists()) {
								f.getParentFile().mkdirs();
							}
							FileUtil.copy(request.getFile(key).getInputStream(), new FileOutputStream(f));
							//生成的是banner 图片
							path= ImageConstant.SHOP_PAGE + filename;
						}
						OrgShopPageFloor ospf = new OrgShopPageFloor();
						ospf.setPageid(shopPageForm.getId());
						ospf.setFloorname(request.getParameter("name_"+i));
						ospf.setFloorNameUrl(request.getParameter("nameurl_"+i));
						ospf.setIsactive(Integer.parseInt(request.getParameter("isActive_"+i)));
						ospf.setPageCategory(Integer.parseInt(classid));
						ospf.setPage1(path);
						ospf.setPageImgUrl(request.getParameter("titleurl_"+i));
						orgShopPageFloorService.add(ospf);
						int numberProduct = Integer.parseInt(request.getParameter("product_"+i+"_Num"));
						// 保存商品
						for(int j=1;j<numberProduct;j++){
							// 商品
							String pid = request.getParameter("product_"+i+"_"+j);
							OrgShopPageFloorProduct orgShopPageFloorProduct = new OrgShopPageFloorProduct();
							
							// 允许不选择商品
							if(pid==null||pid.equals("")){
								orgShopPageFloorProduct.setProductid(-1);
							}else{
								orgShopPageFloorProduct.setProductid(Integer.parseInt(pid));
							}
							orgShopPageFloorProduct.setFloorid(ospf.getFloorid());
							orgShopPageFloorProduct.setType(2); // 普通商品
							orgShopPageFloorProduct.setNickname("");
							orgShopPageFloorProductService.add(orgShopPageFloorProduct);
						}
						int numberRecommand = Integer.parseInt(request.getParameter("recommand_"+i+"_Num"));
						// 保存推荐商品
						for(int j=1;j<numberRecommand;j++){
							// 商品
							String pid = request.getParameter("recommand_" + i + "_" + j);
							String nickname=request.getParameter("nickname_" + i+ "_" + j);
							
							OrgShopPageFloorProduct orgShopPageFloorProduct = new OrgShopPageFloorProduct();
							
							// 允许不选择商品
							if(pid==null||pid.equals("")){
								orgShopPageFloorProduct.setProductid(-1);
							}else{
								orgShopPageFloorProduct.setProductid(Integer.parseInt(pid));
							}
							orgShopPageFloorProduct.setFloorid(ospf.getFloorid());
							orgShopPageFloorProduct.setType(1); // 推荐商品
							orgShopPageFloorProduct.setNickname(nickname);
							orgShopPageFloorProductService.add(orgShopPageFloorProduct);
						}
					}
				}
			}
		}
		return pageList(model,pageReq,new OrgShopPageQuery());
	}

	/**
	 * 准备修改店铺首页		
	 * @param model
	 * @param shopForm
	 * @return
	 */
	@RequestMapping(value = "/editPage", method = { RequestMethod.POST,RequestMethod.GET })
	public String editPage(Model model,OrgShopForm shopForm,Integer pageId){
		
		model.addAttribute("ImageBasePath", ImageConstant.IMAGE_BASE_URL);
		// 获取店铺首页
		OrgShopPage page = orgShopPageService.queryById(pageId);
		model.addAttribute("pageobj", page);
		
		// 获取门店banner
		List<OrgShopBanner> bannerList = orgShopBannerService.queryByPageId(pageId);
		model.addAttribute("blist", bannerList);
		
		// 获取宣传产品信息
		List<OrgShopRecommand> recommandList = orgShopRecommandService.queryByPageId(pageId);
		model.addAttribute("rlist", recommandList);
		
		// 获取楼层列表
		List<OrgShopPageFloorVo> floorList = orgShopPageFloorService.queryByPageIdAsc(pageId);
		for(OrgShopPageFloorVo floor : floorList){
			// 普通商品
			List<OrgShopPageFloorProductVo> comList = orgShopPageFloorProductService.queryCommProductByFloor(floor.getFloorid());
			for(OrgShopPageFloorProductVo p: comList){
				// -1 表示没有给图片指定商品
				if("-1".equals(p.getProductid().toString())){
					p.setGoodsThumb("");
					p.setGoodsName("点击选择商品");
					p.setProductid(null);
				}
			}
			floor.setProductList(comList); 
			
			// 推荐商品
			List<OrgShopPageFloorProductVo> recommList = orgShopPageFloorProductService.queryRecommandProductByFloor(floor.getFloorid()); 
			for(OrgShopPageFloorProductVo p: recommList){
				// -1 表示没有给图片指定商品
				if("-1".equals(p.getProductid().toString())){
					p.setGoodsThumb("");
					p.setGoodsName("点击选择推荐商品");
					p.setProductid(null);
				}
			}
			
			floor.setRecommandList(recommList); 
		}
		
		model.addAttribute("pf", floorList);
		
		// 获取所有一级分类列表
		model.addAttribute("mclass", orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE));
		
		// 展现区域或店铺 1:店铺 0:区域
		if("1".equals(page.getType().toString())){
			OrgShop shop = shopService.queryById(page.getShopId());
			model.addAttribute("shop", shop);
			
			OrgArea area = orgAreaService.queryById(shop.getAreaCode());
			List<OrgArea> listProvince = orgAreaService.queryListByLevel((byte)1);
			model.addAttribute("listProvince",listProvince);
			
			//县
			OrgArea city = orgAreaService.queryById(area.getParentCode());
			OrgArea province = orgAreaService.queryById(city.getParentCode());
			model.addAttribute("provinceCode",province.getCode());
			model.addAttribute("cityCode",city.getCode());
			model.addAttribute("countyCode",area.getCode());
			
			
			List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
			model.addAttribute("listCity",listCity);
			
			List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
			model.addAttribute("listCounty",listCounty);
		} else if("0".equals(page.getType().toString())){
			OrgArea area = orgAreaService.queryById(page.getShopId().toString());
			
			List<OrgArea> listProvince = orgAreaService.queryListByLevel((byte)1);
			model.addAttribute("listProvince",listProvince);
			
			// -1代表全部店铺
			if(!"-1".equals(page.getShopId().toString())){
				if(area.getLevel() == 1){
					//省
					model.addAttribute("provinceCode",area.getCode());
					List<OrgArea> listCity =  orgAreaService.queryListByParentCode(area.getCode());
					model.addAttribute("listCity",listCity);
				}else if(area.getLevel() == 2){
					//市
					OrgArea province = orgAreaService.queryById(area.getParentCode());
					model.addAttribute("provinceCode",province.getCode());
					model.addAttribute("cityCode",area.getCode());
					
					List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
					model.addAttribute("listCity",listCity);
					
					List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(area.getCode());
					model.addAttribute("listCounty",listCounty);
				}else if(area.getLevel() == 3){
					//县
					OrgArea city = orgAreaService.queryById(area.getParentCode());
					OrgArea province = orgAreaService.queryById(city.getParentCode());
					model.addAttribute("provinceCode",province.getCode());
					model.addAttribute("cityCode",city.getCode());
					model.addAttribute("countyCode",area.getCode());
					
					
					List<OrgArea> listCity =  orgAreaService.queryListByParentCode(province.getCode());
					model.addAttribute("listCity",listCity);
					
					List<OrgArea> listCounty =  orgAreaService.queryListByParentCode(city.getCode());
					model.addAttribute("listCounty",listCounty);
				}
			}
		}
		
		
		return "shopPage/shopPageEdit";
	}
	
	/**
	 * 更改店铺首页		
	 * @param model
	 * @param shopForm
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/updatePage", method = { RequestMethod.POST,RequestMethod.GET })
	public String updatePage(Model model,OrgShopPageForm shopPageForm,MultipartHttpServletRequest request,PageReq pageReq) throws Exception {
		// 更新店铺首页
		orgShopPageService.updateByIdSelective(shopPageForm);
		
		// 在不更改图片的情况下，更新banner的url链接
		String bannerIndexsStr = request.getParameter("bannerIndexs");
		String [] bannerIndexs = bannerIndexsStr.split(",");
		for(String index : bannerIndexs){
			if(!StringUtils.isBlank(index)){
				String oldPath = request.getParameter("showimg_"+index + "_");
				if(!StringUtils.isBlank(oldPath)){
					String url = request.getParameter("url_"+index);
					orgShopBannerService.updateBannerUrlByImg(oldPath, url);
				}
			}
		}
		
		
		//  在不更改图片的情况下，更新推荐商品的url链接
		String recommandIndexsStr = request.getParameter("recommandIndexs");
		String [] recommandIndexs = recommandIndexsStr.split(",");
		for(String index : recommandIndexs){
			if(!StringUtils.isBlank(index)){
				String oldPath = request.getParameter("image_"+index);
				if(!StringUtils.isBlank(oldPath)){
					String url = request.getParameter("u_"+index);
					orgShopRecommandService.updateUrlByImg1(oldPath, url);
				}
			}
		}
		
		List<OrgShopBanner> bannerList = new ArrayList<OrgShopBanner>();//banner
		//保存图片
		Iterator<String> it = request.getFileNames();
		//获取宣传产品图片
		String addpath="";
		int bannerOrder=0;
		while(it.hasNext()){
			String key = it.next();
			String filename = UUIDUtils.create() +".jpg";
			File f = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE +filename);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			
			if(key.contains("file")){
				String oldpath = request.getParameter("showimg_"+key.substring(5)+"_");
				bannerOrder++;
				if (request.getFile(key).getSize() != 0) {
					FileUtil.copy(request.getFile(key).getInputStream(), new FileOutputStream(f));
	
					//生成的是banner 图片
					String path = ImageConstant.SHOP_PAGE + filename;
					String url  = request.getParameter("url_"+key.substring(5));
					if(null == oldpath||oldpath.equals("")){
						OrgShopBanner shopBanner = new OrgShopBanner();
						shopBanner.setPageid(shopPageForm.getId());
						shopBanner.setOrgShopBanner(path);
						shopBanner.setOrgShopBannerUrl(url);
						shopBanner.setOrgShopBannerOrder(bannerOrder+"");
						bannerList.add(shopBanner);
					} else {
						orgShopBannerService.updateBanner(oldpath,url, path,bannerOrder+"");
					}
				}else{
					orgShopBannerService.updateBanner(oldpath,bannerOrder+"");
				}
				
			}
			String path_1 ="";
			String path_2 ="";

			String oldpath1="";
			String oldpath2="";
			
			if(key.contains("f_")){
				
				OrgShopRecommand osr = new OrgShopRecommand();
				
				if (request.getFile(key).getSize() != 0&&key.length()==3) {
					
					InputStream inputStream = request.getFile(key).getInputStream();
					FileOutputStream outputStream = new FileOutputStream(f);
					byte[] buf = new byte[1024];
					int length = 0;
					while ((length = inputStream.read(buf)) != -1) {
						outputStream.write(buf, 0, length);
					}
					outputStream.close();
					inputStream.close();
					
					path_1 = ImageConstant.SHOP_PAGE + filename;
					
					oldpath1 = request.getParameter("image_"+key.substring(2));
					String url  = request.getParameter("u_"+key.substring(2));
					
					if(oldpath1.equals("")&&(request.getFile(key+"_")==null||request.getFile(key+"_").getSize()==0)){
						osr.setPageid(shopPageForm.getId());
						osr.setRecommandImg1(path_1);
						osr.setRecommendImgUrl(url);
						osr.setRecommandImg2(path_2);
						orgShopRecommandService.add(osr);
					} else if(!oldpath1.equals("")){
						orgShopRecommandService.updateRecommandImg1(oldpath1, path_1, url);
					}
					
					if(oldpath1.equals("")&&request.getFile(key+"_")!=null){
						addpath=path_1;
					}
					
				}
				String filename_ ="";
				File f_ = null;
				
				//获取第二个图片
				if(request.getFile(key) !=null && request.getFile(key).getSize() !=0&&key.length()==4){
					filename_ = UUIDUtils.create() + ".jpg";
					f_ = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE  + filename_);
					
					InputStream inputStream = request.getFile(key).getInputStream();
					FileOutputStream outputStream = new FileOutputStream(f_);
					byte[] buf = new byte[1024];
					int length = 0;
					while ((length = inputStream.read(buf)) != -1) {
						outputStream.write(buf, 0, length);
					}
					outputStream.close();
					inputStream.close();
					
					path_2 = ImageConstant.SHOP_PAGE + filename_;

					oldpath2 = request.getParameter("image_"+key.substring(2,3) + "_");
					
					String url  = request.getParameter("u_"+key.substring(2,3));
					if(oldpath2.equals("")){
						osr.setPageid(shopPageForm.getId());
						osr.setRecommandImg1(addpath);
						osr.setRecommandImg2(path_2);
						osr.setRecommendImgUrl(url);
						orgShopRecommandService.add(osr);
					} else {						
						orgShopRecommandService.updateRecommandImg2(oldpath2, path_2, url);
					}
				}
			}
		}
		// 保存banner
		orgShopBannerService.addInBatch(bannerList);
		
		// 删除原来的楼层
		orgShopPageFloorService.deleteFloorByPageId(shopPageForm.getId());
		
		//目前最多 8 层
		String floorArrayStr = request.getParameter("floorNumbers");
		if(!StringUtils.isBlank(floorArrayStr)){
			String[] floorArray = floorArrayStr.split(",");
			for(String index : floorArray){
				if(!StringUtils.isBlank(index)){
					int i = Integer.parseInt(index);
					//获取楼层分类
					String classid = request.getParameter("class_"+i);
					if(classid !=null && !classid.equals("")){
						//获取该分类title 图片
						String key = "classtitle_"+i;
						String path = "";
						if (request.getFile(key) !=null &&request.getFile(key).getSize() != 0) {
							String filename = UUIDUtils.create() + ".jpg";
							File f = new  File(ImageConstant.IMAGE_BASE_PATH + ImageConstant.SHOP_PAGE + filename);
							
							if (!f.getParentFile().exists()) {
								f.getParentFile().mkdirs();
							}
							
							FileUtil.copy(request.getFile(key).getInputStream(), new FileOutputStream(f));
							
							//生成的是banner 图片
							path= ImageConstant.SHOP_PAGE + filename;
						}
						OrgShopPageFloor ospf = new OrgShopPageFloor();
						ospf.setPageid(shopPageForm.getId());
						ospf.setFloorname(request.getParameter("name_"+i));
						ospf.setFloorNameUrl(request.getParameter("nameurl_"+i));
						ospf.setIsactive(Integer.parseInt(request.getParameter("isActive_"+i)));
						ospf.setPageCategory(Integer.parseInt(classid));
						
						if(path.equals("")){
							ospf.setPage1(request.getParameter("showtitleimg_"+i));
						}else{
							ospf.setPage1(path);
						}
						
						ospf.setPageImgUrl(request.getParameter("titleurl_"+i));
						orgShopPageFloorService.add(ospf);
						int numberProduct = Integer.parseInt(request.getParameter("product_"+i+"_Num"));
						// 保存商品
						for(int j=1;j<numberProduct;j++){
							// 商品
							String pid = request.getParameter("product_"+i+"_"+j);
							OrgShopPageFloorProduct orgShopPageFloorProduct = new OrgShopPageFloorProduct();
							
							// 允许不选择商品
							if(pid==null||pid.equals("")){
								orgShopPageFloorProduct.setProductid(-1);
							}else{
								orgShopPageFloorProduct.setProductid(Integer.parseInt(pid));
							}
							orgShopPageFloorProduct.setFloorid(ospf.getFloorid());
							orgShopPageFloorProduct.setType(2); // 普通商品
							orgShopPageFloorProduct.setNickname("");
							orgShopPageFloorProductService.add(orgShopPageFloorProduct);
						}
						int numberRecommand = Integer.parseInt(request.getParameter("recommand_"+i+"_Num"));
						// 保存推荐商品
						for(int j=1;j<numberRecommand;j++){
							// 商品
							String pid = request.getParameter("recommand_" + i + "_" + j);
							String nickname=request.getParameter("nickname_" + i+ "_" + j);
							
							OrgShopPageFloorProduct orgShopPageFloorProduct = new OrgShopPageFloorProduct();
							
							// 允许不选择商品
							if(pid==null||pid.equals("")){
								orgShopPageFloorProduct.setProductid(-1);
							}else{
								orgShopPageFloorProduct.setProductid(Integer.parseInt(pid));
							}
							orgShopPageFloorProduct.setFloorid(ospf.getFloorid());
							orgShopPageFloorProduct.setType(1); // 推荐商品
							orgShopPageFloorProduct.setNickname(nickname);
							orgShopPageFloorProductService.add(orgShopPageFloorProduct);
						}
					}
				}
			}
		}
		return pageList(model,pageReq,new OrgShopPageQuery());
	}
	
	
	/**
	 * 验证店铺首页是否唯一
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/pageIsOnly", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> pageIsOnly(OrgShopPageQuery query,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		
		Integer pageId = null;
		if(null != query.getId()){
			pageId = query.getId();
			query.setId(null);
		}
		query.setIsdelete(1); // 未删除的记录
		List<OrgShopPage> list = orgShopPageService.queryList(query);
		
		// 新建时有重复记录
		if(null == pageId && list.size() > 0){
			result.put("code", HttpStatusCode.CODE_ERROR);
			return result;
		}
		
		// 修改时有重复记录
		if(null != pageId){
			if(list.size() > 1){
				result.put("code", HttpStatusCode.CODE_ERROR);
				return result;
			}
			if(list.size() == 1){
				OrgShopPage p = (OrgShopPage)list.get(0);
				if(!pageId.toString().equals(p.getId().toString())){
					result.put("code", HttpStatusCode.CODE_ERROR);
					return result;
				}
			}
		}
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	
	/**
	 * 删除店铺首页
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteShopPage(Integer pageId,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgShopPageService.deletePage(pageId);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 删除banner
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/deleteBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteBanner(String imgPath,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgShopBannerService.deleteBannerByImg(imgPath);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	/**
	 * 删除宣传商品
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/deleteRecommand", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> deleteRecommand(String imgPath,Model model,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		orgShopRecommandService.deleteRecommandByImg1(imgPath);
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		return result;
	}
	
	
	
	/**
	 * 商品分类，添加或修改页面使用
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/shopClass", method = { RequestMethod.POST,RequestMethod.GET })
	public Map<String, Object> shopclass(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		result.put("list", orgClassService.queryListByLevel(OrgClassConstant.LEVEL_ONE));
		return result;
	}
	
	public static void main(String [] args){
		for(int i = 0; i < 100; i++){
			System.out.println(new Date().getTime());
		}
	}
}
