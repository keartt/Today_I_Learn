package net.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI(); // getRequestURI : url 가져온다
		String contextPath = request.getContextPath(); // 마지막 ~~.bo 전까지만 읽는다 = getContextPath
		String command = RequestURI.substring(contextPath.length()); // 그니까 잘라서 bo 까지만 읽는다
																		// http://localhost/aaproject/awrite.bo 에서
																		// awrite.bo 만가져옴
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/BoardList.bo")) {
			// 위 링크가 들어오면 아래 액션 페이지에서 실행을 해
			action = new BoardListAction();
			try {
				// 마지막에 포워드 액션에서 알려줘, 어떤 방식인지
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	     else if(command.equals("/BoardWrite.bo")) {
	         forward=new ActionForward();
	         forward.setRedirect(false);
	         forward.setPath("./board/qna_board_write.jsp");
	      }


		if(forward.isRedirect()){
            response.sendRedirect(forward.getPath());
        }else{
            RequestDispatcher dispatcher=
                request.getRequestDispatcher(forward.getPath());
            dispatcher.forward(request, response);
        }	
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}