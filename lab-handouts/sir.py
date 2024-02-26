class SIRModel:
    def __init__(self, total_population, initial_infected, initial_recovered, beta, gamma):
        self.total_population = total_population
        self.initial_infected = initial_infected
        self.initial_recovered = initial_recovered
        self.beta = beta
        self.gamma = gamma

    def calculate_sir_model(self):
        susceptible = self.total_population - self.initial_infected - self.initial_recovered
        infected = self.initial_infected
        recovered = self.initial_recovered

        for t in range(100):
            new_infected = self.beta * susceptible * infected / self.total_population
            new_recovered = self.gamma * infected

            susceptible -= new_infected
            infected += new_infected - new_recovered
            recovered += new_recovered

            print(f"At time {t}: Susceptible = {susceptible}, Infected = {infected}, Recovered = {recovered}")


if __name__ == "__main__":
    sir_model = SIRModel(1000, 1, 0, 0.5, 0.1)
    sir_model.calculate_sir_model()
