package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;

public class MemberFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

//  로그인 요청 forward 
		if (command.equals("/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/loginForm.jsp");
		}
// 로그아웃
		
		else if (command.equals("/logout.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/logout.jsp");
		}

//		회원 가입 요청 = forward
		// 포워드 치고 게시글 보러 이동~
		else if (command.equals("/join.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/joinForm.jsp");
		}

//		회원 가입 액션 = redirect 
		// DB 찍고 맞는지 확인
		else if (command.equals("/joinProcess.me")) {
			action = new JoinAction();
			forward = action.execute(request, response);
		}

//		로그인 성공- 실패 / name 과  id  ... param 으로 넘김
		else if (command.equals("/loginProcess.me")) {
			action = new LoginAction();
			forward = action.execute(request, response);
		}

		// 어드민 로그인 성공 -> 유저 리스트 페이지로
		else if (command.equals("/MemberList.me")) {
			action = new MemberListAction();
			forward = action.execute(request, response);
		}

		// 유저 정보 조회
		else if (command.equals("/Member_info.me")) {
			action = new MemberViewAction();
			forward =action.execute(request, response);

		}

		// 유저 정보 삭제
		else if (command.equals("/Member_delete.me")) {
			action = new MemberDeleteAction();
			forward = action.execute(request, response);

		}

		// redirect - forward 에 따른 전송방식 차이 지정
		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
