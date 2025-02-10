import java.math.*;
import java.time.*;

public class Employee extends Person {
    BigDecimal salary;
    String role;

    public Employee(String nome, LocalDate dataNascimento, BigDecimal salary, String role) {
        super(nome, dataNascimento);
        this.salary = salary;
        this.role = role;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    
    public String getRole() {
        return role;
    }
    
    @Override
    public String toString() {
        String salary_correct = new Functions().formatter_salary(salary);
        return super.toString() + "\nSalario: " + salary_correct + "\nFuncao: " + role + "\n";
    }

}
