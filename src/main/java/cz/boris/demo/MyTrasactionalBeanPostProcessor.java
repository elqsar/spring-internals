package cz.boris.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Boris on 14.5.2014.
 */
public class MyTrasactionalBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<String, Class>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(MyTransactional.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // here we create proxy
        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("TRANSACTION OPEN...");
                Object returnValue = method.invoke(bean, args);
                System.out.println("TRANSACTION CLOSE...");
                return returnValue;
            });
        }
        return bean;
    }
}
