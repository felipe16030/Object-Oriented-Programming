package Week3;

class CurrencyConversion {
    //My name is Felipe and I love playing electric guitar
    public static void main(String[] args) {
        double aedPerUsd = 3.67;
        double aedPerEur = 4.19;
        int notes = 250;

        String name = "Felipe";

        double euros = notes / aedPerEur;
        double dollars = notes / aedPerUsd;

        euros = euros * 100;
        euros = (int) euros;
        double eurosTrunc = (double) euros / 100;

        dollars = dollars * 100;
        dollars = (int) dollars;
        double dollarsTrunc = (double) dollars / 100;

        System.out.println(name + " is carrying " + eurosTrunc + " Euros and " + dollarsTrunc + " Dollars!"); 
    }

}