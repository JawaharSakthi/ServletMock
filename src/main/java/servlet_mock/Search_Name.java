package servlet_mock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mock_Dao;
import dto.Mock_Table;

@WebServlet("/searchName")
public class Search_Name extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		Mock_Dao dao = new Mock_Dao();
		Mock_Table detail = dao.search_name(name);

		resp.getWriter().print("<h1>Value is Present</h1>");
		resp.getWriter()
				.print("<html><head><table border=1px><tr><td>ID</td><td>Name</td><td>Mobile</td></tr><tr><td>"
						+ detail.getId() + "</td><td>" + detail.getName() + "</td><td>" + detail.getMobile()
						+ "</td></tr></table></html>");
		req.getRequestDispatcher("Mock.jsp").include(req, resp);
	}
}
