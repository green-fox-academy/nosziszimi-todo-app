import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nóra on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    File usage = new File("assets/usage.csv");
    File tasks = new File("assets/tasks.csv");
    if (args.length == 0) {
      try {
        Scanner usageScanner = new Scanner(usage);
        while (usageScanner.hasNext()) {
          System.out.println(usageScanner.nextLine());
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } else if (args.length > 0 && args[0].equals("-l")) {
      try {
        Scanner taskScanner = new Scanner(tasks);
        System.out.println();
        int i = 1;
        while (taskScanner.hasNext()) {
          System.out.print(i + " - ");
          System.out.println(taskScanner.nextLine());
          i++;
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    }
  }
}
