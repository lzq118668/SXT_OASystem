package com.bjsxt.leader.pojo;
/**
 * 报销表的实体类
 * @author Administrator
 *
 */

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * 报销实体类
 */

public class Reimburse  implements Serializable{
       /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private int  id;//报销单的编号
      private int  bid;//报销人的编号
       private  double money;//报销总的金额
       private  Date bDate;//报销的时间
       private  int  sid;//审批人的编号
       private  String remark;//审批说明
      private String bname;//报销人的姓名
      private  String type;//报销类型

     //private  String remark;//报销说明
      private  List<ReimItem> reimItems;//具体的报销向

    @Override
    public String toString() {
        return "Reimburse{" +
                "id=" + id +
                ", bid=" + bid +
                ", money=" + money +
                ", bDate=" + bDate +
                ", sid=" + sid +
                ", remark='" + remark + '\'' +
                ", bname='" + bname + '\'' +
                ", type='" + type + '\'' +
                ", reimItems=" + reimItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimburse reimburse = (Reimburse) o;
        return id == reimburse.id &&
                bid == reimburse.bid &&
                Double.compare(reimburse.money, money) == 0 &&
                sid == reimburse.sid &&
                Objects.equals(bDate, reimburse.bDate) &&
                Objects.equals(remark, reimburse.remark) &&
                Objects.equals(bname, reimburse.bname) &&
                Objects.equals(type, reimburse.type) &&
                Objects.equals(reimItems, reimburse.reimItems);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bid, money, bDate, sid, remark, bname, type, reimItems);
    }

    public Reimburse(int id, int bid, double money, Date bDate, int sid, String remark, String bname, String type, List<ReimItem> reimItems) {
        this.id = id;
        this.bid = bid;
        this.money = money;
        this.bDate = bDate;
        this.sid = sid;
        this.remark = remark;
        this.bname = bname;
        this.type = type;
        //this.reimItems = reimItems;
    }

    public Reimburse() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ReimItem> getReimItems() {
        return reimItems;
    }

    public void setReimItems(List<ReimItem> reimItems) {
        this.reimItems = reimItems;
    }
}
