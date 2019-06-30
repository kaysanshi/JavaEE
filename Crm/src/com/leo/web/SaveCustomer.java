package com.leo.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.leo.domain.Customer;
import com.leo.service.CustomerService;
import com.leo.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class SaveCustomer
 */
@WebServlet(description = "保存修改的用户", urlPatterns = { "/SaveCustomer" })
public class SaveCustomer extends HttpServlet {
	private CustomerService service =new CustomerServiceImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		String id=request.getParameter("cust_id");
		try {
			BeanUtils.setProperty(customer, "cust_id", id);//设置某个bean的属性值
			BeanUtils.populate(customer, request.getParameterMap());//将map装换为bean
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean boo=service.saveUpdate(customer);
		if(boo=true) {
			request.getRequestDispatcher("/ListCustomer").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
