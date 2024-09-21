package com.pouffydev.bundledelight.foundation.util.client.cake;

import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LitCandleCakeModel {
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
        JsonObject textures = new JsonObject();

        json.addProperty("parent", "block/template_cake_with_candle");
        textures.addProperty("candle", "minecraft:block/" + colour + "_candle_lit");
        textures.addProperty("bottom", "bundledelight:block/" + type + "_cake/bottom");
        textures.addProperty("top", "bundledelight:block/" + type + "_cake/top");
        textures.addProperty("side", "bundledelight:block/" + type + "_cake/side");
        textures.addProperty("particle", "bundledelight:block/" + type + "_cake/top");


        json.add("textures", textures);

        String fileName = "src/main/resources/generated/assets/bundledelight/models/block/" + colour + "_" + type + "_candle_cake_lit.json";

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json.toString());
            System.out.println("Generated JSON file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while generating JSON file: " + fileName);
            e.printStackTrace();
        }
    }
}
