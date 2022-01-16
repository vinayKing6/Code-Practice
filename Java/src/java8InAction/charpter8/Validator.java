package java8InAction.charpter8;

import myToolKit.validationStrategy;

public class Validator<T> {
    private validationStrategy<T> value;

    public Validator(validationStrategy<T> v)
    {
        this.value=v;
    }

    public boolean execute(T t)
    {
        return value.execute(t);
    }
}
