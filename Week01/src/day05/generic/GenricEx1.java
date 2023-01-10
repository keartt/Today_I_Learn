package day05.generic;
// static import -> 클래스명 없이 사용 가능 
import static java.lang.System.out;
public class GenricEx1<T> {
	T[] v;
	
	public void set(T[] n) {
		v = n;
	}
	
	public void print() {
		for (T s : v) {
			out.println(s);
		}
	}
}
