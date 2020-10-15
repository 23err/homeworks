package ru.geekbrains_middle.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    HashMap<String, ArrayList<Person>> phoneBook = new HashMap<>();


    public PhoneBook() {
        Person person1 = new Person("Ivanov", "89251551122",
                "ivanov@mail.ru");
        add(person1);
        Person person2 = new Person("Petrov",
                "89129877789", "petrov@mail.ru");
        add(person2);
        add(person2);
        Person person3 = new Person("Alexeev",
                "8912987433", "alexeev@mail.ru");
        add(person3);
        Person person4 = new Person("Ivanov", "89251512121",
                "ivanov23@mail.ru");
        add(person4);

    }

    public void add(Person person){
        if (!phoneBook.containsKey(person.getLastName()))
            phoneBook.put(person.getLastName(), new ArrayList<Person>());
        phoneBook.get(person.getLastName()).add(person);
    }

    public ArrayList<String> getPhones(String lastName) {
        List<Person> personList = getPersons(lastName);
        ArrayList<String> phonesList = new ArrayList<>();
        personList.forEach(item->{
            phonesList.add(item.getPhone());
        });
        return phonesList;
    }

    public ArrayList<String> getEmails(String lastName){
        List<Person> personList = getPersons(lastName);
        ArrayList<String> emailsList = new ArrayList<>();
        personList.forEach(item -> {
            emailsList.add(item.getEmail());
        });
        return emailsList;
    }

    private List<Person> getPersons(String lastName) {
        List<Person> personList = phoneBook.get(lastName);
        if (personList == null)
            personList = new ArrayList<Person>();

        return personList;
    }
}
