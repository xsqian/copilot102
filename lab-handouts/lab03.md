# Doc to Code with GitHub Copilot

## While we are able to generate documentation using GitHub Copilot, it is also possible to generate code _from_ documentation, giving us the upper hand as developers when perhaps a program has already been explained, and now it just needs to be developed

For the purposes of this exercise, you will be investingating SIR models, as shown in the `SIR_documentation.md` file in the `lab-files` directory. Please take a few moments to read through that documentation now.

### Task 1

1. Open `SIR_documentation.md` and select all of the documentation

2. Open GitHub Copilot Chat and prompt it to generate a program from the selected documentation

```
Generate a program based on the selected documentation
```

### Task 2

3. Insert the code into a new file named `SIR.cs`. Your code should look similar to the code below:

```
public class SIRModel
{
    private double susceptible;
    private double infected;
    private double recovered;
    private double totalPopulation;
    private double beta;
    private double gamma;

    public SIRModel(double totalPopulation, double initialInfected, double initialRecovered, double beta, double gamma)
    {
        this.totalPopulation = totalPopulation;
        this.infected = initialInfected;
        this.recovered = initialRecovered;
        this.susceptible = totalPopulation - initialInfected - initialRecovered;
        this.beta = beta;
        this.gamma = gamma;
    }

    public void Calculate(double timeStep, int steps)
    {
        for (int i = 0; i < steps; i++)
        {
            double newInfected = timeStep * beta * susceptible * infected / totalPopulation;
            double newRecovered = timeStep * gamma * infected;

            susceptible -= newInfected;
            infected += newInfected - newRecovered;
            recovered += newRecovered;

            Console.WriteLine($"Step {i}: Susceptible = {susceptible}, Infected = {infected}, Recovered = {recovered}");
        }
    }
}

class Program
{
    static void Main(string[] args)
    {
        SIRModel model = new SIRModel(1000, 1, 0, 0.4, 0.1);
        model.Calculate(0.5, 100);
    }
}
```

In this program, the SIRModel class represents the SIR model. The Calculate method calculates the SIR model over a given number of steps, with each step representing a time interval specified by timeStep. The Main method creates an instance of the SIRModel class and calls the Calculate method to calculate the SIR model. The results are printed to the console at each step.

### Task 3

5. Save your changes and commit your code

    #### Using the VS Code Interface

    1. Click the VS Code **Source Control** tab on the left hand of your VS Code screen or press `Ctrl + Shift + G` 
    2. Stage your changes by clicking the small plus icon in the righthand corner of the panel
    3. Enter a commit message and select the **Commit** button
    4. Once changes are staged, click the elipses in the far right corner, choose **Push** and enter your password
    5. Wait approx. 1 minute and refresh your GitHub repository to ensure that the changes are reflected in your repository
