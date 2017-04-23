package com.kjj.commserver.entity.shop;

public class OrgMobilePageModule {
    /**  */
    private Integer id;

    /** 动移首页id 对应org_mobile_page表id字段 */
    private Integer pageId;

    /** 块模区图片 */
    private String moduleImg;

    /** 模块区排序字段 */
    private Byte moduleOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getModuleImg() {
        return moduleImg;
    }

    public void setModuleImg(String moduleImg) {
        this.moduleImg = moduleImg == null ? null : moduleImg.trim();
    }

    public Byte getModuleOrder() {
        return moduleOrder;
    }

    public void setModuleOrder(Byte moduleOrder) {
        this.moduleOrder = moduleOrder;
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
        OrgMobilePageModule other = (OrgMobilePageModule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPageId() == null ? other.getPageId() == null : this.getPageId().equals(other.getPageId()))
            && (this.getModuleImg() == null ? other.getModuleImg() == null : this.getModuleImg().equals(other.getModuleImg()))
            && (this.getModuleOrder() == null ? other.getModuleOrder() == null : this.getModuleOrder().equals(other.getModuleOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPageId() == null) ? 0 : getPageId().hashCode());
        result = prime * result + ((getModuleImg() == null) ? 0 : getModuleImg().hashCode());
        result = prime * result + ((getModuleOrder() == null) ? 0 : getModuleOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pageId=").append(pageId);
        sb.append(", moduleImg=").append(moduleImg);
        sb.append(", moduleOrder=").append(moduleOrder);
        sb.append("]");
        return sb.toString();
    }
}