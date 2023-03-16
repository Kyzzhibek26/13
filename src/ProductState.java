import java.security.spec.ECField;

public enum ProductState {
    IN_STOCK{
        @Override
        public void startSale(Product p) throws Exception {
        throw new Exception("Товар еще нет в торгах\n");
        }

        @Override
        public void risePrice(Product p) throws Exception {
            p.setState(ProductState.FOR_SALE);
            System.out.printf("|%s| - Товар был выставлен на торги\n",p.getId());
        }

        @Override
        public void withdraw(Product p) throws Exception {
            throw new Exception("нельзя снять с торгов товар, который в них не участвует\n");

        }

        @Override
        public void giveToTheWinner(Product p) throws Exception {
            throw new Exception("нельзя отдать товар сразу со склада\n");
        }
    },
    FOR_SALE{
        @Override
        public void startSale(Product p) throws Exception {
            throw new Exception("товар уже участвует в торгах\n");
        }

        @Override
        public void risePrice(Product p) throws Exception {
            p.setFinalPrice(p.getFinalPrice()+10);
            System.out.printf("|%s| - Цена на товар поднялась на 10 пунктов\n",p.getId());

        }

        @Override
        public void withdraw(Product p) throws Exception {
            if(p.getFinalPrice() == 0 ){
                p.setState(ProductState.IN_STOCK);
                System.out.printf("|%s| - Товар возвращен на склад\n",p.getId());
            }else{ throw new Exception("товар уже в резерве, можно только выдать");}
        }

        @Override
        public void giveToTheWinner(Product p) throws Exception {
            if(p.getFinalPrice()>0){
                p.setState(ProductState.SOLD);
                System.out.printf("|%s| - Товар уже продан на торгах\n",p.getId());}
            else{
                throw new Exception("нельзя отдать товар бесплатно\n");
            }
        }

    },
    SOLD{
        @Override
        public void startSale(Product p) throws Exception {
        throw new Exception("нельзя начать продажу, так как товар уже продан.\n");
        }

        @Override
        public void risePrice(Product p) throws Exception {
        throw new Exception("нельзя повысить стоимость, так как товар уже продан.\n");
        }

        @Override
        public void withdraw(Product p) throws Exception {
            throw new Exception("нельзя снять с торгов, так как товар уже продан\n");
        }

        @Override
        public void giveToTheWinner(Product p) throws Exception {
            throw new Exception("нельзя выдать покупателю, так как товар уже выдан\n");
        }
    };
    public abstract void startSale(Product p) throws Exception;
    public abstract void risePrice(Product p)throws Exception;
    public abstract void withdraw(Product p)throws Exception;
    public abstract void giveToTheWinner(Product p)throws Exception;

}
