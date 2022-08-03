package cn.ray.design.agent;

import cn.ray.design.IUserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author JOJO
 * @date 2022/8/3 21:48
 * 将Bean定义注册到Spring容器
 * 这⾥我们将代理的bean交给spring容器管理，也就可以⾮常⽅便让我们可以获取到代理的bean。
 * 这部分是spring中关于⼀个bean注册过程的源码。
 *
 * GenericBeanDefinition ，⽤于定义⼀个bean的基本信息 setBeanClass(MapperFactoryBean.class);
 * 也包括可以透传给构造函数信息 addGenericArgumentValue(IUserDao.class);
 * 最后使⽤ BeanDefinitionReaderUtils.registerBeanDefinition ，进⾏bean的注册。也就是注册到 DefaultListableBeanFactory 中。
 */
public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(IUserDao.class);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // left intentionally blank
    }

}
