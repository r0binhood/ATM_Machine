
package atmprojectv1.pkg1;

import java.util.Scanner;

public class ATM implements Interfaces{
    int ActualPin;
    int enteredPin;
    int currentAmount;
    int depositAmount;
    int withdrawAmout;
    
    public ATM(){
        currentAmount=10000;
        depositAmount=0;
        ActualPin=1234;
        
    }

    @Override
    public int chkCard() {        
        System.out.println("\nPlease Enter you card. ");    
        System.out.println("\t\tPress (1) if card is Inserted ");
        
        int chkCardInsertion=9;
        
        while(chkCardInsertion!=1){           
        Scanner sc=new Scanner(System.in);
        chkCardInsertion=sc.nextInt();
        
            if(chkCardInsertion==1){
                System.out.println("\tCard is Inserted");
            }
            
            else {
                System.out.println("\tCard is not Inserted");
                System.out.println("Press 1 if card is inserted.");       
            }
        }
        return 0;
    }
       
    
    @Override
    public void chooseLanguage() {
        System.out.println("\nPlease, Choose suitable Language.   ");
        int lang;
        
        
        System.out.println("    Press (0) for NEPALI");
        System.out.println("    Press (1) For ENGLISH ");
        
        Scanner sc = new Scanner(System.in);
        lang = sc.nextInt();
        
        switch (lang) {
            case 1:
                System.out.println("You choose ENGLISH ");
                break;
            case 0:
                System.out.println("You choose NEPALI.");
                break;
            default:
                System.out.println("ERROR.....Invalid Input");
                break;
        }
        
        
    }

    @Override
    public void enterPIN() {
        System.out.println("Enter your PIN... ");
        Scanner sc=new Scanner(System.in);        
        enteredPin=sc.nextInt(); 
        int count=0;
    
        if(count<3){
        if(enteredPin==ActualPin){
            System.out.println("Entered PIN is correct.");
            mainMenu();
        }
        
        else{
            System.out.println("INCORRECT PIN entered.");
            enterPIN();
            }
        count++;
        }
        else
            System.out.println("Exit...");
        System.exit(1);
    }

    public void mainMenu() {
        System.out.println("CHOOSE THE Operation: ");
        System.out.println("        (1). Cash Withdrawl.");
        System.out.println("        (2). Fast Cash.");
        System.out.println("        (3). Balance Inquiry. ");
        System.out.println("        (4). Cash Deposit.");
        System.out.println("        (5). Exit.");
        
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        operations(opt);
    }      

    @Override
    public void cashDeposit() {
        int amount;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter amount to deposit. ");
        depositAmount=sc.nextInt();
        
        currentAmount+=depositAmount;
        System.out.println("Rs. "+currentAmount+" is Deposited ");
        
        options();
        
        
    }
    
    @Override
    public void withdraw(){
        System.out.println("Enter amount to withdraw: ");
        Scanner sc=new Scanner(System.in);
        int withdrawAmount=sc.nextInt();
        
        currentAmount=currentAmount-withdrawAmount;
        System.out.println("Rs."+withdrawAmount+" is withdrawed. ");
        System.out.println("Collect your Cash.");
        options();
    }


    @Override
    public void operations(int op) {
       
        switch (op) {
            case 1:
                withdraw();
                break;
            case 2:
                fastCashOptions();
                //System.out.println("Sorry! Service Unavailable");
                break;
            case 3:
                balanceInquiry();
                break;
            case 4:
                cashDeposit();
                break;
            case 5:
                System.out.println("Thank you");
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        
        
        
    }
    @Override
    public void balanceInquiry(){
        System.out.println("Your current Balance is Rs."+getCurrentAmount());
        options();
    }    

    
    public void options() {
        System.out.println("Press\t1. to Exit.");
        System.out.println("\t2. for Main Menu.");
        Scanner sc=new Scanner(System.in);
        int op=sc.nextInt();
        if(op==1){
            System.out.println("\tThank You.");
        }
        else if(op==2){
            mainMenu();
        }
        else{
            System.out.print("Invalid Input.");
            options();
        }
    }

    @Override
    public int getCurrentAmount() {
        return currentAmount;
    }
    @Override
    public void fastCashOptions(){
            System.out.println(" 1. 500 \t\t2.1000");
            System.out.println(" 3. 2000 \t\t4.2500");
            System.out.println(" 5. 5000 \t\t6.7500");
            System.out.println(" 7. 8000 \t\t8.10000");
            Scanner sc=new Scanner(System.in);
            System.out.print("Choose the option :  ");
            int op=sc.nextInt();
            int collect = 0;
        switch (op) {
            case 1:
                currentAmount-=500;
                collect=500;
                break;
            case 2:
                currentAmount-=1000;
                collect=1000;
                break;
            case 3:
                currentAmount-=2000;
                collect=2000;
                break;
            case 4:
                currentAmount-=2500;
                collect=2500;
                break;
            case 5:
                currentAmount-=5000;
                collect=5000;
                break;
            case 6:
                currentAmount-=7500;
                collect=7500;
                break;
            case 7:
                currentAmount-=8000;
                collect=8000;
                break;
            case 8:
                currentAmount-=10000;
                collect=10000;
                break;
            default:
                System.out.println("Invalid Input.");
                fastCashOptions();
                break;
        }
            System.out.println("Collect "+collect+" and take your card.");
            System.out.println("Amount :"+getCurrentAmount());
            fastCashOptions();
}
   
    
}
