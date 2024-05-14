package day04.abs;

public class AbsExam {

	public static void main(String[] args) {
		Circle cir = new Circle();
		Rect rect = new Rect();
		Tri tri = new Tri();
		Area area;
		
		area = cir;
		area.draw();	// cir.draq();
		
		area = rect;
		area.draw();	// rect.draw();
		
		tri.draw();
	}

	

}
