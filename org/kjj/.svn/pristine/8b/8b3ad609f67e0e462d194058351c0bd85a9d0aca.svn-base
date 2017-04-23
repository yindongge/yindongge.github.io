package com.kjj.pc.web.controller.account;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.OrgAccountDeposit;
import com.kjj.commserver.entity.account.OrgAccountDepositRecords;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositApplyConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsVo;
import com.kjj.commserver.entity.account.aide.OrgAccountDepositTransferForm;
import com.kjj.commserver.entity.user.OrgEnterprise;
import com.kjj.commserver.entity.user.OrgEnterpriseUser;
import com.kjj.commserver.entity.user.OrgUserActive;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseUserVo;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.account.OrgAccountDepositRecordsService;
import com.kjj.commserver.service.account.OrgAccountDepositService;
import com.kjj.commserver.service.user.OrgEnterpriseService;
import com.kjj.commserver.service.user.OrgEnterpriseUserService;
import com.kjj.commserver.service.user.OrgUserActiveService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.commserver.util.MD5;
import com.kjj.commserver.util.SmsUtil;
import com.kjj.pc.constant.HttpStatusCode;
import com.kjj.pc.constant.SessionConstant;
import com.kjj.pc.util.PageReq;

@Controller
@RequestMapping("/accountDeposit")
public class AccountDepositController {
	@Resource
	private OrgAccountDepositRecordsService orgAccountDepositRecordsService;
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	@Resource
	private OrgUserActiveService orgUserActiveService;
	@Resource
	private OrgUsersService orgUsersService;
	@Resource
	private OrgEnterpriseService orgEnterpriseService;
	@Resource
	private OrgEnterpriseUserService orgEnterpriseUserService;
	
	@RequestMapping(value = "/list", method = { RequestMethod.GET,RequestMethod.POST })
	public String list(HttpSession session,Model model,PageReq pageReq,OrgAccountDepositRecords query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		pageReq.setPageSize(10);
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		query.setUserId(user.getOrgUsers().getUserId());
		
		model.addAttribute("levelType",user.getOrgUsers().getLevelType()); // 保存用户类型，用于控制“预存款转账”是否显示
		
		OrgAccountDeposit accountDeposit = orgAccountDepositService.queryById(user.getOrgUsers().getUserId());
		model.addAttribute("accountDeposit",accountDeposit);
		
		Page<OrgAccountDepositRecords> page = orgAccountDepositRecordsService.queryPageList(query, pageReq);
		model.addAttribute("page",page);
		model.addAttribute("query",query);
		
		//前台显示
		// TODO 添加其他操作类型时注意修改
		OrgAccountDepositRecordsVo recordsVo = null;
		for(OrgAccountDepositRecords accountDepositRecords : page.getContent()){
			recordsVo = (OrgAccountDepositRecordsVo)accountDepositRecords;
			recordsVo.setTypeShow(OrgAccountDepositApplyConstant.typeMap.get(String.valueOf(recordsVo.getType())));
			recordsVo.setAmountShow(recordsVo.getFundAmount().add(recordsVo.getAllowanceAmount().add(recordsVo.getFrozenAmount())));
			if(recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_MANUAL_ADD){
				//手动增加
				if(recordsVo.getFrozenAmount().compareTo(BigDecimal.ZERO) > 0){
					recordsVo.setTypeShow("冻结余额-增加");
				}else{
					recordsVo.setTypeShow("可用余额-增加");
				}
			}else if(recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_MANUAL_DEC){
				//手动减少
				if(recordsVo.getFrozenAmount().compareTo(BigDecimal.ZERO) < 0){
					recordsVo.setTypeShow("冻结余额-减少");
				}else{
					recordsVo.setTypeShow("可用余额-减少");
				}
			}else if(recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_MANUAL_FROZEN || recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_SYSTEM_FROZEN){
				//冻结
				recordsVo.setTypeShow("可用余额-转出到冻结余额");
				recordsVo.setAmountShow(recordsVo.getFrozenAmount());
			}else if(recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_MANUAL_UNFROZEN || recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_SYSTEM_UNFROZEN){
				//解冻
				recordsVo.setTypeShow("冻结余额-转出到可用余额");
				recordsVo.setAmountShow(recordsVo.getFundAmount().add(recordsVo.getAllowanceAmount()));
			}else if(recordsVo.getType() == OrgAccountDepositApplyConstant.TYPE_MANUAL_TRANSFER){
				// 转账
				recordsVo.setTypeShow("转账-预存款转账");
				recordsVo.setAmountShow(recordsVo.getAllowanceAmount());
			}
		}
		
		// 字典翻译
		model.addAttribute("originMap", OrgAccountDepositRecordsConstant.originMap); // 来源
		return "accountDeposit/list";
	}
	
	
	
	@RequestMapping(value = "/findPasswordInit", method = {RequestMethod.GET,RequestMethod.POST })
	public String findPasswordInit(Model model,HttpSession session) {
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		if(StringUtils.isNoneBlank(user.getOrgUsers().getMobilePhone())){
			return "accountDeposit/findPassword";
		}else{
			return "redirect:/security/bindPhone";
		}
		
	}
	
	@RequestMapping(value="/updatePasswordInit",method={RequestMethod.GET,RequestMethod.POST})
	public String updatePasswordInit(Model model,HttpSession session){
		return "accountDeposit/updatePassword";
	}
	
	@RequestMapping(value="/setPasswordInit",method={RequestMethod.GET,RequestMethod.POST})
	public String setPasswordInit(Model model,HttpSession session){
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		if(StringUtils.isNoneBlank(user.getOrgUsers().getMobilePhone())){
			return "accountDeposit/setPassword";
		}else{
			return "redirect:/security/bindPhone";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatePassword")
	public Map<String,Object> updatePassword(Model model,HttpSession session,OrgAccountDeposit orgAccountDeposit,String oldPassword) {
		Map<String,Object> map = new HashMap<String,Object>();
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		OrgAccountDeposit accountDeposit = orgAccountDepositService.queryById(user.getOrgUsers().getUserId());
		
		MD5 md5 = new MD5();
		String oldPass = null;
		if(StringUtils.isNotBlank(oldPassword)){
			 oldPass = md5.getMD5ofStr(oldPassword);
		}
		if(!accountDeposit.getPayPassword().equals(oldPass)){//旧密码不正确不可以提交
			map.put("code", HttpStatusCode.CODE_ERROR);
			map.put("desc", "旧密码不正确!");
			return map;
		}else{
			String payPassword = md5.getMD5ofStr(orgAccountDeposit.getPayPassword());
			orgAccountDeposit.setPayPassword(payPassword);
			orgAccountDepositService.updateByIdSelective(orgAccountDeposit);
			map.put("code",HttpStatusCode.CODE_SUCCESS);//旧密码正确可以提交
			return map;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/findAccountPassword")
	public Map<String,Object> findAccountPassword(HttpSession session,OrgAccountDeposit orgAccountDeposit,String verifycode){
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		final int CODE_ERROR_IDENTITY = 401;
		if(StringUtils.isBlank(verifycode) || verifycode.length() != 4){
			mapResult.put("code", CODE_ERROR_IDENTITY);
			mapResult.put("desc", "验证码错误!");
			return mapResult;
		}else{
			OrgUserActive orgUserActive = orgUserActiveService.queryLastByMobilePhone(user.getOrgUsers().getMobilePhone());
			if( orgUserActive == null){
				mapResult.put("code",CODE_ERROR_IDENTITY);
				mapResult.put("desc", "验证码错误!");
				return mapResult;
			}else{
				if(orgUserActive.getVcode().equals(verifycode)){
					//判断是否过期 目前三十分钟过期
					if (System.currentTimeMillis() - orgUserActive.getCreatetime().getTime() > 30 * 60 * 1000){
						//验证码过期
						mapResult.put("code",CODE_ERROR_IDENTITY);
						mapResult.put("desc", "验证码过期!");
						return mapResult;
					}
				}else{
					mapResult.put("code",CODE_ERROR_IDENTITY);
					mapResult.put("desc", "验证码错误!");
					return mapResult;
				}
			}
		}
		MD5 md5 = new MD5();
		String payPassword = md5.getMD5ofStr(orgAccountDeposit.getPayPassword());
		orgAccountDeposit.setPayPassword(payPassword);
		orgAccountDepositService.updateByIdSelective(orgAccountDeposit);
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
	
	/**
	 * 企业关联会员列表-转账
	 * @param session
	 * @param model
	 * @param pageReq
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/transferUserlist", method = { RequestMethod.GET,RequestMethod.POST })
	public String transferUserlist(HttpSession session,Model model,PageReq pageReq,OrgEnterpriseUser query){
		
		pageReq.setSort(new Sort(Direction.DESC,"t.id"));
		
		// 转账列表的人数默认为50
		if(50 > pageReq.getPageSize()) {
			pageReq.setPageSize(50);
		}
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		OrgEnterprise oe = orgEnterpriseService.queryByUserId(user.getOrgUsers().getUserId());
		query.setEnterpriseId(oe.getEnterpriseId());
		
		
		Page<OrgEnterpriseUserVo> page = orgEnterpriseUserService.queryPageList(query, pageReq);
		model.addAttribute("page",page);
		
		OrgAccountDeposit accountDeposit = orgAccountDepositService.queryById(user.getOrgUsers().getUserId());
		model.addAttribute("accountDeposit",accountDeposit);
		
		return "accountDeposit/transferUserList";
	}
	
	
	
	/**
	 * 企业会员转账
	 * @param session
	 * @param targetAccount
	 * @param amount
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/enterpriseUserTransfer")
	public Map<String,Object> enterpriseTransfer(HttpSession session,String targetAccount, BigDecimal amount, String payPassword){
		//获取用户
		OrgUsersSession user = (OrgUsersSession) session.getAttribute(SessionConstant.SESSION_USER);
		Map<String,Object> mapResult = new HashMap<String,Object>();
		
		// 验证支付密码
		OrgAccountDeposit accountDeposit = orgAccountDepositService.queryById(user.getOrgUsers().getUserId());
		MD5 md5 = new MD5();

		if(StringUtils.isBlank(payPassword) || !md5.getMD5ofStr(payPassword).equals(accountDeposit.getPayPassword())){
			OrgAccountDeposit updateAD = new OrgAccountDeposit();
			updateAD.setUserId(accountDeposit.getUserId());
			
			// 将错误次数加1，判断是否累计三次
			updateAD.setErrorNum(accountDeposit.getErrorNum()+1);
			
			int cen = updateAD.getErrorNum();
			if(cen >= 3){
				updateAD.setStatus(OrgAccountDepositConstant.STATUS_INVALID);
				orgAccountDepositService.updateByIdSelective(updateAD);
				mapResult.put("code","600"); // 代表支付账号锁定
				return mapResult;
			} else {
				orgAccountDepositService.updateByIdSelective(updateAD);
			}
			
			
			mapResult.put("code","300"); // 代表支付密码错误
			return mapResult;
		}
		
		String[] accounts = targetAccount.split(",");
		
		List<OrgAccountDepositTransferForm> transfers = new ArrayList<OrgAccountDepositTransferForm>();
		
		
		for(String idAndAmount : accounts){
			OrgAccountDepositTransferForm tf = new OrgAccountDepositTransferForm();
			
			String[] item = idAndAmount.split("-");
			
			if(!StringUtils.isBlank(item[0]) && !StringUtils.isBlank(item[1])){
				tf.setUserId(Integer.parseInt(item[0]));
				tf.setAmount(new BigDecimal(item[1]));
				transfers.add(tf);
			}
		}
		
		Map<String, Object> result = orgAccountDepositService.updateByAllowanceTransfer(OrgAccountDepositRecordsConstant.ORIGIN_ONLINE_SHOP, user.getOrgUsers().getUserId(), amount, transfers);
		BigDecimal currentAmont = (BigDecimal)result.get("outAccountAmount");
		
		//***************发送短信**************
		// 先给企业用户发短信
		SmsUtil.sendAllowanceTransfer("out", user.getOrgUsers().getMobilePhone(), amount, currentAmont);
		// 再给转账的用户发短信
		for(OrgAccountDepositTransferForm odt : transfers){
			SmsUtil.sendAllowanceTransfer("in", odt.getMobilePhone(), odt.getAmount(), odt.getBalance());
		}
		
		
		mapResult.put("code",HttpStatusCode.CODE_SUCCESS);
		return mapResult;
	}
}