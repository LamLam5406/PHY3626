package Hw1_22000084_XuanTheDo.Baitap1;

import java.util.Scanner;
public class TuringM3 {
    public static String invertBits(String binary) {
        char[] tape = binary.toCharArray();
        for (int i = 0; i < tape.length; i++) {
            if (tape[i] == '0') {
                tape[i] = '1';
            } else if (tape[i] == '1') {
                tape[i] = '0';
            }
        }
        return new String(tape);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nhị phân: ");
        String binary = scanner.next();
        scanner.close();
        
        String result = invertBits(binary);
        System.out.println("Kết quả sau khi đảo bit: " + result);
    }
}