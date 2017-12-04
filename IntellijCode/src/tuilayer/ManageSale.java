package tuilayer;

public class ManageSale extends Menu{
    public ManageSale(Menu parent){
        super("Mange sale",parent);

        commandWords.add("Create sale");
        commandWords.add("Delete sale");
    }

    @Override
    public void resolver(int i) {
        switch(i){
            case 0:
                createSale();
                break;
            case 1:
                deleteSale();
                break;
        }
    }

    private void createSale(){
        System.out.print("Create shit here");
    }

    private void deleteSale(){
        System.out.print("Delete shit here");
    }
}
