package peaksoft;

import peaksoft.models.Company;
import peaksoft.models.Course;
import peaksoft.models.Student;
import peaksoft.repository.CompanyRepository;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Student student1 = new Student("Nurkyz","Kasymova","hadicekasymova@gmail.com",19,"+996 773 642 512");
        Student student2 = new Student("Zhazgul","Zhoroeva","zhoroeva@gmail.com",19,"+996 773 642 642");
        Student student3 = new Student("Nursultan","Osorov","osorov97@gmail.com",25,"+996 773 512 512");
        Student student4 = new Student("Nurislam","Bakytov","bakytov@gmail.com",17,"+996 773 996 512");
        Student student5 = new Student("Burulai","Kasymova","hadicekasymova@gmail.com",19,"+996 773 642 512");
        Student student6 = new Student("Bermet","Kasymova","hadicekasymova@gmail.com",19,"+996 773 642 512");


        Course course1 = new Course("Java","12-09-2018","12-09-2019",Arrays.asList(student1,student3));
        Course course2 = new Course("JavaScript","12-01-2020","12-09-2021",Arrays.asList(student2,student5));
        Course course3 = new Course("Python","10-02-2019","10-09-2020",Arrays.asList(student4,student6));

        Company company = new Company("Peaksoft","peaksoft@gmail.com", Arrays.asList(course1,course2,course3));

        student1.getCourses().add(course1);
        student3.getCourses().add(course1);

        student2.getCourses().add(course2);
        student5.getCourses().add(course2);

        student4.getCourses().add(course3);
        student6.getCourses().add(course3);


        course1.setCompany(company);
        course2.setCompany(company);
        course3.setCompany(company);

        CompanyRepository companyRepository = new CompanyRepository();
        companyRepository.save(company);
    }
}
