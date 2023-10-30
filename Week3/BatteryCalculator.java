package Week3;

public class BatteryCalculator {
    public static void main(String[] args) {
        final int tikTokHours = 2;
        final int spotifyHours = 3;
        final double messagingHours = 1.5;
        final double instagramHours = 0.5;
        final int rechargeTime = 31;
        int phoneBattery = 100;

        phoneBattery -= (17 * tikTokHours);
        phoneBattery -= (5 * spotifyHours);
        phoneBattery -= (8 * messagingHours);
        phoneBattery -= (12 * instagramHours);

        System.out.println("The battery of my phone at the end of the day is " + phoneBattery + "%.");

        phoneBattery += (1.3 * rechargeTime);
        
        System.out.println("The battery after a " + rechargeTime + " minute recharge is " + phoneBattery + "%." );
    }

}
