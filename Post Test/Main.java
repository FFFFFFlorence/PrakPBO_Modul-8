class Vehicle {
    void startEngine() {
        System.out.println("Mesin Nyala");
    }
}

class Car extends Vehicle {
    void startEngine() {
        System.out.println("Mesin Mobil Nyala");
    }
}

class Motorcycle extends Vehicle {
    void startEngine() {
        System.out.println("Mesin Motor Nyala");
    }
}

class Driver {
    public String name;
    Vehicle vehicle;
    License license;

    Driver(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
        license = new License("001", 2025);
    }

}

class License {
    public String nomorLisensi;
    public int expDate;

    public License(String nomorLisensi, int expDate) {
        this.nomorLisensi = nomorLisensi;
        this.expDate = expDate ;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Lisensi: " + nomorLisensi);
        System.out.println("Tanggal Expired: " + expDate);
    }
}

public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Budi", new Car());
        Driver driver2 = new Driver("Andi", new Motorcycle());

        if (driver1.vehicle instanceof Car) {
            System.out.println(driver1.name + " mengendarai mobil");
            driver1.vehicle.startEngine();
            driver1.license.tampilkanInfo();
        } else {
            System.out.println(driver1.name + " mengendarai motor");
            driver1.vehicle.startEngine();
            driver1.license.tampilkanInfo();
        }

        if (driver2.vehicle instanceof Car) {
            System.out.println("\n" + driver2.name + " mengendarai mobil");
            driver2.vehicle.startEngine();
            driver2.license.tampilkanInfo();
        } else {
            System.out.println("\n" + driver2.name + " mengendarai motor");
            driver2.vehicle.startEngine();
            driver2.license.tampilkanInfo();
        }
    }
}
