package com.bjsxt.base.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
* 用户实体类
*
*@author leo
*/

public class User implements Serializable {

    /**
     * 用户编号
     */
    private int id;

    /**
     * 用户名
     */

    private String username;

    /**
     * 密码
     */

    private String password;

    /**
     * 真实姓名
     */

    private String name;

    /**
     * 性别
     */

    private String gender;

    /**
     * 出生日期
     */

    private Date birthday;

    /**
     * 入职日期
     */

    private Date hiredate;

    /**
     * 离职日期
     */

    private Date leavedate;

    /**
     * 是否在职
     */

    private int isjob;

    /**
     * 员工类型
     */

    private boolean emptype;

    /**
     * 联系方式电话
     */

    private String phone;

    /**
     * QQ号
     */

    private String qq;

    /**
     * 紧急联系人
     */

    private String contacts;

    /**
     * 身份证
     */

    private String idcard;

    /**
     * 岗位编号（外键）
     */

    private int jid;

    /**
     * 部门编号（外键）
     */

    private int did;

    /**
     * 上级领导编号
     */

    private int mgr;

    /**
    *菜单
    */
    private List<Menu> menus;

    /**
    *用户角色
    */
    private Role role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public int getIsjob() {
        return isjob;
    }

    public void setIsjob(int isjob) {
        this.isjob = isjob;
    }

    public boolean isEmptype() {
        return emptype;
    }

    public void setEmptype(boolean emptype) {
        this.emptype = emptype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                isjob == user.isjob &&
                emptype == user.emptype &&
                jid == user.jid &&
                did == user.did &&
                mgr == user.mgr &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(hiredate, user.hiredate) &&
                Objects.equals(leavedate, user.leavedate) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(qq, user.qq) &&
                Objects.equals(contacts, user.contacts) &&
                Objects.equals(idcard, user.idcard) &&
                Objects.equals(menus, user.menus) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, name, gender, birthday, hiredate, leavedate, isjob, emptype, phone, qq, contacts, idcard, jid, did, mgr, menus, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hiredate=" + hiredate +
                ", leavedate=" + leavedate +
                ", isjob=" + isjob +
                ", emptype=" + emptype +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", contacts='" + contacts + '\'' +
                ", idcard='" + idcard + '\'' +
                ", jid=" + jid +
                ", did=" + did +
                ", mgr=" + mgr +
                ", menus=" + menus +
                ", role=" + role +
                '}';
    }
}
