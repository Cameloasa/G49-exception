package se.lexicon.data_acces;

import se.lexicon.domain.Gender;
import se.lexicon.domain.Person;
import se.lexicon.fileIO.CSVReader_Writer;

import java.util.List;
import java.util.Random;

public class NameService {

    private List<String> maleFirstName;
    private List<String> femaleFirstName;
    private List<String> lastNames;
    private static Random random = new Random();


    public NameService(List<String> maleFirstName, List<String> femaleFirstName, List<String> lastNames) {
        //Should not be null
        if(maleFirstName == null || femaleFirstName == null || lastNames == null)
            throw new IllegalArgumentException("The name field should not be null");
        this.maleFirstName = maleFirstName;
        this.femaleFirstName = femaleFirstName;
        this.lastNames = lastNames;
    }

    //Methods for getting random Gender, first and last name
    public Gender getRandomGender(){
        return random.nextInt(100) > 50 ? Gender.FEMALE : Gender.MALE;
    }

    public String getRandomFemaleFirstName(){
        return femaleFirstName.get(random.nextInt(femaleFirstName.size()));
    }

    public String getRandomMaleFirstName(){
        return maleFirstName.get(random.nextInt(maleFirstName.size()));
    }

    public String getRandomLastName(){
        return lastNames.get(random.nextInt(lastNames.size()));
    }

    //Method for getting random person
    public Person getNewRandomPerson(){
        //Initialize a new default person
        Person person = null;
        //Get a random gender
        Gender gender = getRandomGender();

        switch (gender){
            case MALE:
                person = new Person(getRandomMaleFirstName(),getRandomLastName(),gender);
            break;
            case FEMALE:
                person = new Person(getRandomMaleFirstName(),getRandomLastName(),gender);
            break;
        }
        return person;
    }
    /**
     * Here you need to check if List<String> femaleFirstNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     * @param
     */

    public void addFemaleFirstName(String name) throws DuplicateNameException{
        if(femaleFirstName.contains(name)) {
            throw new DuplicateNameException("First name already exist.");
        }else {
            femaleFirstName.add(name);
            //todo create a method in CSV reader for saving first name
        }
    }
    /**
     * Here you need to check if List<String> maleFirstNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     * @param name
     */
    public void addMaleFirstName(String name) throws DuplicateNameException {
        if (maleFirstName.contains(name)){
            throw new DuplicateNameException("First name already exist.");
        }else{
            maleFirstName.add(name);
            //todo create a method in CSV reader for saving first name
        }
    }

    /**
     * Here you need to check if List<String> lastNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     * @param lastName
     */
    public void addLastName(String lastName) throws DuplicateNameException {
        if (lastNames.contains(lastName)) {
            throw new DuplicateNameException("Last name already exist.");
        } else {
            lastNames.add(lastName);
            //todo create a method in CSV reader for saving last name
        }
    }

}
