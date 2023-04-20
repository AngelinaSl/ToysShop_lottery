package ToyLottery.LotteryInterface;

public class MenuForSeller extends Menu {
    public boolean runForSeller;
    public MenuForSeller() {
        this.runForSeller = true;
    }

    @Override
    public void showMenu() {
        while (runForSeller) {
            System.out.println("Режим продавца:");
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Открыть список игрушек");
            System.out.println("3. Изменить шанс выпадения игрушки");
            System.out.println("4. Изменить количество игрушек");
            System.out.println("5. Выйти из меню");
            System.out.print("▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾▾\n");
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
                    runForSeller = false;
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
