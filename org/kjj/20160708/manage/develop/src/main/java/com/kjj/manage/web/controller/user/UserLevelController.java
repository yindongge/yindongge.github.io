package com.kjj.manage.web.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.user.OrgUserLevel;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.service.user.OrgUserLevelService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.manage.constant.HttpStatusCode;

@Controller
@RequestMapping("userlevel")
public class UserLevelController {
	@Resource
	private OrgUserLevelService orgUserLevelService;
	
	@Resource
	private OrgUsersService orgUsersService;
	
	/**
	 * 会员级别列表
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model,HttpServletRequest request, HttpServletResponse response){
		
		List<OrgUserLevel> userLevels = orgUserLevelService.queryList(new OrgUserLevel()); 

		model.addAttribute("userLevels", userLevels);
		
		return "user/levelList";
	}
	/**
	 * 与线下同步 Ajax
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/offlineSync", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> offlineSync(Model model,HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> result=new HashMap<String, Object>();

		String code = orgUserLevelService.updateLevelBySync();

		result.put("code", code);
		
		return result;
		
	}
	
	/**
	 * 修改前的单个等级信息
	 * @param model
	 * @param request
	 * @param levelId
	 * @return
	 */
	@RequestMapping(value ="/findLevel", method = { RequestMethod.GET, RequestMethod.POST })
	public String findLevel(Model model,HttpServletRequest request, String levelId){
		
		OrgUserLevel userLevel = orgUserLevelService.queryById(levelId);
		
		model.addAttribute("userLevel", userLevel);
		
		return "user/levelEdit";
	}
	
	/**
	 * 保存修改后的会员级别信息
	 * @param model
	 * @param orgUserLevel
	 * @param request
	 * @return
	 */	
	@ResponseBody
	@RequestMapping(value ="/save", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> save(Model model,OrgUserLevel orgUserLevel,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		OrgUserLevel userLevel = orgUserLevelService.queryById(orgUserLevel.getLevelId());
		
		// 验证同一个类型下是否有相同的排序位置
		OrgUserLevel query = new OrgUserLevel();
		query.setLevelType(orgUserLevel.getLevelType());
		query.setLevelOrder(orgUserLevel.getLevelOrder());
		OrgUserLevel t = orgUserLevelService.queryOne(query);
		if(null != t && !t.getLevelId().equals(orgUserLevel.getLevelId())){
			resultMap.put("code", "600"); // 600代表同一个类型下有相同的排序位置
			return resultMap;
		}
		
		userLevel.setConsumeTop(orgUserLevel.getConsumeTop());   // 消费上限
		userLevel.setConsumeDown(orgUserLevel.getConsumeDown()); // 消费下限
		//userLevel.setIntegral(orgUserLevel.getIntegral());       // 积分
		userLevel.setLevelType(orgUserLevel.getLevelType());     // 类型
		userLevel.setLevelOrder(orgUserLevel.getLevelOrder());   // 排序
		userLevel.setDiscount(orgUserLevel.getDiscount());       // 折扣
		
		orgUserLevelService.updateById(userLevel);
		
		resultMap.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return resultMap;
	}
	
	/**
	 * 准备新增
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/preAdd", method = { RequestMethod.GET,RequestMethod.POST })
	public String preAdd(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "user/levelAdd";
	}
	
	/**
	 * 保存新增
	 * @param orgUserLevel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/add", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> add(OrgUserLevel orgUserLevel){
		Map<String, Object> result = new HashMap<String, Object>();
		
		// 验证id是否存在,如果存在就返回错误
		OrgUserLevel query = new OrgUserLevel();
		query.setLevelId(orgUserLevel.getLevelId());
		if(null != orgUserLevelService.queryOne(query)){
			result.put("code", "300"); // 300代表唯一标识重复
			return result;
		}
		// 验证levelName是否存在，如果存在就返回错误
		query = new OrgUserLevel();
		query.setLevelName(orgUserLevel.getLevelName());
		if(null != orgUserLevelService.queryOne(query)){
			result.put("code", "400"); // 400代表级别名称重复
			return result;
		}
		
		// 验证同一个类型下是否有相同的排序位置
		query = new OrgUserLevel();
		query.setLevelType(orgUserLevel.getLevelType());
		query.setLevelOrder(orgUserLevel.getLevelOrder());
		if(null != orgUserLevelService.queryOne(query)){
			result.put("code", "600"); // 600代表同一个类型下有相同的排序位置
			return result;
		}

		orgUserLevelService.add(orgUserLevel);

		result.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return result;
	}
	
	/**
	 * 删除会员级别
	 * @param levelId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> add(String levelId){
		Map<String, Object> result = new HashMap<String, Object>();
		
		OrgUsers query = new OrgUsers();
		query.setLevelId(levelId);
		List<OrgUsers> users = orgUsersService.queryList(query);
		
		if(users.size() > 0){
			result.put("code", "300"); // 代表该会议级别已经使用
			return result;
		}
		
		orgUserLevelService.deleteById(levelId);
		
		result.put("code", HttpStatusCode.CODE_SUCCESS);
		
		return result;
	}
}
