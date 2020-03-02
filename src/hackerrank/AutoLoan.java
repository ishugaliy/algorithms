package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AutoLoan {

    public static void main(String[] args) {
        System.out.println("expected: 0.000000000000133 actual: " + findInterest(6800.00, 100.00, 68));
        System.out.println("expected: 9.562054624583681 actual: " + findInterest(2000.00, 510.00, 4));
        System.out.println("expected: 7.687856394581649 actual: " + findInterest(15000.00, 364.00, 48));
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            String[] params = reader.readLine().split(" ");
//            double price = Double.parseDouble(params[0]);
//            double payment = Double.parseDouble(params[1]);
//            int months = Integer.parseInt(params[2]);
//            // algorithm
//            findInterest(price, payment, months);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//     Month | + Interest | - Payment | = Balance
//    ------------------------------------------
//           |            |           |  2000.00
//        1  |     15.94  |   510.00  |  1505.94
//        2  |     12.00  |   510.00  |  1007.94
//        3  |      8.03  |   510.00  |   505.97
//        4  |      4.03  |   510.00  |     0.00

    private static double findInterest(double price, double payment, int months) {
        double lower = -1;
        double upper = 101;
        while (upper - lower > 0.000001) {
            double pivot = (upper + lower) / 2;
            if (calculateResultBalance(price, payment, months, pivot) >= 0) {
                upper = pivot;
            } else {
                lower = pivot;
            }
        }
        System.out.println(upper);
        return upper;
    }

    private static double calculateResultBalance(double price, double payment, int months, double annualPercentRate) {
        double balance = price;
        double monthRate = annualPercentRate / 12 / 100;
        for (int i = 0; i < months; i++) {
            balance += balance * monthRate - payment;
        }
        return balance;
    }
}
