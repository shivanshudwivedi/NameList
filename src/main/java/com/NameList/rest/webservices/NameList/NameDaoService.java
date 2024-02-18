package com.NameList.rest.webservices.NameList;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class NameDaoService {

    private static List<Name> names = new ArrayList<>();

    private static int nameCount = 0;

    static{
        names.add(new Name(1, "Shivanshu"));
        names.add(new Name(2, "Tarek"));
        names.add(new Name(3, "George"));
    }

    public List<Name> findAll(){
        return names;
    }

    public Name findOne(int id){
        Predicate<? super Name> predicate = user -> user.getId().equals(id);
        return names.stream().filter(predicate).findFirst().get();
    }

    public Name save(Name name){
        name.setId(++nameCount);
        names.add(name);
        return name;
    }

    public void deleteById(int id){
        Predicate<? super Name> predicate = name -> name.getId().equals(id);
        names.removeIf(predicate);
    }

    public Name updateName(int id, Name name){
        for(int index = 0; index < names.size(); index++) {
            Name n = names.get(index);

            if (name.getId() == id) {
                name.setId(id);
                names.set(index, name);
                return name;
            }
        }
        return null;
    }
}
