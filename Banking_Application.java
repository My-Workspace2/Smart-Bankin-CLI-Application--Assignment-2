import java.util.Scanner;

public class Banking_Application{
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        String[] CustomerNames =new String[0];
        String[] CustomerIDs =new String[0];
        Double[] CustomerDeposites =new Double[0];

        String[][] CustomerDetails =new String[0][];
         
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD ="\u001B[1;31m"; 
        final String COLOR_YELLOW_BOLD ="\u001B[1;33m" ;
        final String COLOR_GREEN_BOLD ="\u001B[1;32m" ;
        final String RESET = "\033[0m";

        final String DASHBOARD ="Welcome to Smart Banking" ;
        final String  CREATE_NEW_ACCOUNT= "create new account";
        final String DEPOSITE= "deposite";
        final String WITHDRAWALS = "withdrawals";
        final String BANKING_STATEMENT = "Banking statement";
        final String TRANSFER = "Transfer";
        final String DELETE_ACCOUNT = "Delete Account";
        final String EXIT = "Exit";


        String screen =DASHBOARD ;

        do
        {

        final String APP_TITLE = String.format("%s%s%s",
        COLOR_BLUE_BOLD, screen, RESET);

        System.out.println(CLEAR);
        System.out.println("-".repeat(30));
        System.out.println(" ".repeat((30 - APP_TITLE.length() + 7)/2).concat(APP_TITLE));
        System.out.println("-".repeat(30));


        switch(screen)
        {
        case DASHBOARD:

                System.out.println("[1]. Create new account");
                System.out.println("[2]. Deposite");
                System.out.println("[3]. Withdrawals");
                System.out.println("[4]. Banking statement");
                System.out.println("[5]. Transfer");
                System.out.println("[6]. Delete Account");
                System.out.println("[7]. Exit");
                System.out.print("Enter an option to continue > ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch(option){

                    case 1: screen =CREATE_NEW_ACCOUNT ; break;
                    case 2: screen =DEPOSITE; break;
                    case 3: screen =WITHDRAWALS;break;
                    case 4: screen =BANKING_STATEMENT; break;
                    case 5: screen =TRANSFER; break;
                    case 6: screen =DELETE_ACCOUNT; break;
                    case 7: 
                        {screen =EXIT; 
                        System.exit(0);
                        break;}
                    default:System.exit(0);
                }
                break;

        case CREATE_NEW_ACCOUNT:

             System.out.printf("Your ID generated SDB-%05d\n",(CustomerNames.length+1));
             String ID =String.format("SDB-%05d\n",(CustomerNames.length+1));
             String name;
             boolean valid1;

                do {
                    
                    System.out.print("Enter your name : ");
                    name =scanner.nextLine().strip();

                     if(name.isBlank())
                    {
                        System.out.printf("%sName can t be empty%s\n ",COLOR_RED_BOLD,RESET);
                        valid1 =false ;
                        continue;
                    }
                   
                    valid1 =true ;
                    for(int i=0; i<name.length(); i++)
                    {
                        if(  !( Character.isSpaceChar(name.charAt(i))  || Character.isLetter(name.charAt(i))))
                        {
                            System.out.printf("%sInvalid name%s\n",COLOR_RED_BOLD,RESET);
                            valid1 =false;
                            break ;
                        }
                    }

                   

                }

                while(!valid1);

                boolean valid2;
                Double InitialDeposite;
                do
                   {

                    valid2=true ;
                    System.out.print("Enter Initial Deposite : ") ;
                    InitialDeposite =scanner.nextDouble();
                    scanner.nextLine();

                        if(InitialDeposite<5000)
                        {
                            System.out.printf("%sInsufficient balance%s",COLOR_RED_BOLD,RESET);
                            valid2 =false;

                        }
                   } 

                while(!valid2);

             

                String[][] newCustomerDetails =new String[(CustomerDetails.length+1)][3];

                for(int k=0; k<CustomerNames.length; k++)
                {
                   

                    newCustomerDetails[k] =CustomerDetails[k] ;
                }

               
                newCustomerDetails[newCustomerDetails.length-1][0] =name ;
                newCustomerDetails[newCustomerDetails.length-1][1] =ID ;
                newCustomerDetails[newCustomerDetails.length-1][2]=String.valueOf(InitialDeposite) ;

                


                CustomerDetails =newCustomerDetails ;
         


            System.out.printf("%syour ID and name added succesfully\n%s",COLOR_YELLOW_BOLD,RESET);

            System.out.printf("Your Name  is %s and Account balance is Rs.%,.2f \n", name,InitialDeposite);
            
            System.out.print("Need to add another customer [Y/N]");
            if(scanner.nextLine().toUpperCase().equals("N")) 
            {
                screen=DASHBOARD;
                break;
            }

            break;

        case DELETE_ACCOUNT:
         break ;
        
        
        default : System.exit(0);
                   
    }

    }

    while(true) ;
        
        
    }
}

