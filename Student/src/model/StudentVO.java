package model;

public class StudentVO {
	private int num;
	private String name;
	private int score;
	public StudentVO() {
//		System.out.println("로그 : 기본생성자 호출됨");
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "StudentDAO [num=" + num + ", name=" + name + ", score=" + score + "]";
	}

}
