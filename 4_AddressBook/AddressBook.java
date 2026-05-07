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
            System.out.println("3. 検索");
            System.out.println("4. 終了");
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
                    System.out.print("検索ワード（名前）を入力してください。");
                    String keyword = scanner.nextLine();
                    System.out.println("\n--- 検索結果 ---");
                    boolean hasFound = false;

                    for (Person person : people) {
                        if (person.getName().contains(keyword)) {
                            System.out.println(person);
                            hasFound = true;
                        }
                    }

                    if (!hasFound) System.out.println("該当するデータはありませんでした。");
                    
                    break;
                case 4:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("不正な番号です。");
            }
        }
    }
}
