import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TodoItem> todos = new ArrayList<>();
        int nextId = 1;

        while (true) {
            System.out.println("\n=== ToDo リスト ===");
            System.out.println("1. 追加");
            System.out.println("2. 一覧表示");
            System.out.println("3. 完了にする");
            System.out.println("4. 削除");
            System.out.println("5. 検索");
            System.out.println("6. 終了");
            System.out.print("番号を選んでください: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ToDo を入力してください: ");
                    String title = scanner.nextLine();
                    TodoItem item = new TodoItem(nextId++, title);
                    todos.add(item);
                    System.out.println("追加しました: " + item);
                    break;

                case 2:
                    System.out.println("\n--- ToDo 一覧 ---");
                    for (TodoItem todo : todos) {
                        System.out.println(todo);
                    }
                    break;
                case 3:
                    System.out.print("完了にするIDを入力してください。");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    for (TodoItem todo : todos) {
                        if (todo.getId() == id) {
                            todo.markDone();
                            System.out.println("完了にしました: " + todo);
                        }
                    }
                    break;
                case 4:
                    System.out.println("削除するIDを入力してください: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    TodoItem target = null;
                    for (TodoItem todo : todos) {
                        if (todo.getId() == deleteId) {
                            target = todo;
                            todos.remove(target);
                            System.out.println("削除しました: " + target);
                            break;
                        }
                    }

                    if (target == null) System.out.println("ID が見つかりませんでした。");
                    break;
                case 5:
                    System.out.println("検索ワードを入力してください: ");
                    String keyword = scanner.nextLine();

                    System.out.println("\n--- 検索結果 ---");
                    boolean found = false;
                    for (TodoItem todo : todos) {
                        if (todo.getTitle().contains(keyword)) {
                            System.out.println(todo);
                            found = true;
                        }
                    }

                    if (!found) System.out.println("該当するToDoはありませんでした。");
                    break;
                case 6:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("不正な番号です。");
            }
        }
    }
}
