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
public class ToDoList {
  Path toDoListPath;
  File toDoList;

  public ToDoList() {
    toDoListPath = Paths.get("assets/tasks.csv");
    toDoList = new File(String.valueOf(toDoListPath));
  }

  void list() {
    try {
      Scanner taskScanner = new Scanner(toDoList);
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
  }

  void add(String[] args) {
    List<String> newTask = new ArrayList<>();
    newTask.add(args[1]);
    try {
      Files.write(toDoListPath, newTask);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

