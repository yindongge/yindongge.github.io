package com.kjj.commserver.entity.shop;

public class OrgShopPage {
    /**  */
    private Integer id;

    /**  */
    private Integer shopId;

    /** 对应热门搜索 */
    private String shopSearch;

    /** 否启用是 */
    private Integer isactive;

    /**  */
    private String shopname;

    /** 1 未 删除 0 已经删除 */
    private Integer isdelete;

    /** 0 表示默认首页 1 表示自定义首页 */
    private Short type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopSearch() {
        return shopSearch;
    }

    public void setShopSearch(String shopSearch) {
        this.shopSearch = shopSearch == null ? null : shopSearch.trim();
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
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
        OrgShopPage other = (OrgShopPage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getShopSearch() == null ? other.getShopSearch() == null : this.getShopSearch().equals(other.getShopSearch()))
            && (this.getIsactive() == null ? other.getIsactive() == null : this.getIsactive().equals(other.getIsactive()))
            && (this.getShopname() == null ? other.getShopname() == null : this.getShopname().equals(other.getShopname()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getShopSearch() == null) ? 0 : getShopSearch().hashCode());
        result = prime * result + ((getIsactive() == null) ? 0 : getIsactive().hashCode());
        result = prime * result + ((getShopname() == null) ? 0 : getShopname().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopId=").append(shopId);
        sb.append(", shopSearch=").append(shopSearch);
        sb.append(", isactive=").append(isactive);
        sb.append(", shopname=").append(shopname);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}