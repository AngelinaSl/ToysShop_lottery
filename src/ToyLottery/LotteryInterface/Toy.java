package ToyLottery.LotteryInterface;

public class Toy {
    protected int id;
    protected String name;
    protected int amount;
    protected int weight;

    public Toy(int id, String name, int amount, int weight) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
