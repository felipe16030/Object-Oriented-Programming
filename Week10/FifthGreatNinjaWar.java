
/**
 * Class for the FifthGreatNinjaWar object. Enables one to battle Ninja against
 * eachother.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class FifthGreatNinjaWar {
    private Ninja[] firstTeam = new Ninja[5];
    private Ninja[] secondTeam = new Ninja[5];

    /**
     * Constructor which accepts the two teams battling.
     *
     * @param firstTeam  Array of Ninjas on the first team
     * @param secondTeam Array of Ninjas on the second tema
     */
    public FifthGreatNinjaWar(Ninja[] firstTeam, Ninja[] secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    /**
     * A method that returns a String representing of a FifthGreatNinjaWar object.
     *
     * @return A formatted String listing each of the participants on both sides.
     */
    public String toString() {
        String returnString = "First Team: ";
        for (int i = 0; i < this.firstTeam.length; i++) {
            if (this.firstTeam[i] == null) {
                returnString += "Empty";
            } else {
                returnString += this.firstTeam[i].toString();
            }
            if (i != this.firstTeam.length - 1) {
                returnString += ", ";
            }
        }
        returnString += " vs Second Team: ";
        for (int i = 0; i < this.secondTeam.length; i++) {
            if (this.secondTeam[i] == null) {
                returnString += "Empty";
            } else {
                returnString += this.secondTeam[i].toString();
            }
            if (i != this.firstTeam.length - 1) {
                returnString += ", ";
            }
        }
        return returnString;
    }

    /**
     * A method that compares the teams based on the number of Ninjas they have.
     * A team is predicted to win if they have more Ninja.
     */
    public void compareTeams() {
        int numNinjasFirstTeam = this.countNumNinjas(this.firstTeam);
        int numNinjasSecondTeam = this.countNumNinjas(this.secondTeam);

        if (numNinjasFirstTeam > numNinjasSecondTeam) {
            System.out.println("The first team will probably win.");
        } else if (numNinjasFirstTeam < numNinjasSecondTeam) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * A method that battles the two sides against each other until one or both
     * sides have fainted.
     */
    public void battle() {
        int i = 0;
        int j = 0;
        Ninja[] firstTeamBattle = normalizeNinjaArray(this.firstTeam);
        Ninja[] secondTeamBattle = normalizeNinjaArray(this.secondTeam);
        boolean firstTeamFainted = hasTeamFainted(firstTeamBattle);
        boolean secondTeamFainted = hasTeamFainted(secondTeamBattle);

        while (!firstTeamFainted && !secondTeamFainted) {
            firstTeamBattle[i].attackNinja(secondTeamBattle[j]);
            secondTeamBattle[j].attackNinja(firstTeamBattle[i]);
            if (firstTeamBattle[i].hasFainted()) {
                i++;
            }
            if (secondTeamBattle[j].hasFainted()) {
                j++;
            }
            firstTeamFainted = hasTeamFainted(firstTeamBattle);
            secondTeamFainted = hasTeamFainted(secondTeamBattle);
        }
        if (firstTeamFainted && secondTeamFainted) {
            System.out.println("Both teams fainted.");
        } else if (firstTeamFainted) {
            System.out.println("The second team won!");
        } else {
            System.out.println("The first team won!");
        }
    }

    /**
     * Main method to test Ninjas and FifthGreatNinjaWar.
     *
     * @param args array of strings that contains java command line arguemnts
     */
    public static void main(String[] args) {
        // Ninja[] n1 = {new LeafNinja("Naruto", 10, 30, 10), new StoneNinja("A", 20, 35, true),
        //     new MistNinja("Mei", 10, 25, 1), null, null};
        // Ninja[] n2 = {new LeafNinja("Naruto", 10, 30, 10), new StoneNinja("A", 20, 35, true),
        //     new MistNinja("Mei", 10, 25, 1), null, new LeafNinja("Itachi", 100, 100, 100)};
        // FifthGreatNinjaWar f5 = new FifthGreatNinjaWar(n1, n2);
        // System.out.println(f5.toString());
        // System.out.println(n1[0].toString());
        // System.out.println(n1[1].toString());
        // System.out.println(n1[2].toString());
        // f5.compareTeams();
        // f5.battle();
        calcMod(12);
    }

    public static int calcMod(int x) {
        return (Math.pow(x, 17));
    }

    /**
     * Helper method that cycles through a team and determines if every Ninja has
     * fainted.
     *
     * @param arr a team as an Array of Ninjas
     * @return true if all have fainted, false otherwise.
     */
    private boolean hasTeamFainted(Ninja[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (!(arr[i].hasFainted())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper method that creates new team arrays without null entries.
     *
     * @param arr a team as an Array of Ninjas
     * @return a team as an Array of Ninjas
     */
    private Ninja[] normalizeNinjaArray(Ninja[] arr) {
        Ninja[] newArray = new Ninja[countNumNinjas(arr)];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                newArray[j] = arr[i];
                j++;
            }
        }
        return newArray;
    }

    /**
     * Helper method that counts how many Ninjas are on a team.
     *
     * @param arr a team as an Array of Ninjas
     * @return the number of Ninjas on a team as a an int.
     */
    private int countNumNinjas(Ninja[] arr) {
        int totalCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                totalCount++;
            }
        }
        return totalCount;
    }
}
