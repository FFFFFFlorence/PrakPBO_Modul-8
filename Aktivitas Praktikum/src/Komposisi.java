class Kamar {
    String tipe;

    Kamar (String tipe) {
        this.tipe = tipe;
    }

    void tampilkanTipe() {
        System.out.println("Tipe Kamar: " + tipe);
    }
}

class Rumah {
    private Kamar kamar;

    Rumah() {
        kamar = new Kamar("Mandi");
    }

    void lihatKamar() {
        kamar.tampilkanTipe();
    }
}

public class Komposisi {
    public static void main(String[] args) {
        Rumah rumah = new Rumah();
        rumah.lihatKamar();
    }
}
