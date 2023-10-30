package Week12;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that defines a ticket object. All methods are static.
 *
 * @author Felipe Bergerman
 * @version 1.1
 */
public class Tickets {
    /**
     * Retrieves an ArrayList of games from a file with a given filePath.
     *
     * @param filePath a String representing a filePath to a file
     * @return an ArrayList containing SportsGame objects
     * @throws FileNotFoundException  if the filePath is empty, null or invalid
     * @throws InvalidTicketException if a given line read is not a valid SportsGame
     */
    public static ArrayList<SportsGame> retrieveGames(String filePath)
            throws FileNotFoundException, InvalidTicketException {
        if (!isStringValid(filePath)) {
            throw new FileNotFoundException("filePath either blank or null");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("invalid file path");
        }
        Scanner scanner = new Scanner(file);
        ArrayList<SportsGame> sportsGameArray = new ArrayList<SportsGame>();
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            sportsGameArray.add(processInfo(nextLine));
        }
        scanner.close();
        return sportsGameArray;
    }

    /**
     * A helper method that takes a String and creates a SportsGame based off of its
     * atributes.
     *
     * @param str a String whose attributes will be examined.
     * @return a SportsGame based on the String examined.
     * @throws InvalidTicketException if the String contains neither info for a
     *                                FootballGame nor BasketballGame
     */
    private static SportsGame processInfo(String str) throws InvalidTicketException {
        String[] stringArray = str.split(",");
        if (stringArray[0].equals("BasketballGame")) {
            return new BasketballGame(stringArray[1], stringArray[2], stringArray[3], Integer.parseInt(stringArray[4]),
                    Integer.parseInt(stringArray[5]), Integer.parseInt(stringArray[6]), stringArray[7]);
        } else if (stringArray[0].equals("FootballGame")) {
            return new FootballGame(stringArray[1], stringArray[2], stringArray[3], Integer.parseInt(stringArray[4]),
                    Integer.parseInt(stringArray[5]), Integer.parseInt(stringArray[6]), stringArray[7]);
        } else {
            throw new InvalidTicketException("the gametype neither a FootballGame nor BasketballGame");
        }
    }

    /**
     * Purchases tickets by editing an existing file and additionally populating it
     * with SportsGame objects from an array. If no file exists for a given
     * filePath,
     * one is automatically created.
     *
     * @param filePath        String representing a filePath to a file
     * @param sportsGameArray ArrayList containing SportsGame objects to be added
     * @throws IllegalArgumentException if the filePath is either blank or null
     * @throws IOException              if an error occurs during file
     *                                  location/creation
     */
    public static void purchaseTickets(String filePath, ArrayList<SportsGame> sportsGameArray)
            throws IllegalArgumentException, IOException, InvalidTicketException {
        if (!Tickets.isStringValid(filePath)) {
            throw new IllegalArgumentException("Path blank or null");
        }
        File file = new File(filePath);
        if (file.createNewFile()) {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < sportsGameArray.size(); i++) {
                if (sportsGameArray.get(i).getSeatsLeft() != 0) {
                    fileWriter.write(sportsGameArray.get(i).toString() + "\n");
                }
            }
            fileWriter.close();
        } else {
            ArrayList<SportsGame> updatedList = retrieveGames(filePath);
            for (int i = 0; i < sportsGameArray.size(); i++) {
                updatedList.add(sportsGameArray.get(i));
            }
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < updatedList.size(); i++) {
                if (updatedList.get(i).getSeatsLeft() != 0) {
                    fileWriter.write(updatedList.get(i).toString() + "\n");
                }
            }
            fileWriter.close();
        }
    }

    /**
     * Locates specific tickets within a given file.
     *
     * @param filePath String representing a filePath to a given file
     * @param sg       the SportsGame object to be located
     * @return an ArrayList of ints with each int representing a line number for
     *         which a specific SportsGame is found
     * @throws FileNotFoundException  when the filePath is either empty, null, or
     *                                invalid
     * @throws InvalidTicketException if sg is not found
     */
    public static ArrayList<Integer> findTickets(String filePath, SportsGame sg)
            throws FileNotFoundException, InvalidTicketException {
        if (!isStringValid(filePath)) {
            throw new FileNotFoundException("filePath either empty or null");
        }
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> sportsGameArray = new ArrayList<Integer>();
        int currentLine = 0;
        SportsGame currentGame;
        while (scanner.hasNextLine()) {
            currentGame = Tickets.processInfo(scanner.nextLine());
            if (currentGame.equals(sg)) {
                sportsGameArray.add(currentLine);
            }
            currentLine++;
        }
        scanner.close();
        if (sportsGameArray.size() == 0) {
            throw new InvalidTicketException("SportsGame not found");
        }
        return sportsGameArray;
    }

    /**
     * Attends a sports game by removing all occurences of sg from a file.
     *
     * @param filePath a String representing a filePath for a file.
     * @param sg       a SportsGame object to be found and removed from a file.
     * @throws FileNotFoundException if the file is invalid
     * @throws IOException           if an error occurs during file editing
     */
    public static void attendGame(String filePath, SportsGame sg) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            ArrayList<String> updatedList = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String currLine = scanner.nextLine();
                if (!currLine.equals(sg.toString())) {
                    updatedList.add(currLine);
                }
            }
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < updatedList.size(); i++) {
                fileWriter.write(updatedList.get(i) + "\n");
            }
            scanner.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    /**
     * A helper method that determines if a String is valid.
     *
     * @param str String to be checked for validity
     * @return true if the String is valid, false otherwise
     */
    private static boolean isStringValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }
}
