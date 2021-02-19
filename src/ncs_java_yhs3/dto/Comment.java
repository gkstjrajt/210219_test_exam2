package ncs_java_yhs3.dto;

import java.sql.Timestamp;

public class Comment {
	private int idx;
	private int bIdx;
	private String writer;
	private String content;
	private Timestamp comDate;

	public Comment() {
	}

	public Comment(int idx, int bIdx, String writer, String content, Timestamp comDate) {
		this.idx = idx;
		this.bIdx = bIdx;
		this.writer = writer;
		this.content = content;
		this.comDate = comDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getbIdx() {
		return bIdx;
	}

	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getComDate() {
		return comDate;
	}

	public void setComDate(Timestamp comDate) {
		this.comDate = comDate;
	}

	@Override
	public String toString() {
		return "Comment [idx=" + idx + ", bIdx=" + bIdx + ", writer=" + writer + ", content=" + content + ", comDate="
				+ comDate + "]";
	}

}
