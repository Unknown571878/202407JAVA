package com.board.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.db.*;
import com.board.service.BoardService;

@WebServlet("/")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = null;

		// URL에서 프로젝트 이름 뒷 부분의 문자열 얻어내기
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		// 주어진 URL에 따라 지정된 동작 수행
		if (com.equals("/") || com.equals("/index") || com.equals("/userindex")) {
			HttpSession session = request.getSession();
			if (session == null || session.getAttribute("userNum") == null
					|| session.getAttribute("userNum").equals(""))
				view = "index.jsp";
			else {
				view = "userindex.jsp";
			}
		} else if (com.equals("/logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("userNum");
			view = "index.jsp";
		} else if (com.equals("/login")) {
			view = "login.jsp";
		} else if (com.equals("/join")) {
			view = "join.jsp";
		} else if (com.equals("/deleteAccount")) {
			HttpSession session = request.getSession();
			int usernum = (Integer)session.getAttribute("userNum");
			AccountDAO dao = new AccountDAO();
			BoardDao boardDao = new BoardDao();
			if(boardDao.deleteAll(usernum)) {
				System.out.println("오류발생");
			}
			if(dao.deleteAccount(usernum)) {
				System.out.println("오류발생");
			}
			session.removeAttribute("userNum");
			view = "index.jsp";
		} else if (com.equals("/updateAccount")) {
			HttpSession session = request.getSession();
			int usernum = (Integer) session.getAttribute("userNum");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String adr = request.getParameter("adr");
			AccountDAO dao = new AccountDAO();
			AccountDTO dto = new AccountDTO();
			dto.setUsernum(usernum);
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setNickname(nickname);
			dto.setAdr(adr);
			dao.updateAccount(dto);
			
			view = "redirect:index";
		} else if (com.equals("/account")) {
			HttpSession session = request.getSession();
			int usernum = (Integer)session.getAttribute("userNum");
			AccountDAO dao = new AccountDAO();
			AccountDTO dto = dao.accountInfo(usernum);
			request.setAttribute("userinfo", dto);
			view = "account.jsp";
		} else if (com.equals("/loginAction")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			try {
				AccountDAO dao = new AccountDAO();
				AccountDTO dto = dao.loginAccount(id, pw);
				HttpSession session = request.getSession();
				session.setAttribute("userNum", dto.getUsernum());
				view = "redirect:index";
			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}
		} else if (com.equals("/addAccount")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			String adr = request.getParameter("adr");
			try {
				AccountDTO dto = new AccountDTO();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				dto.setNickname(nickname);
				dto.setAdr(adr);
				AccountDAO dao = new AccountDAO();
				dao.insertOne(dto);
				request.setAttribute("Accountregist", true);
				view = "redirect:index";
			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}
		} else if (com.equals("/list")) {
			String tmp = request.getParameter("page");
			int pageNo = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 1;

			request.setAttribute("msgList", new BoardService().getMsgList(pageNo));
			request.setAttribute("pgnList", new BoardService().getPagination(pageNo));
			System.out.println(new BoardService().getPagination(pageNo));
			view = "list.jsp";

		} else if (com.equals("/view")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			HttpSession session = request.getSession();
			int usernum = (Integer)session.getAttribute("userNum");
			BoardDto boardDto = new BoardDto();
			boardDto.setNum(num);
			boardDto.setUsernum(usernum);
			BoardDao boardDao = new BoardDao();
			if(boardDao.userPost(boardDto) == 1) {
				request.setAttribute("mypost", true);
				System.out.println(boardDao.userPost(boardDto));
			} else {
				request.setAttribute("mypost", false);
			}
			request.setAttribute("msg", new BoardService().getMsg(num));
			view = "view.jsp";

		} else if (com.equals("/write")) {
			String tmp = request.getParameter("num");
			int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

			BoardDto dto = new BoardDto();
			String action = "insert";
			
			HttpSession session = request.getSession();
			int usernum = (Integer)session.getAttribute("userNum");
			
			AccountDAO dao = new AccountDAO();
			AccountDTO accountDTO =  dao.accountInfo(usernum);
			request.setAttribute("account", accountDTO);
			
			if (num > 0) {
				dto = new BoardService().getMsgForWrite(num);
				action = "update?num=" + num;
			}

			request.setAttribute("msg", dto);
			request.setAttribute("action", action);
			view = "write.jsp";

		} else if (com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			LocalDateTime now = LocalDateTime.now();
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			HttpSession session = request.getSession();
			int usernum = (Integer) session.getAttribute("userNum");
			try {
				new BoardService().writeMsg(writer, title, content, date, usernum);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/update")) {
			request.setCharacterEncoding("utf-8");
			int num = Integer.parseInt(request.getParameter("num"));
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			try {
				new BoardService().updateMsg(writer, title, content, num);
				view = "redirect:list";

			} catch (Exception e) {
				request.setAttribute("errorMessage", e.getMessage());
				view = "errorBack.jsp";
			}

		} else if (com.equals("/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));

			new BoardService().deleteMsg(num);
			view = "redirect:list";
		}

		// view에 담긴 문자열에 따라 포워딩 또는 리다이렉팅
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}