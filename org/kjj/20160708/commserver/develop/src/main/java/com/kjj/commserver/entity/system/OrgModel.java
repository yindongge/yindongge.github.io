package com.kjj.commserver.entity.system;

public class OrgModel {
    /** 模块描述 */
    private Integer modelid;

    /** 块模名称 */
    private String modelname;

    /** 片图地址 */
    private String modelimg;

    /** 访问url */
    private String url;

    /** 模块编号 */
    private String modelcode;

    /** 当前模块 启用状态 */
    private Integer flag;

    /** model父节点id */
    private Integer modelparent;

    /** 模块级别 */
    private Integer modellevel;

    /** 模块描述 */
    private String description;

    /**  */
    private String isactive;

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getModelimg() {
        return modelimg;
    }

    public void setModelimg(String modelimg) {
        this.modelimg = modelimg == null ? null : modelimg.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getModelcode() {
        return modelcode;
    }

    public void setModelcode(String modelcode) {
        this.modelcode = modelcode == null ? null : modelcode.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getModelparent() {
        return modelparent;
    }

    public void setModelparent(Integer modelparent) {
        this.modelparent = modelparent;
    }

    public Integer getModellevel() {
        return modellevel;
    }

    public void setModellevel(Integer modellevel) {
        this.modellevel = modellevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
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
        OrgModel other = (OrgModel) that;
        return (this.getModelid() == null ? other.getModelid() == null : this.getModelid().equals(other.getModelid()))
            && (this.getModelname() == null ? other.getModelname() == null : this.getModelname().equals(other.getModelname()))
            && (this.getModelimg() == null ? other.getModelimg() == null : this.getModelimg().equals(other.getModelimg()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getModelcode() == null ? other.getModelcode() == null : this.getModelcode().equals(other.getModelcode()))
            && (this.getFlag() == null ? other.getFlag() == null : this.getFlag().equals(other.getFlag()))
            && (this.getModelparent() == null ? other.getModelparent() == null : this.getModelparent().equals(other.getModelparent()))
            && (this.getModellevel() == null ? other.getModellevel() == null : this.getModellevel().equals(other.getModellevel()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getIsactive() == null ? other.getIsactive() == null : this.getIsactive().equals(other.getIsactive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getModelid() == null) ? 0 : getModelid().hashCode());
        result = prime * result + ((getModelname() == null) ? 0 : getModelname().hashCode());
        result = prime * result + ((getModelimg() == null) ? 0 : getModelimg().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getModelcode() == null) ? 0 : getModelcode().hashCode());
        result = prime * result + ((getFlag() == null) ? 0 : getFlag().hashCode());
        result = prime * result + ((getModelparent() == null) ? 0 : getModelparent().hashCode());
        result = prime * result + ((getModellevel() == null) ? 0 : getModellevel().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIsactive() == null) ? 0 : getIsactive().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", modelid=").append(modelid);
        sb.append(", modelname=").append(modelname);
        sb.append(", modelimg=").append(modelimg);
        sb.append(", url=").append(url);
        sb.append(", modelcode=").append(modelcode);
        sb.append(", flag=").append(flag);
        sb.append(", modelparent=").append(modelparent);
        sb.append(", modellevel=").append(modellevel);
        sb.append(", description=").append(description);
        sb.append(", isactive=").append(isactive);
        sb.append("]");
        return sb.toString();
    }
}