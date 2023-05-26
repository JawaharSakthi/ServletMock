package servlet_mock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mock_Dao;
import dto.Mock_Table;

@WebServlet("/search")
public class Search_Id extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Mock_Dao dao = new Mock_Dao();
		Mock_Table detail = dao.search_id(id);

		if (detail != null) {
			resp.getWriter().print("<h1>Value is Present</h1>");
			resp.getWriter()
			.print("<html><head><table border=1px><tr><td>ID</td><td>Name</td><td>Mobile</td></tr><tr><td>"
					+ detail.getId() + "</td><td>" + detail.getName() + "</td><td>" + detail.getMobile()
					+ "</td></tr></table></html>");
		} else {
			resp.getWriter().print("<h1>Value not present</h1>");
		}
		
		req.getRequestDispatcher("Mock.jsp").include(req, resp);
	}
}