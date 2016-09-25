package nn;


import java.lang.reflect.Array;

public class NeuronMatrix<T> {

    private final Class<? extends T> cls;

    public NeuronMatrix (Class<? extends T> cls) {
        this.cls = cls;
    }

    public void arrayExample() {
        @SuppressWarnings("unchecked")
        T[][] array = (T[][]) Array.newInstance(cls,10,20);
        System.out.println(array.length + " " + array[0].length+ " " + array.getClass());
    }
}
