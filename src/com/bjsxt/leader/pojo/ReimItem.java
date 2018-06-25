package com.bjsxt.leader.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * 报销单明细表
 */
public class ReimItem {

     private  int id;//
     private  String type;//报销单的类型
     private  double  money;//报销金额
     private  String  remark;//报销说明
     private  int  bid;//所属的报销单标号
     private Date  bxDate;//报销时间
    //private  String remark;//报销明细备注


    @Override
    public String toString() {
        return "ReimItem{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", remark='" + remark + '\'' +
                ", bid=" + bid +
                ", bxDate=" + bxDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimItem reimItem = (ReimItem) o;
        return id == reimItem.id &&
                Double.compare(reimItem.money, money) == 0 &&
                bid == reimItem.bid &&
                Objects.equals(type, reimItem.type) &&
                Objects.equals(remark, reimItem.remark) &&
                Objects.equals(bxDate, reimItem.bxDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, money, remark, bid, bxDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Date getBxDate() {
        return bxDate;
    }

    public void setBxDate(Date bxDate) {
        this.bxDate = bxDate;
    }

    public ReimItem() {
    }

    public ReimItem(int id, String type, double money, String remark, int bid, Date bxDate) {
        this.id = id;
        this.type = type;
        this.money = money;
        this.remark = remark;
        this.bid = bid;
        this.bxDate = bxDate;
    }
}
