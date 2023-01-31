package day04.homework;

public class MyStack extends MyMemory {
	static int[] memory = new int[5];
	static int top = 0;
	// 값이 들어갈 배열의 자리 TOP

	@Override
	void push(int value) {
		if (top >= 5) {
			System.out.println("꽉차서 푸쉬 불가능");
		} else {
			// 값은 가장 윗 칸에 들어가기에
			memory[top] = value;
			print();

			// 들어간 후 TOP 을 증가시켜야 다음 PUSH 때 그 곳에 들어감
			top++;
		}

	}

	@Override
	void pop() {

		if (top <= 0) {
			System.out.println("비어있어서 팝 불가능");
		} else {
			// 푸쉬로 인해 pop 이 증가했기 때문에 뺄때는 pop 을 하나 줄이고 빼야함
			top--;
			// 줄인 배열의 top 번째에 0을 넣음으로써 값 제거
			memory[top] = 0;

			print();
		}

	}

	public void print() {
		for (int i = 0; i < 5; i++) {
			System.out.print(memory[i] + " | ");
		}
		System.out.println();
	}

}
