import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Team class that produces a Team object. A Team object stores an array of
 * members which can be manipulated in a variety of ways.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Team {
    private Member[] members;

    /**
     * Constructor that accepts an array of Member objects and deep copies them into
     * the members instance variable.
     * Thows an IllegalArgumentException is the Member array is null or contains
     * null elements.
     *
     * @param members array of Member objects
     */
    public Team(Member[] members) {
        if (members == null) {
            throw new IllegalArgumentException("The members array is null");
        }
        this.members = new Member[members.length];
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                throw new IllegalArgumentException("The members array contains null elements");
            }
            this.members[i] = new Member(members[i]);
        }
    }

    /**
     * Sorts the members array utilizing merge sort, which runs in O(nlog(n)) time.
     */
    public void mergeSortMembers() {
        this.members = mergeHelper(this.members);
    }

    /**
     * Helper method for the mergeSortMembers method. Accepts an array of Member
     * objects. Recursively splits the array until it is composed of arrays of only
     * size 1. Then the arrays are merged using the HWUtils.merge method.
     *
     * @param arrList the array of Member objects to be split
     * @return a sorted array of Member objects.
     */
    private Member[] mergeHelper(Member[] arrList) {
        if (arrList.length == 1) {
            return arrList;
        } else {
            Member[] leftArrList = HWUtils.copyOfRange(arrList, 0, (arrList.length / 2));
            Member[] rightArrList = HWUtils.copyOfRange(arrList, (arrList.length / 2), arrList.length);
            return HWUtils.merge(mergeHelper(leftArrList), mergeHelper(rightArrList));
        }
    }

    /**
     * Accepts a 2D array of: an array of Member arrays. Each array is merged into
     * the members instance variable.
     *
     * @param arrList the 2D array of Member arrays.
     */
    public void mergeAllMembers(Member[][] arrList) {
        Member[] arrayListToAdd;
        for (int i = 0; i < arrList.length; i++) {
            arrayListToAdd = this.mergeHelper(arrList[i]);
            this.members = HWUtils.merge(this.members, arrayListToAdd);
        }
    }

    /**
     * Finds a member in the members instance variable utilizing binary search.
     * Throws an IllegalArgumentException if the Member being searched for is null.
     * Throws a NoSuchElementException is the element is not found with the members
     * instance variable.
     *
     * @param m the Member being located
     * @return the Member located from the member array
     */
    public Member searchMember(Member m) {
        if (m == null) {
            throw new IllegalArgumentException("the Member passed in is null");
        }
        this.mergeSortMembers();
        Member found = this.binarySearch(m, this.members);
        if (found == null) {
            throw new NoSuchElementException("Member was not found");
        }
        return found;
    }

    /**
     * A helper method for the searchMember method. Implements the binary search
     * recursively by accepting a Member to search for and an array of Member
     * objects. Splits the array of Member objects until the correct Member is found
     * or, otherwise, returns null.
     *
     * @param m       the Member to be located
     * @param arrList the array of Member objects to be checked
     * @return a Member that equals the Member m, or null if no Member matching m is
     *         found
     */
    private Member binarySearch(Member m, Member[] arrList) {
        int middleIndex = ((arrList.length) / 2);
        if (arrList[middleIndex].equals(m)) {
            return arrList[middleIndex];
        } else if (arrList.length == 1) {
            return null;
        } else if (m.compareTo(arrList[middleIndex]) > 0) {
            return binarySearch(m, HWUtils.copyOfRange(arrList, middleIndex, arrList.length));
        } else {
            return binarySearch(m, HWUtils.copyOfRange(arrList, 0, middleIndex));
        }
    }

    /**
     * Creates a new Member array which contains the values of the member array but
     * in reverse.
     *
     * @return the Member array cotainining the reversed order
     */
    public Member[] reverseMembers() {
        Member[] arrList = new Member[this.members.length];
        for (int i = 0; i < arrList.length; i++) {
            arrList[i] = new Member(this.members[arrList.length - 1 - i]);
        }
        return arrList;
    }

    /**
     * Selects a leader randomly from the members array for the FRONTEND team and
     * the BACKEND team amongst those labeled as FRONTEND or BACKEND.
     * Throws a NoSuchElementException if the members array contains some
     * combination of no frontEnd or backEnd Members.
     *
     * @return an ArrayList containing 2 Member objects, a leader for the FRONTEND
     *         and a leader for the BACKEND
     */
    public ArrayList<Member> selectLeaderboard() {
        ArrayList<Member> leaders = new ArrayList<>();
        ArrayList<Member> frontEnd = new ArrayList<>();
        ArrayList<Member> backEnd = new ArrayList<>();
        selectLeaderboardHelper(frontEnd, backEnd, 0);
        for (Member member : frontEnd) {
            System.out.println(member.toString());
        }
        for (Member member : backEnd) {
            System.out.println(member.toString());
        }
        if (frontEnd.size() == 0 && backEnd.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for both subgroups.");
        } else if (frontEnd.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for the FRONTEND subgroup.");
        } else if (backEnd.size() == 0) {
            throw new NoSuchElementException("Failed to select leaders for the BACKEND subgroup.");
        }
        Random rnd = new Random();
        leaders.add(frontEnd.get(rnd.nextInt(frontEnd.size())));
        leaders.add(backEnd.get(rnd.nextInt(backEnd.size())));
        return leaders;
    }

    /**
     * A helper method for the selectLeaderboard method. Recursively iterates
     * through the members Array and sorts Member objects into a FRONTEND ArrayList
     * or BACKEND ArrayList based no their designation.
     *
     * @param frontEnd the ArrayList containing FRONTEND Member objects
     * @param backEnd the ArrayList containing BACKEND Member objects
     * @param index the index of the members Array to be checked
     */
    private void selectLeaderboardHelper(ArrayList<Member> frontEnd, ArrayList<Member> backEnd, int index) {
        if (!(index == this.members.length)) {
            if (this.members[index].getSubgroup().name().equals("FRONTEND")) {
                frontEnd.add(this.members[index]);
            } else if (this.members[index].getSubgroup().name().equals("BACKEND")) {
                backEnd.add(this.members[index]);
            }
            selectLeaderboardHelper(frontEnd, backEnd, index + 1);
        } else {
            System.out.println("Max index" + index);
        }
    }

    /**
     * A getter method for the members array instance variable.
     *
     * @return the members array instance variable
     */
    public Member[] getMembers() {
        return this.members;
    }

    // public static void printArray(Member[] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.println(arr[i].toString());
    //     }
    // }

    // public static void main(String[] args) {
    //     Member[] initialMembers = new Member[] { new Member("Pat", Group.FRONTEND, 7) };
    //     Member[] members = new Member[] { new Member("Erich", Group.BACKEND, 8), new Member("Ken", Group.BACKEND, 9),
    //             new Member("Eman", Group.FRONTEND, 6), new Member("Klaus", Group.FRONTEND, 4),
    //             new Member("Harrison", Group.ADMIN, 11) };
    //     Member[][] allMembers = new Member[][] { members };

    //     Team t = new Team(initialMembers);
    //     // Team.printArray(t.getMembers());
    //     t.mergeAllMembers(allMembers);
    //     Team.printArray(t.getMembers());
    //     System.out.println("\n");
    //     ArrayList<Member> arrList = t.selectLeaderboard();
    //     System.out.println(arrList);
    // }
}