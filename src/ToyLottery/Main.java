package ToyLottery;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Lottery toyStore = new Lottery();

        toyStore.addToyToArray(new Toy(1, "Машина", 1, 15));
        toyStore.addToyToArray(new Toy(2, "Кукла", 5, 30));
        menu.generalMenu();
    }
}