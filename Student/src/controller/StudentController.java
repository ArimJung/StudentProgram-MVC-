package controller;

import java.util.ArrayList;

import model.StudentDAO;
import model.StudentVO;
import view.StudentView;

public class StudentController {
	private StudentDAO model;
	private StudentView view;
	public StudentController() {
		model = new StudentDAO();
		view = new StudentView();
	}
	public void startApp() {
		while(true) {
			view.startView();
			if(view.action==1) { // 학생추가
				view.add();
				view.insertName();
				String name = view.inputString();
				String ans = view.addscorecheck();
				int score =0;
				if(ans.equals("YES")) { // 성적 추가여부 묻기
					view.insertScore();
					score = view.inputInt();
				}

				StudentVO vo=new StudentVO();
				vo.setName(name); // V에서 입력받은 값을
				vo.setScore(score); // vo객체에 setter로 설정해서 인자로 넘겨줌

				boolean flag = model.insert(vo);
				if(flag) {
					view.success();	
				}
				else {
					view.fail();
				}
			}
			else if(view.action==2) { // ★★★★★(이름검색) // 학생목록 출력
				view.print();
				StudentVO vo=new StudentVO();
				ArrayList<StudentVO> datas=model.selectAll(vo);
				view.printDatas(datas);
			}
			else if(view.action==3) { // 성적변경
				view.update();
				view.insertNum();
				int num = view.inputInt();

				StudentVO vo = new StudentVO();
				vo.setNum(num);

				vo = model.selectOne(vo);
				if(vo==null) {
					System.out.println("	로그: "+num+"번의 학생은 존재하지않습니다!");
					view.fail();
					continue;
				}

				view.insertScore();
				int score = view.inputInt();
				vo.setScore(score);

				boolean flag = model.update(vo);
				if(flag) {
					view.success();
				}else {
					view.fail();
				}
			}
			else if(view.action==4) { // 학생삭제
				view.delete();
				view.insertNum();
				int num = view.inputInt();

				// c에서 유효한 vo인지를 확인하는 작업을 해준다면?
				StudentVO vo = new StudentVO();
				vo.setNum(num);
				vo=model.selectOne(vo);
				if(vo==null) {
					System.out.println("    로그 : "+ num +"번의 학생은 존재하지않습니다!");
					view.fail();
					continue;
				}

				boolean flag = model.delete(vo);
				if(flag) {
					view.success();
				}else {
					view.fail();
				}
			}
			else if(view.action==5) { // 종료
				view.shutup();
				break;
			}
			else if(view.action==6) { 
				view.searchName();
				view.insertName();
				String name = view.inputString();
				// 로직이 필요한 순간
				// DAO에서 제작해야함
				// R : selectAll
				// output이 2개이상 vs 1개or 0개 
				// -> pk로 검색하는 경우가 아니라면 모두 All()
				StudentVO vo = new StudentVO();
				vo.setName(name);
				// V에서 사용자가 입력한 이름정보를 
				// M_DAO의 핵심로직(비즈니스 메서드) 인자로 전달하는 코드
				ArrayList<StudentVO> datas = model.selectAll(vo);
				view.printDatas(datas);
			}
		}
	}
}
