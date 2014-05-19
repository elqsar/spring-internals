package cz.boris.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by Boris on 14.5.2014.
 */
public class DeprecationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    // here we can extract all BeanDefinitions
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(beanClassName);
                MyDeprecated annotation = beanClass.getAnnotation(MyDeprecated.class);
                if (annotation != null) {
                    beanDefinition.setBeanClassName(annotation.newClass().getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
