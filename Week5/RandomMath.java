package Week5;
import java.util.Random;
import java.util.Scanner;

public class RandomMath {
    public static void main(String[] args) {
        System.out.println("1, Powers of a Number");
        System.out.println("2, Random Positive Integer with Maximum");
        System.out.println("3, Area of Random Circle");
        System.out.println("4, Area of Random Square");
        System.out.println("What would you like to do?");

        Scanner sc = new Scanner(System.in);

        int userInput = sc.nextInt();

        while (userInput >= 5 || userInput <= 0) {
            System.out.println("Invalid user input, type a number 1-4.");
            userInput = sc.nextInt();
        }

        switch (userInput) {
        case 1:
            System.out.print("What number would you like to calculate powers of? ");
            userInput = sc.nextInt();
            if (userInput == -1) {
                System.out.println("-1 raised to 0 is 1");
                System.out.println("-1 raised to odd powers greater than 0 is -1");
                System.out.println("-1 raised to even powers greater than 0 is 1");
            } else if (userInput == 0) {
                System.out.println("0 raised to the 0 is 1 ");
                System.out.println("0 raised to powers greater than 0 is 0 ");
            } else if (userInput == 1) {
                System.out.println("1 raised to ANY power is still 1");
            } else {
                int i = 0;
                do {
                    System.out.printf("%d raised to the %d is %d.\n", userInput, i, (int) Math.pow(userInput, i));
                    i++;
                } while (Math.abs(Math.pow(userInput, i)) < 100);
            }
            break;
        case 2:
            System.out.println("What is the max value you want your random number to be? ");
            userInput = sc.nextInt();
            if (userInput <= 0) {
                System.out.println("User input must be positive and non-zero.");
            } else {
                int randomNumber = (int) ((Math.random() * userInput) + 1);
                System.out.printf("Your random number is %d", randomNumber);
            }
            break;
        case 3:
            Random rnd = new Random();
            int circleRadius = (rnd.nextInt(101));
            double circleArea = Math.PI * Math.pow(circleRadius, 2);
            System.out.printf("A circle of radius %d has an area of %.2f", circleRadius,
                    ((int) (circleArea * 100)) / 100.0);
            break;
        default:
            int sideLength = (int) (Math.random() * 101);
            int squareArea = (int) Math.pow(sideLength, 2);
            System.out.printf("A square of sidelength %d has an area of %d", sideLength, squareArea);
            break;
        }
    }
}
