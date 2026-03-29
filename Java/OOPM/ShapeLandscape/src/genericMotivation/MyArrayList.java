package genericMotivation;

public class MyArrayList<E> {

    private Object[] data = new Object[99];
    private int nextIdx = 0;

    public boolean add(E element){
        if (nextIdx == data.length)
            return false;
        data[nextIdx++] = element;
        return true;
    }
}
