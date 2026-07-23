import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getName();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getName() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getName() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    private final T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return "Meal{" + mealPlan.getName() + '}';
    }
}

public class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        System.out.println("Generating personalized meal plan for: " + mealPlan.getName());
        return new Meal<>(mealPlan);
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = generateMealPlan(new KetoMeal());

        List<Meal<? extends MealPlan>> meals = new ArrayList<>();
        meals.add(vegMeal);
        meals.add(veganMeal);
        meals.add(ketoMeal);

        System.out.println("\nPersonalized meal plans:");
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
        }
    }
}
