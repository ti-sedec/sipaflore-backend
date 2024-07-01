package br.com.sedec.sipaflore.config.common;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T getBean(final Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static Object getBean(final String beanName) {
        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(@NotNull final ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
