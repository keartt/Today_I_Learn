import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Iterator;

public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		response.setCharacterEncoding("utf-8"); 
		
		PrintWriter out=response.getWriter();
		
		double num1=Double.parseDouble(request.getParameter("num1"));
		double num2=Double.parseDouble(request.getParameter("num2"));
		String oper=request.getParameter("oper");
		
		Calculator  c = new Calculator(num1, num2, oper);
		double result = c.getResult();
		
		String html="<!DOCTYPE html>"
				   +"<head>"
				   +"<meta charset=\"EUC-KR\">"
				   +"<title>Calc</title>"
				   +"</head><br>"
				   +"<body><br>"
				   +"<h1 align=\"center\">Calc</h1><br>"
				   +"<p align=\"center\">"
				   + num1 + " " + oper + " " + num2 + " = " + result
				   +"</p>"
				   +"<div align=\"center\">"
				   +"<a href=\"javascript:history.back();\">"
				   +"메인으로 돌아가기"
				   +"</a>"
				   +"</div>"
				   +"</body><br>"
				   +"</html><br>";
		
		
		out.write(html);
	}
	
	
}

class Calculator {
	double num1;
	double num2;
	String oper;
	public Calculator(double num1, double num2, String oper) {
		this.num1=num1;
		this.num2=num2;
		this.oper=oper;
	}
	
	public double  getResult(){
		double result = 0;
		switch(oper) {
		case"+" : result = num1+num2; break;
		case"-" : result = num1-num2; break;
		case"*" : result = num1*num2; break;
		case"/" : result = num1/num2; break;
		}
		return result;
	}
	
}


