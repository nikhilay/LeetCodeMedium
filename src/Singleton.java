/**
 * Created by Nikhil on 11/11/16.
 */
public class Singleton {

    private Singleton(){}

    private Singleton instance;

    public Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
}
