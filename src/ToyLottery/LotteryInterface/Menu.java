package ToyLottery.LotteryInterface;

import java.util.Scanner;

public class Menu implements GameInterfaсe {
    public Scanner scanner;
    public boolean isRunning;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.isRunning = true;
    }

    public void showMenu() {

        MenuForCustomer menuForCustomer = new MenuForCustomer();
        MenuForSeller menuForSeller = new MenuForSeller();
        while (isRunning) {
            System.out.println("1. Режим продавца");
            System.out.println("2. Режим покупателя");
            System.out.println("3. Выйти из меню");
            System.out.print("▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾\n");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    menuForSeller.showMenu();
                    break;
                case 2:
                    menuForCustomer.showMenu();
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("\uD83D\uDEAA Выход \uD83D\uDEAA");
                    break;
                default:
                    System.out.println("☒ Ошибка ввода ☒");
                    break;
            }
            System.out.println();
        }
    }
}

