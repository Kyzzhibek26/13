import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class List {
private String name;

    public List(String name) {
        this.name = name;
    }
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static Product [] getGoods(){
        String fromFile = "";
        try (
                FileReader fr = new FileReader("./product.json");
                Scanner scan = new Scanner(fr);) {
            while (scan.hasNextLine()) {
                fromFile += scan.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(fromFile, Product[].class);
    }
    }
