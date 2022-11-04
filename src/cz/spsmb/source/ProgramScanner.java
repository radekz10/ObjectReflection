package cz.spsmb.source;

import cz.spsmb.Application;

import java.lang.reflect.*;

public class ProgramScanner {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException {

        ProgramScanner.methods();
        System.out.println("------------");
        ProgramScanner.userData();
        System.out.println("------------");
        ProgramScanner.modifiers();
        System.out.println("------------");
        ProgramScanner.createInstances();


    }

    public int a = 5;

    public int getA(){
        return a;
    }

    public static void methods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = Application.class.getDeclaredMethods();

        for (Method method: methods){
            if(method.getName().compareTo("print") == 0){
                method.invoke(Application.class, "asdsad");
            }
        }
    }


    public static void userData() throws IllegalAccessException {

        PrivateField privateField = new PrivateField();

        Field[] fields;
        fields = PrivateField.class.getDeclaredFields();

        for(Field field : fields){
            field.setAccessible(true);
            Object value = field.get(privateField);

            System.out.println(field.getName() + " - " + value);
        }

    }

    public static void modifiers(){

        DeclaredMethodList declaredMethodList = new DeclaredMethodList();

        Method[] methods;
        methods = DeclaredMethodList.class.getDeclaredMethods();

        for(Method method : methods){
            if(Modifier.isPublic(method.getModifiers())){
                System.out.println(method.getName() + " = Public");
            }
            if(Modifier.isPrivate(method.getModifiers())){
                System.out.println(method.getName() + " = Private");
            }
        }

    }

    public static void createInstances() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class<?> clazz = Class.forName("cz.spsmb.source.Singleton");
        Constructor<?> constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Singleton singleton = (Singleton)constructor.newInstance();

        //singleton = (Singleton)constructor.newInstance();
        //singleton = (Singleton)constructor.newInstance();
        //singleton = (Singleton)constructor.newInstance();

        System.out.println(singleton);

        System.out.println("Instance count = " + Singleton.getInstanceCount());


    }




}
