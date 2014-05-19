package cz.boris.demo;

import org.junit.Test;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Created by Boris on 14.5.2014.
 */
public class GroovyContextTest {

    @Test
    public void groovyContextTest() {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("context.groovy");
        context.getBean(SimpleDaoUser.class).callDao();
    }
}
