class Owner {
    public String nama;
    Animal hewanPeliharaan;

    public Owner(String nama, Animal hewanPeliharaan) {
        this.nama = nama;
        this.hewanPeliharaan = hewanPeliharaan;
    }   
}

class HealthRecord {
    public int medRecNo;
    public String medRecDate;

    public HealthRecord(int medRecNo, String medRecDate) {
        this.medRecNo = medRecNo;
        this.medRecDate = medRecDate;
    }

    public void tampilkanInfo() {
        System.out.println("MedRec No: " + medRecNo);
        System.out.println("MedRec Date: " + medRecDate);
    }
}

class Animal{
    HealthRecord medRecs;

    public Animal() {
        this.medRecs = new HealthRecord(0, "2023-10-01");
    }
    
    public void makeSound(){
        System.out.println("Suara Hewan Peliharaan");
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Guk-Guk!");
    }
}

class Cat extends Animal{
    public void makeSound(){
        System.out.println("Meong!");
    }
}

public class Main {
    public static void main(String[] args) {
        Owner pemilik = new Owner("Budi", new Dog());
        Owner pemilik1 = new Owner("Andi", new Cat());
    
        if (pemilik.hewanPeliharaan instanceof Dog) {
            System.out.println(pemilik.nama + " memiliki hewan peliharaan Dog");
            pemilik.hewanPeliharaan.makeSound();
            pemilik.hewanPeliharaan.medRecs.tampilkanInfo();
        } else  {
            System.out.println(pemilik.nama + " memiliki hewan peliharaan Cat");
            pemilik.hewanPeliharaan.makeSound();
            pemilik.hewanPeliharaan.medRecs.tampilkanInfo();
        } 

        if (pemilik1.hewanPeliharaan instanceof Dog) {
            System.out.println("\n" + pemilik1.nama + " memiliki hewan peliharaan Dog");
            pemilik1.hewanPeliharaan.makeSound();
            pemilik1.hewanPeliharaan.medRecs.tampilkanInfo();
        } else  {
            System.out.println("\n" + pemilik1.nama + " memiliki hewan peliharaan Cat");
            pemilik1.hewanPeliharaan.makeSound();
            pemilik1.hewanPeliharaan.medRecs.tampilkanInfo();
        } 
        
        
    }    
}
