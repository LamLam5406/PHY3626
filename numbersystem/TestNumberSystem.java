package hus.oop.numbersystem;
import java.util.Random;
// Import necessary classes for file writing
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
public class TestNumberSystem {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số tự nhiện n1, n2, n3:

        - Thực hiện chạy chương trình bằng cách set các số vừa sinh ra vào MyNumber.
          Chương trình sẽ in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:

          Original number: n1
          Binary: 1111111
          Octal: 7777777

          Original number: n2
          Binary: 1111111
          Octal: 7777777

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        String studentName = "NguyenVanA"; // <--- REPLACE WITH YOUR NAME
        String studentId = "123456";   // <--- REPLACE WITH YOUR ID
        String outputFileName = studentName + "_" + studentId + "_NumberSystemConverter.txt";
        PrintStream originalOut = System.out; // Store original System.out
        PrintStream fileOut = null;

        try {
            // Create a PrintStream to write to the specified file
            fileOut = new PrintStream(outputFileName);
            // Redirect standard output to the file
            System.setOut(fileOut);
            System.out.println("--- Number System Conversion Output ---");
            System.out.println("Student: " + studentName + ", ID: " + studentId);
            System.out.println("---------------------------------------");

        } catch (FileNotFoundException e) {
            // If file creation fails, print error to original standard error and exit
            System.err.println("Error: Could not create or write to file " + outputFileName);
            e.printStackTrace();
            // Optionally restore original System.out before exiting if needed elsewhere
            // System.setOut(originalOut);
            return; // Exit the program
        }


        // --- Main Logic ---

        // 1. Create the Subject (MyNumber) - start with an initial value (e.g., 0 or first random number)
        MyNumber numberSubject = new MyNumber(0); // Initial value doesn't matter much here

        // 2. Create the Observers (Converters) and register them with the Subject
        // Registration happens automatically within the converter constructors
        BinaryConverter binaryObserver = new BinaryConverter(numberSubject);
        OctalConverter octalObserver = new OctalConverter(numberSubject);

        // 3. Generate random numbers
        Random random = new Random();
        // Generate 3 random integers (e.g., between 0 and 999 inclusive)
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(1000);
        int n3 = random.nextInt(1000);

        int[] numbersToTest = {n1, n2, n3};

        // 4. Test each number
        System.out.println("\nStarting Number Conversion Tests:");
        for (int number : numbersToTest) {
            // Set the new number in the subject.
            // This triggers notifyConverters() -> update() -> decimalTo() in observers.
            numberSubject.setNumber(number);

            // Display the original number and the results from the converters.
            // Use the displayAll convenience method in MyNumber.
            numberSubject.displayAll();
            System.out.println("--------------------"); // Separator for clarity
        }

        System.out.println("\nNumber Conversion Tests Completed.");
        System.out.println("Output saved to: " + outputFileName);

        // --- Cleanup ---
        // Close the file stream
        if (fileOut != null) {
            fileOut.close();
        }
        // Restore original standard output
        System.setOut(originalOut);

        // Optional: Print a confirmation message to the console
        System.out.println("Program finished. Output written to " + outputFileName);
    }
}
