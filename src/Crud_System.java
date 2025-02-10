import java.time.*;
import java.time.format.DateTimeFormatter;
import java.math.*;
import java.util.*;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Crud_System {
    Scanner scan = new Scanner(System.in);
    Functions functions = new Functions();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ArrayList<Employee> listEmployee = new ArrayList<>();

    public void insert(){
        // Insert Employees manually
        // String name;
        // LocalDate birthDate;
        // BigDecimal salary;
        // String role;
        // System.out.println("Name: ");
        // name = scan.nextLine();
        // System.out.println("Date of birth: ");
        // birthDate = LocalDate.parse(scan.nextLine(),formatter);
        // System.out.println("Salary: ");
        // salary = new BigDecimal(scan.nextLine());
        // System.out.println("Role: ");
        // role = scan.nextLine();
        // listEmployee.add(new Employee(name,birthDate,salary,role));

        // Insert Employees through a file
        String arqCSV = "c:/Users/giueg/OneDrive/Documentos/Workspace/Teste_Projedata/CRUD_System/data/funcionarios.csv";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arqCSV), StandardCharsets.UTF_8))) {
            String line;
            boolean first = true;

            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                if(first){
                    first = false;
                    continue;
                }
                String name = functions.normalizer_text(values[0]);
                LocalDate birthDate = LocalDate.parse(values[1],formatter);
                BigDecimal salary = new BigDecimal(values[2]);
                String role = values[3];
                listEmployee.add(new Employee(name,birthDate,salary,role));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete_joao(){
        for(Employee Employee : listEmployee){
            if(functions.normalizer_text(Employee.getName()).equalsIgnoreCase(functions.normalizer_text("João"))){
                listEmployee.remove(Employee);
                break;
            }
        }
    }

    public void print(){
        for(Employee Employee : listEmployee){
            System.out.println(Employee);
        }
    }

    public void update_salary(){
        for(Employee Employee : listEmployee){
            BigDecimal salary_old = Employee.getSalary();
            BigDecimal salary_new = salary_old.multiply(new BigDecimal("1.1"));
            Employee.setSalary(salary_new);
        }
    }

    public void print_group_role(){
        Map<String, List<Employee>> mapEmployeeRole = new HashMap<>();

        mapEmployeeRole = listEmployee.stream().collect(Collectors.groupingBy(Employee -> Employee.role));

        for(Map.Entry<String, List<Employee>> entry : mapEmployeeRole.entrySet()){
            System.out.println("\n");
            System.out.println(entry.getKey());
            entry.getValue().forEach(Employee -> System.out.println(Employee));
        }
    }

    public void print_birth_mouth_10_12(){
        for(Employee Employee : listEmployee){
            if(Employee.getBirthdate().getMonthValue() == 10 || Employee.getBirthdate().getMonthValue() == 12){
                System.out.println(Employee);
            }
        }
    }

    public void print_oldest(){
        Optional<Employee> oldest = listEmployee.stream().min(Comparator.comparing(Employee -> Employee.getBirthdate()));

        String name = oldest.map(Employee::getName).orElse("None Employee");
        LocalDate Birthdate = oldest.map(Employee -> Employee.getBirthdate()).orElse(LocalDate.now());
        LocalDate now = LocalDate.now();

        int age = Period.between(Birthdate, now).getYears();

        System.out.println("Name: " + name + "\nAge: " + age);
        
    }

    public void print_asc_name(){
        List<Employee> listEmployeeOrdenada = listEmployee.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        listEmployeeOrdenada.forEach(Employee -> System.out.println(Employee));
    }

    public void print_sum_salary(){
        BigDecimal sum = listEmployee.stream().map(Employee -> Employee.getSalary()).reduce(BigDecimal.ZERO, BigDecimal::add);
        String sum_correct = functions.formatter_salary(sum);
        System.out.println("\nSum of salarys: " + sum_correct);
    }

    public void print_minimal_salary(){
        for(Employee Employee : listEmployee){
            BigDecimal salary = Employee.getSalary();
            BigDecimal minimal_salary = salary.divide(new BigDecimal("1212.00"), RoundingMode.HALF_UP);
            System.out.println("Name: " + Employee.getName() + "\nQuantily of minimal salary: " + minimal_salary + "\n");
        }
    }

    

}
