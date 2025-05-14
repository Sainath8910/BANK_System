# Bank System(using OOPs concepts)

The system allows users to perform basic banking operations such as:

Account creation (via class instantiation)

Depositing money (with bonus in savings account)

Withdrawing money (including an option to include transaction fee)

Viewing account details

# Classes:

Account (Abstract Class):
Contains private account details
Abstract methods: deposit(), displayBalance()
Overloaded withdraw() methods

BankAccount:
Inherits from Account
Implements deposit without bonus

SavingsAccount:
Inherits from Account
Overrides deposit to include a bonus (2%)

Bank:
Main class to test the functionality using polymorphism
