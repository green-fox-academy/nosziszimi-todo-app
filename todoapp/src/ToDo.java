/**
 * Created by Nóra on 2017. 04. 06..
 */
public class ToDo {
  boolean isDone;
  String task;
  static int counter;
  int id;

  public ToDo() {
    this("");
  }

  public ToDo(String task) {
    this("", task);
  }

  public ToDo(String check, String task) {
    if (check.equals("[x]")){
      isDone = true;
    } else {
      isDone = false;
    }
    this.task = task;
    id = counter;
    counter++;
  }


}
