package com.kjj.commserver.service.consult.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kjj.commserver.dao.consult.OrgConsultAnswerDao;
import com.kjj.commserver.entity.consult.OrgConsultAnswer;
import com.kjj.commserver.entity.consult.OrgConsultProblem;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerConstant;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerQuery;
import com.kjj.commserver.entity.consult.aide.OrgConsultAnswerVo;
import com.kjj.commserver.entity.consult.aide.OrgConsultProblemConstant;
import com.kjj.commserver.entity.system.OrgAdminUser;
import com.kjj.commserver.entity.user.OrgUsers;
import com.kjj.commserver.service.consult.OrgConsultAnswerService;
import com.kjj.commserver.service.consult.OrgConsultProblemService;
import com.kjj.commserver.service.system.OrgAdminUserService;
import com.kjj.commserver.service.user.OrgUsersService;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgConsultAnswerServiceImpl extends BaseServiceImpl<OrgConsultAnswer, Integer> implements OrgConsultAnswerService {
    @Resource
    private OrgConsultAnswerDao orgConsultAnswerDao;
    @Resource
    private OrgAdminUserService orgAdminUserService;
    @Resource
    OrgUsersService orgUsersService;
    @Resource
    OrgConsultProblemService orgConsultProblemService;
    
    @Override
    protected BaseDao<OrgConsultAnswer, Integer> getBaseDao() {
        return orgConsultAnswerDao;
    }

	@Override
	public List<OrgConsultAnswer> queryByConsultProblemIds(
			Collection<Integer> consultProblemIds) {
		OrgConsultAnswerQuery query = new OrgConsultAnswerQuery();
		query.setConsultProblemIds(consultProblemIds);
		return queryList(query);
	}

	@Override
	public List<OrgConsultAnswerVo> queryByCousultAnswer(Integer consultProblemId) {
		OrgConsultAnswerQuery query = new OrgConsultAnswerQuery();
		query.setConsultProblemId(consultProblemId);
		List<OrgConsultAnswerVo> list = queryList(query);
		for(OrgConsultAnswerVo item:list){
			Byte userType = item.getCreateUserType();
			//userType 1时创建用户为后台用户 0时创建用户为前台用户
			if(userType == OrgConsultAnswerConstant.USER_TYPE_ADMIN){
				OrgAdminUser adminUser = orgAdminUserService.queryById(item.getFromUser().shortValue());
				item.setOrgAdminUser(adminUser);
				OrgUsers user = orgUsersService.queryById(item.getToUser());
				item.setOrgUser(user);
			}else{
				OrgAdminUser adminUser = orgAdminUserService.queryById(item.getToUser().shortValue());
				item.setOrgAdminUser(adminUser);
				OrgUsers user = orgUsersService.queryById(item.getFromUser());
				item.setOrgUser(user);
			}
		}
		return list;
	}

	@Override
	public void syncWebReply(Integer userId, OrgConsultAnswer orgConsultAnswer) {
		orgConsultAnswer.setCreateTime(new Date());
		orgConsultAnswer.setFromUser(userId);
		orgConsultAnswer.setReplyState(OrgConsultProblemConstant.CONSULT_REPLY_STATE_NO);
		orgConsultAnswer.setCreateUserType(OrgConsultProblemConstant.CONSULT_CREATEUSER_TYPE_FRONT);
		add(orgConsultAnswer);
		//用户添加新的咨询，并将该问题设置为未回复
		OrgConsultProblem orgConsultProblem = orgConsultProblemService.queryById(orgConsultAnswer.getConsultProblemId());
		orgConsultProblem.setReplyState(OrgConsultProblemConstant.CONSULT_REPLY_STATE_NO);
		orgConsultProblemService.updateByIdSelective(orgConsultProblem);
	}
}