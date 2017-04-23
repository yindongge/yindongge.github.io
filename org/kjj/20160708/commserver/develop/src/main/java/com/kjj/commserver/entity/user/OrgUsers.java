package com.kjj.commserver.entity.user;

import java.math.BigDecimal;
import java.util.Date;

public class OrgUsers {
    /** 会员资料自增id */
    private Integer userId;

    /** 会员邮箱 */
    private String email;

    /** 用户名 */
    private String userName;

    /** 用户密码 */
    private String password;

    /** 安全问题答案 */
    private String question;

    /** 安全问题 */
    private String answer;

    /** 性别，0，保密；1，男；2，女 */
    private Byte sex;

    /** 生日日期 */
    private String birthday;

    /** 用户现有资金 */
    private BigDecimal userMoney;

    /** 用户冻结资金 */
    private BigDecimal frozenMoney;

    /** 消费积分 */
    private Integer payPoints;

    /** 会员等级积分 */
    private Integer rankPoints;

    /** 收货信息id，取值表org_user_address  */
    private Integer addressId;

    /**  */
    private Date regTime;

    /** 最后一次登录时间 */
    private Date lastLogin;

    /** 应该是最后一次修改信息时间，该表信息从其他表同步过来考虑 */
    private Date lastTime;

    /** 最后一次登录ip */
    private String lastIp;

    /** 登录次数 */
    private Short visitCount;

    /** 会员登记id，取值ecs_user_rank */
    private Byte userRank;

    /**  */
    private Byte isSpecial;

    /**  */
    private String salt;

    /** 推荐人id */
    private Integer parentId;

    /**  */
    private Byte flag;

    /** 昵称 */
    private String alias;

    /** msn */
    private String msn;

    /** qq号 */
    private String qq;

    /** 办公电话 */
    private String officePhone;

    /** 家庭电话 */
    private String homePhone;

    /** 手机 */
    private String mobilePhone;

    /**  */
    private Byte isValidated;

    /** 信用额度，目前2.6.0版好像没有作实现 */
    private BigDecimal creditLine;

    /** 会员注册门店id */
    private Integer ownId;

    /** 微信id */
    private String openId;

    /** 会员来源渠道  微信 网站 等 */
    private Byte channelId;

    /** 目前服务会员门店id */
    private Short serviceId;

    /** 用户头像id */
    private String imageUrl;

    /** 会员所属国家 */
    private Short country;

    /**  */
    private String serialnumber;

    /** 家乡地址 */
    private String addresshome;

    /** 现在住址 */
    private String addressnow;

    /**  */
    private String realname;

    /**  */
    private String addressdesc;

    /** 0正常 1 锁定 */
    private Integer status;

    /**  */
    private String hobbies;

    /** 配送方式 0：送货上门 1：到店自取 */
    private Byte lastSendStyle;
    
    /** 会员类型*/
    private Byte levelType;
    
    /** 会员级别*/
    private String levelId;
    
    /** 用户编码，与瑞星系统同步会员使用 */
    private String userCode;
    
    public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Byte getLevelType() {
		return levelType;
	}

	public void setLevelType(Byte levelType) {
		this.levelType = levelType;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public BigDecimal getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(BigDecimal frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public Integer getPayPoints() {
        return payPoints;
    }

    public void setPayPoints(Integer payPoints) {
        this.payPoints = payPoints;
    }

    public Integer getRankPoints() {
        return rankPoints;
    }

    public void setRankPoints(Integer rankPoints) {
        this.rankPoints = rankPoints;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    public Short getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Short visitCount) {
        this.visitCount = visitCount;
    }

    public Byte getUserRank() {
        return userRank;
    }

    public void setUserRank(Byte userRank) {
        this.userRank = userRank;
    }

    public Byte getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Byte isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone == null ? null : homePhone.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public Byte getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Byte isValidated) {
        this.isValidated = isValidated;
    }

    public BigDecimal getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(BigDecimal creditLine) {
        this.creditLine = creditLine;
    }

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Byte getChannelId() {
        return channelId;
    }

    public void setChannelId(Byte channelId) {
        this.channelId = channelId;
    }

    public Short getServiceId() {
        return serviceId;
    }

    public void setServiceId(Short serviceId) {
        this.serviceId = serviceId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Short getCountry() {
        return country;
    }

    public void setCountry(Short country) {
        this.country = country;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public String getAddresshome() {
        return addresshome;
    }

    public void setAddresshome(String addresshome) {
        this.addresshome = addresshome == null ? null : addresshome.trim();
    }

    public String getAddressnow() {
        return addressnow;
    }

    public void setAddressnow(String addressnow) {
        this.addressnow = addressnow == null ? null : addressnow.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getAddressdesc() {
        return addressdesc;
    }

    public void setAddressdesc(String addressdesc) {
        this.addressdesc = addressdesc == null ? null : addressdesc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies == null ? null : hobbies.trim();
    }

    public Byte getLastSendStyle() {
        return lastSendStyle;
    }

    public void setLastSendStyle(Byte lastSendStyle) {
        this.lastSendStyle = lastSendStyle;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrgUsers other = (OrgUsers) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getFrozenMoney() == null ? other.getFrozenMoney() == null : this.getFrozenMoney().equals(other.getFrozenMoney()))
            && (this.getPayPoints() == null ? other.getPayPoints() == null : this.getPayPoints().equals(other.getPayPoints()))
            && (this.getRankPoints() == null ? other.getRankPoints() == null : this.getRankPoints().equals(other.getRankPoints()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getRegTime() == null ? other.getRegTime() == null : this.getRegTime().equals(other.getRegTime()))
            && (this.getLastLogin() == null ? other.getLastLogin() == null : this.getLastLogin().equals(other.getLastLogin()))
            && (this.getLastTime() == null ? other.getLastTime() == null : this.getLastTime().equals(other.getLastTime()))
            && (this.getLastIp() == null ? other.getLastIp() == null : this.getLastIp().equals(other.getLastIp()))
            && (this.getVisitCount() == null ? other.getVisitCount() == null : this.getVisitCount().equals(other.getVisitCount()))
            && (this.getUserRank() == null ? other.getUserRank() == null : this.getUserRank().equals(other.getUserRank()))
            && (this.getIsSpecial() == null ? other.getIsSpecial() == null : this.getIsSpecial().equals(other.getIsSpecial()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getMsn() == null ? other.getMsn() == null : this.getMsn().equals(other.getMsn()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getOfficePhone() == null ? other.getOfficePhone() == null : this.getOfficePhone().equals(other.getOfficePhone()))
            && (this.getHomePhone() == null ? other.getHomePhone() == null : this.getHomePhone().equals(other.getHomePhone()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getIsValidated() == null ? other.getIsValidated() == null : this.getIsValidated().equals(other.getIsValidated()))
            && (this.getCreditLine() == null ? other.getCreditLine() == null : this.getCreditLine().equals(other.getCreditLine()))
            && (this.getOwnId() == null ? other.getOwnId() == null : this.getOwnId().equals(other.getOwnId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getSerialnumber() == null ? other.getSerialnumber() == null : this.getSerialnumber().equals(other.getSerialnumber()))
            && (this.getAddresshome() == null ? other.getAddresshome() == null : this.getAddresshome().equals(other.getAddresshome()))
            && (this.getAddressnow() == null ? other.getAddressnow() == null : this.getAddressnow().equals(other.getAddressnow()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getAddressdesc() == null ? other.getAddressdesc() == null : this.getAddressdesc().equals(other.getAddressdesc()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getHobbies() == null ? other.getHobbies() == null : this.getHobbies().equals(other.getHobbies()))
            && (this.getLastSendStyle() == null ? other.getLastSendStyle() == null : this.getLastSendStyle().equals(other.getLastSendStyle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getFrozenMoney() == null) ? 0 : getFrozenMoney().hashCode());
        result = prime * result + ((getPayPoints() == null) ? 0 : getPayPoints().hashCode());
        result = prime * result + ((getRankPoints() == null) ? 0 : getRankPoints().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getRegTime() == null) ? 0 : getRegTime().hashCode());
        result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
        result = prime * result + ((getLastTime() == null) ? 0 : getLastTime().hashCode());
        result = prime * result + ((getLastIp() == null) ? 0 : getLastIp().hashCode());
        result = prime * result + ((getVisitCount() == null) ? 0 : getVisitCount().hashCode());
        result = prime * result + ((getUserRank() == null) ? 0 : getUserRank().hashCode());
        result = prime * result + ((getIsSpecial() == null) ? 0 : getIsSpecial().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getMsn() == null) ? 0 : getMsn().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getOfficePhone() == null) ? 0 : getOfficePhone().hashCode());
        result = prime * result + ((getHomePhone() == null) ? 0 : getHomePhone().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getIsValidated() == null) ? 0 : getIsValidated().hashCode());
        result = prime * result + ((getCreditLine() == null) ? 0 : getCreditLine().hashCode());
        result = prime * result + ((getOwnId() == null) ? 0 : getOwnId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getSerialnumber() == null) ? 0 : getSerialnumber().hashCode());
        result = prime * result + ((getAddresshome() == null) ? 0 : getAddresshome().hashCode());
        result = prime * result + ((getAddressnow() == null) ? 0 : getAddressnow().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getAddressdesc() == null) ? 0 : getAddressdesc().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getHobbies() == null) ? 0 : getHobbies().hashCode());
        result = prime * result + ((getLastSendStyle() == null) ? 0 : getLastSendStyle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", email=").append(email);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", question=").append(question);
        sb.append(", answer=").append(answer);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", frozenMoney=").append(frozenMoney);
        sb.append(", payPoints=").append(payPoints);
        sb.append(", rankPoints=").append(rankPoints);
        sb.append(", addressId=").append(addressId);
        sb.append(", regTime=").append(regTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", visitCount=").append(visitCount);
        sb.append(", userRank=").append(userRank);
        sb.append(", isSpecial=").append(isSpecial);
        sb.append(", salt=").append(salt);
        sb.append(", parentId=").append(parentId);
        sb.append(", flag=").append(flag);
        sb.append(", alias=").append(alias);
        sb.append(", msn=").append(msn);
        sb.append(", qq=").append(qq);
        sb.append(", officePhone=").append(officePhone);
        sb.append(", homePhone=").append(homePhone);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", isValidated=").append(isValidated);
        sb.append(", creditLine=").append(creditLine);
        sb.append(", ownId=").append(ownId);
        sb.append(", openId=").append(openId);
        sb.append(", channelId=").append(channelId);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", country=").append(country);
        sb.append(", serialnumber=").append(serialnumber);
        sb.append(", addresshome=").append(addresshome);
        sb.append(", addressnow=").append(addressnow);
        sb.append(", realname=").append(realname);
        sb.append(", addressdesc=").append(addressdesc);
        sb.append(", status=").append(status);
        sb.append(", hobbies=").append(hobbies);
        sb.append(", lastSendStyle=").append(lastSendStyle);
        sb.append("]");
        return sb.toString();
    }
}