
public class Tests{

    public static void testPerson(){
        Person p1 = new Person("Alice", 30, "Engineer");
        assert p1.introduce().equals("Hello, my name is Alice") : "introduce() failed";

        Person p2 = new Person("Bob", 25, "Doctor");
        assert p2.describeJob().equals("I am currently working as a(n) Doctor") : "describeJob() failed";

        Person p3 = new Person("Charlie", 40, "Teacher");
        assert p3.getName().equals("Charlie") : "getName() failed";

        System.out.println("All tests of 'Person' class passed.");
    }

    public static void testCompProg(){
        ComputerProgrammer p1 = new ComputerProgrammer("Alice", 30);
        assert p1.introduce().equals("Hello, my name is Alice") : "introduce() failed";

        ComputerProgrammer p2 = new ComputerProgrammer("Bob", 25);

        assert p2.describeJob().equals("I am currently working as a(n) Computer Programmer, I'm learning OOP and Java!") : "describeJob() failed";

        // Subclass validation tests
        assert p1 instanceof Person : "ComputerProgrammer should be a subclass of Person";

        System.out.println("All tests of 'ComputerProgrammer' class passed.");
    }

    public static void testWebDev(){
        WebDeveloper p1 = new WebDeveloper("Alice", 30);
        assert p1.introduce().equals("Hello, my name is Alice") : "introduce() failed";

        WebDeveloper p2 = new WebDeveloper("Bob", 25);
        assert p2.describeWebsite().equals("My professional world-class website is made from HTML, CSS, Javascript and Java!") : "describeWebsite() failed";
        assert p2.getName().equals("Bob") : "getName() failed";

        assert WebDeveloper.species.equals("Homo Sapiens") : "species constant failed";

        // Subclass validation tests
        assert p1 instanceof ComputerProgrammer : "WebDeveloper should be a subclass of ComputerProgrammer";
        assert p2 instanceof ComputerProgrammer : "WebDeveloper should be a subclass of ComputerProgrammer";

        System.out.println("All tests of 'WebDeveloper' class passed.");
    }

}
