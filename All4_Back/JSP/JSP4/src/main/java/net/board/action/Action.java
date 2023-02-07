package net.board.action;

import javax.servlet.http.*;

public interface Action {
	
    public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}

//인터페이스니까 추상메소드 하나 만듦
	// 인터페이스? 추상메소드?  = 쉽게 기억해서 이걸 상속받는 애들은 이
	// execute 라는 메소드를 무조건 상속받아서 써야 함 
	// 그니까 뭔 액션~ 하면서 이거 상속받는 애들은 다 execute 로 뭘 해야 된다 ㅇㅋ?