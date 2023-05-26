package servlet_mock;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Mock_Dao;
import dto.Mock_Table;

@WebServlet("/fetchAll")
public class FetchAll extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Mock_Dao dao = new Mock_Dao();

		List<Mock_Table> lstAll = dao.fetchAll();
		resp.getWriter().print("<html><head><table border=1px><tr><td>ID</td><td>Name</td><td>Mobile</td></tr>");
		for (Mock_Table mock : lstAll) {
			resp.getWriter().print("<tr><td>" + mock.getId() + "</td><td>" + mock.getName() + "<td>" + mock.getMobile()
					+ "</td></tr>");
		}
		resp.getWriter().print("</table>");
		req.getRequestDispatcher("Mock.jsp").include(req, resp);
	}
}
