package model;
//∂‘”¶duty±Ì
import java.io.Serializable;
public class TbDutyInfo implements Serializable{
	public int getDutyId() {
		return dutyId;
	}
	public void setDutyId(int dutyId) {
		this.dutyId = dutyId;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public int getDutyGrade() {
		return dutyGrade;
	}
	public void setDutyGrade(int dutyGrade) {
		this.dutyGrade = dutyGrade;
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
	private int dutyId;
	private String dutyName;
	private int dutyGrade;
	private String hireDate;
	private String fireDate;

}
