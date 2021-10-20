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
     * Loads cake objects into cakes list.
     *
     * @param cakes
     */
    public static void loadCakes(List<Dessert> cakes) {
        FirebaseFirestore.setLoggingEnabled(true);
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
                                    double cost = (double) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int peopleServed = (Math.toIntExact((long) document.get("peopleServed")));
                                    int weight = (Math.toIntExact((long) document.get("weight")));
                                    int slice = (Math.toIntExact((long) document.get("slice")));
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
    }

    /**
     * Loads ice cream objects into ice cream list.
     *
     * @param iceCream - Dessert List to be filled.
     */
    public static void loadIceCream(List<Dessert> iceCream) {
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
                                    double cost = (double) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int peopleServed = (Math.toIntExact((long) document.get("peopleServed")));
                                    int scoops = (Math.toIntExact((long) document.get("scoops")));
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
    }

    /**
     * Loads tea objects into tea list.
     *
     * @param tea - Dessert List to be filled.
     */
    public static void loadTea(List<Dessert> tea) {
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Drinkable").collection("Tea").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    double cost = (double) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int volume = (Math.toIntExact((long) document.get("volume")));
                                    int ice = (Math.toIntExact((long) document.get("ice")));
                                    int sugar = (Math.toIntExact((long) document.get("sugar")));
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
    }

    /**
     * Loads coffee objects into coffee list.
     *
     * @param coffee - Dessert List to be filled.
     */
    public static void loadCoffee(List<Dessert> coffee) {
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document("Drinkable").collection("Coffee").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())) {
                                try {
                                    String name = (String) document.get("name");
                                    long id = (long) document.get("id");
                                    double cost = (double) (double) document.get("cost");
                                    String basicDescription = (String) document.get("basicDescription");
                                    List<String> ingredientsContained = (List<String>) document.get("ingredientsContained");
                                    List<String> dietsSuitableFor = (List<String>) document.get("dietsSuitableFor");
                                    long numberViewed = (long) document.get("numberViewed");
                                    int volume = (Math.toIntExact((long) document.get("volume")));
                                    int ice = (Math.toIntExact((long) document.get("ice")));
                                    int sugar = (Math.toIntExact((long) document.get("sugar")));
                                    List<String> toppings = (List<String>) document.get("toppings");
                                    int coffeePercent = (Math.toIntExact((long) document.get("coffeePercent")));
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
    }

    /**
     * The addNumberViewed gets used in the concrete classes to update the number in the database by one.
     *
     * @param abstractClass - The abstract class inherited by the concrete class which implements the Dessert interface.
     * @param concrete      - The concrete class in which this method is called.
     * @param id            - The id of the object.
     * @param numberViewed  - The updated number viewed.
     */
    public static void addNumberViewed(String abstractClass, String concrete, long id, long numberViewed) {
        FirebaseFirestore dessertDBFirestore = FirebaseFirestore.getInstance();
        dessertDBFirestore.collection("Desserts").document(abstractClass).collection(concrete).document(Long.toString(id)).update("numberViewed", numberViewed);
    }

    /**
     * Gets list of all Cake.
     *
     * @return Dessert List of Cake
     */
    public static List<Dessert> getAllCakes() {
        List<Dessert> cakes = new ArrayList<>();
        loadCakes(cakes);
        return cakes;
    }

    /**
     * Gets list of all IceCream.
     *
     * @return Dessert List of IceCream
     */
    public static List<Dessert> getAllIceCreams() {
        List<Dessert> iceCreams = new ArrayList<>();
        loadIceCream(iceCreams);
        return iceCreams;
    }

    /**
     * Gets list of all Tea.
     *
     * @return Dessert List of Tea
     */
    public static List<Dessert> getAllTeas() {
        List<Dessert> teas = new ArrayList<>();
        loadTea(teas);
        return teas;
    }

    /**
     * Gets list of all Coffee.
     *
     * @return Dessert List of Coffee
     */
    public static List<Dessert> getAllCoffees() {
        List<Dessert> coffees = new ArrayList<>();
        loadCoffee(coffees);
        return coffees;
    }

}
