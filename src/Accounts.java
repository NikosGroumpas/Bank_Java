public abstract class Accounts {
    private String type;
    private String name;
    private double balance;
    private String date;


    public Accounts(String type, String name, String date, double balance ) {
        this.type = type;
        this.name = name;
        this.balance = balance;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getBalance() {
        return balance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String type) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract int getInterest();
}

