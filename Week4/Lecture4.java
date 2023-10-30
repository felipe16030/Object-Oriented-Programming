package Week4;


public class Lecture4 {

    public static void main(String[] args) {
        String s1 = "Good Morning";
        s1 = s1.replace("Good", "Bad"); // replace does not change the original string, returns new version

        System.out.println(s1);

        String s2 = s1.toUpperCase(); // toUpperCase also does not mutate original String

        System.out.println(s2);

        // Comparing strings with == compares memory location

        String thing1 = "thing";
        String thing2 = "thing"; // points to same memory location as thing1
        String thing3 = new String("thing");
        System.out.println(thing1 == thing2); // true
        System.out.println(thing1 == thing3); // true

        // Do not use == to compare doubles either because floating point calculations have error (ex. 0.1 + 0.2)
        System.out.println(0.1 + 0.2 == 0.3); // false
        System.out.println(Math.abs((0.1+0.2)-0.3) < 0.00000001); // true


        // Escape sequences are specific in Java: ex. \n creates a new line, \" produces a " inside a String,
        // \t produces a tab, \b removes the char preceding it, and \r moves to the beginning of the line

    }
}
