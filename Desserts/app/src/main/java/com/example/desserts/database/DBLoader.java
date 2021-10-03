package com.example.desserts.database;

import androidx.annotation.NonNull;

import com.example.desserts.structures.Dessert;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Static DBLoader class to load Desserts from the Database.
 * @author Osama Kashif
 */
public class DBLoader {

    private static DatabaseReference dessertDB = FirebaseDatabase.getInstance().getReference();
    private static FirebaseFirestore dessertDBFiresote = FirebaseFirestore.getInstance();

    /**
     * Gets the list of all Desserts of the particular Dessert Type specified.
     * @param concreteDessertName - String for specific Dessert Type
     * @return - List of all Desserts of that Dessert Type
     */
    public static List<Dessert> getCollectionDesserts(String concreteDessertName) {
        List<Dessert> concreteDesserts = new ArrayList<>();
        String className = "com.example.desserts.structures."+concreteDessertName;
        try {
            Class<?> concreteDessertClass = Class.forName(className);
            Constructor<?> concreteDessertConstructor = concreteDessertClass.getConstructor(String.class);
            Object concreteDessert = concreteDessertConstructor.newInstance("MyAttributeValue");
            concreteDesserts.add((Dessert) concreteDessert);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return concreteDesserts;
    }

    /**
     * Gets list of all Cake.
     * @return Dessert List of Cake
     */
    public static List<Dessert> getAllCake() {
        List<Dessert> cakes = new ArrayList<>();
        dessertDBFiresote.collection("Desserts").document("Edible").collection("Cake").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                Log.d(TAG, document.getId() + " => " + document.getData());
                                System.out.println(document.getId() + " => " + document.getData());
//                                document.get(); //NEED TO FILL
                            }
                        } else {
//                            Log.d(TAG, "Error getting documents: ", task.getException());
                            System.out.println("Error getting documents: "+ task.getException());
                        }
                    }
                });
//        for (QuerySnapshot cake: allCakes) {
//
//        }
        return cakes;
    }

    /**
     * Gets list of all IceCream.
     * @return Dessert List of IceCream
     */
    public static List<Dessert> getAllIceCream() {
        List<Dessert> iceCream = new ArrayList<>();
        return iceCream;
    }

    /**
     * Gets list of all Tea.
     * @return Dessert List of Tea
     */
    public static List<Dessert> getAllTea() {
        List<Dessert> tea = new ArrayList<>();
        return tea;
    }

    /**
     * Gets list of all Coffee.
     * @return Dessert List of Coffee
     */
    public static List<Dessert> getAllCoffee() {
        List<Dessert> coffee = new ArrayList<>();
        return coffee;
    }

}
