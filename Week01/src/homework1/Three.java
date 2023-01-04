package homework1;


public class Three {

	public static void main(String[] args) {
		for (int i = 0; i <3 ; i++) {
			
			for (int k = 0; k < 2-i;  k++) {		// 공백찍기
			System.out.print(" ");
			}
			
			for (int j = 0; j<i+1; j++) {			// 별찍기
				System.out.print("*");
			}
			System.out.println();					// 쥴버뀸
		
	}


}
}