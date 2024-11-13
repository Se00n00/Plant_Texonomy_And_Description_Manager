import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FlowerDescription {
    private Map<String, Flower> flowers;

    // Constructor to initialize the flowers map from the JSON file
    public FlowerDescription(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Read the JSON file into a Map
        this.flowers = mapper.readValue(new File("C:\\Users\\Saurav\\IdeaProjects\\Plant_Texonomy_And_Description_Manager\\Description_Manager\\src\\main\\resources\\Description.json"), new TypeReference<Map<String, Flower>>() {});
    }

    // Method to get a flower by its common name
    public Flower getFlowerByName(String name) {
        return flowers.get(name);
    }

    public static void main(String[] args) {
        try {
            // Create an instance of FlowerDescription
            FlowerDescription flowerDescription = new FlowerDescription("C:\\Users\\Saurav\\IdeaProjects\\Plant_Texonomy_And_Description_Manager\\Description_Manager\\src\\main\\resources\\Description.json");

            // Get flower by name
            Flower flower = flowerDescription.getFlowerByName("Frangipani");

            if (flower != null) {
                System.out.println("Common Name: " + flower.getCommonName());
                System.out.println("Scientific Name: " + flower.getScientificName());
                System.out.println("Family belongs: "+ flower.getFamily());
                System.out.println("Genus: "+ flower.getGenus());
                System.out.println("Height in meters: "+ flower.getHeight());
                System.out.println("Leaf shape of flower: "+ flower.getLeafShape());
                System.out.println("Color of leaf: "+ flower.getLeafColor());
                System.out.println("Flower Colors:");
                for (String color : flower.getFlowerColor()) {
                    System.out.println("- " + color);
                }
                System.out.println("Blooming period: "+ flower.getBloomingPeriod());
                System.out.println("Type of soil it needs: "+ flower.getSoilType());
                System.out.println("Water Requirements: "+ flower.getWaterRequirements());
                System.out.println("Sun light requirements: "+ flower.getSunlightRequirements());
                System.out.println("Native range: "+ flower.getNativeRange());
                System.out.println("Distributions: "+ flower.getDistribution());
                System.out.println("Uses are: ");
                for (String use : flower.getUses()) {
                    System.out.println("- " + use);
                }

            } else {
                System.out.println("Flower not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
