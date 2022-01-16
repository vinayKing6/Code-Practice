package java8InAction.charpter8.Observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements subject<String>{

    List<observer<String>> observers=new ArrayList<>();

    @Override
    public void registerObserver(observer<String> o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserver(String s) {
        this.observers.forEach(o->o.notify(s));
    }

    public static void main(String[] args) {
        Feed feed=new Feed();
        feed.registerObserver(new DailyReport());
        feed.registerObserver(new EconomicTime());
        feed.registerObserver(s -> {
            if (s!=null&&s.contains("disaster"))
                System.out.println("Urgent News ! Pay Attention Please!\n"+s+"\n");
        });
        feed.notifyObserver("On Oct 12th morning, the stock of apple falls to 0.3% which makes most stockholders worried!");
    }
}
