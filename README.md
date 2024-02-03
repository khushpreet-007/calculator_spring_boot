
Addition
![image](https://github.com/khushpreet-007/calculator_spring_boot/assets/75271300/32baa93f-14ac-486d-9aac-1dc2ae0de398)

Multipication:
![image](https://github.com/khushpreet-007/calculator_spring_boot/assets/75271300/68d93c4a-fb69-4010-a820-da13e9c64a42)

Result Page: 
![image](https://github.com/khushpreet-007/calculator_spring_boot/assets/75271300/df8a0028-0a71-422f-8b10-8f3ccc241728)

Working: 
Sure, I'll explain the data flow in the calculator code from the user input through the controller.

1. **User Input (HTML Form):**
   - The user interacts with the HTML form, providing input values for `num1` and `num2` in the text fields and selecting an operation from the dropdown (`operation`).

2. **Form Submission (POST Request):**
   - When the user clicks the "Calculate" button, a POST request is sent to the server with the form data.

3. **Controller (`AddController`):**
   - The `@PostMapping("/calculate")` method in the controller (`AddController`) handles the POST request for the "/calculate" endpoint.
   - The `@ModelAttribute Calculator calculator` parameter is annotated with `@ModelAttribute`, which binds the form data to a `Calculator` object.
   - The `calculate` method of the `Calculator` class is then called to perform the calculation based on the selected operation.
   - The result is added to the model with the key "result".

```java
@PostMapping("/calculate")
public String calculate(@ModelAttribute Calculator calculator, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "index";
    }

    int resultValue = calculator.calculate();
    model.addAttribute("result", resultValue);

    return "calculate";
}
```

4. **Result Page (`calculate.html`):**
   - The user is redirected to the "calculate.html" template.
   - In the template, the result is displayed using the Thymeleaf expression `${result}`:

```html
<div>
    <h1>Result</h1>
    <p th:text="${result}"></p>
</div>
```

This represents a basic flow of data from the user input through the controller to the result page. 
The `Calculator` class is responsible for handling different operations and calculating the result based on user input.
Thymeleaf expressions are used in the HTML templates to dynamically display data from the model.
