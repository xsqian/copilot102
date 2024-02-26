# SIR Model Calculation in C#

This program calculates the Susceptible-Infected-Recovered (SIR) model, which is a mathematical model used to describe the dynamics of infectious diseases.

The SIR model is a simple mathematical model used to understand the dynamics of infectious diseases in a population. The model divides the population into three compartments:

Susceptible (S): The individuals who have not yet been infected but could potentially become infected.

Infected (I): The individuals who are currently infected and can spread the disease to susceptible individuals.

Recovered (R): The individuals who have been infected and have either recovered from the disease and are now immune, or have died.

The model uses differential equations to describe how individuals move from one compartment to another over time. The rate at which individuals move from the susceptible to the infected compartment is determined by the contact rate (often denoted as beta) and the number of susceptible and infected individuals. The rate at which individuals move from the infected to the recovered compartment is determined by the recovery rate (often denoted as gamma) and the number of infected individuals.

The SIR model is a core model in epidemiology and has been used to study diseases such as measles, chickenpox, and influenza, and more recently, COVID-19. It provides a theoretical framework to predict the spread of an epidemic, assess the impact of different interventions, and estimate key epidemiological parameters.

## Class: SIRModel

The `SIRModel` class represents a SIR model.

### Fields

- `totalPopulation`: The total population.
- `initialInfected`: The initial number of infected individuals.
- `initialRecovered`: The initial number of recovered individuals.
- `beta`: The rate of infection per susceptible and per infective individual.
- `gamma`: The rate of recovery per infective.

### Constructor

The constructor of the `SIRModel` class takes the following parameters:

- `totalPopulation`: The total population.
- `initialInfected`: The initial number of infected individuals.
- `initialRecovered`: The initial number of recovered individuals.
- `beta`: The rate of infection per susceptible and per infective individual.
- `gamma`: The rate of recovery per infective.

```csharp
public SIRModel(double totalPopulation, double initialInfected, double initialRecovered, double beta, double gamma)