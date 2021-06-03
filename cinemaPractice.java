package com.helloworld;
import java.util.Scanner;

public class cinemaPractice {
    public static void main(String[] args) {
        int frontRow = 0;
        int backRow = 0;
        int i = 0;
        int j = 0;
        int counter = 0;
        float bookedSeat = 0;
        int seatincome = 0;
        int totalIncome = 0;
        int frontMoney = 0;
        int backMoney = 0;
        boolean pause = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        rows += 1;
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        seats += 1;
        System.out.println();

        float totalseats = (rows - 1) * (seats - 1);

        int actualRows = rows - 1;
        int actualSeats = seats -1;

        int rowNum = 0;
        int seatNum = 0;

        char[][] theatre = new char[rows][seats];
        for (i = 0; i < rows; i++){
            for(j = 0; j < seats; j++){
                theatre[i][j] = 'S';
            }
        }
        char replace = 'B';
        float percentage = 0;
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int command = scanner.nextInt();
        if(totalseats <= 60){
            totalIncome = actualRows * actualSeats * 10;
        } else {
            if (actualRows % 2 == 0) {
                frontRow = (actualRows / 2);
                backRow = (actualRows / 2);
                totalIncome = (actualRows * actualSeats) * 10;
            } else {
                frontRow = (actualRows / 2);
                backRow = (actualRows - frontRow);
                totalIncome = (actualSeats * frontRow * 10) + (actualSeats * backRow * 8);
            }
        }
        while (command != 0) {
            switch (command) {
                case 1:
                    if (counter == 0) {
                        System.out.println();
                        System.out.println("Cinema:");
                        for (i = 0; i < rows; i++) {
                            if (i == 0) {
                                System.out.print("  ");
                            } else {
                                System.out.print(i + " ");
                            }
                            for (j = 1; j < seats; j++) {
                                if (i == 0) {
                                    System.out.print(j + " ");
                                }
                                if (i >= 1 && j >= 1) {
                                    System.out.print(theatre[i][j] + " ");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println();
                        System.out.println("1. Show the seats");
                        System.out.println("2. Buy a ticket");
                        System.out.println("3. Statistics");
                        System.out.println("0. Exit");
                        command = scanner.nextInt();
                        break;
                    } else if (counter > 0) {
                        System.out.println();
                        System.out.println("Cinema:");
                        for (i = 0; i < rows; i++) {
                            if (i == 0) {
                                System.out.print("  ");
                            } else {
                                System.out.print(i + " ");
                            }
                            for (j = 1; j < seats; j++) {
                                theatre[rowNum][seatNum] = 'B';
                                if (i == 0) {
                                    System.out.print(j + " ");
                                }
                                if (i == rowNum && j == seatNum) {
                                    System.out.print(theatre[rowNum][seatNum] + " ");
                                } else if (i >= 1 && j >= 1) {
                                    System.out.print(theatre[i][j] + " ");
                                }
                            }
                            System.out.println();
                        }
                    }
                    System.out.println();
                    System.out.println("1. Show the seats");
                    System.out.println("2. Buy a ticket");
                    System.out.println("3. Statistics");
                    System.out.println("0. Exit");
                    command = scanner.nextInt();
                    break;
                case 2:
                        do {
                            try {
                            System.out.println();
                            System.out.println("Enter a row number: ");
                            int rowNumber = scanner.nextInt();
                            rowNum = rowNumber;
                            System.out.println("Enter a seat number in that row: ");
                            int seatNumber = scanner.nextInt();
                            seatNum = seatNumber;
                            if(theatre[rowNum][seatNum] == 'B'){
                                System.out.println();
                                System.out.println("That ticket has already been purchased!");
                                pause = true;
                            } else {
                                System.out.print("Ticket price: ");
                                if (totalseats <= 60) {
                                    System.out.println();
                                    System.out.print("$10");
                                    pause = false;
                                    frontMoney++;
                                    System.out.println();
                                } else if (totalseats > 60) {
                                    System.out.println();
                                    if (actualRows % 2 == 0) {
                                        frontRow = (actualRows / 2);
                                        backRow = (actualRows / 2);
                                        if (rowNumber <= frontRow) {
                                            System.out.print("$10");
                                            pause = false;
                                            frontMoney++;
                                        } else {
                                            System.out.print("$8");
                                            pause = false;
                                            backMoney++;
                                        }
                                    } else {
                                        frontRow = (actualRows / 2);
                                        backRow = (actualRows - frontRow);
                                        if (rowNumber <= frontRow) {
                                            System.out.println("$10");
                                            pause = false;
                                            frontMoney++;
                                        } else {
                                            System.out.println("$8");
                                            pause = false;
                                            backMoney++;
                                        }
                                    }
                                }
                            }
                            theatre[rowNum][seatNum] = 'B';
                            } catch (Exception e){
                                System.out.println();
                                System.out.println("Wrong input!");
                                pause = true;
                            }
                        } while (pause);
                    System.out.println();
                    bookedSeat++;
                    counter++;
                    percentage = 100 * (bookedSeat / totalseats);
                    seatincome = (frontMoney * 10) + (backMoney * 8);

                    System.out.println("1. Show the seats");
                    System.out.println("2. Buy a ticket");
                    System.out.println("3. Statistics");
                    System.out.println("0. Exit");
                    command = scanner.nextInt();
                    break;
                case 3:
                    System.out.println();
                    System.out.printf("Number of purchased tickets: %.0f\n", bookedSeat);
                    System.out.printf("Percentage: %.2f%%\n", percentage);
                    System.out.println("Current income: $" + seatincome);
                    System.out.printf("Total income: $%d\n", totalIncome );
                    System.out.println();
                    System.out.println("1. Show the seats");
                    System.out.println("2. Buy a ticket");
                    System.out.println("3. Statistics");
                    System.out.println("0. Exit");
                    command = scanner.nextInt();
                    break;
                case 0:
                    break;
            }
        }
    }
}
