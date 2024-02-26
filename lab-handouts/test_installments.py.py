import unittest
from amortization_calculator import calculate_amortization

class TestAmortizationCalculator(unittest.TestCase):
    def test_calculate_amortization_zero_interest_rate(self):
        # Test case 2: Zero interest rate
        principal = 100000
        rate = 0
        years = 30
        expected_result = 277.78
        self.assertAlmostEqual(calculate_amortization(principal, rate, years), expected_result, places=2)

if __name__ == '__main__':
    unittest.main()

