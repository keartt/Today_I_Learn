package day06;

public class ExceptionTest {
// 예외처리 .. 중간에 멈추지 않게 하기 위해서	
										// try catch 문 사용빈도 줄이기 위해 throws
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
		int[] arr = { 1, 2, 3, 4 };
		for (int i = 0; i < 5; i++) {
			try {	// 예외 발생 예상 환경
				System.out.println(arr[i]);
				// 에러 발생한 순간 아래 문장 실행이 아니라 catch 로 이동
				System.out.println("Test"+i);
			} catch (ArrayIndexOutOfBoundsException e) { // 예외처리
				// 에러 메세지
				System.out.println("Exception");
			
				// 다중 캐치문 ... 최종 오류 대장 Exception
				// 예상 불가한 오류 > Exception class
				// 다른걸 잡을 수 도 있기 때문에 Exception 은 trycatch 맨 아래에
			} catch (Exception e) {
				
			}
			
				// finally
				// 예외 발생하던 말던 동작해야 하는 부분
			finally {
				System.out.println("Test" + i);
			}
		}
		System.out.println("end");
	}
}
