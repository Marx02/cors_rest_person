/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.webtrade.spa_cors_demo.data;

import dk.webtrade.spa_cors_demo.entity.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author thomas
 */
public class DataFacade {
    private static Map<Integer, Person> persons = new HashMap();
    {
    persons.put(1, new Person("Helge Hansen", 33));
    persons.put(2, new Person("Ronnie Rapenhal", 55));
    persons.put(3, new Person("Kalle Kammersøn", 22));
    }
    public Person getPerson(int id){
        return persons.get(id);
    }
    public Map<Integer, Person> getAllPersons(){
        return persons;
    }
    public void addPerson(Person p){
        final AtomicInteger max = new AtomicInteger(0);
        persons.keySet().forEach(key->{
            if(key > max.get()) max.getAndSet(key);
        });
        persons.put(max.get()+1, p);
    }
}
