package servlet_mock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.lookup.ConstraintExceptionFormula;
import org.hibernate.exception.ConstraintViolationException;

import dao.Mock_Dao;
import dto.Mock_Table;

@WebServlet("/insert")
public class Insert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));

		Mock_Table table = new Mock_Table();
		table.setId(id);
		table.setName(name);
		table.setMobile(mobile);

		Mock_Dao dao = new Mock_Dao();
		if (dao.search_id(id) == null) {
			dao.insert(table);
			resp.getWriter().print("<h1>Inserted Successfully</h1>");
		} else {
			resp.getWriter().print("<h1>Data Already Present</h1>");
		}

		req.getRequestDispatcher("Mock.jsp").include(req, resp);
	}
}
