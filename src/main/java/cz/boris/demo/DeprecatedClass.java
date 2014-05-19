package cz.boris.demo;

/**
 * Created by Boris on 14.5.2014.
 */
@MyDeprecated(newClass = NewImplementation.class)
public class DeprecatedClass implements JustInterface {

    @Override
    public void method() {
        System.out.println("Old Method");
    }
}
