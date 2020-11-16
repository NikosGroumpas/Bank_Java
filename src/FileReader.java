import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReader {
    ArrayList<Accounts> account;

    public void readFile() {
        account = new ArrayList<>();

        File dataFile = new File("AccountData.csv");
        try {
            Scanner dataScanner = new Scanner(dataFile);
            while (dataScanner.hasNextLine()) {
                String line = dataScanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                if (tokenizer.countTokens()==6) {
                    Accounts s = new Saving(
                            tokenizer.nextToken().trim(),
                            tokenizer.nextToken().trim(),
                            tokenizer.nextToken().trim(),
                            Double.parseDouble(tokenizer.nextToken().trim()),
                            Integer.parseInt(tokenizer.nextToken().trim()),
                            Integer.parseInt(tokenizer.nextToken().trim())
                    );
                    account.add(s);
                } else if (tokenizer.countTokens()==4) {
                    Accounts c = new Checking(
                            tokenizer.nextToken().trim(),
                            tokenizer.nextToken().trim(),
                            tokenizer.nextToken().trim(),
                            Double.parseDouble(tokenizer.nextToken().trim())
                    );
                    account.add(c);
                }else{
                    System.out.println("Wrong number of items");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found dude");
            e.printStackTrace();

        }
    }

    public void printAccounts(){
        for (Accounts s: account){
            System.out.println(s.getName() + " has " + s.getBalance() + " to withdraw till " + s.getDate() + " " +  " " + s.getInterest());
        }
    }



    private static Scanner x;

    public static void editRecordChecking(String filePath, String editTerm,String newType, String newName, String newDate ,String newBalance){
        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newfile = new File(tempFile);
        String balance=""; String type= ""; String name=""; String date="";
        try{
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filePath));
            x.useDelimiter(",");
            while (x.hasNext()){
                type=x.next();
                name=x.next();
                date=x.next();
                balance=x.next();
                if (balance.equals(editTerm)){
                    pw.println(newType + "," + newName + "," + newDate + "," + newBalance);
                }else{
                    pw.println(type + "," + name + "," + date + "," + balance);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newfile.renameTo(dump);
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    public static void login(){
        System.out.println("To enter our System, please enter your password");
        do {
            Scanner input = new Scanner(System.in);
            int password = input.nextInt();
            if (password == 123) {
                System.out.println("Welcome");
                break;
            } else {
                System.out.println("Please try again");
            }
        }while (true);
    }

    public static void userMenu(){
        System.out.println("User menu!\nYou can Withdraw, deposit or press '3' to return to Main Menu\nTo continue press any number");
        Scanner inputStream = new Scanner(System.in);
        int exit = inputStream.nextInt();
        if (exit==3){
            mainMenu();
        }else{
            System.out.println("Ok, let's go");
        }
        System.out.println("Enter number you want to deposit: ");
        Scanner scanner = new Scanner(System.in);
        String depositEntry = scanner.nextLine();
        System.out.println("Enter deposit number you are replacing: ");
        String previousDeposit = scanner.nextLine();
        String filePath= "AccountData.csv"; String editTerm=" " + previousDeposit; String type="c"; String name="Korina Vafiadaki";
        String date="2021-04-12"; String balance=depositEntry;
        editRecordChecking(filePath,editTerm,type,name,date,balance);
    }

    public static void adminMenu(){
        System.out.println("Admin Menu, press '3' if you want to return to Main Menu\nTo continue press any number");
        Scanner input = new Scanner(System.in);
        int exit = input.nextInt();
        if (exit==3){
            mainMenu();
        }else{
            System.out.println("Ok, let's go");
        }
        System.out.println("Enter number you want to deposit: ");
        Scanner scanner = new Scanner(System.in);
        String depositEntry = scanner.nextLine();
        System.out.println("Enter deposit number you are replacing: ");
        String previousDeposit = scanner.nextLine();
    }

    public static void mainMenu(){
        int choice=0;
        System.out.println("Press 1 for User menu or 2 for Admin menu: ");
        do {
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            if (choice == 1) {
                userMenu();
            } else if (choice == 2) {
                adminMenu();
            } else {
                System.out.println("Wrong choice   ┐(´•_•`)┌");
            }
        }while (true);
    }




    public static void main(String[] args) {
        FileReader reader = new FileReader();
        reader.readFile();
        login();
        mainMenu();
        reader.printAccounts();

    }

}
