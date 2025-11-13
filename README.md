🧪 nopEcommerce UI Automation Testing

Welcome to the nopEcommerce UI Automation Project, a complete test automation suite designed to validate the core functionalities of the nopEcommerce web application.

This project focuses on creating end-to-end automated test scenarios using TestNG, Selenium WebDriver, and ExtentReports for reporting, ensuring the reliability of user flows from login to checkout.

📌 Project Overview

This project ensures functional coverage of the nopEcommerce web application, verifying user flows like product searches, cart operations, and completing orders.

🧪 End-to-End Scenarios

Verify User can search for products and add them to the cart.

Verify User can view the cart and proceed to checkout with the correct details.

Verify User can remove products from the cart and update quantities before checkout.

Verify User completes the checkout process with correct payment and shipping details.

🛠️ Tech Stack

Java 21

Selenium WebDriver 4.34.0

TestNG 7.10.2

ExtentReports 5.1.2

Jackson Databind 2.17.2

Maven (Build & Dependency Management)

🧩 Project Design

This project follows a modular design approach with Page Object Model (POM) for structuring tests and separating the logic of the application from the test code. It uses TestNG for test execution and ExtentReports for generating detailed, interactive reports.

🧰 Key Features

✅ TestNG Integration for test execution and configuration.

✅ Page Object Model (POM) for maintaining cleaner test code.

✅ ExtentReports for rich, detailed reporting, including screenshots for failed steps.

✅ JSON Data Management for dynamic test data handling.

✅ Custom Utilities for managing configurations, files, and test data.

✅ Supports both command-line (Maven) and IDE-based execution (e.g., IntelliJ IDEA or Eclipse).

⚙️ Build Configuration (pom.xml)

The project uses Maven for dependency management and builds configuration. Key configurations include:

Maven Compiler Plugin targeting Java 21.

ExtentReports for generating detailed HTML reports with screenshots for failed tests.

TestNG for running tests and defining test suites.

🚀 Getting Started

To get started with this project, follow these steps:

Clone the repository:

git clone https://github.com/fatmaessa5/nopEcommerce.git


Open the project in your preferred IDE (e.g., IntelliJ IDEA or Eclipse).

Install dependencies using Maven:

mvn install


Run test classes:

Using Maven:

mvn clean test


Using TestNG XML:

Run the testng.xml file directly from your IDE.

📊 ExtentReports Integration

To generate detailed reports, ensure you have ExtentReports integrated with your test cases. Reports will be generated after each test run.

🧠 Lessons Learned

A separate file, Learned_Lessons.md, includes a summary of key concepts gained during this project.

Key Takeaways:

Modular test design with the Page Object Model for maintainability.

TestNG for managing test execution, retries, and parallel test execution.

ExtentReports for clear, interactive reporting with automatic screenshots for failed steps.

Data-driven testing using JSON files and utility classes for dynamic test data management.

Test maintenance with custom utilities to handle configurations and reusable functions.

This project improved my ability to design enterprise-level automation frameworks and apply best practices in real-world web application testing.

👨‍💻 Author

Fatma Essa
Junior Software QC Engineer
📧 fatma.essa5@gmail.com

🔗 LinkedIn Profile

💻 GitHub Repository
