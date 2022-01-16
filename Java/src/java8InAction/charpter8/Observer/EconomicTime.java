package java8InAction.charpter8.Observer;

public class EconomicTime implements observer<String>{
    @Override
    public void notify(String string) {
        if(string!=null&&(string.contains("money")||string.contains("stock")))
            System.out.println("Economic Times ! \n"+string+"\n");
    }
}
