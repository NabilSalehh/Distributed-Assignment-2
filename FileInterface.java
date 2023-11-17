import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileInterface extends Remote 
{
   double volcal(double radius, double height1) throws RemoteException;
   public double mortgageCalculator(double amount, double downp, double rate, double duration) throws RemoteException;
   public String passwordChecker(String length1) throws RemoteException;
   public String scrambler(String wordInput) throws RemoteException;
   public String reverseWord(String wordreverse) throws RemoteException;
   public double bmiCalculator(double height, double weight) throws RemoteException;
}