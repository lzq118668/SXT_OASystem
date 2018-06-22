package com.bjsxt.base.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {

    /**
     * 菜单id
     */
    private int id;

    /**
     * 菜单名
     */
    private String mname;

    /**
     * 菜单路径
     */
    private String url;

    /**
     * 父菜单id
     */
    private int pid;

    /**
     * 描述
     */

    private String remark;

    /**
     * 子菜单集合
     */
    private List<Menu> subMenu;

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                pid == menu.pid &&
                Objects.equals(mname, menu.mname) &&
                Objects.equals(url, menu.url) &&
                Objects.equals(remark, menu.remark) &&
                Objects.equals(subMenu, menu.subMenu);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mname, url, pid, remark, subMenu);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", remark='" + remark + '\'' +
                ", subMenu=" + subMenu +
                '}';
    }
}
