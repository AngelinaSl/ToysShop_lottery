package ToyLottery.LotteryInterface;

public class MenuForCustomer extends Menu {
    public boolean runForCustomer;

    public MenuForCustomer() {
        this.runForCustomer = true;
    }

    @Override
    public void showMenu() {
        while (runForCustomer) {
            System.out.println("Режим покупателя:");
            System.out.println("1. Провести розыгрыш");
            System.out.println("2. Получить приз");
            System.out.println("3. Выйти из меню");
            System.out.print("▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾\n");
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
                    runForCustomer = false;
                    System.out.println("\uD83D\uDEAA Выход в основное меню \uD83D\uDEAA");
                    break;
                default:
                    System.out.println("☒ Ошибка ввода ☒");
                    break;
            }
            System.out.println();
        }
    }
}
