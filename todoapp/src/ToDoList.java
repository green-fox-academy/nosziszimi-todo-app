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
  Path path;
  File file;
  ArrayList<ToDo> tasks;
  ArrayList<String> linesOfFile;

  public ToDoList() {
    path = Paths.get("assets/tasks.csv");
    file = new File(String.valueOf(path));
    tasks = new ArrayList<>();
    linesOfFile = new ArrayList<>();
  }

  void readInFile() {
    try {
      Scanner fileScanner = new Scanner(file);
      while (fileScanner.hasNext()) {
        linesOfFile.add(fileScanner.nextLine());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  void linesToTodo() {
    String[] columns;
    for (String line : linesOfFile) {
      columns = line.split(";");
      tasks.add(new ToDo(columns[0], columns[1]));
    }
  }

  void list() {
    try {
      Scanner taskScanner = new Scanner(file);
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
    tasks.add(new ToDo(args[1]));
    try {
      Files.write(path, newTask);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  void check(String[] args) {

    try {
      List<String> lines = Files.readAllLines(path);
      ArrayList<String> lines2 = new ArrayList<>();
      for (String line : lines) {
        lines2.add(line);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

