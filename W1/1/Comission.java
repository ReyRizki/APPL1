//********************************************************************
// Comission.java Author: Rey Rizki
//
// Hourly employee but with commission
//********************************************************************
public class Comission extends Hourly
{
    private double totalSales, commissionRate;

    public Comission (
        String eName,
        String eAddress,
        String ePhone,
        String socSecNumber,
        double hourlyRate,
        double commissionRate
    ){
        super (eName, eAddress, ePhone, socSecNumber, hourlyRate);

        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    public void addSales(double totalSales)
    {
        this.totalSales += totalSales;
    }

    public double pay() {
        double commissionHonor = totalSales * commissionRate;
        this.totalSales = 0;

        return super.pay() + commissionHonor;
    }

    public String toString()
    {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;

        return result;
    }
}
