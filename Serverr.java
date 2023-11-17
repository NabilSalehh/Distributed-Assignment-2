import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serverr {
   public static void main(String argv[]) {
      try {
         FileInterface fi = (FileInterface) UnicastRemoteObject.exportObject(new FileImpl("Serverr"), 0);
         Registry reg = LocateRegistry.getRegistry();

         reg.rebind("Serverr", fi);
         System.out.println("Server Ready - service is running...");

      } catch (Exception e) {
         System.out.println("Serverr: " + e.getMessage());
         e.printStackTrace();
      }
   }
}
