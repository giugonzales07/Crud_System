import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    String name;
    LocalDate birthdate;
    
    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }
    
    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthdate_correct = birthdate.format(formatter);
        return "Nome: " + name + "\nData de nascimento: " + birthdate_correct;
    }
    
}

