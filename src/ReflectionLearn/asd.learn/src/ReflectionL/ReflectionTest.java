package ReflectionL;

import ReflectionL.person.Employee;

import java.lang.reflect.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        Employee e = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Class cl = e.getClass();
        System.out.println(cl.getName() + " " + e.getName());
        Class c11 = Date.class;
        Class c12 = int.class;
        Class c13 = Double[].class;

        var className = "java.util.Random";
        cl = Class.forName(className);
        Object obj = cl.getConstructor().newInstance();
        ((Random)obj).nextInt();


         //извлечь имя класса из аргументов командной строки или
         // введенных пользователем данных
         String name;
         if (args.length > 0) name = args[0];
         else {
             var in = new Scanner(System.in);
             System.out.println("Enter class name "
                     + "(e.g. java.util.Date): ");
             name = in.next();
             // вывести имя класса и суперкласса (if != Object)
             cl = Class.forName(name);
             Class superCl = cl.getSuperclass();
             String modifiers = Modifier.toString(cl.getModifiers());

             if (modifiers.length() > 0)
                 System.out.print(modifiers + " ");
             System.out.print("class "+ superCl.getName());

             if (superCl != null && superCl != Object.class) {
                 System.out.print("\n{\n");
                 printConstructors(superCl);
                 System.out.println();
                 printMethods(superCl);
                 System.out.println();
                 printFields(superCl);
                 System.out.println("}");
             }

             if (modifiers.length() > 0)
                 System.out.print(modifiers + " ");
             System.out.print("class "+ cl.getName());

             if (superCl != null && superCl != Object.class) {
                 System.out.print(" extends " + superCl.getName());

             }
             System.out.print("\n{\n");
             printConstructors(cl);
             System.out.println();
             printMethods(cl);
             System.out.println();
             printFields(cl);
             System.out.println("}");

         }
    }
    public static void printConstructors(Class cl){

        Constructor[] constructors = cl.getDeclaredConstructors();

         for (Constructor c : constructors) {
             String name = c.getName();
             System.out.print(" ");
             String modifiers = Modifier.toString(
                     c.getModifiers());

             if (modifiers.length() > 0)
                 System.out.print(modifiers + " ");
             System.out.print(name + "(");

             // вывести типы параметров
             Class[] paramTypes = c.getParameterTypes();
             for (int j = 0; j < paramTypes.length; j++) {
                 if (j > 0) System.out.print(", ");
                 System.out.print(paramTypes[j].getName());
             }
             System.out.println(");");
         }
    }

/**
 * Выводить все методы класса
 * @param cl Класс
 */
  public static void printMethods(Class cl) {

      Method[] methods = cl.getDeclaredMethods();


      for (Method m : methods) {

          Class retType = m.getReturnType();
          String name = m.getName();

          System.out.print(" ");
          // вывести модификаторы, возвращаемый тип,
          // а также имя метода
          String modifiers = Modifier.toString(
                  m.getModifiers());
          if (modifiers.length() > 0)
              System.out.print(modifiers + " ");
          System.out.print(retType.getName() + " "
                  + name + "(");

          //вывести типы параметров
          Class[] paramTypes = m.getParameterTypes();
          for (int j = 0; j < paramTypes.length; j++) {
              if (j > 0) System.out.print(", ");
              System.out.print(paramTypes[j].getName());
          }
          System.out.println(");");
      }
  }

/**
 * Выводит все поля класса
 * @param cl а Класс
 */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();

            String name = f.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

}