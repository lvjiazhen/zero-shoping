package com.zero.base.util;

import java.beans.Introspector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;

import tk.mybatis.mapper.common.Mapper;

/** 
* @author lanwei
* @date 2014年10月29日 下午1:37:02 
*  
*/
@Configuration
public class SpringUtils implements BeanFactoryPostProcessor  {
    private static ConfigurableListableBeanFactory beanFactory; // Spring应用上下文环境

    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }

    /**
     * 获取对象
     *
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     *
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name); 
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param clz
     * @return
     * @throws BeansException
     *
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static Class<?> getType(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     *
     */
    public static String[] getAliases(String name)
            throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    @SuppressWarnings(value="unchecked")
    public static <T> Mapper<T> getMapperBean(Class<T> c) {
        String entityNm = c.getName();
        String beanName = entityNm.replace("domain", "persistence")+"Mapper";
        String shortName = Introspector.decapitalize(ClassUtils.getShortName(beanName));
        return (Mapper<T>) getBean(shortName);
    }
    
    public static void main(String[] args) {
		String abc = "com.ljz.AbcMapper" ;
		System.out.println(abc.substring(abc.lastIndexOf(".")+1, abc.length()));
		System.out.println(Introspector.decapitalize(ClassUtils.getShortName(abc)));
	}
    
}
