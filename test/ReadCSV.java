import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.math.*;

public class ReadCSV {

    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV();
        readCSV.readCSVFile();
    }

    public void readCSVFile(){
        // Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<Funcionario> listFuncionario = new ArrayList<>();
        String arqCSV = "c:/Users/giueg/OneDrive/Documentos/Workspace/Teste_Projedata/CRUD_System/data/funcionarios.csv";
    
        try (BufferedReader br = new BufferedReader(new FileReader(arqCSV))){
                String line;
                boolean first = true;
    
                while((line = br.readLine()) != null){
                    String[] values = line.split(",");
                    if(first){
                        first = false;
                        continue;
                    }
                    String name = values[0];
                    LocalDate birthDate = LocalDate.parse(values[1],formatter);
                    BigDecimal salary = new BigDecimal(values[2]);
                    String role = values[3];
                    listFuncionario.add(new Funcionario(name,birthDate,salary,role));
                }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }   
        
        for(Funcionario funcionario : listFuncionario){
            System.out.println(funcionario);
        }
    }    
}
