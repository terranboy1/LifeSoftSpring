package com.example.spring04.model.memo.dto;

import java.util.Date;

public class MemoDTO {
	private String _id;
	private String writer;
	private String memo;
	private Date post_date;
	//getter/setter,toString()
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public MemoDTO(String _id, String writer, String memo, Date post_date) {
		super();
		this._id = _id;
		this.writer = writer;
		this.memo = memo;
		this.post_date = post_date;
	}
	
}
