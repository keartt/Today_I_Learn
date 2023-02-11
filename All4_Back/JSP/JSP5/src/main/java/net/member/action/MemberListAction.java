package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.Action;
import net.board.action.ActionForward;
import net.member.db.MemberDAO;

public class MemberListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		ActionForward forward = new ActionForward();
		MemberDAO mb = new MemberDAO();
		
		
		ArrayList<String> memberList = new ArrayList<String>();
		memberList = mb.getUserID();
		
		request.setAttribute("memberList", memberList);
		
		forward.setRedirect(false);
		forward.setPath("./member/Member_list.jsp");

	return forward;
	}

}
