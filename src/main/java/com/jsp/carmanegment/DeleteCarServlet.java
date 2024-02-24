package com.jsp.carmanegment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
@WebServlet("/DeleteCar")
public class DeleteCarServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   int carId = Integer.parseInt(req.getParameter("carId"));
		   
		   Configuration con=new Configuration().configure().addAnnotatedClass(Car.class);
		   SessionFactory buildSessionFactory = con.buildSessionFactory();
		   Session session = buildSessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();
		   
		   Car car = session.get(Car.class, carId);
		   
		   session.delete(car);
		   
		   Query query = session.createQuery("FROM Car");
		   List cars = query.list();
		   
		   req.setAttribute("carList", cars);
		   RequestDispatcher requestDispatcher = req.getRequestDispatcher("Display.jsp");
		   requestDispatcher.forward(req, resp);
		   
		   transaction.commit();
		   session.close();
	}

}
