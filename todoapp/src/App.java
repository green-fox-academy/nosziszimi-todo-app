
/**
 * Created by Nóra on 2017. 04. 06..
 */
public class App {

  public static void main(String[] args) {
    Usage usage = new Usage();
    ToDoList todo = new ToDoList();

    if (args.length == 0) {
      usage.display();
    } else if (args.length > 0 && args[0].equals("-l")) {
      todo.list();
    } else if (args.length > 0 && args[0].equals("-a")) {
      todo.add(args);
    }
  }
}
