package com.bjsxt.base.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Role implements Serializable {


    private int id;

    private String type;

    private String remark;


    public Role() {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(type, role.type) &&
                Objects.equals(remark, role.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, remark);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
