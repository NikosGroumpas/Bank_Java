public class Saving extends Accounts{
    private int interest;
    private int feeForEarlyWithdraw;

    public Saving(String type, String name, String date, double balance,  int interest, int feeForEarlyWithdraw) {
        super(type, name, date, balance);
        this.interest = interest;
        this.feeForEarlyWithdraw = feeForEarlyWithdraw;
    }

    public int getInterest() {
        return interest;
    }

    public double getFeeForEarlyWithdraw() {
        return feeForEarlyWithdraw;
    }

    public void  setInterest(int interest) {
        this.interest = interest;
    }

    public void setFeeForEarlyWithdraw(int feeForEarlyWithdraw) {
        this.feeForEarlyWithdraw = feeForEarlyWithdraw;
    }
}

