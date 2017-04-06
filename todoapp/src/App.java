import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nóra on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    File usage = new File("assets/usage.csv");
    try {
      Scanner scanner = new Scanner(usage);
      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
