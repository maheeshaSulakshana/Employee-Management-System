package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Employee;
import services.EmployeeServices;

import java.io.IOException;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String domain = request.getContextPath();
		String page = url.substring(domain.length());
		request.setAttribute("page", page);
		
		if (page.equals("/")) {
			request.getRequestDispatcher("views/home.jsp").forward(request, response);
		}
		else if (page.equals("/new")) {
			request.getRequestDispatcher("views/new-employee.jsp").forward(request, response);
		}
		else if (page.equals("/update")) {
			request.getRequestDispatcher("views/get-details.jsp").forward(request, response);
		}
		else if (page.equals("/delete")) {
			request.getRequestDispatcher("views/get-details.jsp").forward(request, response);
		}
		else if (page.equals("/view")) {
			request.getRequestDispatcher("views/employees.jsp").forward(request, response);
		}
		else if (page.equals("/search")) {
			request.getRequestDispatcher("views/get-details.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String domain = request.getContextPath();
		String page = url.substring(domain.length());
		request.setAttribute("page", page);
		
		if (page.equals("/new")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			int teleNo = Integer.valueOf(request.getParameter("teleNo"));
			String DOB = request.getParameter("DOB");
			String gender = request.getParameter("gender");
			String designation = request.getParameter("designation");
			
			Employee employee =  new Employee(name, address, teleNo, DOB, gender, designation);
			
			EmployeeServices employeeService = new EmployeeServices();
			
			if (employeeService.save(employee)) {
				response.sendRedirect("views/employees.jsp");
			}
			else {
				request.getRequestDispatcher("views/new-employee.jsp").forward(request, response);
			}
		}
		else if (page.equals("/update")) {
			String name = (String) request.getParameter("name");
			if (name.equals("")) {
				Integer ID = Integer.valueOf(request.getParameter("id"));
				EmployeeServices employeeServices = new EmployeeServices();
				Employee employee = employeeServices.findByID(ID);
				request.setAttribute("employee", employee);
				request.getRequestDispatcher("views/update-employee.jsp").forward(request, response);
			}
			else {
				int id = Integer.valueOf((String) request.getParameter("id"));
				name = request.getParameter("name");
				String address = request.getParameter("address");
				int teleNo = Integer.valueOf(request.getParameter("teleNo"));
				String DOB = request.getParameter("DOB");
				String gender = request.getParameter("gender");
				String designation = request.getParameter("designation");
				
				Employee employee = new Employee(id, name, address, teleNo, DOB, gender, designation);
				EmployeeServices employeeServices = new EmployeeServices();
				
				if (employeeServices.update(employee)) {
					response.sendRedirect("views/employees.jsp");
				}
				else {
					request.getRequestDispatcher("views/update-employee.jsp").forward(request, response);
				}
			}
		}
		else if (page.equals("/delete")) {
			String name = request.getParameter("name");
			if (name.equals("")) {
				Integer ID = Integer.valueOf(request.getParameter("id"));
				EmployeeServices employeeServices = new EmployeeServices();
				Employee employee = employeeServices.findByID(ID);
				request.setAttribute("employee", employee);
				request.getRequestDispatcher("views/delete-employee.jsp").forward(request, response);
			}
			else {
				Integer ID = Integer.valueOf(request.getParameter("id"));
				EmployeeServices employeeServices = new EmployeeServices();
				
				if (employeeServices.delete(ID)) {
					response.sendRedirect("views/employees.jsp");
				}
				else {
					request.getRequestDispatcher("views/delete-employee.jsp").forward(request, response);
				}
			}
		}
		else if (page.equals("/search")) {
			Integer ID = Integer.valueOf(request.getParameter("id"));
			EmployeeServices employeeServices = new EmployeeServices();
			Employee employee = employeeServices.findByID(ID);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("views/employee.jsp").forward(request, response);
		}
	}

}
