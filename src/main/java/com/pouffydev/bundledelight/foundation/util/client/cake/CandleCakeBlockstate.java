package com.pouffydev.bundledelight.util.client.cake;

import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CandleCakeBlockstate {
    public static void main(String[] args) {
        String typeFile = "src/main/resources/generated/assets/bundledelight/modelGenerators/cakes.txt";
        String colourFile = "src/main/resources/generated/assets/bundledelight/modelGenerators/colours.txt";

        try {
            String[] types = Files.readAllLines(Paths.get(typeFile)).toArray(new String[0]);
            String[] colours = Files.readAllLines(Paths.get(colourFile)).toArray(new String[0]);

            for (String col : colours) {
                for (String typ : types) {
                    generateJson(typ, col);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input files.");
            e.printStackTrace();
        }
    }

    public static void generateJson(String type, String colour) {
        JsonObject json = new JsonObject();
        JsonObject objectVariants = new JsonObject();
        JsonObject litFalse = new JsonObject();
        JsonObject litTrue = new JsonObject();
        litFalse.addProperty("model", "bundledelight:block/" + colour + "_" + type + "_candle_cake");
        litTrue.addProperty("model", "bundledelight:block/" + colour + "_" + type + "_candle_cake_lit");
        objectVariants.add("lit=false", litFalse);
        objectVariants.add("lit=true", litTrue);
        json.add("variants", objectVariants);
        String fileName = "src/main/resources/generated/assets/bundledelight/blockstates/" + colour + "_" + type + "_candle_cake.json";

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json.toString());
            System.out.println("Generated JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while generating JSON file: " + fileName);
            e.printStackTrace();
        }
    }
}
