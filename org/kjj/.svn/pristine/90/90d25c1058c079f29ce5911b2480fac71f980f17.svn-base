package com.kjj.commserver.entity.special;

public class OrgSpecialRule {
    /**  */
    private Integer id;

    /** 对应表org_special中的special_id */
    private Integer specialId;

    /** 规则内容 */
    private String ruleContent;

    /** 代码内容 */
    private String ruleHtml;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent == null ? null : ruleContent.trim();
    }

    public String getRuleHtml() {
        return ruleHtml;
    }

    public void setRuleHtml(String ruleHtml) {
        this.ruleHtml = ruleHtml == null ? null : ruleHtml.trim();
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
        OrgSpecialRule other = (OrgSpecialRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSpecialId() == null ? other.getSpecialId() == null : this.getSpecialId().equals(other.getSpecialId()))
            && (this.getRuleContent() == null ? other.getRuleContent() == null : this.getRuleContent().equals(other.getRuleContent()))
            && (this.getRuleHtml() == null ? other.getRuleHtml() == null : this.getRuleHtml().equals(other.getRuleHtml()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSpecialId() == null) ? 0 : getSpecialId().hashCode());
        result = prime * result + ((getRuleContent() == null) ? 0 : getRuleContent().hashCode());
        result = prime * result + ((getRuleHtml() == null) ? 0 : getRuleHtml().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", specialId=").append(specialId);
        sb.append(", ruleContent=").append(ruleContent);
        sb.append(", ruleHtml=").append(ruleHtml);
        sb.append("]");
        return sb.toString();
    }
}