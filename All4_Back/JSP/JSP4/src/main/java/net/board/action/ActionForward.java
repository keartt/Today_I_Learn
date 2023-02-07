package net.board.action;

public class ActionForward { 				// 전송방식, 경로 결정해줌 
    private boolean isRedirect=false;		// 리다이렉트 방식으로 갈래? 포워드 방식으로 갈래? -> boolean 을 이용해서
    private String path=null;
    
    public boolean isRedirect(){
        return isRedirect;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setRedirect(boolean b){
        isRedirect=b;
    }
    
    public void setPath(String string){
        path=string;
    }
}