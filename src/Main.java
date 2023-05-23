import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a four digit number: ");
        int number = input.nextInt();

        int encryptedNumber = encrypt(number);
        System.out.println("Encrypted number: " + encryptedNumber);

        int decryptedNumber = decrypt(encryptedNumber);
        System.out.println("Decrypted number: " + decryptedNumber);

    }

    public static int encrypt(int number) {
        int[] digits = getDigits(number);

        for (int i = 0; i < 4; i++) {
            digits[i] = (digits[i] + 7) % 10;
        }

        // Swap the first with the third
        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        // Swap the second with the fourth
        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        return composeNumber(digits);
    }

    public static int[] getDigits(int number) {
        int[] digits = new int[4];

        digits[0] = number / 1000;
        digits[1] = (number / 100) % 10;
        digits[2] = (number / 10) % 10;
        digits[3] = number % 10;

        return digits;
    }

    public  static int composeNumber(int[] digits) {
        int number = 0;

        number += digits[0] * 1000;
        number += digits[1] * 1000;
        number += digits[2] * 1000;
        number += digits[3] * 1000;

        return number;
    }

    public static int decrypt(int number) {
        int[] digits = getDigits(number);

        // Swap the first digit with the third
        int temp = digits[0];
        digits[0] = digits[2];
        digits[2] = temp;

        // Swap the second digit with the fourth
        temp = digits[1];
        digits[1] = digits[3];
        digits[3] = temp;

        // Subtract 7 and add 10 if necessary to get the original values
        for(int i=0; i < 4; i++) {
            digits[i] = (digits[i] - 7 + 10) % 10;
        }

        return composeNumber(digits);
    }


}