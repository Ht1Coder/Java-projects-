# Java-projects-

## ATM

A console-based Java ATM simulation with checking and savings accounts. It supports credential verification, deposits, withdrawals, a checking overdraft limit, and savings investment with compound interest.

### Requirements

- JDK 8 or later

### Compile and run

From the repository root:

```text
javac -d out ATM.java
java -cp out projects.ATM
```

The demo accounts use account number `5129` and PIN `1234`. The checking account starts at `$500.00` with a `$50.00` overdraft limit. The savings account starts at `$1,000.00` with a `12.5%` annual investment rate. These are sample values for this local simulation, not real banking credentials.
