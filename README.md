# OrangeHRM Automation Framework  

## 📌 Project Overview  
This project automates the testing of the **OrangeHRM Web Application** using **Selenium WebDriver, Java, TestNG, and Maven**.  
It verifies key functionalities like **Login, Employee Management (Add, Validate, Logout)** and ensures application stability with data-driven testing.  

The framework follows the **Page Object Model (POM)** design pattern for better reusability, readability, and maintainability.  

---

##  Tech Stack  
- **Java 21**  
- **Selenium WebDriver 4.35.0**  
- **TestNG** – Test execution and reporting  
- **Maven** – Build management & dependencies  
- **Page Object Model (POM)** – Design pattern for UI automation  
- **Git** – Version control  

## Project Structure  
src/test/java/Hrm
├── pages/ # Page classes (Page Object Model)
├── testscripts/ # Test classes with TestNG
├── utils/ # Utilities (browser setup, waits, configs, etc.)
testng.xml # TestNG suite file
pom.xml # Maven dependencies & plugins

## Setup Instructions  

1. Clone the repository:  
   ```bash
   git clone <repo-url>

**Test Scenarios Covered**

Login Test → Verify valid login with Admin credentials

Add Employee Test → Add new employees using @DataProvider

Validate Employee Test → Verify employee exists in Employee List

Logout Test → Verify successful logout
