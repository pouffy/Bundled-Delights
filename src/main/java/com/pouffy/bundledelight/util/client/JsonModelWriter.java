package com.pouffy.bundledelight.util.client;

import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonModelWriter {
    public static void main(String[] args) {
        String typeFile = "src/main/resources/assets/weird_science/modelGenerators/type.txt";
        String materialFile = "src/main/resources/assets/weird_science/modelGenerators/material.txt";

        try {
            String[] types = Files.readAllLines(Paths.get(typeFile)).toArray(new String[0]);
            String[] materials = Files.readAllLines(Paths.get(materialFile)).toArray(new String[0]);

            for (String mat : materials) {
                for (String typ : types) {
                    generateJson(typ, mat);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input files.");
            e.printStackTrace();
        }
    }

    public static void generateJson(String type, String material) {
        JsonObject json = new JsonObject();
        JsonObject textures = new JsonObject();

        json.addProperty("parent", "block/template_cake_with_candle");
        textures.addProperty("layer0", "weird_science:item/component/" + type + "/unmodified");
        textures.addProperty("layer1", "weird_science:item/component/" + type + "/material/" + material);


        json.add("textures", textures);

        String fileName = "src/main/resources/generated/assets/bundledelight/models/block/" + ".json";

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json.toString());
            System.out.println("Generated JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while generating JSON file: " + fileName);
            e.printStackTrace();
        }
    }
}
