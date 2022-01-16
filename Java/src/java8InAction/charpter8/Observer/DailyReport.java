package java8InAction.charpter8.Observer;

public class DailyReport implements observer<String> {

    @Override
    public void notify(String s) {
        if (s!=null&&s.toString().contains("life"))
            System.out.println("Daily Report ! Pay Attention Please !\n"+s+"\n");
    }
}
