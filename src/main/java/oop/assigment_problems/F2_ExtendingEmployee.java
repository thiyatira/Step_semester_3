package oop.assigment_problems;

// testing employee hierarchy using instanceof
public class F2_ExtendingEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee("EMP101", "Ramesh", 40000);
        Employee e2 = new ManagerEmployee("MGR201", "Suresh", 70000, 8000);
        Employee e3 = new InternEmployee("INT301", "Priya", 12000, 10000);

        Employee[] list = {e1, e2, e3};

        for(Employee emp : list) {
            // check employee type using instanceof
            if(emp instanceof ManagerEmployee) {
                ManagerEmployee m = (ManagerEmployee) emp;
                System.out.println("Manager effective pay: Rs " + m.effectiveSalary());
            } else if(emp instanceof InternEmployee) {
                InternEmployee i = (InternEmployee) emp;
                System.out.println("Intern effective pay: Rs " + i.effectiveSalary());
            } else {
                System.out.println("Plain employee pay: Rs " + emp.getSalary());
            }
        }
    }
}
