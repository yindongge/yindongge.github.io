package com.kjj.ruixing.entity.user;

import java.math.BigDecimal;

public class Basviptyp {
    /** null */
    private Short ruid;

    /** null */
    private String typno;

    /** null */
    private String typname;

    /** null */
    private BigDecimal typflag;

    /** null */
    private Short isdiscnt;

    /** null */
    private Short discnt;

    public Short getRuid() {
        return ruid;
    }

    public void setRuid(Short ruid) {
        this.ruid = ruid;
    }

    public String getTypno() {
        return typno;
    }

    public void setTypno(String typno) {
        this.typno = typno == null ? null : typno.trim();
    }

    public String getTypname() {
        return typname;
    }

    public void setTypname(String typname) {
        this.typname = typname == null ? null : typname.trim();
    }

    public BigDecimal getTypflag() {
        return typflag;
    }

    public void setTypflag(BigDecimal typflag) {
        this.typflag = typflag;
    }

    public Short getIsdiscnt() {
        return isdiscnt;
    }

    public void setIsdiscnt(Short isdiscnt) {
        this.isdiscnt = isdiscnt;
    }

    public Short getDiscnt() {
        return discnt;
    }

    public void setDiscnt(Short discnt) {
        this.discnt = discnt;
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
        Basviptyp other = (Basviptyp) that;
        return (this.getRuid() == null ? other.getRuid() == null : this.getRuid().equals(other.getRuid()))
            && (this.getTypno() == null ? other.getTypno() == null : this.getTypno().equals(other.getTypno()))
            && (this.getTypname() == null ? other.getTypname() == null : this.getTypname().equals(other.getTypname()))
            && (this.getTypflag() == null ? other.getTypflag() == null : this.getTypflag().equals(other.getTypflag()))
            && (this.getIsdiscnt() == null ? other.getIsdiscnt() == null : this.getIsdiscnt().equals(other.getIsdiscnt()))
            && (this.getDiscnt() == null ? other.getDiscnt() == null : this.getDiscnt().equals(other.getDiscnt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuid() == null) ? 0 : getRuid().hashCode());
        result = prime * result + ((getTypno() == null) ? 0 : getTypno().hashCode());
        result = prime * result + ((getTypname() == null) ? 0 : getTypname().hashCode());
        result = prime * result + ((getTypflag() == null) ? 0 : getTypflag().hashCode());
        result = prime * result + ((getIsdiscnt() == null) ? 0 : getIsdiscnt().hashCode());
        result = prime * result + ((getDiscnt() == null) ? 0 : getDiscnt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ruid=").append(ruid);
        sb.append(", typno=").append(typno);
        sb.append(", typname=").append(typname);
        sb.append(", typflag=").append(typflag);
        sb.append(", isdiscnt=").append(isdiscnt);
        sb.append(", discnt=").append(discnt);
        sb.append("]");
        return sb.toString();
    }
}