package projects;

import java.util.Scanner;
class ATM{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Checking_Account bank = new Checking_Account("5129", 500.00, 1234, 50.00);
    Saving_Account savings = new Saving_Account("5129", 1000.00, 1234, 12.5);
    for(int i = 1; i <= 3; i++){
        System.out.print("What is your pin and account number for your checking account (pin first)? 3 tries ");
        int enteredPin = scanner.nextInt();
        scanner.nextLine();
        String enteredAccountNumber = scanner.nextLine();
        if(bank.verifycredentials(enteredPin, enteredAccountNumber) == true){
            System.out.println("That is the right credentials");
            System.out.println("Do you want to make a withdrawal from your checking account? y/n ");
            String answer = scanner.nextLine();
            if(answer.equals("y")){
                System.out.print("Of how much? ??.?? ");
                double moneyOut = scanner.nextDouble();
                bank.withdraw(moneyOut);
                }
            System.out.println("Do you want to make a deposit? y/n ");
            scanner.nextLine();
            String answer_2 = scanner.nextLine();
            if(answer_2.equals("y")){
                System.out.print("Of how much? ??.?? ");
                double moneyIn = scanner.nextDouble();
                bank.deposit(moneyIn);
                  break;
            }
            else{
                break;
            }
            }

        else{
            System.out.println("Incorrect credentials given try " + i);
        }
        }
        for(int i = 1; i <= 3; i++){
        System.out.print("What is your pin and account number for your saving account (pin first)? 3 tries ");
        int enteredPin = scanner.nextInt();
        scanner.nextLine();
        String enteredAccountNumber = scanner.nextLine();
        if(savings.verifycredentials(enteredPin, enteredAccountNumber) == true){
            System.out.println("That is the right credentials");
            System.out.println("Do you want to make a withdrawal from your saving  account? y/n ");
            String answer = scanner.nextLine();
            if(answer.equals("y")){
                System.out.print("Of how much? ??.?? ");
                double moneyOut = scanner.nextDouble();
                savings.withdraw(moneyOut);
                }
            System.out.println("Do you want to make a deposit? y/n ");
            scanner.nextLine();
            String answer_2 = scanner.nextLine();
            if(answer_2.equals("y")){
                System.out.print("Of how much? ??.?? ");
                double moneyIn = scanner.nextDouble();
                savings.deposit(moneyIn);

            }
            System.out.println("Do you want to invest? y/n ");
            scanner.nextLine();
            String answer_3 = scanner.nextLine();
            if(answer_3.equals("y")){
                System.out.print("How much? ??.?? ");
                double moneyIn = scanner.nextDouble();
                System.out.print("How many years? (whole number)");
                int years = scanner.nextInt();
                savings.invest(moneyIn, years);
                break;
            }
            else{
                break;
            }
            }

        else{
            System.out.println("Incorrect credentials given try " + i);
        }
        }
        scanner.close();
    }
}
    class Bankaccount{
    private String accountNumber;
    protected double balance;
    private int pin;
    Bankaccount(String accountNumber, double balance, int pin){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }
    boolean verifycredentials(int enteredPin, String enteredAccountNumber){
        if(enteredPin == pin && enteredAccountNumber.equals(accountNumber)){
            return true;
        }
        else{
            return false;
        }
    }
    void withdraw(double moneyOut){
        if(moneyOut <= balance && moneyOut >= 0){
            balance = balance - moneyOut;
            System.out.println("Balance of " + balance + " remaining");
        }
        else if(moneyOut <= 0){
            System.out.println("Negatives are not allowed");
        }
        else{
            System.out.println("You do not have enough money in your account");
        }
    }
    void deposit(double moneyIn){
         if(moneyIn >= 0){
            balance = balance + moneyIn;
            System.out.println("Balance of " + balance + " remaining");
         }
         else{
             System.out.println("Negatives are not allowed");
         }

         }
    }
class Saving_Account extends Bankaccount{
    private double rate;

    Saving_Account(String accountNumber, double balance, int pin, double rate){
        super(accountNumber, balance, pin);
        this.rate = rate;
    }
    void invest(double moneyIn, int years){
        if(moneyIn >= 0 && years >= 1){
            balance = moneyIn* Math.pow((1 + rate / 100), years);
            System.out.println("Balance of " + balance + " remaining");
        }
        else if(moneyIn >= 0){
            System.out.println("Negatives for the money invested is not allowed are not allowed");
        }
        else if(years >= 1){
            System.out.println("You have to invest for atleast a year");
        }
        else{
            System.out.println("An error has occured");
        }
    }
}
class Checking_Account extends Bankaccount{
    private double overdraft;

     Checking_Account(String accountNumber, double balance, int pin, double overdraft){
        super(accountNumber, balance, pin);
        this.overdraft = overdraft;
    }
    @Override
    void withdraw(double moneyOut){
        if(moneyOut <= balance + overdraft && moneyOut >= 0){
            balance = balance - moneyOut;
            System.out.println("Balance of " + balance + " remaining");
        }
        else if(moneyOut <= 0){
            System.out.println("Negatives are not allowed");
        }
        else{
            System.out.println("To much money has been spent over the overdraft limit");
        }
}
}