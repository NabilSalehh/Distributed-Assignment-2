import java.io.*;
import java.rmi.*;
import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileImpl extends RemoteServer implements FileInterface {

    private String name;

    public FileImpl(String s) throws RemoteException {
        super();
        name = s;
    }

    // Function 1 - Volume Calculator
    public double volcal(double radius, double height1) throws RemoteException {
        if (radius <= 0 || height1 <= 0) {
            throw new RemoteException("Invalid input: Dimensions must be positive numbers.");
        }
        return Math.PI * radius * radius * height1;
    }


    // Function 2 - Mortgage Calculator
    public double mortgageCalculator(double amount, double downp, double rate, double duration) throws RemoteException {
        if (amount <= 0 || downp < 0 || rate <= 0 || duration <= 0) {
            throw new RemoteException("Invalid input: All values must be positive numbers.");
        }
        double monthlyRate = rate / 100 / 12;
        return (amount - downp) * monthlyRate / (1 - Math.pow(1 + monthlyRate, -duration));
    }

    // Function 3 - Password Checker
    public String passwordChecker(String length1) throws RemoteException {
        int length;
        try {
            length = Integer.parseInt(length1);
            if (length <= 0) {
                throw new RemoteException("Invalid input: Length must be a positive number.");
            }
        } catch (NumberFormatException e) {
            throw new RemoteException("Invalid input: Length must be a numeric value.");
        }

        String passwordChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (passwordChars.length() * Math.random());
            sb.append(passwordChars.charAt(index));
        }

        try (FileWriter myWriter = new FileWriter("passwords.txt")) {
            myWriter.write(sb.toString());
        } catch (IOException e) {
            throw new RemoteException("Error writing to file: " + e.getMessage());
        }

        return sb.toString();
    }

    // Function 4 - Word Scrambler
    public String scrambler(String wordInput) throws RemoteException {
        List<Character> characters = new ArrayList<>();
        for (char c : wordInput.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);
        StringBuilder scrambledWord = new StringBuilder();
        for (char c : characters) {
            scrambledWord.append(c);
        }

        return scrambledWord.toString();
    }

    // Function 5 - Reverse Word
    public String reverseWord(String wordreverse) throws RemoteException {
        return new StringBuilder(wordreverse).reverse().toString();
    }

    // Function 6 - BMI Calculator
    public double bmiCalculator(double height, double weight) throws RemoteException {
        if (height <= 0 || weight <= 0) {
            throw new RemoteException("Invalid input: Height and weight must be positive numbers.");
        }
        return weight / (height * height);
    }
}
