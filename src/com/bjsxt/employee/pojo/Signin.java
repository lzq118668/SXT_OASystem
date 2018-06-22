package com.bjsxt.employee.pojo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Signin implements Serializable {

    /**
     * 签到编号
     */
    private int id;

    /**
     * 签到用户编号
     */

    private int uid;

    /**
     * 签到时间
     */

    private Time qddate;

    /**
     * 签到日期
     */

    private Date attdate;

    /**
     * 签退日期
     */

    private Time qtdate;

    public Signin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Time getQddate() {
        return qddate;
    }

    public void setQddate(Time qddate) {
        this.qddate = qddate;
    }

    public Date getAttdate() {
        return attdate;
    }

    public void setAttdate(Date attdate) {
        this.attdate = attdate;
    }

    public Time getQtdate() {
        return qtdate;
    }

    public void setQtdate(Time qtdate) {
        this.qtdate = qtdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signin signin = (Signin) o;
        return id == signin.id &&
                uid == signin.uid &&
                Objects.equals(qddate, signin.qddate) &&
                Objects.equals(attdate, signin.attdate) &&
                Objects.equals(qtdate, signin.qtdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, uid, qddate, attdate, qtdate);
    }

    @Override
    public String toString() {
        return "Signin{" +
                "id=" + id +
                ", uid=" + uid +
                ", qddate=" + qddate +
                ", attdate=" + attdate +
                ", qtdate=" + qtdate +
                '}';
    }
}
