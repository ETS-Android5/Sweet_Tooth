package com.example.desserts.database;

import androidx.annotation.NonNull;

import com.example.desserts.structures.Cake;
import com.example.desserts.structures.Coffee;
import com.example.desserts.structures.Dessert;
import com.example.desserts.structures.IceCream;
import com.example.desserts.structures.Tea;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Static DBLoader class to load Desserts from the Database.
 *
 * @author Osama Kashif
 */
public class DBLoader {

    /**
     * Gets list of all Cake.
     *
     * @return Dessert List of Cake
     */
    public static List<Dessert> getAllCake() {
        List<Dessert> cakes = new ArrayList<>();
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Edible").collection("Cake").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    float cost = (float) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int peopleServed = (int) document.get("peopleServed");
                                    int weight = (int) document.get("weight");
                                    int slice = (int) document.get("slice");
                                    cakes.add(new Cake(name, id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, peopleServed, weight, slice));
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Error getting documents: " + task.getException());
                        }
                    }
                });
        return cakes;
    }

    /**
     * Gets list of all IceCream.
     *
     * @return Dessert List of IceCream
     */
    public static List<Dessert> getAllIceCream() {
        List<Dessert> iceCream = new ArrayList<>();
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Edible").collection("Ice cream").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    float cost = (float) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int peopleServed = (int) document.get("peopleServed");
                                    int scoops = (int) document.get("scoops");
                                    boolean cone = (boolean) document.get("cone");
                                    iceCream.add(new IceCream(name, id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, peopleServed, scoops, cone));
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Error getting documents: " + task.getException());
                        }
                    }
                });
        return iceCream;
    }

    /**
     * Gets list of all Tea.
     *
     * @return Dessert List of Tea
     */
    public static List<Dessert> getAllTea() {
        List<Dessert> tea = new ArrayList<>();
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Edible").collection("Tea").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    float cost = (float) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    float volume = (float) document.get("volume");
                                    int ice = (int) document.get("ice");
                                    int sugar = (int) document.get("sugar");
                                    List<String> toppings = (List<String>) document.get("toppings");
                                    String teaBase = (String) document.get("teaBase");
                                    tea.add(new Tea(name, id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, volume, ice, sugar, toppings, teaBase));
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Error getting documents: " + task.getException());
                        }
                    }
                });
        return tea;
    }

    /**
     * Gets list of all Coffee.
     *
     * @return Dessert List of Coffee
     */
    public static List<Dessert> getAllCoffee() {
        List<Dessert> coffee = new ArrayList<>();
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Edible").collection("Coffee").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    float cost = (float) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    float volume = (float) document.get("volume");
                                    int ice = (int) document.get("ice");
                                    int sugar = (int) document.get("sugar");
                                    List<String> toppings = (List<String>) document.get("toppings");
                                    int coffeePercent = (int) document.get("coffeePercent");
                                    coffee.add(new Coffee(name, id, cost, basicDescription, ingredientsContained, dietsSuitableFor, numberViewed, volume, ice, sugar, toppings, coffeePercent));
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Error getting documents: " + task.getException());
                        }
                    }
                });
        return coffee;
    }

}
