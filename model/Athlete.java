package model;

public class Athlete extends User {
	private boolean proffesional;
	private int skill;

	public boolean isProffesional() {
		return proffesional;
	}

	public void setProffesional(boolean proffesional) {
		this.proffesional = proffesional;
	}

	public int getSkill() {
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

}