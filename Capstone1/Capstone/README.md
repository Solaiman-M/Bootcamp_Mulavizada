LedgerFlow – Office Accounting System
Overview

LedgerFlow is a Java-based, console-driven office accounting system designed to help users manage and track financial transactions. It allows users to record deposits and payments, review transaction history, and generate reports using different search and filtering options.

The application stores transaction records in a CSV file, allowing financial data to persist between program executions.

Features
1. Transaction Management
   Add Deposit: Record incoming funds with a description, vendor, and amount.
   Make Payment: Record outgoing payments with a description, vendor, and amount.
   Automatically records the current date and time for every transaction.
   Validates transaction amounts to ensure they are greater than zero.
   Stores deposits as positive amounts and payments as negative amounts.
2. Ledger Management

Users can access the Ledger menu to review financial transactions.

All Transactions: Displays the latest 30 transactions.
Deposit Report: Displays deposit transactions.
Purchase Report: Displays payment transactions.
More Report Options: Provides additional reporting and search functionality.
3. Financial Reports

LedgerFlow supports several reporting options:

Report	Description
Month To Date	Displays transactions from the beginning of the current month through today.
Previous Month	Displays transactions from the previous calendar month.
Year To Date	Displays transactions from the beginning of the current year through today.
Previous Year	Displays transactions from the previous year.
Search By Vendor	Finds transactions using a vendor name or keyword.
Custom Search	Filters transactions using multiple search criteria.
4. Custom Search

The custom search feature allows users to narrow down transactions using:

Start Date: Displays transactions on or after a specified date.
End Date: Displays transactions on or before a specified date.
Vendor: Searches for transactions matching a vendor name or keyword.
Transaction Type: Filters by purchases, deposits, or both.
Minimum Amount: Displays transactions equal to or greater than a specified amount.
Maximum Amount: Displays transactions equal to or less than a specified amount.

Users can leave optional search fields empty to include all matching records for that criterion.

5. Data Persistence
   Transaction records are stored in transaction.csv.
   New transactions are appended to the existing file.
   Existing transactions are loaded when the application starts.
   Transaction history remains available after the application closes.
   Technologies Used
   Java – Main programming language.
   Java Time API – Handles transaction dates and times using LocalDate and LocalTime.
   Java Collections Framework – Uses ArrayList and List to manage transaction records.
   Java File I/O – Reads and writes transaction data using FileReader, FileWriter, BufferedReader, and BufferedWriter.
   CSV File Storage – Stores financial transaction records in a pipe-delimited text file.
   Scanner – Handles user input through the console.
   Project Structure
   text
   LedgerFlow/
   │
   ├── src/
   │   └── main/
   │       ├── java/
   │       │   └── org/
   │       │       └── example/
   │       │           ├── Main.java
   │       │           ├── Ledger.java
   │       │           └── FileManager.java
   │       │
   │       └── resources/
   │           └── transaction.csv
   │
   └── README.md

Class Responsibilities

Main.java

Handles the application's main menu and user interaction. It contains the methods responsible for adding deposits, recording payments, displaying transactions, generating reports, and performing custom searches.

Ledger.java

Represents an individual financial transaction. Each transaction contains:

Date
Time
Description
Vendor
Amount

The class uses private fields and getter methods to protect transaction information from being modified after creation.

FileManager.java

Handles file operations, including reading existing transactions from transaction.csv and appending new transactions to the file.

Getting Started
Prerequisites

Before running the application, make sure you have:

Java Development Kit (JDK) installed.
A Java IDE such as IntelliJ IDEA, Eclipse, or VS Code.
A properly configured Java project.
Installation
Clone or download the repository.
Open the project in your preferred Java IDE.
Make sure the following directory exists:
text
src/main/resources/

Create a file named transaction.csv inside the resources directory.
Add the following header to the CSV file:
text
date|time|description|vendor|amount

Run Main.java to start the application.
How to Use

Once the application starts, the main menu will appear:

text
===================================================================
                            LEDGER FLOW
                       OFFICE ACCOUNTING SYSTEM
                            MAIN MENU
===================================================================
[D]  Add Deposit
[P]  Make Payment
[L]  Ledger
[X]  Exit
-------------------------------------------------------------------
Choose an Option:

Example: Adding a Deposit
Select D from the main menu.
Enter a transaction description.
Enter the vendor name.
Enter the deposit amount.
The application automatically records the current date and time.
The transaction is saved to transaction.csv.
Example: Making a Payment
Select P from the main menu.
Enter a transaction description.
Enter the vendor name.
Enter the payment amount.
The application automatically converts the payment into a negative transaction amount.
The transaction is saved to transaction.csv.
Example: Viewing Reports
Select L from the main menu.
Select M to access additional report options.
Choose the desired report.
Follow the console prompts to filter and display transactions.
Data Storage Format

LedgerFlow uses a pipe-delimited file format to store transaction records.

Each transaction follows this structure:

text
date|time|description|vendor|amount


Example:

text
date|time|description|vendor|amount
11/05/2026|10:30:15 AM|Office Supplies|Staples|125.50
11/05/2026|11:15:20 AM|Office Equipment|Best Buy|-450.00


Transaction Amount Convention:

Positive values represent deposits (incoming money).
Negative values represent payments (outgoing money).

This convention makes it easier to distinguish between incoming and outgoing transactions when generating reports.

Future Improvements

Potential enhancements for future versions include:

Add transaction editing and deletion functionality.
Implement account balance calculations.
Add transaction sorting options.
Export reports to CSV or PDF.
Improve input validation for descriptions and vendor names.
Add support for multiple accounts.
Implement a graphical user interface (GUI).
Improve file handling and error management.
Author

Developed as a Java programming project to demonstrate object-oriented programming, file handling, collections, date and time management, and console-based application development.

License

This project is intended for educational and personal development purposes.