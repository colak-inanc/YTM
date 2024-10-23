import java.util.Scanner;

class Account {
    private String CustomerName;
    private String AccountNo;
    private double Balance;

    public Account(String CustomerName, String AccountNo, double Balance) {
        this.CustomerName = CustomerName;
        this.AccountNo = AccountNo;
        this.Balance = Balance;
    }

    public void viewBalance(){
        System.out.println("Current Balance: " + Balance + "$");
    }

    public void deposit(double Amount){
        if(Amount > 0){
            Balance += Amount;
            System.out.println(Amount+" $ has been deposited");
        } else {
            System.out.println("Amount is invalid");
        }
    }

    public void withdraw(double Amount){
        if(Amount > 0 && Amount < Balance){
            Balance -= Amount;
            System.out.println(Amount+" $ has been withdrawn");
        } else if (Amount>Balance) {
            System.out.println("Amount is insufficient!");
        }else {
            System.out.println("Amount is invalid!");
        }
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String CustomerName = sc.nextLine();
        System.out.print("Enter Account No: ");
        String AccountNo = sc.nextLine();
        System.out.print("Enter Balance: ");
        double Balance = sc.nextDouble();

        Account account = new Account(CustomerName, AccountNo, Balance);

        boolean cont = true;
        while(cont){
            System.out.println("\n-- Enter Your Choice -- ");
            System.out.println("1- View Balance");
            System.out.println("2- Deposit Money");
            System.out.println("3- Withdraw Money");
            System.out.println("4- Exit");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    account.viewBalance();
                    break;
                case 2:
                    System.out.print("Enter Amount to Deposit: ");
                    double AmountD = sc.nextDouble();
                    account.deposit(AmountD);
                    break;
                case 3:
                    System.out.print("Enter Amount to Withdraw: ");
                    double AmountW = sc.nextDouble();
                    account.withdraw(AmountW);
                    break;
                case 4:
                     cont = false;
                     System.out.print("Exit");
                     break;
                default:
                    System.out.print("Invalid Choice!!!");

            }
        }
        sc.close();
    }
}