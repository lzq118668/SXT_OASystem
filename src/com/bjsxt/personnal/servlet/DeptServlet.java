package com.bjsxt.personnal.servlet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.personnal.pojo.Dept;
import com.bjsxt.personnal.service.DeptService;
import com.bjsxt.personnal.service.impl.DeptServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept.action")
public class DeptServlet  extends BaseServlet {
    /**
     * 查询所有的部门
     * @param req
     * @param resp
     * @throws IOException
     */
    public void sel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DeptService ds=new DeptServiceImpl();
        String some=req.getParameter("some");
        List<Dept> depts = ds.selDept();
        if("sel".equals(some)){
            Dept dept=new Dept();
            dept.setId(-1);
            dept.setName("请选择");
            depts.add(0,dept);
        }


        req.getSession().setAttribute("depts",depts);
        resp.sendRedirect(req.getContextPath()+"personnal/deptList.jsp");


    }

    /**
     * 修改部门信息
     * @param req
     * @param resp
     * @throws IOException
     */
    public void updDept(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       int id=Integer.parseInt(req.getParameter("id"));
       String  dname=req.getParameter("dname");
       String loc=req.getParameter("loc");
        DeptService ds=new DeptServiceImpl();
        int i = ds.updDept(id, dname, loc);
        System.out.println(i);
        System.out.println(dname);
        System.out.println(loc);
       //
        resp.sendRedirect(req.getContextPath()+"dept.action?op=sel");

    }

    /**
     * 删除部门
     * @param req
     * @param resp
     * @throws IOException
     */
    public void delDept(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        DeptService ds=new DeptServiceImpl();
        int i = ds.delDept(id);
        System.out.println(i);
        resp.sendRedirect(req.getContextPath()+"dept.action?op=sel");

    }

    /**
     * 添加部门
     * @param req
     * @param resp
     * @throws IOException
     */
    public void  addDept(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String dname=req.getParameter("dname");
        String  loc=req.getParameter("loc");
        Dept dept=new Dept();
        dept.setId(id);
        dept.setName(dname);
        dept.setLoc(loc);
        DeptService ds=new DeptServiceImpl();
        int i = ds.addDept(dept);
        System.out.println(dept);
        resp.sendRedirect(req.getContextPath()+"dept.action?op=sel");

    }


}
