package com.kjj.commserver.service.user.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.user.OrgEnterpriseEasyInvitationDao;
import com.kjj.commserver.entity.user.OrgEnterpriseEasyInvitation;
import com.kjj.commserver.entity.user.aide.OrgEnterpriseEasyInvitationQuery;
import com.kjj.commserver.service.user.OrgEnterpriseEasyInvitationService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgEnterpriseEasyInvitationServiceImpl extends BaseServiceImpl<OrgEnterpriseEasyInvitation, Integer> implements OrgEnterpriseEasyInvitationService {
    @Resource
    private OrgEnterpriseEasyInvitationDao orgEnterpriseEasyInvitationDao;

    @Override
    protected BaseDao<OrgEnterpriseEasyInvitation, Integer> getBaseDao() {
        return orgEnterpriseEasyInvitationDao;
    }

	@Override
	public String createInvitationCode() {
		
		// 生成一个6位的数字编码
		String newCode = null;
		while(true) {
			String code = String.valueOf(nextInt(100000,999999));

			StringBuffer sb = new StringBuffer(code);
			for(int j = 0; j < 6; j++){
				int max=5;
				int min=0;
				Random random = new Random();
				int one = random.nextInt(max)%(max-min+1) + min;
				
				int two = random.nextInt(max)%(max-min+1) + min;
				
				char oneChar = sb.charAt(one);
				
				sb.setCharAt(one,sb.charAt(two));
				sb.setCharAt(two, oneChar);
			}
			
			// 验证编码是否存在,如果存在则重新生成，否则退出
			OrgEnterpriseEasyInvitationQuery query = new OrgEnterpriseEasyInvitationQuery();
			query.setCode(sb.toString());
			List< OrgEnterpriseEasyInvitation> invitationList = this.queryList(query);
			
			if(invitationList.size() < 1){
				newCode = sb.toString();
				break;
			}
			
		}
		
		return newCode;
	}

	private static int nextInt(final int min, final int max) {
		Random rand = new Random(); 
	    int tmp = Math.abs(rand.nextInt());
	    return tmp % (max - min + 1) + min;
	}

	@Override
	public OrgEnterpriseEasyInvitation lockQueryByInvitationCode(String code) {
		OrgEnterpriseEasyInvitationQuery query = new OrgEnterpriseEasyInvitationQuery();
		query.setCode(code);
		query.setSelect4Update(true);
		return queryOne(query);
	}
}