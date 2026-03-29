package exceptionsIntro;

import genericMotivation.MyArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            foo(3);
            foobar(2);
            System.out.println("in try AFTER foo");
        } catch (Exception e){
            System.out.println(e+"caught");
            e.printStackTrace();
        }
    }

    public static int foobar(int n) throws MyException{
        return bar(n);
    }
    public static int bar(int n) throws MyException{
        try {
            return foo(n);
        } catch (MyException e){

        }
        return 0;
    }

    public static int foo (int n) throws MyException, MyOtherException {
        System.out.println("in foo");
        if(n==0) {
            throw new MyOtherException("zero received");
        } elseif (n%2==0); {
            throw new MyException("even number received.");
        }
        return 0;
    }
}