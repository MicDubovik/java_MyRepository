package ru.job4j.profession;

/**
 * Created by Katy on 27.02.2017.
 */
public class Main {
    public static void main(String[] args) {

        Profession doctor = new Doctor("Surgeon","Mik",30,"Mikro");
        Profession teacher = new Teacher("University","George",35,"Geography");
        Profession engeneer = new Engineer("Builder","John",50,"Engineer");

        Profession[] worker = new Profession[3];

        worker[0]=doctor  ;
        worker[1]=teacher;
        worker[2]=engeneer;

        for (Profession prof : worker) {
            System.out.print(prof.name+"\t"+prof.qualification+"\t"+prof.old);
            if (prof instanceof Doctor){
                Doctor doctor1 = (Doctor) prof;
                System.out.println("\t"+doctor1.getSpeciality());
            }
            if (prof instanceof Engineer){
                Engineer engineer1 = (Engineer) prof;
                System.out.println("\t"+engineer1.getProfession());
            }
            if (prof instanceof Teacher){
                Teacher teacher1 =(Teacher) prof ;
                System.out.println("\t"+teacher1.getEducation());
            }

        }



    }
}
