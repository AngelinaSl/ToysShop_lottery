package ToyLottery;

import ToyLottery.LotteryInterface.Lottery;
import ToyLottery.LotteryInterface.Menu;
import ToyLottery.LotteryInterface.Toy;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Lottery toyStore = new Lottery();
        toyStore.addToyToArray(new Toy(1, "Машина", 2, 35));
        toyStore.addToyToArray(new Toy(2, "Кукла", 3, 30));
        menu.showMenu();
    }
}