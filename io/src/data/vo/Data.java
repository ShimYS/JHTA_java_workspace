package data.vo;
//발생년,발생년월일시분,주야,요일,사망자수,사상자수,중상자수,경상자수,부상신고자수,발생지시도,
//발생지시군구,사고유형_대분류,사고유형_중분류,사고유형,법규위반_대분류,법규위반,도로형태_대분류,도로형태,가해자_당사자종별_대분류,가해자_당사자종별,
//피해자_당사자종별_대분류,피해자_당사자종별,발생위치X_UTMK,발생위치Y_UTMK,경도,위도

public class Data {
	private String day;
	private String dayOfWeek;	//요일
	private int numOfDeath;
	private String sido;
	private String gugun;
	private String violationOfLaw;
	
	public Data() {}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getNumOfDeath() {
		return numOfDeath;
	}

	public void setNumOfDeath(int numOfDeath) {
		this.numOfDeath = numOfDeath;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getViolationOfLaw() {
		return violationOfLaw;
	}

	public void setViolationOfLaw(String violationOfLaw) {
		this.violationOfLaw = violationOfLaw;
	}
	
	
}
