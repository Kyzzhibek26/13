import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Main {
    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Product[] products = {
                Product.make(ProductState.IN_STOCK),
                Product.make(ProductState.FOR_SALE),
                Product.make(ProductState.SOLD),
                Product.make(ProductState.SOLD)
        };
        for(Product p : products){
                p.startSale();
                p.risePrice();
                p.giveToTheWinner();
        }
    }
    }