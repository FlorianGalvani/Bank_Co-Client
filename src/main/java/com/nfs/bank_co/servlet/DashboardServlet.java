package com.nfs.bank_co.servlet;

import com.nfs.bank_co.dao.DaoFactory;
import com.nfs.bank_co.entities.Customer;
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
//        Customer customer = (Customer) request.getSession().getAttribute("customer");
//        if (customer.getNewCustomer()) {
//            response.sendRedirect(request.getContextPath() + "/dashboard/newcustomer.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
//        }
        List<DashboardView> dashboardView = (List<DashboardView>) request.getSession().getAttribute("dashboardView");
        request.getSession().removeAttribute("dashboardView");
        List<DashboardView> updatedDashboardView = DaoFactory.getCustomerDao().getViewsByCustomerNumber(dashboardView);
        System.out.println("UPDATE DASHBOARD VIEW : " +updatedDashboardView.get(0).getBalance());

        request.getSession().setAttribute("dashboardView", updatedDashboardView);
        response.sendRedirect(request.getContextPath() + "/dashboard/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
