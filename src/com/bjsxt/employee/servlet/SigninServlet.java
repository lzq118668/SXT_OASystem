package com.bjsxt.employee.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.base.util.DateUtil;
import com.bjsxt.employee.pojo.Signin;
import com.bjsxt.employee.service.SigninService;
import com.bjsxt.employee.service.impl.SigninServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet("/sign.action")
public class SigninServlet extends BaseServlet {

    private SigninService signinService = new SigninServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private PrintWriter out = null;


    public void signin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String id = req.getParameter("id");
        System.out.println(id);
        Signin signin = new Signin();
        signin.setUid(Integer.parseInt(id));

        //当前时间。yyyy-MM-dd
        String todaydate = dateFormat.format(new Date());

        //是否进行插入操作的标志
        String mark = req.getParameter("mark");
        System.out.println(mark);

        out = resp.getWriter();

        if (mark == "no") {
            //查询当天是否已经签到。
            String tdate = req.getParameter("tdate");
            Signin signin1 = signinService.selToday(java.sql.Date.valueOf(tdate));

            if (signin1 != null) {
                out.print("1");
            } else {
                out.print("2");
            }
        } else if (mark == "ok") {
            //插入当天签到数据。
            int i = signinService.insSign(signin);

            if (i > 0) {
                //设置session的有效期为24小时，当天00：00时销毁。
                req.getSession().setMaxInactiveInterval(60 * 24 * 60);

                java.sql.Date date = java.sql.Date.valueOf(todaydate.toString());

                Signin today = signinService.selToday(date);
                //将当天的签到信息放入today对象传入前台。
                req.getSession().setAttribute("today", today);

                out.print("yes");

            } else {

                out.print("no");

            }


        }

    }

    public void signout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {

        //创建当前时间对象
        String now = dateFormat.format(new Date());


        //创建格式化日期对象。规则为HH:mm:ss
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String nowTime = timeFormat.format(new Date());

        //获取当天签到的id。
        Signin today = (Signin) req.getSession().getAttribute("today");
        int id = today.getId();
        String qddate = today.getQddate().toString();
        out = resp.getWriter();
        if (qddate == null) {
            out.print("请先签到再进行此操作！");
            req.getRequestDispatcher("Empoyee/dutyAdd.jsp");
        } else {
            int i = signinService.insSignout(id + "");
            if (i > 0) {
                out.print("签退成功!");
                //过了11:30自动销毁session
                DateUtil.TimeForSession(nowTime, req.getSession());
                //如果签到时间不在当天11：30点前，销毁session

            } else {
                out.print("签退失败！请重试。");
            }


        }
    }

    public void selSign(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {

        User user = (User) req.getSession().getAttribute("user");
        Signin signin = new Signin();
        int uid = user.getId();

        List<Signin> signins = signinService.selSign(uid);

//        for (Signin signina : signins) {
//            signina.setAttdate(StrToDate(dateFormat.format(signina.getAttdate())));
//            System.out.println(StrToDate(dateFormat.format(signina.getAttdate())));
//            System.out.println(dateFormat.format(signina.getAttdate()));
//        }


        req.getSession().setAttribute("signins", signins);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();



        resp.getWriter().print(gson.toJson(signins));

        resp.sendRedirect(req.getContextPath() + "Empoyee/myDuty.jsp");

    }
}
