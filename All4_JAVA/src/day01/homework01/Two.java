package day01.homework01;

public class Two {
	public static void main(String[] args) {
		for (int i = 0; i <3 ; i++) {		
			for (int j = 0; j<=i; j++) {		
				System.out.print("*");		// j 가 i 이하일 때만 별 출력
			}
			System.out.println();			//줄바꿈
		}
	}

}
