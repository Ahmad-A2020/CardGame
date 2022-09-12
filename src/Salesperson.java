public class Salesperson {
    private int ID;
    private double annyalSalesAmount;

    public Salesperson(int ID, double annyalSalesAmount) {
        this.ID = ID;
        this.annyalSalesAmount = annyalSalesAmount;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAnnyalSalesAmount(double annyalSalesAmount) {
        this.annyalSalesAmount = annyalSalesAmount;
    }

    public int getID() {
        return ID;
    }

    public double getAnnyalSalesAmount() {
        return annyalSalesAmount;
    }
}
