package edd.project.ZERO.data.preparation;

public interface DataProvider<T> {

    T get(int length);
}
