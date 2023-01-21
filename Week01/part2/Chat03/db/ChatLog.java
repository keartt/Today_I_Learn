package Chat03.db;

import java.sql.Timestamp;

public class ChatLog {
	private int id;
	private String sender;
	private String reciver;
	private String contents;
	private java.sql.Timestamp created_at;
	
	
	public ChatLog(int id, String sender, String reciver, String contents, Timestamp in_out_time) {
		super();
		this.id = id;
		this.sender = sender;
		this.reciver = reciver;
		this.contents = contents;
		this.created_at = in_out_time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public java.sql.Timestamp getTime() {
		return created_at;
	}
	public void setTime(java.sql.Timestamp in_out_time) {
		this.created_at = in_out_time;
	} 
	
}
