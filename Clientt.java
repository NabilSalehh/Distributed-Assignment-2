import java.io.*; 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.net.InetAddress;

public class Clientt {
    public static void main(String argv[]) {
        try {
            String feature = null;
            Scanner sc = new Scanner(System.in);
            Registry reg = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostName()); 
            FileInterface fileInterface = (FileInterface) reg.lookup("Serverr");

            // Giving Client Options to Choose From
            System.out.println("Welcome to Nabs Features App? \n");
            System.out.println("Type in the corresponding number of the Feature you want to use\n");
            System.out.println("1: Volume of a container Calculator \n");
            System.out.println("2: Loan Payment Calculator \n");
            System.out.println("3: Password Generator \n");
            System.out.println("4: Scramble Words \n");
            System.out.println("5: Gives you words Backwards \n");
            System.out.println("6: BMI Calculator \n");
            feature = sc.nextLine();
            // If Function 1: volume Calculator
            if (feature.equalsIgnoreCase("1")) {
                System.out.println("Enter radius of the container/cup (in cm)");
                String radius = sc.nextLine(); 
                System.out.println("Enter the height of the container (in cm): ");
                String height1 = sc.nextLine(); 
                volcal(fileInterface, radius, height1);
            }

            // If Function 2: Mortgage Calculator
            else if (feature.equalsIgnoreCase("2")) {
                System.out.println("Enter the total Mortgage Amount in CAD Dollars (i.e 250000): ");
                String amount = sc.nextLine();
                System.out.println("Enter amount of Down Payment (i.e 10000): ");
                String downp = sc.nextLine();
                System.out.println("Enter the Interest Rate of the Mortgage (i.e 5.5): ");
                String rate = sc.nextLine();
                System.out.println("Enter the Total length of loan in Months (i.e 96): ");
                String duration = sc.nextLine();
                mortgageCalculator(fileInterface, amount, downp, rate, duration);
            }

            // If Function 3: Password Creator & Saves Password to Text File
            else if (feature.equalsIgnoreCase("3")) {
                System.out.println("What length password?: ");
                String length1 = sc.nextLine();
                passwordChecker(fileInterface, length1);
            }

            // If Function 4: word scramble
            else if (feature.equalsIgnoreCase("4")) {
                System.out.println("Enter a word to scramble: ");
                String wordInput = sc.nextLine(); 
                scrambler(fileInterface, wordInput);
            }

            // If Function 5: Word reversing
            else if (feature.equalsIgnoreCase("5")) {
                System.out.println("Enter a word to reverse: ");
                String wordreverse = sc.nextLine(); 
                reverseWord(fileInterface, wordreverse);
            }
            // If Function 6: BMI Calculator
            else if (feature.equalsIgnoreCase("6")) {
                System.out.println("Enter your height in meters (e.g., 1.75): ");
                String height = sc.nextLine();
                System.out.println("Enter your weight in kilograms (e.g., 70): ");
                String weight = sc.nextLine();
                bmiCalculator(fileInterface, height, weight);
            }
        } catch(Exception e) { 
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // Function 1 volume of a cup CALCULATOR
    public static void volcal(FileInterface fileInterface, String radius, String height1) throws IOException {
        try {
            System.out.println("The volume of the container is: " + fileInterface.volcal(Double.parseDouble(radius), Double.parseDouble(height1))+ "in cubic centimeters");
        }
        catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    // Function 2 MORTGAGE CALCULATOR
    public static void mortgageCalculator(FileInterface fileInterface, String amount, String downp, String rate, String duration) throws IOException {
        try { 
            System.out.println("Your Monthly mortgage Payment will be: " + fileInterface.mortgageCalculator(Double.parseDouble(amount), Double.parseDouble(downp), Double.parseDouble(rate), Double.parseDouble(duration)));
        }
        catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    // Function 3 CREATE PASSWORD AND SAVE TO FILE
    public static void passwordChecker(FileInterface fileInterface, String length1) throws IOException {
        try { 
            System.out.println("Your password for that length is: " + fileInterface.passwordChecker(length1));
        }
        catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

     // Function 4 - Scrambler Words
     public static void scrambler(FileInterface fileInterface, String wordInput) throws IOException {
        try {
            System.out.println("The word scrambled is: " + fileInterface.scrambler(wordInput));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Function 5 REVERSE WORD
    public static void reverseWord(FileInterface fileInterface, String wordreverse) throws IOException {
        try {
            System.out.println("Your word Reversed is: " + fileInterface.reverseWord(wordreverse));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Function 6 BMI Calculator
    public static void bmiCalculator(FileInterface fileInterface, String height, String weight) throws IOException {
        try {
            System.out.println("Your BMI is: " + fileInterface.bmiCalculator(Double.parseDouble(height), Double.parseDouble(weight)));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}