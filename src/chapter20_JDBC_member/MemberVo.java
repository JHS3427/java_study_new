package chapter20_JDBC_member;

public class MemberVo {

	//Field
	int MEMBER_ID;
	String NAME;
	String EMAIL;
	String CREATED_AT;
	public int getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(int mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getCREATED_AT() {
		return CREATED_AT;
	}
	public void setCREATED_AT(String cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}
}
