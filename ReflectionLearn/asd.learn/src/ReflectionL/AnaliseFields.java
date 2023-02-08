package ReflectionL;

import ReflectionL.person.Employee;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

public class AnaliseFields {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        Class cl = harry.getClass();
        Field f = cl.getDeclaredField("name");
        f.setAccessible(true);

        Object v = f.get(harry);
        System.out.println(v);

        f.set(harry, "Tony");
        v = f.get(harry);
        System.out.println(v);

    }
    public Object getFieldValue(Object obj, String fieldName, MethodHandles.Lookup lookup) throws NoSuchFieldException, IllegalAccessException {
        Class<?> cl = obj.getClass();
        Field field = cl.getDeclaredField(fieldName);
        VarHandle handle = MethodHandles
                .privateLookupIn(cl, lookup)
                .unreflectVarHandle(field);
        return handle.get(obj);
    }
}
