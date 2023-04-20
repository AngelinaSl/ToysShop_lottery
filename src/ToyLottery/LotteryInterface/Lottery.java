package ToyLottery.LotteryInterface;

import java.io.*;
import java.util.*;
import java.io.FileWriter;

public class Lottery {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static ArrayList<String> winToys = new ArrayList<>();
    private static int count = 0;

    public static ArrayList<Toy> getToys() {
        return toys;
    }

    public void addToyToArray(Toy toy) {
        toys.add(toy);
    }

    static void addNewToyToArray() {
        System.out.println("✛ Добавляем новую игрушку ✛");
        System.out.print("⏎ Введите название игрушки: ");
        String name = scanner.nextLine();
        System.out.print("⏎ Введите количество игрушек: ");
        int amount = scanner.nextInt();
        System.out.print("⏎ Введите шанс выпадения игрушки: ");
        int weight = scanner.nextInt();
        int toyID = toys.get(toys.size() - 1).getId() + 1;
        toys.add(new Toy(toyID, name, amount, weight));
        System.out.printf("✓ Игрушка '%s'(%dшт.) добавлена в магазин ✓\n", name, amount);
        scanner.nextLine();
    }

    public static void toyListToPrint() {
        System.out.printf("╔%s╦%s╦%s╦%s╗%n", "═".repeat(3), "═".repeat(20), "═".repeat(8), "═".repeat(6));
        System.out.printf("║%2s ║   %-15s  ║ %6s ║ %4s ║%n", "Id", "Название", "Кол-во", "Шанс");
        System.out.printf("╠%s╬%s╬%s╬%s╣%n", "═".repeat(3), "═".repeat(20), "═".repeat(8), "═".repeat(6));
        for (Toy toy : toys) {
            System.out.printf("║%2s ║ %-14s     ║ %4s   ║ %3s  ║%n", toy.getId(), toy.getName(), toy.getAmount(), toy.getWeight());
        }
        System.out.printf("╚%s╩%s╩%s╩%s╝%n", "═".repeat(3), "═".repeat(20), "═".repeat(8), "═".repeat(6));
    }

    public static void changeWeight(ArrayList<Toy> toysList) {
        toyListToPrint();
        System.out.print("Введите id игрушки: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Toy changeToy = toysList.get(id - 1);
        System.out.printf("Шанс выпадения %s: %d%s\n", changeToy.getName(), changeToy.getWeight(), "%");
        System.out.print("Введите новое значение(от 1 до 100): ");
        changeToy.setWeight(scanner.nextInt());
    }


    public static void changeAmount(ArrayList<Toy> toysList) {
        toyListToPrint();
        System.out.print("Введите id игрушки: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Toy changeToy = toysList.get(id - 1);
        System.out.printf("Количество %s: %dшт.\n", changeToy.getName(), changeToy.getAmount());
        System.out.print("Введите новое значение: ");
        changeToy.setAmount(scanner.nextInt());

    }

    static void playGame() {
        if (toys.size() == 0) {
            System.out.println("Извините! \uD83D\uDE22 Игрушек больше нет.");
        }
        else{
            System.out.println("Ура! \uD83D\uDC4F  Вы выиграли:");
            System.out.println("\uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73");
            int generalWeight = 0;
            String winToy = "";
            for (Toy toy : toys) {
                if (toy.getAmount() > 0) {
                    generalWeight += toy.getWeight();
                }
            }
            int randomNumber = new Random().nextInt(generalWeight);
            for (Toy toy : toys) {
                randomNumber -= toy.getWeight();
                if (toy.getAmount() == 0) {
                    System.out.println("Игрушка закончилась! \uD83D\uDE22 Попробуйте еще раз! \uD83D\uDE22");

                }
                else if (randomNumber <= 0) {
                    toy.setAmount(toy.getAmount() - 1);
                    winToy = toy.getName();
                    winToys.add(winToy);
                    if (toy.getAmount() <= 0){
                        toys.remove(toy);
                    }
                }
            }
            System.out.printf("Вы выиграли %s! \uD83D\uDC4F \n", winToy);
            System.out.println("\uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73");
        }
    }


    static void removePrize() {
        if (winToys.size() == 0){
            System.out.println("Нет призов для получения! \uD83D\uDE22");
        }
        else if (winToys.size() > 0) {
            if (winToys.size() > 1) {
                System.out.println("Удача! \uD83D\uDC4F  Заберите прошлый выигрыш! \uD83D\uDC4F ");
                System.out.println("Вас ждет " + winToys.get(0) + "! Получите еще один приз! \uD83D\uDC4F");
            }
            else {
                System.out.println("Ура! \uD83D\uDC4F  Теперь " + winToys.get(0) + " у Вас! \uD83D\uDC4F ");
            }
            count += 1;
            String prizeToy = count + ". "+ winToys.remove(0);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("prizes.txt", true));
                writer.append(prizeToy + "\n");
                writer.close();
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}