package org.example;



import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Financial Calculator Menu ---");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator (Compound Interest)");
        System.out.println("3. Present Value of Annuity Calculator");
        System.out.println("0. Exit");

        System.out.print("Please select a calculator (0-3): ");
        int calNum =scanner.nextInt();

        while(calNum >0 || 0 < calNum)
        {
            if (0<calNum && calNum <=3) {
                switch (calNum) {
                    case 1:

                        System.out.print("Enter your Loan Principle: ");
                        double p = scanner.nextDouble(); //p for prrinciple

                        System.out.print("Enter the Interest Rate: ");
                        double r = scanner.nextDouble(); // r for interest rate

                        System.out.print("What is your loan length in Years? ");
                        int n = scanner.nextInt(); // n for year length

                        double mR = (r / 100.0) / 12.0; //monthly interest rate
                        double mN = n * 12; //number of monthly payment

                        double powerResult = Math.pow(1 + mR, mN);
                        double m = (p * mR * powerResult) / (powerResult - 1);
                        double totalInterestPaid = ((m * mN) - p);
                        //totalInterestPaid = totalInterestPaid * -1;

                            /*
                            double yearlyPrinciple = p/n;
                            double monthlyPrinciple = yearlyPrinciple/12;
                            double montlyInterestRateInDecimal = r/1200;
                            double m = monthlyPrinciple * montlyInterestRateInDecimal;
                            */
                        System.out.println();
                        System.out.printf("Your monthly payment is: $%.2f%n", m);
                        System.out.printf("Your Total Interest paid is: $%.2f%n", totalInterestPaid);
                        calNum =0;
                        break;

                    case 2:

                        System.out.print("Enter your Initial Deposit: ");
                         p = scanner.nextDouble(); //p for initial deposit

                        System.out.print("Enter the Interest Rate: ");
                         r = scanner.nextDouble(); // r for annual interest rate

                        System.out.print("Enter the number of Years: ");
                        int t = scanner.nextInt();

                        double aR  = (r/100.0); //annual rate
                        int day = 365; // day in year
                        double n1 = day *t; // daily per total year
                        double pResult = Math.pow(1 + aR/n1, n1 *t);
                        double FV = p * pResult;
                        double totalIn = FV - p;
                        System.out.println();
                        System.out.printf("The future value is: $%.2f%n", FV);
                        System.out.printf("The total Interest earned is: $%.2f%n",totalIn);

                        calNum =0;
                        break;

                    case 3:
                        System.out.print("Enter the monthly payout in dollar: ");
                        m = scanner.nextDouble(); //p for initial deposit

                        System.out.print("Enter the Interest Rate: ");
                        r = scanner.nextDouble(); // r for annual interest rate

                        System.out.print("Enter the number of Years: ");
                        n = scanner.nextInt();

                        aR  = r/100.0/12.0; //annual rate
                        double yearInMonth = n * 12; //number of monthly payment

                        double powerR = (1-Math.pow(1 + aR, -yearInMonth))/aR;

                        double monthlyPay = m * powerR;

                        System.out.println();
                        System.out.printf("You Need to invest: $%.2f%n", monthlyPay);

                        calNum =0;
                        break;

                }

                System.out.println();
                System.out.println("Do you want to do another calculation");
                System.out.print("Write true or false: ");
                boolean T = scanner.nextBoolean();



                if(calNum == 0 && T == true){
                    System.out.println();
                    System.out.println();
                    System.out.println("--- Choose Another Financial Calculator From Menu ---");
                    System.out.println("1. Mortgage Calculator");
                    System.out.println("2. Future Value Calculator (Compound Interest)");
                    System.out.println("3. Present Value of Annuity Calculator");
                    System.out.println("0. Exit");

                    System.out.print("Please select a calculator (0-3): ");
                    calNum =scanner.nextInt();
                }

            } else {


                System.out.print("You Enter a Wrong Number.You should Enter a Number Between (0-3): ");
                calNum =scanner.nextInt();
            }

        }
        System.out.println();
        System.out.println("Thank you for visiting our website. Goodbye.");

    }
}


