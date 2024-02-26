public class SIRModel
{
    private double totalPopulation;
    private double initialInfected;
    private double initialRecovered;
    private double beta;
    private double gamma;

    public SIRModel(double totalPopulation, double initialInfected, double initialRecovered, double beta, double gamma)
    {
        this.totalPopulation = totalPopulation;
        this.initialInfected = initialInfected;
        this.initialRecovered = initialRecovered;
        this.beta = beta;
        this.gamma = gamma;
    }

    public void CalculateSIRModel()
    {
        double susceptible = totalPopulation - initialInfected - initialRecovered;
        double infected = initialInfected;
        double recovered = initialRecovered;

        for (int t = 0; t < 100; t++)
        {
            double newInfected = beta * susceptible * infected / totalPopulation;
            double newRecovered = gamma * infected;

            susceptible -= newInfected;
            infected += newInfected - newRecovered;
            recovered += newRecovered;

            System.Console.WriteLine($"At time {t}: Susceptible = {susceptible}, Infected = {infected}, Recovered = {recovered}");
        }
    }
}

public class Program
{
    public static void Main()
    {
        SIRModel sirModel = new SIRModel(1000, 1, 0, 0.5, 0.1);
        sirModel.CalculateSIRModel();
    }
}