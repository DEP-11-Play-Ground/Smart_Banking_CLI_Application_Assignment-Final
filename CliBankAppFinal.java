import java.util.Arrays;
import java.util.Scanner;

class CliBankAppFinal {
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main(String[] args) {

    final String CLEAR = "\033[H\033[2J";
    final String COLOR_BLUE_BOLD = "\033[34;1m";
    final String COLOR_RED_BOLD = "\033[31;1m";
    final String COLOR_GREEN_BOLD = "\033[33;1m";
    final String RESET = "\033[0m";

    final String DASHBOARD = "Welcome to Smart Banking";
    final String CREATE_ACCOUNT = "Create new Account";
    final String DEPOSITS = "Deposits";
    final String WITHDRAWSLS = "Withdrawals";
    final String TRANSFER = "Transfer";
    final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
    final String DELETE_ACCOUNT = "Delete Account";

    final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

    String[][] BankDetails = new String[5][3];
    int[] AccountNo = {1};

    String screen = DASHBOARD;

          do {
      final String APP_TITLE = String.format("%s%s%s",
          COLOR_BLUE_BOLD, screen, RESET);

      System.out.println(CLEAR);
      System.out.println("\t" + APP_TITLE + "\n");

      switch (screen) {
        case DASHBOARD:
          System.out.println("\t[1]. Create new Account");
          System.out.println("\t[2]. Deposits");
          System.out.println("\t[3]. Withdrawals");
          System.out.println("\t[4]. Transfer");
          System.out.println("\t[5]. Check Account Balance");
          System.out.println("\t[6]. Delete Account");
          System.out.println("\t[7]. Exit\n");
          System.out.print("\tEnter an option to continue: ");
          int option = SCANNER.nextInt();
          SCANNER.nextLine();

          switch (option) {
            case 1: 
              System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, CREATE_ACCOUNT, RESET);
              screen = addAccount(AccountNo, screen, DASHBOARD, CREATE_ACCOUNT, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 2:
             System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, DEPOSITS, RESET);
             screen = deposits(screen, DASHBOARD, DEPOSITS, ERROR_MSG, SUCCESS_MSG, BankDetails) ;
              break;

            case 3:  
            System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, WITHDRAWSLS, RESET);      
             screen = withdrawls(screen, DASHBOARD, WITHDRAWSLS, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 4:
              System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, TRANSFER, RESET);
              screen = Transfer(screen, DASHBOARD, TRANSFER, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 5:
              System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, CHECK_ACCOUNT_BALANCE, RESET);
              screen = checkAccountBalance(screen, DASHBOARD, CHECK_ACCOUNT_BALANCE, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 6:
             System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, DELETE_ACCOUNT, RESET);
             screen = DeleteAccount(screen, DASHBOARD, DELETE_ACCOUNT, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 7:
             System.out.printf("\n\t%s%s%s\n\n",COLOR_BLUE_BOLD, CLEAR, RESET);
               exit(CLEAR);
            default:
              continue;
          }
          break;

      }

    } while (true);

  }




public static String addAccount(int[] AccountNo, String screen, 
                            String DASHBOARD, String CREATE_ACCOUNT, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){     
                                

          String id = "";
          String name = "";
          Double initialDeposit = 0.00;
          boolean valid = true;

   loopadd:      do{
              valid = true;

           System.out.printf("\tNew Account id: SDB-%05d\n",AccountNo[0]);
           id = String.format("SDB-%05d",AccountNo[0]);

   loopvalidation:  do{  System.out.print("\tEnter Customer Name : ");
           name = SCANNER.nextLine().strip();
           if (name.isBlank()){
           System.out.printf(ERROR_MSG, "Customer name can't be empty");
           valid = false;
           break loopvalidation;
           }

           for (int i = 0; i < name.length(); i++) {
           if (!(Character.isLetter(name.charAt(i)) ||
           Character.isSpaceChar(name.charAt(i))) ) {
           System.out.printf(ERROR_MSG, "Invalid name");
           valid = false;
           break loopvalidation;
              }
           }

    
           System.out.print("\tEnter Deposit value: ");
           initialDeposit = SCANNER.nextDouble();
           SCANNER.nextLine();

           if ((initialDeposit<5000.00)){
           System.out.printf(ERROR_MSG, "Insufficient Account");
           valid = false;
            break loopvalidation;
               }
           }while(!valid);


             if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                  continue;
              }else{screen = DASHBOARD; break loopadd;} }


           String[][] newBankDetails = new String[BankDetails.length+1][3];

           for (int i = 0; i < BankDetails.length; i++) {
                for (int k = 0; k < 3; k++) {
           newBankDetails[i][k] = BankDetails[i][k];
           }

           }

       
           newBankDetails[newBankDetails.length - 1][0] = id;
           newBankDetails[newBankDetails.length - 1][1] = name;
           newBankDetails[newBankDetails.length - 1][2] = Double.toString(initialDeposit);

           BankDetails = newBankDetails;

System.out.println("Check,,,,");
System.out.println();


           for (int i = 0; i < newBankDetails.length; i++) {
            Arrays.toString(BankDetails[i]);
           }




           System.out.println();
           System.out.printf(SUCCESS_MSG,
           String.format("%s:%s has been saved successfully\n", id, name)); AccountNo[0]++;
           
           for (int i = 0; i < newBankDetails.length; i++) {
            Arrays.toString(BankDetails[i]);
           }

           System.out.print("\tDo you want to continue adding (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 valid = false;
                 continue;

              }else{ screen = DASHBOARD;
                valid = true; break loopadd;
                    }

         }while(!valid);
          
         return screen;      

     }




public static String deposits(String screen, 
                            String DASHBOARD, String DEPOSITS, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){


    int index1 = 0;
    boolean valid = true;
    String id;

    loopD:  do {
            valid = true;
            System.out.print("\tEnter the Account No: ");
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 8) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;

      loop1 :   for (int i = 0; i < BankDetails.length; i++) {
                if (BankDetails[i][0].equals(id)) {
                  index1 = i;
                  exists = true;
                  break loop1;
                }
              }
              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account is not Found");
              }
            }


       if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
                break loopD;
              }else{screen = DEPOSITS; continue;}
            }

              System.out.println();
              System.out.println(BankDetails[index1][2]);
              Double ValueOfBalance = Double.valueOf(BankDetails[index1][2]);
              System.out.println(ValueOfBalance);

              System.out.printf("\tCurrent Balance : %.2f \n", ValueOfBalance);

              System.out.print("\tDeposit amount : ");
              Double depositAmount = SCANNER.nextDouble();
              SCANNER.nextLine();

              if (!(depositAmount > 500)) {
                System.out.print("\tInsufficient Amount\n");
                break;
              } else {
                BankDetails[index1][2] = Double.toString(Double.valueOf(BankDetails[index1][2]) + depositAmount);
              }

              System.out.printf("\tNew Account Balance: %.2f \n", Double.valueOf(BankDetails[index1][2]));

              System.out.printf(SUCCESS_MSG,
                  String.format("%s has been done successfully\n", "Diposit"));
              System.out.print("\tDo you want to continue (Y/n)? ");

              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 valid = false;
                 continue;

              }else{ screen = DASHBOARD;
                valid = true; break loopD;

                    }
          } while (!valid);

          return screen;
          
   }


public static String withdrawls(String screen, 
                            String DASHBOARD, String WITHDRAWSLS, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

   int index2 = 0;
   boolean valid = true;
   String id;

          // ID Validation
      loopW:    do {
            valid = true;
            System.out.print("\tEnter the Account Id : ");
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 9) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;
              for (int i = 0; i < BankDetails.length; i++) {
                if (BankDetails[i][0].equals(id)) {
                  index2 = i;
                  exists = true;
                  break;
                }
              }
              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account does not exist");
              }
            }

            if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
                break loopW;
              }else{screen = WITHDRAWSLS; continue;}
            }
              System.out.println();

              System.out.printf("\tCurrent Balance : %.2f\n", Double.valueOf(BankDetails[index2][2]));

              System.out.print("\tWithdraw amount : ");
              Double withdraw = SCANNER.nextDouble();
              SCANNER.nextLine();
             
              Double check =(Double.valueOf(BankDetails[index2][2]) - withdraw);

              if (withdraw < 100 || check < 500) {
                System.out.print("\tInsufficient Amount\n");
              } else {
                BankDetails[index2][2] = (Double.toString(Double.valueOf(BankDetails[index2][2]) - withdraw));           
                System.out.printf("\tNew Account Balance: %.2f\n\n", Double.valueOf(BankDetails[index2][2]));

                 System.out.printf(SUCCESS_MSG,
                 String.format("%s has been done successfully\n", "Withdraw"));}

                System.out.print("\tDo you want to continue (Y/n)? ");
                if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 valid = false;
                 continue;

              }else{ 
                screen = DASHBOARD; 
                 valid = true;
              break loopW;
              }

            
          } while (!valid);
          System.out.println("dash screen = "+screen);
          return screen;


}





public static String Transfer(String screen, 
                            String DASHBOARD, String TRANSFER, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){


           boolean valid = true;
           String id;
           int customer = 0;
           Double transfer = 0.00;
           int[] cusId = new int[2]; 

     loopT:      do {
            valid = true;

            do{
              String identity = "";
              if(customer==0) identity = "From";
              else if (customer==1) identity = "To";

            System.out.printf("\tEnter the %s Account Id to check: ",identity);
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 9) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;

              if(valid){
              for (int i = 0; i < BankDetails.length; i++) {
                if (BankDetails[i][0].equals(id)) {
                  cusId[customer]=i;
                  exists = true;
                  break;
                }
              }

              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account does not exist");
              }
            }
          }


            if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
                break loopT;
              }else{
                customer = 0;
               continue; 
                }
            }

               System.out.printf("\tAccount Name: %s\n",BankDetails[cusId[customer]][1]);
               System.out.println();
               customer++;

          }while(customer<2);


          System.out.printf("\n\tFrom Account Balance: %.2f\n",Double.valueOf(BankDetails[cusId[0]][2]));
          System.out.printf("\tTo Account Balance: %.2f\n\n",Double.valueOf(BankDetails[cusId[1]][2]));


           System.out.print("\tEnter Transfer amount : ");
              transfer = SCANNER.nextDouble();
              SCANNER.nextLine();
             
              Double checkBalance = (Double.valueOf(BankDetails[cusId[0]][2])-transfer);

              if (transfer < 100 || checkBalance < 500) {
                System.out.print("\tInsufficient Amount\n");
              } else {

                Double tax = 0.02 * transfer;
                BankDetails[cusId[0]][2] = 
                (Double.toString(Double.valueOf(Double.valueOf(BankDetails[cusId[0]][2])- transfer - tax)));

                 BankDetails[cusId[1]][2] = 
                (Double.toString(Double.valueOf(BankDetails[cusId[1]][2])+ transfer));
             


              System.out.printf("\tNew From Account Balance: %.2f\n",Double.valueOf(BankDetails[cusId[0]][2]));
              System.out.printf("\tNew To Account Balance: %.2f\n", Double.valueOf(BankDetails[cusId[1]][2]));


                 System.out.printf(SUCCESS_MSG,
                 String.format("%s has been Shown successfully\n", "Balance")); }
              System.out.print("\tDo you want to continue (Y/n)? ");
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                valid = false;
                customer = 0;
                 continue;
                
              }else{ screen = DASHBOARD; 
                valid = true; 
                break loopT;
              }
            
          } while (!valid);

      return screen;
}


public static String checkAccountBalance( String screen, 
                            String DASHBOARD, String CHECK_ACCOUNT_BALANCE, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){


    int indexAcc = 0;
    boolean valid;
    String id;

   loop1:        do {
            valid = true;
            System.out.print("\tEnter the Account Id to check: ");
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 8) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;

              if(valid){
              for (int i = 0; i < BankDetails.length; i++) {
                if (BankDetails[i][0].equals(id)) {
                  indexAcc = i;
                  exists = true;
                  break;
                }
              }

              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account does not exist");
              }
            }
          }

            if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                continue;
              }else{screen = DASHBOARD ; break loop1;}
            }
              System.out.println();

              System.out.printf("\tCurrent Balance : %.2f\n", Double.valueOf(BankDetails[indexAcc][2]));


                 System.out.printf(SUCCESS_MSG,
                 String.format("%s has been Shown successfully\n", "Balance"));
              System.out.print("\tDo you want to continue (Y/n)? ");
           
           
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 valid = false;
                 continue;

              }else{ screen = DASHBOARD;
                valid = true; 
                break loop1;
                    }

            
          } while (!valid);

          return screen;

}




public static String DeleteAccount(String screen, 
                            String DASHBOARD, String CHECK_ACCOUNT_BALANCE, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){




             for (int i = 0; i < BankDetails.length; i++) {
            System.out.println(Arrays.toString(BankDetails[i]));
             }


              int index3 = 0;
              boolean valid = true;
              String id;
              String [][] newBankDetails;

   loopDe:       do {
             valid = true;
            System.out.print("\tEnter the Account Id to check: ");
            id = SCANNER.nextLine().toUpperCase().strip();
            if (id.isBlank()) {
              System.out.printf(ERROR_MSG, "ID can't be empty");
              valid = false;
            } else if (!id.startsWith("SDB-") || id.length() < 8) {
              System.out.printf(ERROR_MSG, "Invalid ID format");
              valid = false;
            } else {
              String number = id.substring(4);
              for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {
                  System.out.printf(ERROR_MSG, "Invalid ID format");
                  valid = false;
                  break;
                }
              }
              boolean exists = false;

              if(valid){
              for (int i = 0; i < BankDetails.length; i++) {
                if (BankDetails[i][0].equals(id)) {
                  index3 = i;
                  exists = true;
                  break;
                }
              }

              if (!exists) {
                valid = false;
                System.out.printf(ERROR_MSG, "Account does not exist");
              }
            }
          }

            if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
                break loopDe;
              }else{screen = CHECK_ACCOUNT_BALANCE ; continue;}
            }

              System.out.println();

            
         

          System.out.print("\tAre you sure to delete this account (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
            valid = false;
          
          
          newBankDetails = new String[BankDetails.length - 1][3];

          for (int i = 0; i < BankDetails.length; i++) {
            if (i < index3) {
              newBankDetails[i] = BankDetails[i];

            } else if (i == index3) {
              continue;
            } else {
              newBankDetails[i - 1] = BankDetails[i];
              newBankDetails[i - 1] = BankDetails[i];
            }
          }

          BankDetails = newBankDetails;

          System.out.println();
          System.out.printf(SUCCESS_MSG,
          String.format("%s has been deleted successfully", id));

          
          }
            

             for (int i = 0; i < BankDetails.length; i++) {
            System.out.println(Arrays.toString(BankDetails[i]));
             }

    
          System.out.print("\tDo you want to continue deleting (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
             continue;
          }else{
          screen = DASHBOARD;
         // break;
          break loopDe;
          }
       } while (!valid);

       return screen;
  

}



      public static void exit(String CLEAR){

            System.out.println("Exit customer method");
            System.out.println(CLEAR);
            System.exit(0);

          }

}
