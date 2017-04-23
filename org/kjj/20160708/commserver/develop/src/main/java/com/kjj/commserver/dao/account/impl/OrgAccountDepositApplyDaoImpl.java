package com.kjj.commserver.dao.account.impl;

import com.kjj.commserver.dao.account.OrgAccountDepositApplyDao;
import com.kjj.commserver.entity.account.OrgAccountDepositApply;
import com.kjj.core.dao.BaseDaoImpl;

import org.springframework.stereotype.Repository;

@Repository
public class OrgAccountDepositApplyDaoImpl extends BaseDaoImpl<OrgAccountDepositApply, Integer> implements OrgAccountDepositApplyDao {
	private static final String SQL_ID_DEPOSIT_APPLY_CODE_SEQ = "selectDepositApplyCodeSeq";
	
	@Override
	public String queryApplyCodeSeq() {
		Long seq = selectCount(null, SQL_ID_DEPOSIT_APPLY_CODE_SEQ);
		String sb = String.valueOf(seq);
		
		while(true){
			// 以“0”补位
			if(sb.length() < 4){
				sb = "0" + sb;
			} else {
				break;
			}
		}
		
		return (sb);
	}
}