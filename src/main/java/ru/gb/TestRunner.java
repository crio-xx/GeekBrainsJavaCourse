package ru.gb;

import ru.gb.annotations.AfterSuite;
import ru.gb.annotations.BeforeSuite;
import ru.gb.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

public class TestRunner {
    public static void start(Class<?> classTests) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Object obj = classTests.getConstructor().newInstance();
        Method[] methods = classTests.getDeclaredMethods();

        TreeMap<Integer, Method> testsForRun = new TreeMap<>();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;

        for(var method: methods) {
            if(isHaveAnnotation(method, Test.class)) {
                // допустим, нельзя указывать аннотации @BeforeSuite и @AfterSuite к аннотации @Test
                if(isHaveAnnotation(method, BeforeSuite.class) || isHaveAnnotation(method, AfterSuite.class)) {
                    throw new RuntimeException("Сan`t use annotations Tests with BeforeSuite or AfterSuite");
                }
                int priority = method.getAnnotation(Test.class).priority();
                // Значение priority должно быть в пределах от 1 до 10
                if(priority > 10 || priority < 1) {
                    throw new RuntimeException("Incorrect priority value in method: " + method.getName());
                }
                testsForRun.put(priority, method);
            } else if (isHaveAnnotation(method, BeforeSuite.class)) {
                if(beforeSuiteMethod != null) {
                    throw new RuntimeException("Сan`t use two or more annotations BeforeSuite");
                }
                beforeSuiteMethod = method;
            } else if (isHaveAnnotation(method, AfterSuite.class)) {
                if(afterSuiteMethod != null) {
                    throw new RuntimeException("Сan`t use two or more annotations AfterSuite");
                }
                afterSuiteMethod = method;
            }
        }
        // run BeforeSuite
        if(beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(obj);
        }
        // run Tests
        for(var test: testsForRun.values()) {
            // try/catch, чтобы исключение в тесте не ломало выполнение всего suite
            try {
                test.invoke(obj);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        // run AfterSuite
        if(afterSuiteMethod != null) {
            afterSuiteMethod.invoke(obj);
        }
    }

    private static boolean isHaveAnnotation(Method method, Class annotation) {
        return method.getAnnotation(annotation) != null;
    }
}
