import java.util.*;

class Account {
    String acc_name;
    String acc_accno;
    String acc_address;
    double balance;
    String lastTransaction = "No transactions yet";

    Account(String acc_name, String acc_accno, String acc_address, double balance) {
        this.acc_name = acc_name;
        this.acc_accno = acc_accno;
        this.acc_address = acc_address;

        if (balance > 0.0) {
            this.balance = balance;
        } else {
            this.balance = 0.0;
        }
    }

    void credit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            lastTransaction = "Deposited : " + amount;
            System.out.println("Amount Credited Successfully");
        } else {
            System.out.println("Invalid Amount");
        }
    }

    void debit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else if (balance >= amount) {
            balance = balance - amount;
            lastTransaction = "Withdrawn : " + amount;
            System.out.println("Amount Debited Successfully");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    double getbalance() {
        return balance;
    }

    void displaydetails() {
        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Account Name    : " + acc_name);
        System.out.println("Account Number  : " + acc_accno);
        System.out.println("Account Address : " + acc_address);
        System.out.println("Account Balance : " + balance);
    }

    void transactionHistory() {
        System.out.println("Last Transaction : " + lastTransaction);
    }
}

class acc {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Name : ");
        String name = sc.nextLine();

        System.out.println("Enter Account Number : ");
        String accnum = sc.nextLine();

        System.out.println("Enter Account Address : ");
        String address = sc.nextLine();

        System.out.println("Enter Initial Balance : ");
        double balance = sc.nextDouble();

        Account obj = new Account(name, accnum, address, balance);

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Credit Amount");
            System.out.println("2. Debit Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Amount to Credit : ");
                    double creditAmt = sc.nextDouble();
                    obj.credit(creditAmt);
                    break;

                case 2:
                    System.out.print("Enter Amount to Debit : ");
                    double debitAmt = sc.nextDouble();
                    obj.debit(debitAmt);
                    break;

                case 3:
                    System.out.println("Current Balance : " + obj.getbalance());
                    break;

                case 4:
                    obj.displaydetails();
                    break;

                case 5:
                    obj.transactionHistory();
                    break;

                case 6:
                    System.out.println("Thank You for Using Banking System");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
