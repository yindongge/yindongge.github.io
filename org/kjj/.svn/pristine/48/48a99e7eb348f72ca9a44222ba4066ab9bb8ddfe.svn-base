package com.kjj.commserver.entity.user;

import java.util.Date;

public class OrgEnterprise {
    /** 主键 */
    private Integer enterpriseId;

    /** 公司名称 */
    private String enterpriseName;

    /** 公司地址 */
    private String address;

    /** 所在地_省 */
    private Integer provinceCode;

    /** 所在地_市 */
    private Integer cityCode;

    /** 所在地_县 */
    private Integer countyCode;

    /** 推荐人手机 */
    private String referenceTel;

    /** 企业人数 */
    private Byte employees;

    /** 企业行业 */
    private Byte industry;

    /** 性质 */
    private Byte nature;

    /** 联系人名称 */
    private String contactName;

    /** 联系人邮箱 */
    private String contactEmail;

    /** 部门 */
    private Byte department;

    /** 固定电话 */
    private String landlines;

    /** 验证手机 */
    private String mobile;

    /** 0:未审核 1:审核通过 2:审核未通过 */
    private Byte status;

    /** 关联用户表org_users的user_Id */
    private Integer userId;

    /** 是否锁定 0:未锁定 1:锁定 */
    private Byte isLocked;

    /** 组织机构代码图片地址 */
    private String organizationCodeImg;

    /** 营业执照图片地址 */
    private String businessLicenImg;
    
    /** 创建日期,注册日期 */
    private Date createTime;
    
    /** 对应表org_shop中的shop_id */
    private Integer shopId;
    
    /** 门店负责人 */
    private String shopContact;

    public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopContact() {
		return shopContact;
	}

	public void setShopContact(String shopContact) {
		this.shopContact = shopContact;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }


    public String getReferenceTel() {
        return referenceTel;
    }

    public void setReferenceTel(String referenceTel) {
        this.referenceTel = referenceTel == null ? null : referenceTel.trim();
    }

    public Byte getEmployees() {
        return employees;
    }

    public void setEmployees(Byte employees) {
        this.employees = employees;
    }

    public Byte getIndustry() {
        return industry;
    }

    public void setIndustry(Byte industry) {
        this.industry = industry;
    }

    public Byte getNature() {
        return nature;
    }

    public void setNature(Byte nature) {
        this.nature = nature;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public Byte getDepartment() {
        return department;
    }

    public void setDepartment(Byte department) {
        this.department = department;
    }

    public String getLandlines() {
        return landlines;
    }

    public void setLandlines(String landlines) {
        this.landlines = landlines == null ? null : landlines.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    public String getOrganizationCodeImg() {
        return organizationCodeImg;
    }

    public void setOrganizationCodeImg(String organizationCodeImg) {
        this.organizationCodeImg = organizationCodeImg == null ? null : organizationCodeImg.trim();
    }

    public String getBusinessLicenImg() {
        return businessLicenImg;
    }

    public void setBusinessLicenImg(String businessLicenImg) {
        this.businessLicenImg = businessLicenImg == null ? null : businessLicenImg.trim();
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
        OrgEnterprise other = (OrgEnterprise) that;
        return (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getEnterpriseName() == null ? other.getEnterpriseName() == null : this.getEnterpriseName().equals(other.getEnterpriseName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getCityCode() == null ? other.getCityCode() == null : this.getCityCode().equals(other.getCityCode()))
            && (this.getCountyCode() == null ? other.getCountyCode() == null : this.getCountyCode().equals(other.getCountyCode()))
            && (this.getReferenceTel() == null ? other.getReferenceTel() == null : this.getReferenceTel().equals(other.getReferenceTel()))
            && (this.getEmployees() == null ? other.getEmployees() == null : this.getEmployees().equals(other.getEmployees()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getNature() == null ? other.getNature() == null : this.getNature().equals(other.getNature()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactEmail() == null ? other.getContactEmail() == null : this.getContactEmail().equals(other.getContactEmail()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getLandlines() == null ? other.getLandlines() == null : this.getLandlines().equals(other.getLandlines()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIsLocked() == null ? other.getIsLocked() == null : this.getIsLocked().equals(other.getIsLocked()))
            && (this.getOrganizationCodeImg() == null ? other.getOrganizationCodeImg() == null : this.getOrganizationCodeImg().equals(other.getOrganizationCodeImg()))
            && (this.getBusinessLicenImg() == null ? other.getBusinessLicenImg() == null : this.getBusinessLicenImg().equals(other.getBusinessLicenImg()));
    }

    public Integer getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(Integer countyCode) {
		this.countyCode = countyCode;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getEnterpriseName() == null) ? 0 : getEnterpriseName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getCityCode() == null) ? 0 : getCityCode().hashCode());
        result = prime * result + ((getCountyCode() == null) ? 0 : getCountyCode().hashCode());
        result = prime * result + ((getReferenceTel() == null) ? 0 : getReferenceTel().hashCode());
        result = prime * result + ((getEmployees() == null) ? 0 : getEmployees().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getNature() == null) ? 0 : getNature().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactEmail() == null) ? 0 : getContactEmail().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getLandlines() == null) ? 0 : getLandlines().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIsLocked() == null) ? 0 : getIsLocked().hashCode());
        result = prime * result + ((getOrganizationCodeImg() == null) ? 0 : getOrganizationCodeImg().hashCode());
        result = prime * result + ((getBusinessLicenImg() == null) ? 0 : getBusinessLicenImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", enterpriseName=").append(enterpriseName);
        sb.append(", address=").append(address);
        sb.append(", province=").append(provinceCode);
        sb.append(", city=").append(cityCode);
        sb.append(", county=").append(countyCode);
        sb.append(", referenceTel=").append(referenceTel);
        sb.append(", employees=").append(employees);
        sb.append(", industry=").append(industry);
        sb.append(", nature=").append(nature);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", department=").append(department);
        sb.append(", landlines=").append(landlines);
        sb.append(", mobile=").append(mobile);
        sb.append(", status=").append(status);
        sb.append(", userId=").append(userId);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", organizationCodeImg=").append(organizationCodeImg);
        sb.append(", businessLicenImg=").append(businessLicenImg);
        sb.append("]");
        return sb.toString();
    }
}