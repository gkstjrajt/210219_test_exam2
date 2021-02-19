package ncs_java_yhs3.dto;

import java.sql.Timestamp;

public class Board {
	private int idx;
	private String writer;
	private String subject;
	private String content;
	private Timestamp conDate;

	public Board() {
	}

	public Board(int idx, String writer, String subject, String content, Timestamp conDate) {
		this.idx = idx;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.conDate = conDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getConDate() {
		return conDate;
	}

	public void setConDate(Timestamp conDate) {
		this.conDate = conDate;
	}

	@Override
	public String toString() {
		return "Board [idx=" + idx + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", conDate=" + conDate + "]";
	}

}
