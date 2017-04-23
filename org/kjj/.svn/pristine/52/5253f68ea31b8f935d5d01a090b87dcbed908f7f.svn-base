package com.kjj.commserver.entity.user;

import java.util.Date;

public class OrgUserLogin {
    /**  */
    private Long id;

    /**  */
    private Integer userid;

    /** 用户自动登录的key 用户客户自动登录使用 */
    private String rememberKey;

    /**  */
    private String loginip;

    /**  */
    private Date logintime;

    /**  */
    private String rep1;

    /**  */
    private String rep2;

    /**  */
    private String rep3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRememberKey() {
        return rememberKey;
    }

    public void setRememberKey(String rememberKey) {
        this.rememberKey = rememberKey == null ? null : rememberKey.trim();
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1 == null ? null : rep1.trim();
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2 == null ? null : rep2.trim();
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3 == null ? null : rep3.trim();
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
        OrgUserLogin other = (OrgUserLogin) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getRememberKey() == null ? other.getRememberKey() == null : this.getRememberKey().equals(other.getRememberKey()))
            && (this.getLoginip() == null ? other.getLoginip() == null : this.getLoginip().equals(other.getLoginip()))
            && (this.getLogintime() == null ? other.getLogintime() == null : this.getLogintime().equals(other.getLogintime()))
            && (this.getRep1() == null ? other.getRep1() == null : this.getRep1().equals(other.getRep1()))
            && (this.getRep2() == null ? other.getRep2() == null : this.getRep2().equals(other.getRep2()))
            && (this.getRep3() == null ? other.getRep3() == null : this.getRep3().equals(other.getRep3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getRememberKey() == null) ? 0 : getRememberKey().hashCode());
        result = prime * result + ((getLoginip() == null) ? 0 : getLoginip().hashCode());
        result = prime * result + ((getLogintime() == null) ? 0 : getLogintime().hashCode());
        result = prime * result + ((getRep1() == null) ? 0 : getRep1().hashCode());
        result = prime * result + ((getRep2() == null) ? 0 : getRep2().hashCode());
        result = prime * result + ((getRep3() == null) ? 0 : getRep3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", rememberKey=").append(rememberKey);
        sb.append(", loginip=").append(loginip);
        sb.append(", logintime=").append(logintime);
        sb.append(", rep1=").append(rep1);
        sb.append(", rep2=").append(rep2);
        sb.append(", rep3=").append(rep3);
        sb.append("]");
        return sb.toString();
    }
}