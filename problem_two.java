import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.Reader;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

// Runs with:
// javac -cp ".:commons-csv-1.5/commons-csv-1.5.jar:commons-csv-1.5/commons-csv-1.5-sources.jar:" problem_two.java
// java -cp ".:commons-csv-1.5/commons-csv-1.5.jar:commons-csv-1.5/commons-csv-1.5-sources.jar:" problem_two

public class problem_two {
    private static final String SAMPLE_CSV_FILE_PATH = "./employees.csv";
    public static void main(String[] args) throws IOException {
        Scanner input_reader = new Scanner(System.in);
        System.out.println("Enter the minimum salary as an integer: ");
        int min = input_reader.nextInt();

        System.out.println("Enter the maximum salary as an integer: ");
        int max = input_reader.nextInt();

        input_reader.close();

        try (
            Reader csv_reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(csv_reader, CSVFormat.DEFAULT
                    .withHeader("employee_id", "employee_name", "employee_salary")
                    .withIgnoreHeaderCase()
                    .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String id = csvRecord.get("employee_id");
                String name = csvRecord.get("employee_name");
                String salary = csvRecord.get("employee_salary");

                Integer salary_num = Integer.parseInt(salary);
                if ((min <= salary_num) && (salary_num <= max)) {
                    System.out.println(id + ", " + name + ", " + salary);
                }
            }
        }
    }
}
