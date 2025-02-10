import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        Crud_System crud = new Crud_System();
        Scanner scan = new Scanner(System.in);
        int option;

        do{
            
            System.out.println("\n\nHello, I'm CRUD System! What would you like?");
            System.out.println("1 - Insert");
            System.out.println("2 - Delete Joao");
            System.out.println("3 - Print");
            System.out.println("4 - Update Salary");
            System.out.println("5 - Print Group by Role");
            System.out.println("6 - Print Birth Month 10-12");
            System.out.println("7 - Print Oldest");
            System.out.println("8 - Print Asc Name");
            System.out.println("9 - Print Sum Salary");
            System.out.println("10 - Print Minimal Salary");
            System.out.println("11 - Exit");
            option = scan.nextInt();

            switch(option){
                case 1:
                    System.out.println("Insert");
                    crud.insert();
                    break;
                case 2:
                    System.out.println("Delete Joao");
                    crud.delete_joao();
                    break;
                case 3:
                    System.out.println("Print");
                    crud.print();
                    break;
                case 4:
                    System.out.println("Update Salary");
                    crud.update_salary();
                    break;
                case 5:
                    System.out.println("Print Group by Role");
                    crud.print_group_role();
                    break;
                case 6:
                    System.out.println("Print Birth Month 10-12");
                    crud.print_birth_mouth_10_12();
                    break;
                case 7:
                    System.out.println("Print Oldest");
                    crud.print_oldest();
                    break;
                case 8:
                    System.out.println("Print Asc Name");
                    crud.print_asc_name();
                    break;
                case 9:
                    System.out.println("Print Sum Salary");
                    crud.print_sum_salary();
                    break;
                case 10:
                    System.out.println("Print Minimal Salary");
                    crud.print_minimal_salary();
                    break;
                case 11:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while(option != 11);
    }
}
