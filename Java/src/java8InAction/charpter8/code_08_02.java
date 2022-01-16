package java8InAction.charpter8;

import myToolKit.validationStrategy;


public class code_08_02 {
    public static void main(String[] args) {
        //Validation Strategy:
        Validator<String> isLower=new Validator<>(new isAllLowerCase());
        Validator<String> isNumeric=new Validator<>(new isNumeric());
        System.out.println(isLower.execute("abcdefg")+" "+isLower.execute("Abcbc"));
        System.out.println(isNumeric.execute("123445")+" "+isNumeric.execute("1232323d"));
        Validator<String> ifContains=new Validator<>(string-> string.contains("hello"));
        System.out.println(ifContains.execute("hello world")+" "+ifContains.execute("hi world"));
    }

    public static class isAllLowerCase implements validationStrategy<String>
    {

        @Override
        public boolean execute(String type) {
            return type.matches("[a-z]+");
        }
    }

    public static class isNumeric implements validationStrategy<String>
    {

        @Override
        public boolean execute(String type) {
            return type.matches("\\d+");
        }
    }
}
