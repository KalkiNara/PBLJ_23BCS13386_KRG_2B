import java.util.Scanner;

                            /*EASY LEVEL*/
class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any text: ");
        String input = sc.nextLine();

        int vowelCount = 0, consonantCount = 0, digitCount = 0, specialCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
                if ("aeiou".indexOf(lower) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (!Character.isWhitespace(ch)) {
                specialCount++;
            }
        }

        System.out.println("Total Vowels: " + vowelCount);
        System.out.println("Total Consonants: " + consonantCount);
        System.out.println("Total Digits: " + digitCount);
        System.out.println("Total Special Characters: " + specialCount);
    }
}

                         /*MEDIUM LEVEL*/
class MatrixCalculator {

    public static int[][] inputMatrix(Scanner sc, int rows, int cols) {
        int[][] mat = new int[rows][cols];
        System.out.println("Enter matrix values (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length, colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix X: ");
        int rowsX = sc.nextInt(), colsX = sc.nextInt();
        int[][] X = inputMatrix(sc, rowsX, colsX);

        System.out.print("Enter rows and columns of Matrix Y: ");
        int rowsY = sc.nextInt(), colsY = sc.nextInt();
        int[][] Y = inputMatrix(sc, rowsY, colsY);

        System.out.println("\nMatrix X:");
        printMatrix(X);
        System.out.println("Matrix Y:");
        printMatrix(Y);

        if (rowsX == rowsY && colsX == colsY) {
            System.out.println("\nAddition Result:");
            printMatrix(addMatrices(X, Y));

            System.out.println("Subtraction Result:");
            printMatrix(subtractMatrices(X, Y));
        } else {
            System.out.println("\nAddition/Subtraction not possible (size mismatch).");
        }

        if (colsX == rowsY) {
            System.out.println("\nMultiplication Result:");
            printMatrix(multiplyMatrices(X, Y));
        } else {
            System.out.println("\nMultiplication not possible (X columns != Y rows).");
        }
    }
}

                                    /*HARD LEVEL*/
class Account {
    private String holderName;
    private String accNo;
    private double balance;

    public Account(String holderName, String accNo, double balance) {
        this.holderName = holderName;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current Balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " | New Balance: " + balance);
        }
    }

    public void showDetails() {
        System.out.println("Holder: " + holderName);
        System.out.println("Account No: " + accNo);
        System.out.println("Balance: " + balance);
    }
}

class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Open Account ===");
        System.out.print("Enter Holder Name: ");
        String holderName = sc.nextLine();
        System.out.print("Enter Account No: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double initBalance = sc.nextDouble();

        Account acc = new Account(holderName, accNo, initBalance);
        acc.showDetails();

        int option;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Account Info");
            System.out.println("4. Exit");
            System.out.print("Select option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depAmt = sc.nextDouble();
                    acc.deposit(depAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withAmt = sc.nextDouble();
                    acc.withdraw(withAmt);
                    break;
                case 3:
                    acc.showDetails();
                    break;
                case 4:
                    System.out.println("Goodbye! Thanks for using BankingApp.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);
    }
}
