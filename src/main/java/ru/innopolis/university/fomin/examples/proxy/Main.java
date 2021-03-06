package ru.innopolis.university.fomin.examples.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        demoProxy();
    }

    private static void demoProxy() {
        Object proxy = getProxyObject();

        ((Buyable) proxy).buy();
        ((Printable) proxy).print();
    }

    private static Object getProxyObject() {
        final ClassLoader classLoader = Main.class.getClassLoader();

        Class<?>[] interfaces = { Buyable.class, Printable.class };

        InvocationHandler myHandler = new InvocationHandler() {

            final OriginalObject originalObject = new OriginalObject();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.printf("Start invoking operation %s\n", method.getName());
                Object object = method.invoke(originalObject, args);
                System.out.printf("Finish invoking operation %s\n", method.getName());
                return object;
            }
        };

        return Proxy.newProxyInstance(
                classLoader,
                interfaces,
                myHandler
        );
    }
}
