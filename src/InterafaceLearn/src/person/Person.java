package person;

public interface Person {
    default String getName(){
        return "";
    }
}
