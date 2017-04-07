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

  void listOfToDoFromFile() {
    readInFile();
    linesToTodo();
  }

  void writeListToFile() {
    List<String> lines = new ArrayList<>();
    for (int j = 0; j < tasks.size(); j++ ) {
      String check;
      String line;
      if (tasks.get(j).isDone) {
        check = "[x]";
      } else {
        check = "[ ]";
      }
      line = check + ";" + tasks.get(j).task;
      lines.add(line);
      try {
        Files.write(path, lines);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  void list() {
    listOfToDoFromFile();
    String check;
    int i = 1;
    System.out.println();
    if (tasks.size() > 0) {
      for (ToDo todo : tasks) {
        if (todo.isDone) {
          check = "[x]";
        } else {
          check = "[ ]";
        }
        System.out.println(i + " - " + check + " " + todo.task);
        i++;
      }
    } else {
      System.out.println("No todos for today! :)");
    }
  }

  void add(String[] args) {
    listOfToDoFromFile();
    if (args.length >= 2) {
      tasks.add(new ToDo(args[1]));
    } else {
      System.out.println();
      System.out.println("Unable to add: no task provided");
    }
    writeListToFile();
  }

  void check(String[] args) {
    listOfToDoFromFile();
    int index = Integer.parseInt(args[1]);
    tasks.get(index-1).isDone = true;
    writeListToFile();
  }

  void remove(String[] args) {
    listOfToDoFromFile();
    int index = Integer.parseInt(args[1]);
    tasks.remove(index-1);
    writeListToFile();
  }
}

