import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс для представления продуктов
class FoodItem {
    private String name;
    private double caloriesPerUnit;  // Калории на единицу измерения
    private double quantity;         // Количество продукта

    public FoodItem(String name, double caloriesPerUnit, double quantity) {
        this.name = name;
        this.caloriesPerUnit = caloriesPerUnit;
        this.quantity = quantity;
    }

    public double getTotalCalories() {
        return caloriesPerUnit * quantity;  // Общее количество калорий для этого продукта
    }

    @Override
    public String toString() {
        return name + " (" + quantity + " units) - " + getTotalCalories() + " calories";
    }
}

// Класс для подсчета общего количества калорий
public class CalorieCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<FoodItem> foodItems = new ArrayList<>();
        double totalCalories = 0;

        System.out.println("Введите количество продуктов в рационе:");
        int numItems = scanner.nextInt();
        scanner.nextLine();  // Для считывания остаточного символа новой строки

        // Считываем информацию о каждом продукте
        for (int i = 0; i < numItems; i++) {
            System.out.println("Введите название продукта #" + (i + 1) + ":");
            String name = scanner.nextLine();

            System.out.println("Введите калории на единицу измерения для " + name + ":");
            double caloriesPerUnit = scanner.nextDouble();

            System.out.println("Введите количество продукта (в единицах):");
            double quantity = scanner.nextDouble();
            scanner.nextLine();  // Для считывания остаточного символа новой строки

            // Создаем объект продукта и добавляем его в список
            FoodItem foodItem = new FoodItem(name, caloriesPerUnit, quantity);
            foodItems.add(foodItem);

            totalCalories += foodItem.getTotalCalories();
        }

        // Выводим все продукты и их калории
        System.out.println("\nПродукты в вашем рационе:");
        for (FoodItem foodItem : foodItems) {
            System.out.println(foodItem);
        }

        // Выводим общий итог
        System.out.println("\nОбщее количество калорий в рационе: " + totalCalories + " калорий");
        scanner.close();
    }
}
