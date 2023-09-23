package com.JAVAEXERCISES;
import java.util.*;
public class Banking_System {
/*Build a basic ATM simulation system with classes for accounts, transactions, and the ATM itself.
Implement methods for depositing, withdrawing, and checking account balances.*/


    public static void main(String[] args) {
        Accounts acc = new Accounts();
        Transactions  trans = new Transactions();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Welcome to banking system software");
            System.out.println("Press 1 for credit money");
            System.out.println("Press 2 for debit money");
            System.out.println("Press 3 for set account details");
            System.out.println("Press 4 for get account details");
            int user = 0;
            try {
                user = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid option.");
                sc.nextLine();
                continue;
            }
            switch (user){
                case 1:
                    System.out.println("How much money you want to credit");
                    int user_credit = sc.nextInt();
                   trans.getMoney_credited(user_credit);
                    System.out.println("Your money has been credited successfully."+ trans.Total_money);
                    break;
                case 2:
                    System.out.println("How much money you want to debit");
                    int user_debit = sc.nextInt();
                    if (trans.Total_money == 0){
                        System.out.println("Your total money is 0. So, Please credit some amount to your nearest bank");
                        break;
                    }else if(user_debit>trans.Total_money){
                        System.out.println("Your account doesn't have sufficient balance");
                    }
                    else {
                        System.out.println("Your amount has been debited successfully. ");
                        trans.getMoney_debited(user_debit);
                        System.out.println("Your total money after debited is: "+ trans.Total_money);
                    }
                    break;
                case 3:
                    System.out.println("Enter Account Holder name");
                    String Acc_holder = sc.nextLine();
                    System.out.println("Enter Account Number");
                    int Acc_Number = sc.nextInt();
                    System.out.println("Enter Account Holder location");
                    String Acc_location = sc.nextLine();
                    acc.setAccountDetail(Acc_holder,Acc_Number,Acc_location);
                    System.out.println("Account details has been set successfully.");
                    break;
                case 4:
                    acc.getAccountDetail();
                    break;
                default:
                    System.out.println("Please Enter Valid Input");
            }
        }

    }
}


class Accounts{
    String Account_Holdername;
    int Account_number;
    String Holder_location;
    public void setAccountDetail(String Account_Holdername,int Account_number,String Holder_location){
        this.Account_Holdername = Account_Holdername;
        this.Account_number = Account_number;
        this.Holder_location = Holder_location;
    }public void getAccountDetail(){
        System.out.println("Account holder name is: "+ Account_Holdername);
        System.out.println("Account number is: "+ Account_number);
        System.out.println("Account holder location is: "+ Holder_location);

    }
}
class Transactions{
    static int Total_money = 0;
    int money_credited;
    int money_debited;
    public void getMoney_credited(int credited){
        this.Total_money += credited;
    }
    public void getMoney_debited(int debited){
        this.Total_money -= debited;
    }
    public int checkBalance(){
        return Total_money;
    }
}
