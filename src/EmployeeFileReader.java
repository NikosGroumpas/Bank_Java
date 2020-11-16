import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EmployeeFileReader {

    ArrayList<Employee> employees;
    ArrayList<Car> cars;

    public void readFile() {

        employees = new ArrayList<>();
        cars = new ArrayList<>();

        File dataFile = new File("C:\\Users\\Nikos\\IdeaProjects\\FileRead\\src\\data.csv");
        try {
            Scanner dataScanner = new Scanner(dataFile);
            while (dataScanner.hasNextLine()) {
                String line = dataScanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                if (tokenizer.countTokens()==4) {
                    Employee e = new Employee
                            (
                                    Integer.parseInt(tokenizer.nextToken().trim()),
                                    tokenizer.nextToken().trim(),
                                    tokenizer.nextToken().trim(),
                                    Double.parseDouble(tokenizer.nextToken().trim())
                            );
                    employees.add(e);
                }  else if (tokenizer.nextToken().equals("car")){
                    Car c = new Car(
                            tokenizer.nextToken().trim(),
                            Integer.parseInt(tokenizer.nextToken().trim()),
                            tokenizer.nextToken().trim(),
                            Integer.parseInt(tokenizer.nextToken().trim())
                            );
                    cars.add(c);
                } else {
                    System.out.println("Wrong number of items");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void printCars() {
        for (Car c : cars) {
            System.out.println(c.getModel() + " with " + c.gethorsePower() + " horsepower was made in " + c.getDatemanufactured());
        }
    }
    public void printEmployees(){
        for (Employee e : employees){
            System.out.println(e.getName() + " was born " + e.getBirthDate());
        }
    }




    public static void main(String[] args) {
        EmployeeFileReader reader = new EmployeeFileReader();
        reader.readFile();
        reader.printEmployees();
        reader.printCars();

    }




}
