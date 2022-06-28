package routine.fwd.vo;

import java.time.LocalDateTime;

public class ExBoardVo {

	private int exb_no;
	private int exm_name;
	private String m_name;
	private String exb_title;
	private String exb_text;
	private LocalDateTime exb_time;
	private int exb_look;

	public int getExb_no() {
		return exb_no;
	}

	public void setExb_no(int exb_no) {
		this.exb_no = exb_no;
	}

	public int getExm_name() {
		return exm_name;
	}

	public void setExm_name(int exm_name) {
		this.exm_name = exm_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getExb_title() {
		return exb_title;
	}

	public void setExb_title(String exb_title) {
		this.exb_title = exb_title;
	}

	public String getExb_text() {
		return exb_text;
	}

	public void setExb_text(String exb_text) {
		this.exb_text = exb_text;
	}

	public LocalDateTime getExb_time() {
		return exb_time;
	}

	public void setExb_time(LocalDateTime exb_time) {
		this.exb_time = exb_time;
	}

	public int getExb_look() {
		return exb_look;
	}

	public void setExb_look(int exb_look) {
		this.exb_look = exb_look;
	}

}
