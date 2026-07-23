package Week1.Thursday.CollectionsPractice.coll;

import java.util.ArrayList;

public class EmployeeManager{


    public static void main(String[] args) {
        Employee emp = new Employee(1,"jon", 100000);
        Employee emp2 = new Employee(2,"jane", 120000);
        Employee emp3 = new Employee(3,"bob", 110000);
        Employee emp4 = new Employee(4,"alice", 130000);
        Employee emp5 = new Employee(5,"charlie", 140000);




        ArrayList<Employee> list=new ArrayList<>();
        list.add(emp);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);



        for (Employee e:list){
            System.out.println(e);
        }



        //Collections.sort(list, new EmployeeManager());
    }


}
