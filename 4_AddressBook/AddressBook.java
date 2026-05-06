import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int nextId = 1;

        while(true) {
            System.out.println("\n=== 住所録アプリ ===");
            System.out.println("1. 登録");
            System.out.println("2. 一覧表示");
            System.out.println("3. 終了");
            System.out.print("番号を選んでください。");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("名前： ");
                    String name = scanner.nextLine();

                    System.out.println("電話番号： ");
                    String phone = scanner.nextLine();

                    System.out.println("メールアドレス： ");
                    String email = scanner.nextLine();

                    System.out.println("住所： ");
                    String address = scanner.nextLine();

                    Person personToRegister = new Person(nextId++, name, phone, email, address);
                    people.add(personToRegister);
                    break;
                case 2:
                    System.out.println("\n--- 登録一覧 ---");
                    for (Person person : people) {
                        System.out.println(person);
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
