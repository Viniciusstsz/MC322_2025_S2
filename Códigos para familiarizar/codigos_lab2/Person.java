public class Person {

    //Atributos
    private String name;
    private int age;
    private String occupation;
    public static String species="Homo Sapiens";

    public Person(String nome, int idade, String occupation){
        this.name=nome;
        this.age=idade;
        this.occupation=occupation;
    }

    public String introduce(){
        return "Hello, my name is"+name;
    }

    public String describeJob(){
        return "I am currently working as a(n) "+occupation;
    }

    public String getName(){
        return name;
    }
}