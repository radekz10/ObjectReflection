package cz.spsmb.source;

public class Singleton {

    private static int instanceCount;
    private static int maxInstanceCount = 1;
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton() {
        return singleton;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private Singleton() {
        //Singleton.instanceCount++;

        try {
            if(singleton != null){
                throw new InstantiationError("Error");
            }
            else{
                Singleton.instanceCount++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getMessage() {
        return "Hello";
    }

}
