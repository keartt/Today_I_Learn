package hello.core;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        Integer [] numbers = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            numbers[i] = N.charAt(i) - '0';
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        for (int number : numbers) {
            sb.append(number);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
