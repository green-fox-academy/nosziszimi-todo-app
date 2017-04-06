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
    Path tasksPath = Paths.get("assets/tasks.csv");
    File tasks = new File(String.valueOf(tasksPath));
    Usage usage = new Usage();
    if (args.length == 0) {
      usage.display();
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
      List<String> newTask = new ArrayList<>();
      newTask.add(args[1]);
      try {
        Files.write(tasksPath, newTask);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
