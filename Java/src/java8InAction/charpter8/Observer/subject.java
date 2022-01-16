package java8InAction.charpter8.Observer;

public interface subject<T> {
    void registerObserver(observer<T> o);
    void notifyObserver(T t);
}
