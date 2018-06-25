package com.bjsxt.personnal.servlet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.personnal.pojo.Dept;
import com.bjsxt.personnal.pojo.Job;
import com.bjsxt.personnal.service.DeptService;
import com.bjsxt.personnal.service.JobService;
import com.bjsxt.personnal.service.impl.DeptServiceImpl;
import com.bjsxt.personnal.service.impl.JobServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/job.action")
public class JobServlet extends BaseServlet {
    /**
     * 添加职位
     * @param req
     * @param resp
     * @throws IOException
     */
    public void  addJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String jname=req.getParameter("jname");
        String  jmark=req.getParameter("jmark");
        Job job=new Job();
        job.setId(id);
        job.setJname(jname);
        job.setJmark(jmark);
        JobService js=new JobServiceImpl();
        int i = js.addJob(job);
        System.out.println(job);
        resp.sendRedirect(req.getContextPath()+"job.action?op=selJob");

    }

    /**
     * 查询所有的部门
     * @param req
     * @param resp
     * @throws IOException
     */
    public void selJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //int id=Integer.parseInt(req.getParameter("id"));
        JobService js=new JobServiceImpl();
        List<Job> jobs = js.selJob();
        System.out.println(jobs);
        req.getSession().setAttribute("jobs",jobs);
        //System.out.println(job);
        resp.sendRedirect(req.getContextPath()+"personnal/positionList.jsp");
    }

    /**
     * 修改部门信息
     * @param req
     * @param resp
     * @throws IOException
     */
    public void updJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String  jname=req.getParameter("jname");
        String jmark=req.getParameter("jmark");
        JobService js=new JobServiceImpl();
        int i = js.updJob(id, jname, jmark);
        //
        resp.sendRedirect(req.getContextPath()+"job.action?op=selJob");

    }

    /**
     * 删除部门
     * @param req
     * @param resp
     * @throws IOException
     */
    public void delJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        JobService js=new JobServiceImpl();
        int i = js.deLJob(id);
        //
        resp.sendRedirect(req.getContextPath()+"job.action?op=selJob");



    }


}
