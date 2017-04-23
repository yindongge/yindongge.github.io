package com.kjj.commserver.entity.system;

public class OrgSystemParameter {
    /** 主键 */
    private Integer id;

    /** 参数名称 */
    private String parameterName;

    /** 参数值 */
    private String parameterValue;

    /** 参数说明 */
    private String parameterDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName == null ? null : parameterName.trim();
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue == null ? null : parameterValue.trim();
    }

    public String getParameterDesc() {
        return parameterDesc;
    }

    public void setParameterDesc(String parameterDesc) {
        this.parameterDesc = parameterDesc == null ? null : parameterDesc.trim();
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
        OrgSystemParameter other = (OrgSystemParameter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParameterName() == null ? other.getParameterName() == null : this.getParameterName().equals(other.getParameterName()))
            && (this.getParameterValue() == null ? other.getParameterValue() == null : this.getParameterValue().equals(other.getParameterValue()))
            && (this.getParameterDesc() == null ? other.getParameterDesc() == null : this.getParameterDesc().equals(other.getParameterDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParameterName() == null) ? 0 : getParameterName().hashCode());
        result = prime * result + ((getParameterValue() == null) ? 0 : getParameterValue().hashCode());
        result = prime * result + ((getParameterDesc() == null) ? 0 : getParameterDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parameterName=").append(parameterName);
        sb.append(", parameterValue=").append(parameterValue);
        sb.append(", parameterDesc=").append(parameterDesc);
        sb.append("]");
        return sb.toString();
    }
}