package model;
import java.io.Serializable;
//±ítb_specialduty
public class TbSpecialdutyInfo implements Serializable{
	public int getSdId() {
		return sdId;
	}
	public void setSdId(int sdId) {
		this.sdId = sdId;
	}
	public String getSdName() {
		return sdName;
	}
	public void setSdName(String sdName) {
		this.sdName = sdName;
	}
	public int getSdsId() {
		return sdsId;
	}
	public void setSdsId(int sdsId) {
		this.sdsId = sdsId;
	}
	public String getHireMark() {
		return hireMark;
	}
	public void setHireMark(String hireMark) {
		this.hireMark = hireMark;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getFireDate() {
		return fireDate;
	}
	public void setFireDate(String fireDate) {
		this.fireDate = fireDate;
	}
	public int getSdSalGrade() {
		return sdSalGrade;
	}
	public void setSdSalGrade(int sdSalGrade) {
		this.sdSalGrade = sdSalGrade;
	}
	public int getSdSal() {
		return sdSal;
	}
	public void setSdSal(int sdSal) {
		this.sdSal = sdSal;
	}
	public String getSdSalModDate() {
		return sdSalModDate;
	}
	public void setSdSalModDate(String sdSalModDate) {
		this.sdSalModDate = sdSalModDate;
	}
	public int getSdGrade() {
		return sdGrade;
	}
	public void setSdGrade(int sdGrade) {
		this.sdGrade = sdGrade;
	}
	private int sdId;
	private String sdName;
	private int sdsId;
	private String hireMark;
	private String hireDate;
	private String fireDate;
	private int sdSalGrade;
	private int sdSal;
	private String sdSalModDate;
	private int sdGrade;
	
	
}
