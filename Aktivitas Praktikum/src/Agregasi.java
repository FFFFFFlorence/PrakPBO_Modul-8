import java.util.ArrayList;

class Mahasiswa {
    String nama;

    Mahasiswa(String nama){
        this.nama = nama;
    }
}

class Universitas {
    String namaUniv;
    ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    Universitas(String namaUniv){
        this.namaUniv = namaUniv;
    }

    void tambahMahasiswa(Mahasiswa mhs){
        daftarMahasiswa.add(mhs);
    }

    void tampilkanMahasiswa(){
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println(mhs.nama);
        }
    }
}

public class Agregasi {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("Farhan");
        Mahasiswa mhs2 = new Mahasiswa("Irfan");

        Universitas uper = new Universitas("Universitas Pertamina");
        uper.tambahMahasiswa(mhs1);
        uper.tambahMahasiswa(mhs2);

        uper.tampilkanMahasiswa();
    }
}
