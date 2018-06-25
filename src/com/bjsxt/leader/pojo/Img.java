package com.bjsxt.leader.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Img implements Serializable {
    private  int id;
    private  String  imgname;//上传到服务器的名字
    private  String   name;//图片的真实名称
    private  String imgtype;//TU图片的类型
    private  int bid;//报销人的编号

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", imgname='" + imgname + '\'' +
                ", name='" + name + '\'' +
                ", imgtype='" + imgtype + '\'' +
                ", bid=" + bid +
                '}';
    }

    public Img(int id, String imgname, String name, String imgtype, int bid) {
        this.id = id;
        this.imgname = imgname;
        this.name = name;
        this.imgtype = imgtype;
        this.bid = bid;
    }

    public Img() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}
