public class Checking extends Accounts{
    public Checking(String type, String name, String date, double balance ) {
        super(type, name, date, balance );
    }

    @Override
    public int getInterest() {
        return 0;
    }
}
