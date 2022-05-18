package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Banker;
import com.nfs.bank_co.entities.DashboardView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContactServlet", urlPatterns = "/dashboard/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DashboardView> dashboardView = (List<DashboardView>) request.getSession().getAttribute("dashboardView");
        int bankerId = dashboardView.get(0).getId_banker();
        Banker banker = DaoFactory.getBankerDao().getOneById(bankerId);
        request.getSession().setAttribute("banker",banker);
        response.sendRedirect(request.getContextPath() + "/dashboard/contact.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
