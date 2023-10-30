package Week4;
public class Prime23 { 
    public static void main(String[] args) {
        int numToCheck = 980;
        int numFactors = 2;
        int smallestFactor = numToCheck;
        int currentFactor = numToCheck - 1;
        System.out.printf("Checking if %d is prime...", numToCheck);
        while(currentFactor > 2) {
            if(numToCheck % currentFactor == 0) {
                System.out.printf("\n%d divides %d", currentFactor, numToCheck);
                if(currentFactor < smallestFactor) {
                    smallestFactor = currentFactor;
                }
                numFactors++;
            }
            else {
                System.out.printf("\n%d is not a multiple of %d", numToCheck, currentFactor);
            }
            currentFactor--;
        }
        System.out.printf("\nNumber to check for primality: %d", numToCheck);
        System.out.printf("\nSmallest factor: %d", smallestFactor);

        switch(numFactors) {
            case 2: {
                System.out.printf("\nThe number is prime!");
                break;
            }
            case 3: {
                System.out.printf("\nThis number has three factors, so it is not prime.");
                break;
            }
            case 4: {
                System.out.printf("\nThis number has four factors, so it is not prime.");
                break;
            }
            case 5: {
                System.out.printf("\nThis number has five factors, so it is not prime.");
                break;
            }
            default: {
                System.out.printf("\nWow, %d is a lot of factors! This number is not prime.", numFactors);
            }
        }
    }
    
}
