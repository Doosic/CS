package cs.list.make;

public interface List<T> {

    void printAll();
    void clearAll();
    // 원하는 위치에 데이터를 저장해주는 insertAt
    void insertAt(int index, T data);
}
