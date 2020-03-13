package repository;

import model.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T extends Model> {
    final List<T> list = new ArrayList<>();
    int counter = 2;

    public List<T> findAll() {
        return this.list;
    }

    public T save(T object) {
        object.setId(String.valueOf(counter));
        counter++;
        list.add(object);
        return object;
    }

    public T update(T newObject){
        T oldObject = list.get(Integer.parseInt(newObject.getId()));
        merge(oldObject,newObject);
        list.add(Integer.parseInt(newObject.getId()),newObject);
        return list.get(Integer.parseInt(newObject.getId()));
    }

    public T delete(String id) {
        T object = list.get(Integer.parseInt(id));
        list.remove(object);
        return object;
    }

    public T getById(String id) {
        return list.stream().filter(object -> object.getId().equals(id)).findFirst().get();
    }
    private void merge(Object obj, Object update){
        if(!obj.getClass().isAssignableFrom(update.getClass())){
            return;
        }

        Method[] methods = obj.getClass().getMethods();

        for(Method fromMethod: methods){
            if(fromMethod.getDeclaringClass().equals(obj.getClass())
                    && fromMethod.getName().startsWith("get")){

                String fromName = fromMethod.getName();
                String toName = fromName.replace("get", "set");

                try {
                    Method toMetod = obj.getClass().getMethod(toName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(update, (Object[])null);
                    if(value != null){
                        toMetod.invoke(obj, value);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
