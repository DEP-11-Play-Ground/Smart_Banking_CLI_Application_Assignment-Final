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
    int Account = 1;

    String screen = DASHBOARD;

    //Ini check
         BankDetails[0][0] = "SDB-00001";
          BankDetails[0][1] = "Kasun";
          BankDetails[0][2] = "7500.00";

          BankDetails[1][0] = "SDB-00002";
          BankDetails[1][1] = "Nuwan";
          BankDetails[1][2] = "12500.00";

          BankDetails[2][0] = "SDB-00003";
          BankDetails[2][1] = "Pasan";
          BankDetails[2][2] = "9000.00";

          BankDetails[3][0] = "SDB-00004";
          BankDetails[3][1] = "Kamal";
          BankDetails[3][2] = "15000.00";

          BankDetails[4][0] = "SDB-00005";
          BankDetails[4][1] = "Sunil";
          BankDetails[4][2] = "10000.00";

          //Check is over

    mainLoop: do {
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
              screen = CREATE_ACCOUNT;
              break;

            case 2:
            //  screen = DEPOSITS;
              deposits(screen, DASHBOARD, DEPOSITS, ERROR_MSG, SUCCESS_MSG, BankDetails) ;
              break;

            case 3:
             // screen = WITHDRAWSLS;           
              withdrawls(screen, DASHBOARD, WITHDRAWSLS, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 4:
             // screen = TRANSFER;
              Transfer(screen, DASHBOARD, TRANSFER, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 5:
             // screen = CHECK_ACCOUNT_BALANCE;
              checkAccountBalance(screen, DASHBOARD, DEPOSITS, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 6:
             //screen = DELETE_ACCOUNT;
             DeleteAccount(screen, DASHBOARD, DELETE_ACCOUNT, ERROR_MSG, SUCCESS_MSG, BankDetails);
              break;

            case 7:
               exit(CLEAR);
            default:
              continue;
          }
          break;

        case CREATE_ACCOUNT:
          String id = "";
          String name = "";
          Double initialDeposit = 0.00;
          boolean valid = true;



          // System.out.printf("\tNew Account id: SDB-%05d\n",Account);
          // id = String.format("SDB-%05d",Account);

          // // Name Validation
          // do{

          // valid = true;
          // System.out.print("\tEnter Customer Name: ");
          // name = SCANNER.nextLine().strip();
          // if (name.isBlank()){
          // System.out.printf(ERROR_MSG, "Customer name can't be empty");
          // valid = false;
          // continue;
          // }

          // for (int i = 0; i < name.length(); i++) {
          // if (!(Character.isLetter(name.charAt(i)) ||
          // Character.isSpaceChar(name.charAt(i))) ) {
          // System.out.printf(ERROR_MSG, "Invalid name");
          // valid = false;
          // break;
          // }
          // }
          // }while(!valid);

          // //Deposit Validation

          // do{

          // valid = true;
          // System.out.print("\tEnter Deposit value: ");
          // initialDeposit = SCANNER.nextDouble();
          // SCANNER.nextLine();
          // // System.out.println(initialDeposit);

          // if ((initialDeposit<5000.00)){
          // System.out.printf(ERROR_MSG, "Insufficient Account");
          // valid = false;
          // }
          // }while(!valid);
           String[][] newBankDetails = new String[BankDetails.length+1][3];

          // for (int i = 0; i < BankDetails.length; i++) {
          // newBankDetails[i] = BankDetails[i];
          // }

          // newBankDetails[newBankDetails.length - 1][0] = id;
          // newBankDetails[newBankDetails.length - 1][1] = name;
          // newBankDetails[newBankDetails.length - 1][2] =
          // Double.toString(initialDeposit);

          // BankDetails = newBankDetails;
          // // System.out.println(BankDetails[0][2]);

          // // System.out.println(Arrays.toString(BankDetails));
          // // System.out.println(Arrays.toString(BankDetails));
          // // System.out.println(Arrays.toString(BankDetails));
          // // System.out.println(BankDetails[0][0]);
          // // System.out.println(BankDetails[0][1]);
          // // System.out.println(BankDetails[0][2]);

          // System.out.println();
          // System.out.printf(SUCCESS_MSG,
          // String.format("%s:%s has been saved successfully", id, name)); Account++;
          // System.out.print("\tDo you want to continue adding (Y/n)? ");
          // if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
          // screen = DASHBOARD;
          // break;








//-------------------------------------------------------------------------------------------------
//=================================================================================================



        case DEPOSITS:  
              deposits(screen, DASHBOARD, DEPOSITS, ERROR_MSG, SUCCESS_MSG, BankDetails) ;
         


        case WITHDRAWSLS:
              withdrawls(screen, DASHBOARD, WITHDRAWSLS, ERROR_MSG, SUCCESS_MSG, BankDetails);


        case TRANSFER:
              Transfer(screen, DASHBOARD, TRANSFER, ERROR_MSG, SUCCESS_MSG, BankDetails);

        
        case CHECK_ACCOUNT_BALANCE:
              checkAccountBalance(screen, DASHBOARD, CHECK_ACCOUNT_BALANCE, ERROR_MSG, SUCCESS_MSG, BankDetails); 




          ////////////////////////////////////////////////////////////////////////////////////





       




    case DELETE_ACCOUNT:
    

            
       
      }



    } while (true);




  }





  // ................>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





public static void addAccount(){

  System.out.println("Add customer method");

}




public static String deposits(String screen, 
                            String DASHBOARD, String DEPOSITS, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

  System.out.println("Add deposit method");

    int index1 = 0;
    boolean valid = true;
    String id;

          // ID Validation
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
              System.out.println("for loop-");
              System.out.println(BankDetails.length);
              System.out.print(BankDetails[0][0]+", "+BankDetails[1][0]+", "+BankDetails[2][0]);

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


            System.out.println("\n------------>\n"+valid);

       if (!valid) {
              System.out.print("\n\tDo you want to try again? (Y/n)");
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
                break loopD;
                //continue mainLoop;
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
                  String.format("%s has been done successfully", "Diposit"));
              System.out.print("\tDo you want to continue (Y/n)? ");

              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 valid = false;
                 continue;

              }else{ screen = DASHBOARD;
                valid = true; break loopD;
                 /*     continue mainLoop; */
                    }
              //  continue;
              //screen = DASHBOARD;
            //  break;

          //  }
          } while (!valid);
          System.out.println("final screen : "+ screen);

          return screen;
          
   }










public static String withdrawls(String screen, 
                            String DASHBOARD, String WITHDRAWSLS, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

  System.out.println("Add customer method");

   int index2 = 0;
   boolean valid = true;
   String id;

          // ID Validation
      loopW:    do {
            valid = true;
            System.out.print("\tEnter the Account Id (Withdraw): ");
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
                //continue mainLoop;
              }else{screen = WITHDRAWSLS; continue;}
            }
              System.out.println();

              System.out.printf("\tCurrent Balance : %.2f\n", Double.valueOf(BankDetails[index2][2]));

              System.out.print("\tWithdraw amount : ");
              Double withdraw = SCANNER.nextDouble();
              SCANNER.nextLine();

              if (!(withdraw > 100 || (Double.valueOf(BankDetails[index2][2]) - withdraw) > 500)) {
                System.out.print("Insufficient Amount");
                break;
              } else {
                BankDetails[index2][2] = (Double.toString(Double.valueOf(BankDetails[index2][2]) - withdraw));
              }

              System.out.printf("\tNew Account Balance: %.2f\n\n", Double.valueOf(BankDetails[index2][2]));

                 System.out.printf(SUCCESS_MSG,
                 String.format("%s has been done successfully\n", "Withdraw"));
              System.out.print("\tDo you want to continue (Y/n)? ");
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 // continue;
                 valid = false;
                 continue;

              }else{ 
                screen = DASHBOARD; 
                 valid = true;
              //  continue mainLoop;
              break loopW;
              }

            
          } while (!valid);
          System.out.println("dash screen = "+screen);
          return screen;


}





public static String Transfer(String screen, 
                            String DASHBOARD, String TRANSFER, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

  System.out.println("Add customer method");


  boolean valid = true;
  String id;
    int indexTra = 0;
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
                  indexTra = i;
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
                //continue mainLoop;
              }else{screen = TRANSFER; continue;}
            }

               System.out.printf("\tAccount Name: %s\n",BankDetails[customer][1]);
               System.out.println();
               customer++;

          }while(customer<2);


          System.out.printf("\t\nFrom Account Balance: %.2f\n",Double.valueOf(BankDetails[cusId[0]][2]));
          System.out.printf("\tTo Account Balance: %.2f\n\n",Double.valueOf(BankDetails[cusId[1]][2]));

      // System.out.printf("\tCurrent Balance : %.2f\n", 
      //                Double.valueOf(BankDetails[indexTra][2]));

           System.out.print("\tEnter Transfer amount : ");
              transfer = SCANNER.nextDouble();
              SCANNER.nextLine();

              if (!(transfer> 100 || (Double.valueOf(BankDetails[cusId[0]][2])-transfer) > 500)) {
                System.out.print("Insufficient Amount");
                break;
              } else {

                Double tax = 0.02 * transfer;
                System.out.println("Tax = "+ tax);

                BankDetails[cusId[0]][2] = 
                (Double.toString(Double.valueOf(Double.valueOf(BankDetails[cusId[0]][2])- transfer - tax)));

                 BankDetails[cusId[1]][2] = 
                (Double.toString(Double.valueOf(BankDetails[cusId[1]][2])+ transfer));
              }


              System.out.printf("\tNew From Account Balance: %.2f\n",Double.valueOf(BankDetails[cusId[0]][2]));
              System.out.printf("\tNew To Account Balance: %.2f\n", Double.valueOf(BankDetails[cusId[1]][2]));






                 System.out.printf(SUCCESS_MSG,
                 String.format("%s has been Shown successfully\n", "Balance"));
              System.out.print("\tDo you want to continue (Y/n)? ");
              if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
                 // continue;
                  valid = false;
                 continue;
                 

              }else{ screen = DASHBOARD; 
                valid = true; 
                break loopT;
                //continue mainLoop;
              }

            
          } while (!valid);

      return screen;

}







public static String checkAccountBalance( String screen, 
                            String DASHBOARD, String CHECK_ACCOUNT_BALANCE, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

  System.out.println("Check Acc Balance method");

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
              if (!SCANNER.nextLine().strip().toUpperCase().equals("Y")) {
                screen = DASHBOARD;
               /*  continue mainLoop;*/
              }else{screen = CHECK_ACCOUNT_BALANCE ; continue;}
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
                 /*     continue mainLoop; */
                    }

            
          } while (!valid);

          return screen;

}




public static void DeleteAccount(String screen, 
                            String DASHBOARD, String CHECK_ACCOUNT_BALANCE, String ERROR_MSG, 
                               String SUCCESS_MSG, String [][]BankDetails){

  System.out.println("Delete customer method");


              int index3 = 0;
              boolean valid = true;
              String id;
              String [][] newBankDetails;
          // ID Validation

     //     do{}while();

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
               /*  continue mainLoop;*/
              }else{screen = CHECK_ACCOUNT_BALANCE ; continue;}
            }

              System.out.println();

            
         

          System.out.print("\tAre you sure to delete this account (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
            valid = false;
          
          
          newBankDetails = new String[BankDetails.length - 1][3];
       //   newBankDetails = new String[BankDetails.length - 1][3];

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
            

          


          System.out.print("\tDo you want to continue adding (Y/n)? ");
          if (SCANNER.nextLine().strip().toUpperCase().equals("Y")){
             continue;
          }else{
          screen = DASHBOARD;
         // break;
          break loopDe;
          }
       } while (!valid);
  

}



public static void exit(String CLEAR){

  System.out.println("Exit customer method");
        System.out.println(CLEAR);
        System.exit(0);

}






}
