import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Nóra on 2017. 04. 06..
 */
public class Usage {

  Path usagePath;
  File usage;

  public Usage() {
    usagePath = Paths.get("../assets/usage.csv");
    usage = new File(String.valueOf(usagePath));
  }

  void display() {
    try {
      Scanner usageScanner = new Scanner(usage);
      while (usageScanner.hasNext()) {
        System.out.println(usageScanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
