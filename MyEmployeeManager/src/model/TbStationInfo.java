package model;

import java.io.Serializable;
//±ítb_stationinfo
public class TbStationInfo implements Serializable {
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getStKindId() {
		return stKindId;
	}
	public void setStKindId(int stKindId) {
		this.stKindId = stKindId;
	}
	public int getStSal() {
		return stSal;
	}
	public void setStSal(int stSal) {
		this.stSal = stSal;
	}
	public String getStSalModDate() {
		return stSalModDate;
	}
	public void setStSalModDate(String stSalModDate) {
		this.stSalModDate = stSalModDate;
	}
	private int stId;
	private String stName;
	private int stKindId;
	private int stSal;
	private String stSalModDate;
}
