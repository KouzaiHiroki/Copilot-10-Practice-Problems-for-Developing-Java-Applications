import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todos = new ArrayList<>();

        while (true) {
            System.out.println("\n=== ToDo リスト ===");
            System.out.println("1. 追加");
            System.out.println("2. 一覧表示");
            System.out.println("3. 終了");
            System.out.print("番号を選んでください: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ToDo を入力してください: ");
                    String todo = scanner.nextLine();
                    todos.add(todo);
                    System.out.println("追加しました: " + todo);
                    break;
                case 2:
                    System.out.println("\n--- ToDo 一覧 ---");
                    for (int i = 0; i < todos.size(); i++) {
                        System.out.println((i + 1) + ". " + todos.get(i));
                    }
                    break;
                case 3:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("不正な番号です。");
            }
        }
    }
}
