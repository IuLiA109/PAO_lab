package lab10.tasks;

import java.util.Map;
import java.util.function.Function;
import java.util.HashMap;

public class MyCustomContainer implements CustomContainer {
    private final Map<String, Object> instances;
    private final Map<Class<?>, Function<CustomContainer, ?>> factoryMethods;

    public MyCustomContainer() {
        this.instances = new HashMap<>();
        this.factoryMethods = new HashMap<>();
    }

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null){
            throw new CustomContainerException("Null is not allowed as a parameter");
        }
        String name = instance.getClass().getName();
        return addInstance(instance, name);
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if (customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if (instances.containsKey(customName)) {
            throw new CustomContainerException("Instances cannot be redeclared");
        }

        instances.put(customName, instance);
        return true;
    }
    /*
    //task 2
    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        String name = type.getName();
        return getInstance(type, name);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if (!instances.containsKey(customName)) {
            return null;
        }

        Object instance = instances.get(customName);
        if (!type.isInstance(instance)) {
            throw new CustomContainerException("Invalid type for object");
        }

        return type.cast(instance);
    }
    */

    //task 4
    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        String name = type.getName();
        return getInstance(type, name);
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        if (instances.containsKey(customName)) {
            Object instance = instances.get(customName);
            if (!type.isInstance(instance)) {
                throw new CustomContainerException("Invalid type for object");
            }
            return type.cast(instance);
        }

        if (factoryMethods.containsKey(type)) {
            T instance = create(type);
            addInstance(instance, customName);
            return instance;
        }

        throw new CustomContainerException("Cannot provide instance");
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        factoryMethods.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        if (type == null) {
            throw new CustomContainerException("Null is not allowed as a parameter");
        }

        Function<CustomContainer, ?> factory = factoryMethods.get(type);
        if (factory == null){
            throw new CustomContainerException("Cannot provide instance");
        }
        return type.cast(factory.apply(this));
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (!factoryMethods.containsKey(type)) {
            throw new CustomContainerException("Cannot provide instance");
        }
        Function<CustomContainer, ?> factory = factoryMethods.get(type);
        CustomContainer parameterContainer = new MyCustomContainer();
        parameters.forEach((name, instance) -> parameterContainer.addInstance(instance, name));

        return type.cast(factory.apply(parameterContainer));
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                try {
                    ((AutoCloseable) instance).close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
