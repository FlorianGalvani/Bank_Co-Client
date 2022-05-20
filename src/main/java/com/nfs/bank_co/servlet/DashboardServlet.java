package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.DashboardView;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard/"})
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DashboardView> dashboardView = (List<DashboardView>) request.getSession().getAttribute("dashboardView");
        request.getSession().removeAttribute("dashboardView");
        List<DashboardView> updatedDashboardView = DaoFactory.getCustomerDao().getViewsByCustomerNumber(dashboardView);
        request.getSession().setAttribute("dashboardView", updatedDashboardView);
        if (updatedDashboardView.get(0).getIsNewCustomer()) {
            response.sendRedirect(request.getContextPath() + "/dashboard/newcustomer.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
