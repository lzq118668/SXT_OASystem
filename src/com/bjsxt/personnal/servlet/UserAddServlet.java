package com.bjsxt.personnal.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.base.util.DateUtil;
import com.bjsxt.personnal.pojo.Dept;
import com.bjsxt.personnal.pojo.Job;
import com.bjsxt.personnal.service.DeptService;
import com.bjsxt.personnal.service.JobService;
import com.bjsxt.personnal.service.UserService;
import com.bjsxt.personnal.service.impl.DeptServiceImpl;
import com.bjsxt.personnal.service.impl.JobServiceImpl;
import com.bjsxt.personnal.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/userAdd.action")
public class UserAddServlet  extends BaseServlet {

    /**
     * 添加员工
     * @param req
     * @param resp
     * @throws IOException
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = getParem(req);
        UserService us=new UserServiceImpl();
        int i = us.addUser(user);
        resp.sendRedirect(req.getContextPath()+"emp.action?op=selUser");



    }

    /**
     * 查询员工
     * @param req
     * @param resp
     * @throws IOException
     */
    public void selUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService us=new UserServiceImpl();
        List<User> users = us.selUser();
        DeptService ds=new DeptServiceImpl();
        List<Dept> depts = ds.selDept();
        JobService js=new JobServiceImpl();
        List<Job> jobs = js.selJob();
        req.getSession().setAttribute("users",users);
        req.getSession().setAttribute("deptss",depts);
        req.getSession().setAttribute("jobss",jobs);
        resp.sendRedirect(req.getContextPath()+"personnal/empAdd.jsp");


    }

    /**
     * 获取参数
     *
     */
    public User getParem(HttpServletRequest req){
        //int id=Integer.parseInt(req.getParameter("id")
        long id=System.currentTimeMillis();
         String id1=id+"";
        String id2 = id1.substring(10);
        User user=new User();
        user.setId(Integer.parseInt(id2));
        System.out.println(id1.length()+"=====id1============");
        System.out.println(id2.length()+"=======id2=======");
         user.setUsername(req.getParameter("username"));
         user.setPassword(req.getParameter("password"));
         user.setGender(req.getParameter("sex"));
          user.setName(req.getParameter("name"));
        String birthday1 = req.getParameter("birthday");
        Date  bidthday=DateUtil.StrToDate(birthday1);
        user.setBirthday(bidthday);

       String hiredate1=req.getParameter("hiredate");
         Date  hiredate=DateUtil.StrToDate(hiredate1);
         user.setHiredate(hiredate);

        String emptype1 = req.getParameter("emptype");
        boolean emptype=Boolean.parseBoolean(emptype1);
        user.setEmptype(emptype);

        int did=Integer.parseInt(req.getParameter("did"));
        user.setDid(did);

        int jid=Integer.parseInt(req.getParameter("jid"));
        user.setJid(jid);
        if(jid==1){
            user.setRid(1);
        }else if(jid==2){
           user.setRid(4);
        }else if (jid==3){
            user.setRid(4);
        }else if (jid==4){
            user.setRid(5);
        }else if (jid==5){
            user.setRid(5);
        }else if (jid==6){
            user.setRid(5);
        }

        int mgr=Integer.parseInt(req.getParameter("mgr"));
        user.setMgr(mgr);

        String phone =req.getParameter("phone");
        user.setPhone(phone);

        String qq=req.getParameter("qq");
        user.setQq(qq);

        String contacts=req.getParameter("contacts");
        user.setContacts(contacts);

        String idcard=req.getParameter("idcard");
        user.setIdcard(idcard);


        return user;
    }

    /**
     * 生成不重复的随机数
     * @param size
     * @return
     */

}
