package day04.homework;

public class MyQue extends MyMemory {
	static int[] memory = new int[5];
	static int top = 0;

	@Override
	void push(int value) {
		if (top >=5) {
			System.out.println("꽉차서 푸쉬 불가능");
		}else {
			memory[top] = value;
			top++;
			print();
		}

	}

	@Override
	void pop() {
		if (top <= 0) {
			System.out.println("비어있어서 팝 불가능");
		}
		for (int i = 1; i <= 5; i++) {
				// memory[5] 는 없으므로
			if (i == 5) {
				memory[4] = 0;
			} else {
				// 앞쪽 배열에 뒷쪽 배열값 대입
				memory[i - 1] = memory[i];
			}

		}
		top--;
		print();
	}

	// top 까지만 프린트
	public void print() {
		for (int i = 0; i < 5; i++) {
			System.out.print(memory[i] + " | ");
		}
		System.out.println();
	}

}
