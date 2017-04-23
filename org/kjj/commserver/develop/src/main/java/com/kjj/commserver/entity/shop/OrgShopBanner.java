package com.kjj.commserver.entity.shop;

public class OrgShopBanner {
    /**  */
    private Integer id;

    /**  */
    private Integer pageid;

    /**  */
    private String orgShopBanner;

    /**  */
    private String orgShopBannerUrl;

    /**  */
    private String orgShopBannerOrder;

    /**  */
    private String b2;

    /**  */
    private String b3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public String getOrgShopBanner() {
        return orgShopBanner;
    }

    public void setOrgShopBanner(String orgShopBanner) {
        this.orgShopBanner = orgShopBanner == null ? null : orgShopBanner.trim();
    }

    public String getOrgShopBannerUrl() {
        return orgShopBannerUrl;
    }

    public void setOrgShopBannerUrl(String orgShopBannerUrl) {
        this.orgShopBannerUrl = orgShopBannerUrl == null ? null : orgShopBannerUrl.trim();
    }

    public String getOrgShopBannerOrder() {
        return orgShopBannerOrder;
    }

    public void setOrgShopBannerOrder(String orgShopBannerOrder) {
        this.orgShopBannerOrder = orgShopBannerOrder == null ? null : orgShopBannerOrder.trim();
    }

    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2 == null ? null : b2.trim();
    }

    public String getB3() {
        return b3;
    }

    public void setB3(String b3) {
        this.b3 = b3 == null ? null : b3.trim();
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
        OrgShopBanner other = (OrgShopBanner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPageid() == null ? other.getPageid() == null : this.getPageid().equals(other.getPageid()))
            && (this.getOrgShopBanner() == null ? other.getOrgShopBanner() == null : this.getOrgShopBanner().equals(other.getOrgShopBanner()))
            && (this.getOrgShopBannerUrl() == null ? other.getOrgShopBannerUrl() == null : this.getOrgShopBannerUrl().equals(other.getOrgShopBannerUrl()))
            && (this.getOrgShopBannerOrder() == null ? other.getOrgShopBannerOrder() == null : this.getOrgShopBannerOrder().equals(other.getOrgShopBannerOrder()))
            && (this.getB2() == null ? other.getB2() == null : this.getB2().equals(other.getB2()))
            && (this.getB3() == null ? other.getB3() == null : this.getB3().equals(other.getB3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPageid() == null) ? 0 : getPageid().hashCode());
        result = prime * result + ((getOrgShopBanner() == null) ? 0 : getOrgShopBanner().hashCode());
        result = prime * result + ((getOrgShopBannerUrl() == null) ? 0 : getOrgShopBannerUrl().hashCode());
        result = prime * result + ((getOrgShopBannerOrder() == null) ? 0 : getOrgShopBannerOrder().hashCode());
        result = prime * result + ((getB2() == null) ? 0 : getB2().hashCode());
        result = prime * result + ((getB3() == null) ? 0 : getB3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pageid=").append(pageid);
        sb.append(", orgShopBanner=").append(orgShopBanner);
        sb.append(", orgShopBannerUrl=").append(orgShopBannerUrl);
        sb.append(", orgShopBannerOrder=").append(orgShopBannerOrder);
        sb.append(", b2=").append(b2);
        sb.append(", b3=").append(b3);
        sb.append("]");
        return sb.toString();
    }
}