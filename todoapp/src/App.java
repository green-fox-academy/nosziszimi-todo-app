import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nóra on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    Path usagePath = Paths.get("assets/usage.csv");
    Path tasksPath = Paths.get("assets/tasks.csv");
    File usage = new File(String.valueOf(usagePath));
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
        if (!taskScanner.hasNext()) {
          System.out.println("No todos for today! :)");
        }
        while (taskScanner.hasNext()) {
          System.out.print(i + " - ");
          System.out.println(taskScanner.nextLine());
          i++;
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    } else if (args.length > 0 && args[0].equals("-a")) {
      List<String> newTask = new ArrayList<String>();
      newTask.add(args[1]);
      try {
        Files.write(tasksPath, newTask);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
