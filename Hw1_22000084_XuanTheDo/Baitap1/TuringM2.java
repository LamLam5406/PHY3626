package Hw1_22000084_XuanTheDo.Baitap1;

import java.util.Scanner;
public class TuringM2 {
    public static String subtractOne(String binary) {
        char[] tape = ("B" + binary + "B").toCharArray();
        int head = tape.length - 2;
        boolean borrow = true;
        while (borrow && head >= 0) {
            if (tape[head] == '1') {
                tape[head] = '0';
                borrow = false;
            } else if (tape[head] == '0') {
                tape[head] = '1';
            } else if (tape[head] == 'B') {
                break;
            }
            head--;
        }
        String result = new String(tape).replaceAll("^B|B$", "");
        return result.replaceFirst("^0+", "");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nhị phân: ");
        String binary = scanner.next();
        scanner.close();
        String result = subtractOne(binary);
        System.out.println("Kết quả sau khi trừ 1: " + result);
    }
}
