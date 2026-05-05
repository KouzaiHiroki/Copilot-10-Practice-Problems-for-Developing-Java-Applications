import java.util.Random;
import java.util.Scanner;

public class Janken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int win = 0;
        int lose = 0;
        int draw = 0;

        System.out.println("=== じゃんけんゲーム ===");
        while (true) {
            System.out.println("0: グー");
            System.out.println("1: チョキ");
            System.out.println("2: パー");
            System.out.print("あなたの手を選んでください: ");

            int playerHand = scanner.nextInt();
            int cpuHand = cpuSmartHand(playerHand, random);

            System.out.println("あなた: " + handName(playerHand));
            System.out.println("CPU: " + handName(cpuHand));

            String result = judgeByHand(playerHand, cpuHand);
            System.out.println("結果: " + result);

            switch (result) {
                case "あなたの勝ち!": win++; break;
                case "あなたの負け...": lose++; break;
                case "あいこ": draw++; break;
            }

            System.out.print("続けますか? (y/n): ");
            String shouldContinue = scanner.next();
            if (shouldContinue.equalsIgnoreCase("n")) break;
        }

        System.out.println("\n=== 成績 ===");
        System.out.println("勝ち: " + win);
        System.out.println("負け: " + lose);
        System.out.println("あいこ: " + draw);
    } 

    public static String handName(int hand) {
        switch (hand) {
            case 0: return "グー";
            case 1: return "チョキ";
            case 2: return "パー";
            default: return "不明";
        }
    }

    public static String judgeByHand (int playerHand, int cpuHand) {
        if (playerHand == cpuHand) return "あいこ";

        if ((playerHand == 0 && cpuHand == 1) ||
            (playerHand == 1 && cpuHand == 2) ||
            (playerHand == 2 && cpuHand == 0)) {
            return "あなたの勝ち!";
        } else {
            return "あなたの負け...";
        }
    }

    public static int cpuSmartHand(int playerHand, Random random) {
        int winHand;

        //プレイヤーに勝つ手
        switch (playerHand) {
            case 0: winHand = 2; break;
            case 1: winHand = 0; break;
            case 2: winHand = 1; break;
            default: winHand = random.nextInt(3);
        }
        if (random.nextInt(100) < 70) {
            return winHand;
        } else {
            return random.nextInt(3);
        }
    }

}