import java.util.ArrayList;

public class Item {

    private String nama;
    private String deskripsi;
    private Ruangan objRuangan;
    protected GameInfo objGameInfo; // mengganti hak akses variabel dari private menjadi protected agar dapat digunakan oleh subclass inherit
    protected ArrayList<String> arrAksi = new ArrayList<>(); // mengganti hak akses variabel dari private menjadi protected agar dapat digunakan oleh subclass inherit

    public Item(String nama) {

        this.nama = nama;
    }

//    dibuat overloading pada construct Item, untuk mencegah error pada inheritance / subclass Pintu
    public Item(){

    }


    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getDeskripsi() {

        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {

        this.deskripsi = deskripsi;
    }

    public void setObjRuangan(Ruangan objRuangan) {

        this.objRuangan = objRuangan;
    }

    public void setObjGameInfo(GameInfo objGameInfo) {

        this.objGameInfo = objGameInfo;
    }

    public ArrayList<String> getAksi() {

        //aksi dinamik tergantung ada di ruangan atau dipegang player/npc
        ArrayList<String> arrOut = new ArrayList<>();

        if (objRuangan==null) {

            //ada di player, ada opsi buang
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        }
        else {

            //ada di ruangan ada opsi ambil
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }

        return(arrOut);
    }

    public void printItem() {

        //print deskripsi item
        System.out.println(deskripsi);
    }

    public void prosesAksi(int pil) {

        if (pil==1) {

            System.out.println(deskripsi);
        }
        else  if (pil==2) {  //bisa ambil atau buang

            if (objRuangan==null) {

                //dipegang player, buang ke ruangan
                dibuang();
            }
            else {

                //ada di ruangan, diambil player
                diambil();
            }
        }
    }

    private void dibuang() {

        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().hapusItem(this); //hapus dari player
        objGameInfo.getObjRuangan().addItem(this);  //tambah ke ruangan
        objRuangan = objGameInfo.getObjRuangan(); // set ruangan
    }

    private void diambil() {

        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);     //tambahkan  objek ini (this) pada player
        objRuangan.hapusItem(this);                    //hapus dari ruangan
        objRuangan = null;
    }
}