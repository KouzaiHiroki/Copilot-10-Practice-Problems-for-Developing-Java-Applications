import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int nextId = 1;

        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("addressbook.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phone = parts[2];
                String email = parts[3];
                String address = parts[4];

                Person personRegistered = new Person(id, name, phone, email, address);
                people.add(personRegistered);
                nextId = Math.max(nextId, id + 1);
            }
            System.out.println("保存データを読み込みました。");
        } catch (Exception exception) {
            System.out.println("保存データはありません。");
        }

        while(true) {
            System.out.println("\n=== 住所録アプリ ===");
            System.out.println("1. 登録");
            System.out.println("2. 一覧表示");
            System.out.println("3. 検索");
            System.out.println("4. 削除");
            System.out.println("5. 編集");
            System.out.println("6. 保存");
            System.out.println("7. 終了");
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
                    System.out.print("削除するIDを入力してください。");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    Person personToDelete = null;

                    for (Person person : people) {
                        if (person.getId() == deleteId) {
                            personToDelete = person;
                            break;
                        }
                    }

                    if (personToDelete != null) {
                        people.remove(personToDelete);
                        System.out.println("削除しました: " + personToDelete);
                    } else {
                        System.out.println("指定のIDが見つかりませんでした。");
                    }
                    break;
                case 5:
                    System.out.println("編集するIDを入力してください。");
                    int editId = scanner.nextInt();
                    scanner.nextLine();

                    Person personToEdit = null;

                    for (Person person : people) {
                        if (person.getId() == editId) {
                            personToEdit = person;
                            break;
                        }
                    }

                    if (personToEdit == null) {
                        System.out.println("指定のIDが見つかりませんでした。");
                        break;
                    }

                    System.out.println("現在の情報: " + personToEdit);

                    System.out.print("新しい名前（空欄で変更なし）:");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) personToEdit.setName(newName);

                    System.out.print("新しい電話番号（空欄で変更なし）:");
                    String newPhone = scanner.nextLine();
                    if (!newPhone.isEmpty()) personToEdit.setPhone(newPhone);

                    System.out.print("新しいメールアドレス（空欄で変更なし）:");
                    String newEmail = scanner.nextLine();
                    if (!newEmail.isEmpty()) personToEdit.setEmail(newEmail);

                    System.out.print("新しい住所（空欄で変更なし）:");
                    String newAddress = scanner.nextLine();
                    if (!newAddress.isEmpty()) personToEdit.setAddress(newAddress);

                    System.out.println("更新しました: " + personToEdit);
                    break;
                case 6:
                    try (java.io.FileWriter writer = new java.io.FileWriter("addressbook.csv")) {
                        for (Person person : people) {
                            writer.write(
                                person.getId() + "," +
                                person.getName() + "," +
                                person.getPhone() + "," +
                                person.getEmail() + "," +
                                person.getAddress() + "\n"
                            );
                        }
                        System.out.println("保存しました。");
                    } catch (Exception exception) {
                        System.out.println("保存中にエラーが発生しました。" + exception.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("終了します。");
                    return;
                default:
                    System.out.println("不正な番号です。");
            }
        }
    }
}
