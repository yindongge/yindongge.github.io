package com.kjj.manage.web.controller.account;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjj.commserver.entity.account.aide.OrgAccountDepositRecordsConstant;
import com.kjj.commserver.service.account.OrgAccountDepositService;


@Controller
@RequestMapping("accountDeposit")
public class AccountDepositController {
	
	@Resource
	private OrgAccountDepositService orgAccountDepositService;
	
	/**
	 * 查询接口
	 * @param userCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/queryUserAccount", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> queryUserAccount(String userCode){
		return orgAccountDepositService.queryUserAccount(userCode);
	}
	
	/**
	 * 扣款接口
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/chargeUserAccount", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> chargeUserAccount(String userCode, BigDecimal amount, String password, String sc){
		return orgAccountDepositService.updateAddOrder(OrgAccountDepositRecordsConstant.ORIGIN_RUIXING,userCode,amount,password,sc);
	}
	
	/**
	 * 退款接口
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @param qc
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/refundUserAccount", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> refundUserAccount(String userCode, BigDecimal amount, String sc, String qc){
		return orgAccountDepositService.updateAddRefund(OrgAccountDepositRecordsConstant.ORIGIN_RUIXING,userCode,amount,sc,qc);
	}
	
	/**
	 * 扣款接口
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/chargeUserAccount4CheBang", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> chargeUserAccount4CheBang(String userCode, BigDecimal amount, String password, String sc){
		return orgAccountDepositService.updateAddOrder(OrgAccountDepositRecordsConstant.ORIGIN_CHEBANGAPP,userCode,amount,password,sc);
	}
	
	
	/**
	 * 退款接口
	 * @param userCode
	 * @param amount
	 * @param sc
	 * @param qc
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/refundUserAccount4CheBang", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> refundUserAccount4CheBang(String userCode, BigDecimal amount, String sc, String qc){
		return orgAccountDepositService.updateAddRefund(OrgAccountDepositRecordsConstant.ORIGIN_CHEBANGAPP,userCode,amount,sc,qc);
	}
}
