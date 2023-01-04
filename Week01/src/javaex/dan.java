package javaex;

public class dan {

	public static void main(String[] args) {
//		for (int i = 1; i < 10  ; i++) {
//			for (int j = 2; j < 10; j++) {
//				System.out.print(j+"*"+i+"="+j*i+"\t");
//			}
//			System.out.println();
//		}
		
		int i = 1;
		
		while (i<10) {
			int j = 2;
			while (j<10) {
				System.out.print(j+"*"+i+"="+j*i+"\t");
				j++;
			}
			i++;
			System.out.println();
		}
		
	}
}
