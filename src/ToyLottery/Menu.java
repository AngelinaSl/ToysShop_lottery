package ToyLottery;

import java.util.Scanner;


public class Menu {
    private Scanner scanner;
    private boolean isRunning;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }
    public Menu(Scanner scanner, boolean isRunning){
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    public void menuForSeller() {
        while (isRunning) {
            System.out.println("Меню:");
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Открыть список игрушек");
            System.out.println("3. Изменить вес игрушки");
            System.out.println("4. Изменить количество игрушек");
            System.out.println("5. Выйти из меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    Lottery.addNewToyToArray();
                    break;
                case 2:
                    Lottery.toyListToPrint();
                    break;

                case 3:
                    Lottery.changeWeight(Lottery.getToys());
                    break;
                case 4:
                    Lottery.changeAmount(Lottery.getToys());
                    break;
                case 5:
                    generalMenu();
                    System.out.println("Выход из меню");
                    break;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
            System.out.println();
        }
    }

    public void menuForCustomer() {

        while (isRunning) {
            System.out.println("Меню:");
            System.out.println("1. Провести розыгрыш");
            System.out.println("2. Получить приз");
            System.out.println("3. Выйти из меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    Lottery.playGame();
                    break;
                case 2:
                    Lottery.removePrize();
                    break;
                case 3:
                    generalMenu();
                    System.out.println("Выход в основное меню");
                    break;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
            System.out.println();
        }
    }

    public void generalMenu() {
        while (isRunning) {
            System.out.println("1. Меню продавца");
            System.out.println("2. Меню покупателя");
            System.out.println("3. Выйти из меню");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    menuForSeller();
                    break;
                case 2:
                    menuForCustomer();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
            System.out.println();
        }
    }
    }

