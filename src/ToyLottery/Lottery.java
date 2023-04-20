package ToyLottery;

import java.io.*;
import java.util.*;
import java.io.FileWriter;

public class Lottery {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Toy> toys = new ArrayList<>();
    private static ArrayList<Toy> winToys = new ArrayList<>();

    public static ArrayList<Toy> getToys() {
        return toys;
    }

//    public static ArrayList<Toy> getWinToys() {
//        return winToys;
//    }

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
        System.out.printf("✓ %s(%dшт.)  добавлена в магазин ✓\n", name, amount);
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


//    public static Toy random() {
//        Toy prize = null;
//
//        int generalWeight = 0;
//        for (Toy toy : toys) {
//            generalWeight += toy.getWeight();
//        }
//        int randomNumber = new Random().nextInt(generalWeight);
//        for (Toy toy : toys) {
//
//            if (randomNumber <= 0) {
//                toy.setAmount(toy.getAmount() - 1);
//                prize = toy;
//                winToys.add(toy);
//                return prize;
//                if (toy.getAmount() <= 0) {
//                    toys.remove(toy);
//                }
//
//            }
//        }
//        return prize;
//    }

    static void playGame() {
        if (toys.size() > 0) {
            System.out.println("Вы выиграли:");
            System.out.println("\uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73");
            int generalWeight = 0;
            for (Toy toy : toys) {
                generalWeight += toy.getWeight();
            }
            int randomNumber = new Random().nextInt(generalWeight);
            Toy winToy = null;
            for (Toy toy : toys) {
                if (randomNumber < toy.getWeight()) {
                    winToy = toy;
                    break;
                }
                randomNumber -= toy.getWeight();
            }


            if (winToy != null && winToy.getAmount() > 0) {
                winToy.setAmount(winToy.getAmount() - 1);
                winToys.add(winToy);
                System.out.println("%s", winToy.getName());
                System.out.println("\uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73");

            } else {
                System.out.println("Извините! Игрушек больше нет.");
            }
        }
    }


    static void removePrize() {
        if (winToys.size() > 0) {
            Toy prizeToy = winToys.remove(0);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("prizes.txt", true));
                writer.append(prizeToy.getId() + "," + prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }

        }

    }
}