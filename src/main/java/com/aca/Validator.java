import java.lang.reflect.Field;
import java.util.*;

class Validator {
       boolean isValid(Object object) throws IllegalAccessException, InstantiationException {
        Class<Object> objectClass = (Class<Object>) object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                Object value = field.get(object);
                if (value == null) {
                    return false;
                }
            } else if (field.isAnnotationPresent(NotEmpty.class)) {
                if (Collection.class.isAssignableFrom(field.getType())) {
                    Collection c = (Collection) field.get(object);
                    if (c.isEmpty()) {
                        return false;
                    }

                } else if (Map.class.isAssignableFrom(field.getType())) {
                    Map m = (Map) field.get(object);;
                    if (m.isEmpty()) {
                        return false;
                    }

                }
            } else if(field.isAnnotationPresent(Valid.class)){
                Valid annotations = field.getAnnotation(Valid.class);
                if (field.getType().equals(float.class)){
                    float value = (float) field.get(object);
                    if(! (annotations.minValue() <= value) || !( annotations.maxValue() >= value)){
                        return false;
                    }
                }else if(field.getType().equals(int.class)){
                    int value = (int) field.get(objectClass);
                    if(!(annotations.minValue() <= value) || !( annotations.maxValue() >= value)){
                        return false;
                    }
                }


            }
            field.setAccessible(false);
        }
       return true;
    }
}