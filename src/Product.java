import java.util.Random;

public class Product {
    private String  id;
    private String name;
    private int startPrice;
    private int finalPrice;
    private String honorary_code;
    private ProductState state;

    public static Product make(ProductState state){
        Random r = new Random();
        Product p = new Product();
        p.id = "ID" + Util.makeName(10);;
        p.name = Util.makeName(5);;
        p.startPrice = r.nextInt(10)+4;
        p.state = state;
        p.finalPrice = 0;
        return p;
    }
    public String getId(){
        return id;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public void startSale() throws Exception {
        try{state.startSale(this);
        } catch (Exception e) {
        printMessage(this.id,e.getMessage());
        }
    };
    public void risePrice() throws Exception {
        try{state.risePrice(this);
        } catch (Exception e) {
            printMessage(this.id,e.getMessage());
        }
    };
    public void withdraw() throws Exception {
        try{state.withdraw(this);
        } catch (Exception e) {
            printMessage(this.id,e.getMessage());
        }
    };
    public void giveToTheWinner() throws Exception {
        try{state.giveToTheWinner(this);
        } catch (Exception e) {
            printMessage(this.id,e.getMessage());
        }
    };
    private void printMessage(String id, String e){
        System.out.printf("|%s| - %s", id,e);
    }
}
