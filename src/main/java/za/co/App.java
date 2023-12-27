package za.co;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Noxolo.Mkhungo
 */
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        LOGGER.debug("Initializing Spring context.", App.class.getName());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/application-context.xml");
    }
}
