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

@WebServlet("/saveUpdatedCar")
public class SaveUpdatedCars extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int carId =Integer.parseInt(req.getParameter("carId"));
		String carModel=req.getParameter("carModel");
		String carBrand=req.getParameter("carBrand");
		int carPrice=Integer.parseInt(req.getParameter("carPrice"));


		Car car=new Car();
		car.setCarId(carId);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarPrice(carPrice);


		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(car);
		trans.commit();
		Query<Car> query = session.createQuery("FROM Car ");
		List<Car> cars= query.list();
		session.close();
		req.setAttribute("carList", cars);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("Display.jsp");
		requestDispatcher.forward(req, resp);
	}
}
