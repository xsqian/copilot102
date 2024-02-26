
        years = 30
        expected_result = 0
        self.assertEqual(calculate_amortization(principal, rate, years), expected_result)

        # Test case 5: High interest rate
        principal = 100000
        rate = 15
        years = 30
        expected_result = 1264.14
        self.assertAlmostEqual(calculate_amortization(principal, rate, years), expected_result, places=2)

if __name__ == '__main__':
    unittest.main()