# Test Driven Development with GitHub Copilot

## Test-driven development (TDD) with GitHub Copilot represents a powerful synergy of software development practices and cutting-edge AI assistance. With TDD, developers follow a process of writing tests before implementing their code. It actively assists in crafting test cases, generating test templates, and suggesting test scenarios based on the code being written

### Task 1

1. Open GitHub Copilot Chat and prompt it to generate test cases for a program that calculates amortization amount per month

**Note, this program has not been written**

```
Generate test cases for a Python program that calculates the amoritzation amount per month, given: 
- Principal borrowed
- Rate of interest per annum
- Years to repay the loan
```

2. Prompt Copilot Chat to ask about the directory structure and naming conventions for testing in Python

```
What is the directory structure and naming conventions for testing in Python?
```

  2a. Create the correct directory and file in your codebase for testing

3. Add the code from step 1 into your new testing file, ensure this file is named `test_installments.py`

### Task 2

4. Create a new Python file named `equated_monthly_installments.py` and 

5. Open GitHub Copilot Chat

6. Prompt Copilot Chat to create a program that calculates the amortization amount per month, asking it to think step-by-step

```
Program to calculate the amortization amount per month, given
- Principal borrowed
- Rate of interest per annum
- Years to repay the loan

Generate code that will pass the tests
Think step-by-step
```

### Task 3
7. Review Copilot's rationale for the code, and add it's suggestions into your `equated_monthly_installments.py` file. Your code may look similar to the program below: 

```
def equated_monthly_installments(
    principal: float, rate_per_annum: float, years_to_repay: int
) -> float:
    if principal <= 0:
        raise Exception("Principal borrowed must be > 0")
    if rate_per_annum < 0:
        raise Exception("Rate of interest must be >= 0")
    if years_to_repay <= 0 or not isinstance(years_to_repay, int):
        raise Exception("Years to repay must be an integer > 0")

    # Yearly rate is divided by 12 to get monthly rate
    rate_per_month = rate_per_annum / 12

    # Years to repay is multiplied by 12 to get number of payments as payment is monthly
    number_of_payments = years_to_repay * 12

    return (
        principal
        * rate_per_month
        * (1 + rate_per_month) ** number_of_payments
        / ((1 + rate_per_month) ** number_of_payments - 1)
    )

```

### Task 4

8. If your code does not contain a docstring, prompt Copilot to generate one: `Generate a docstring for the above code`

9. Add the docstring into your new file

### Task 5

10. Prompt 

### Task 5

10. Save your code and commit your changes 

    #### Using the VS Code Interface

    1. Click the VS Code **Source Control** tab on the left hand of your VS Code screen or press `Ctrl + Shift + G` 
    2. Stage your changes by clicking the small plus icon in the righthand corner of the panel
    3. Enter a commit message and select the **Commit** button
    4. Once changes are staged, click the elipses in the far right corner, choose **Push** and enter your password
    5. Wait approx. 1 minute and refresh your GitHub repository to ensure that the changes are reflected in your repository