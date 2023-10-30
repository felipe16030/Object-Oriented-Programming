public class HealthyEating23 {

    public static Food[] mealPrep(int numFoods) {
        Food[] foodArray = new Food[numFoods];
        for (int i = 0; i < foodArray.length; i++) {
            int randNum = (int) (Math.random() * 6);
            foodArray[i] = Food.values()[randNum];
        }
        return foodArray;
    }

    public static Food[] followRecipe(String recipe) {
        String[] stringEnumArray = recipe.split(" ");
        Food[] foodArray = new Food[stringEnumArray.length];
        for (int i = 0; i < foodArray.length; i++) {
            foodArray[i] = Food.valueOf(stringEnumArray[i]);
        }
        return foodArray;
    }

    public static void mealAnalyzer(Food[] foodArray) {
        System.out.println("The following types of food are in your meal:");
        Food[] typesOfFoodArray = Food.values();
        for (int i = 0; i < typesOfFoodArray.length; i++) {
            int countOfCurrentFood = 0;
            for (int j = 0; j < foodArray.length; j++) {

                if (foodArray[j] == typesOfFoodArray[i]) {
                    countOfCurrentFood++;
                }
            }
            System.out.println(typesOfFoodArray[i] + " " + countOfCurrentFood);
        }
    }

    public static void healthyChoice(Food[] meal1, Food[] meal2) {
        int meal1Score = 0;
        int meal2Score = 0;
        for (int i = 0; i < meal1.length; i++) {
            meal1Score += meal1[i].ordinal();
        }
        for (int i = 0; i < meal2.length; i++) {
            meal2Score += meal2[i].ordinal();
        }
        if (meal1Score > meal2Score) {
            System.out.println("The first meal is the healthier choice with a score of " + meal1Score + ".");
        } else if (meal2Score > meal1Score) {
            System.out.println("The second meal is the healthier choice with a score of " + meal2Score + ".");
        } else {
            System.out.println("The two meals are equally healthy with scores of " + meal1Score + ".");
        }
    }

    public static void main(String[] args) {
        Food[] meal1 = followRecipe("DAIRY GRAIN PROTEIN GRAIN PROTEIN");
        Food[] meal2 = followRecipe("VEGETABLE VEGETABLE VEGETABLE VEGETABLE");
        mealAnalyzer(meal1);
        mealAnalyzer(meal2);
        healthyChoice(meal1, meal2);
        meal1 = followRecipe("VEGETABLE VEGETABLE VEGETABLE VEGETABLE");
        meal2 = followRecipe("DAIRY GRAIN PROTEIN GRAIN PROTEIN");
        healthyChoice(meal1, meal2);
        meal1 = followRecipe("DAIRY GRAIN PROTEIN GRAIN PROTEIN");
        meal2 = followRecipe("DAIRY GRAIN PROTEIN GRAIN PROTEIN");
        healthyChoice(meal1, meal2);
    }
}
