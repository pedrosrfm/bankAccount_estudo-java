package entities;

public class Department {
    private String name;

    //construtor//

    public Department(String departmentName){
        this.name = departmentName;
    }

    //getters e setters//

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
