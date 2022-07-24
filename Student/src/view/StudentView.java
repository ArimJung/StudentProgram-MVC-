package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.StudentVO;

public class StudentView {

	public int action;
	Scanner sc = new Scanner(System.in);

	public void startView() {
		while(true) {

			System.out.println();
			System.out.println("===학생부 프로그램===");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생목록");
			System.out.println("3. 성적변경");
			System.out.println("4. 학생삭제");
			System.out.println("5. 종료");
			System.out.println("6. 이름검색");
			System.out.print("메뉴입력 ) ");

			try {
				action = sc.nextInt();
				if(1<=action&&action<=6) {
					break;
				}
				System.out.println("범위외입력!");
			}catch(Exception e) {
				sc.nextLine();
				System.out.println("정수만 입력하세요!");
			}

		}
	}
	
	public String inputString() {
		System.out.print("문자열 입력 ) ");
		String str=sc.next();
		return str;
	}
	
	public int inputInt() {
		System.out.print("정수 입력 ) ");
		int i=sc.nextInt();
		return i;
	}
	
	public void printDatas(ArrayList<StudentVO> datas) {
		System.out.println();
		if(datas.size()==0) {
			System.out.println("저장된 정보가 없습니다!");
			return;
		}
		
		System.out.println("===학생목록===");
		for(StudentVO vo: datas) {
			System.out.println(vo.getNum()+"번 "+vo.getName()+"학생 "+vo.getScore()+"점");
		}
		System.out.println("================");
	}

	public void add() {
		System.out.println("학생추가 메뉴입니다.");
	}
	
	public void print() {
		System.out.println("학생목록 메뉴입니다.");
	}
	
	public void update() {
		System.out.println("성적변경 메뉴입니다.");
	}
	
	public void delete() {
		System.out.println("학생삭제 메뉴입니다.");
	}
	
	public void insertName() {
		System.out.println("이름을 입력합니다..");
	}
	
	public void insertScore() {
		System.out.println("성적을 입력합니다..");
	}
	
	public void insertNum() {
		System.out.println("번호를 입력합니다..");
	}
	
	public void shutup() {
		System.out.println("프로그램을 종료합니다.....");
	}
	
	public void success() {
		System.out.println("수행성공!");
	}
	
	public void fail() {
		System.out.println("수행실패...");
	}  
	
	public String addscorecheck() {
		String ans;
		while(true) {
			System.out.println("성적을 추가 입력하시겠습니까? (Y/N)");
			ans = sc.next();
			ans.toUpperCase();
			if(ans.equals("YES")|| ans.equals("NO")) {
				break;
			}
			System.out.println("YES or NO 만 입력가능합니다!");
		}   
		return ans;
	}
	
	public void searchName() {
		System.out.println("이름검색 메뉴입니다..");
	}
	
}
