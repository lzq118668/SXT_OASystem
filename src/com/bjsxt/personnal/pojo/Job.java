package com.bjsxt.personnal.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * 职位表
 */
public class Job implements Serializable {
    private  int id;
    private  String jname;//职位名称
    private  String jmark;//职位描述

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                Objects.equals(jname, job.jname) &&
                Objects.equals(jmark, job.jmark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, jname, jmark);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jname='" + jname + '\'' +
                ", jmark='" + jmark + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJmark() {
        return jmark;
    }

    public void setJmark(String jmark) {
        this.jmark = jmark;
    }

    public Job() {
    }

    public Job(int id, String jname, String jmark) {
        this.id = id;
        this.jname = jname;
        this.jmark = jmark;
    }
}
