package day05.score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Process {
	private Scanner sc = new Scanner(System.in);

	private ArrayList<Students> studentList = new ArrayList<Students>();

	public void start() {
		addSampless();
		while (true) {

			System.out.println("1:입력  2:검색  3:삭제  4:조회  0:종료");
			System.out.print(">> ");

			int num = sc.nextInt();

			switch (num) {

			case 1:
				add();
				break;

			case 2:
				search();
				break;

			case 3:
				del();
				break;

			case 4:
				list(studentList);
				break;

			case 0:
				System.out.println("종료");
				return;

			default:
				System.out.println("잘못된 입력");
				break;
			}
		}

	}

	private void search() {
		while (true) {

			System.out.println("1:이름검색  2:국어점수  3:수학점수  4:영어점수  5:평균  0:종료");
			System.out.print(">> ");

			int num = sc.nextInt();

			switch (num) {

			case 1:searchName();
				break;

			case 2:searchKor();
				break;

			case 3: searchMath();
				break;

			case 4: searchEng();
				break;
				
			case 5: searchAvg();
				break;

			case 0: 
				System.out.println("종료");
				return;

			default:
				System.out.println("잘못된 입력");
				break;
			}
		}
	}
//	-------------------------정렬-----------------------------------
	private void searchName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equals(name)) {
				show(studentList.get(i));
			} else 
				System.out.println("없음");
		}
	}

	private void searchKor() {
		Collections.sort(studentList, new KorComparator());
		list(studentList);
	}
	private void searchMath() {
		Collections.sort(studentList, new MathComparator());
		list(studentList);
	}
	private void searchEng() {
		Collections.sort(studentList, new EngComparator());
		list(studentList);
	}
	private void searchAvg() {
		Collections.sort(studentList, new AvgComparator());
		list(studentList);
	}
	
	
//	-------------------------정렬-----------------------------------

	// 단일 출력
	private void show(Students students) {
		System.out.println(students.toString());
	}

	private void del() {
		System.out.println("삭제할 이름 입력: ");
		String name = sc.next();

		for (Students st : studentList.stream().collect(Collectors.toList())) {
			// .stream() ~ : checkForComodification 오류 발생으로 인해 추가
			if (st.getName().equals(name)) {
				studentList.remove(st);
			}

		}
		System.out.println("삭제되었습니다");

		
//		for (int i = 0; i < studentList.size(); i++) {
//			if (studentList.get(i).getName().equals(name)) {
//				show(studentList.remove(i));
//			} else 
//				System.out.println("없음");
//		}
	}

	private void add() {
		System.out.print("이름을 입력하세요: ");
		String name = sc.next();

		System.out.print("국어점수를 입력하세요: ");
		int kor = sc.nextInt();

		System.out.print("수학점수를 입력하세요: ");
		int math = sc.nextInt();

		System.out.print("국어점수를 입력하세요: ");
		int eng = sc.nextInt();

		// 생성자를 통한 값 주입
		Students students = new Students(name, kor, math, eng);
		studentList.add(students);

	}

	public void list(List<Students> list) {

		System.out.println("이름\t국어\t수학\t영어\t총점\t평균");
		System.out.println("===========================================");
		for (Students s : list) {
			System.out.println(s.getName() + "\t" + s.getKor() + "\t" + s.getMath() + "\t" + s.getEng() + "\t"
					+ s.getSum() + "\t" + s.getAvg());
		}
		
//		for (Students s : list) {
//			System.out.println(s.toString());
//		}
		System.out.println();
	}
	
//	-------------------------기본값-----------------------------------
	private void addSampless() {
		studentList.add(new Students("A", 11, 22, 39));
		studentList.add(new Students("B", 12, 21, 34));
		studentList.add(new Students("C", 13, 24, 33));
		studentList.add(new Students("D", 14, 23, 30));
		studentList.add(new Students("E", 15, 26, 32));
		studentList.add(new Students("F", 16, 25, 35));
		studentList.add(new Students("G", 17, 27, 31));
    }

}



