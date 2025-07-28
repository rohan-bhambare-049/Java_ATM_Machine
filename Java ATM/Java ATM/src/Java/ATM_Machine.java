package Java;
import java.util.Scanner;
class ATM{
    float Balance = 0;
    int PIN;

    public void createPin(){
        System.out.print("Create your Custom 4 Digit PIN or Change Your PIN : ");
        Scanner abc = new Scanner(System.in);
        int newpin = abc.nextInt();
        PIN = newpin;
        System.out.println("Your PIN is Successfully Created or Changed");
        checkpin();
    }

    public void checkpin(){
        Scanner sc = new Scanner(System.in);

        int attempt = 0;
        while (attempt < 3) {
            System.out.print("Enter your PIN : ");
            int enteredpin = sc.nextInt();

            if (enteredpin == PIN) {
                System.out.println("Correct PIN, you can proceed...");
                menu();
                return;
            } else {
                System.out.println("Invalid PIN! Try again.");
                attempt++;
            }
        }

        System.out.println("Too many incorrect attempts. Exiting...");
        System.exit(0);
    }

    public void menu(){
        System.out.println("You are in the Menu Section Now...");
        System.out.println("1. Check Account Balance ->");
        System.out.println("2. Withdraw Money ->");
        System.out.println("3. Deposit Money ->");
        System.out.println("4. Change Your PIN ->");
        System.out.println("5. EXIT ->");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        switch (opt){
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                createPin();
                break;
            case 5:
                System.out.println("Thanks for Using our ATM, BYE!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option Try Again!");
                menu();
                break;
        }

    }

    public void checkBalance(){
        System.out.println("Available Balance : " + Balance + " Rupees Only/-");
        menu();
    }

    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to be WithDraw : ");
        float with = sc.nextFloat();
        if(with>Balance){
            System.out.println("Insufficient Amount in Your Balance");
            checkBalance();
            menu();
        }else{
            Balance = Balance - with;
            System.out.println("You Successfully Debited "+with+" Rupees");
            checkBalance();
            menu();
        }
    }

    public void deposit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to be Deposited : ");
        float bal = sc.nextFloat();
        Balance = Balance + bal;
        System.out.println("You Deposited "+bal+" Rupees Successfully");
        menu();
    }
}

public class ATM_Machine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.createPin();
    }
}
