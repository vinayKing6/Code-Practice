package myToolKit;

public class container<T> {
    private T value=null;

    public container(T value){
        this.value=value;
    }

    public T getValue(){
        return value;
    }

}
