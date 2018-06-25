package com.bjsxt.leader.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 审批表的实体类
 */
public class Audit implements Serializable {
    private  int id;
    private  String sname;//审核人的姓名
    private  String bname;//报销人的姓名
    private  double money;//报销的总金额
    private Date   bDate;//报销时间
    private  Date   auditDate;// 审批时间
    private  String remark;//备注信息
    private   String  type;//报销的类型
    private  String rid;//报销表的编号
    private List<ReimItem> reimItems;//具体的报销向
    private  String auditResult;//审核结果

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return id == audit.id &&
                Double.compare(audit.money, money) == 0 &&
                Objects.equals(bname, audit.bname) &&
                Objects.equals(bDate, audit.bDate) &&
                Objects.equals(auditDate, audit.auditDate) &&
                Objects.equals(remark, audit.remark) &&
                Objects.equals(type, audit.type) &&
                Objects.equals(rid, audit.rid) &&
                Objects.equals(reimItems, audit.reimItems) &&
                Objects.equals(auditResult, audit.auditResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bname, money, bDate, auditDate, remark, type, rid, reimItems, auditResult);
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", money=" + money +
                ", bDate=" + bDate +
                ", auditDate=" + auditDate +
                ", remark='" + remark + '\'' +
                ", type='" + type + '\'' +
                ", rid='" + rid + '\'' +
                ", reimItems=" + reimItems +
                ", auditResult='" + auditResult + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public List<ReimItem> getReimItems() {
        return reimItems;
    }

    public void setReimItems(List<ReimItem> reimItems) {
        this.reimItems = reimItems;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public Audit() {
    }

    public Audit(int id, String bname, double money, Date bDate, Date auditDate, String remark, String type, String rid, List<ReimItem> reimItems, String auditResult) {
        this.id = id;
        this.bname = bname;
        this.money = money;
        this.bDate = bDate;
        this.auditDate = auditDate;
        this.remark = remark;
        this.type = type;
        this.rid = rid;
        this.reimItems = reimItems;
        this.auditResult = auditResult;
    }
}
