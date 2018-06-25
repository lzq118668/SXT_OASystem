package com.bjsxt.leader.servlcet;

import com.bjsxt.base.servlet.BaseServlet;
import com.bjsxt.leader.pojo.Img;
import com.bjsxt.leader.service.ImgService;
import com.bjsxt.leader.service.impl.ImgServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/img.action")
public class ImgServlet extends BaseServlet {

    public void selByBid(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      int  bid = Integer.parseInt(req.getParameter("bid"));
        ImgService is=new ImgServiceImpl();
        List<Img> imgs = is.selByBid(bid);
        req.getSession().setAttribute("imgs",imgs);
        resp.sendRedirect(req.getContextPath()+"leader/expenseImg.jsp");
        System.out.println(imgs);


    }
}
