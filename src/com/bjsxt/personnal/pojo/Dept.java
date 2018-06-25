package com.bjsxt.personnal.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 部门表
 */
public class Dept  implements Serializable {
    private  int id;//部门编号
    private   String  dname;//部门名称
    private  String  loc;//部门地址

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return id == dept.id &&
                Objects.equals(dname, dept.dname) &&
                Objects.equals(loc, dept.loc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dname, loc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return dname;
    }

    public void setName(String name) {
        this.dname = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Dept() {
    }

    public Dept(int id, String name, String loc) {
        this.id = id;
        this.dname = name;
        this.loc = loc;
    }
}
