package com.bjsxt.employee.servlet;

import com.bjsxt.base.pojo.User;
import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.base.util.DateUtil;
import com.bjsxt.employee.pojo.Signin;
import com.bjsxt.employee.service.SigninService;
import com.bjsxt.employee.service.impl.SigninServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/sign.action")
public class SigninServlet extends BaseServlet {

    private SigninService signinService = new SigninServiceImpl();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void signin(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        Signin signin = new Signin();
        signin.setUid(Integer.parseInt(id));
        int i = signinService.insSign(signin);
        //创建签到时间对象

        String todaydate = dateFormat.format(new Date());

        if (i > 0) {
            //设置session的有效期为24小时，当天00：00时销毁。
            req.getSession().setMaxInactiveInterval(60 * 24 * 60);

            java.sql.Date date = java.sql.Date.valueOf(dateFormat.format(new Date()).toString());

            Signin today = signinService.selToday(date);
            //将当天的签到信息放入today对象传入前台。
            req.getSession().setAttribute("today", today);
            //将是否签过到的flag放到session中
            req.getSession().setAttribute("todaydate", todaydate);
            req.getSession().setAttribute("flag", true);
            req.setAttribute("msg", "签到成功");
        } else {
            req.setAttribute("msg", "签到失败");
        }

    }

    public void signout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {

        //创建当前时间对象
        String now = dateFormat.format(new Date());

        //创建格式化日期对象。规则为HH:mm:ss
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String nowTime = timeFormat.format(new Date());
        //获取是否签过到的flag
        Boolean flag = (Boolean) req.getSession().getAttribute("flag");

        //获取签到是存入session的日期。
        String todaydate = (String) req.getSession().getAttribute("todaydate");


        //获取当天签到的id。
        Signin today = (Signin) req.getSession().getAttribute("today");
        int id = today.getId();
        if (now == todaydate) {

            int i = signinService.insSignout(id + "");
            if (i > 0) {
                req.setAttribute("msg", "签退成功");

                //过了11:30自动销毁session
                DateUtil.TimeForSession(nowTime, req.getSession());
                //如果签到时间不在当天11：30点前，销毁session
                if (!DateUtil.compareTime(nowTime, "11:30:00")) {
                    req.getSession();
                    req.getSession().invalidate();
                }
            } else {
                req.setAttribute("msg", "签退失败");
            }
        } else {
            req.setAttribute("msg", "不是签到时间！");
        }


    }

    public void selSign(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        User user = (User) req.getSession().getAttribute("user");
        Signin signin = new Signin();
        int uid = user.getId();

        List<Signin> signins = signinService.selSign(uid);

        req.setAttribute("signins",signins);

        //req.getRequestDispatcher("");

    }
}
