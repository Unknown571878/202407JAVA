package hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardService;
import command.CommandHandler;

public class ViewHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		int num = Integer.parseInt(req.getParameter("num"));

        req.setAttribute("msg", new BoardService().getMsg(num));
		return "/WEB-INF/view/view.jsp";
	}

}
