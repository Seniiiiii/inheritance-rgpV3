import java.util.ArrayList;
import java.util.Scanner;

public class Ruangan {

    private String deskripsi;
    private Pintu objPintu;
    private NPC objNPC;
    private Item  objRoti;
    private GameInfo objGameInfo;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private Scanner sc              = new Scanner(System.in);

    public String getDeskripsi() {

        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {

        this.deskripsi = deskripsi;
    }

    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {

        this.objGameInfo = objGameInfo;
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);

        for (Item objItem:arrItem) {

            objItem.setObjGameInfo(objGameInfo);
        }
    }

    public Ruangan() {
        // init ruangan
        // init pintu, kunci dan roti.
        objPintu    = new Pintu();
        objNPC      = new NPC();

        objRoti     = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        //tambah item ke array
        arrItem.add(objRoti);
    }

    public void listDeskripsi(int urutPil, int subPil, ArrayList<String> arrPil){ // method untuk digunakan di pilihan aksi Ruangan dan Player

        for (String strPil:arrPil) { // sama kaya di Ruangan
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        //aksi2 item
        System.out.println("Item di ruangan");

//        nampilin arraylist item
        for (Item objItem:arrItem) {

            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());
            //ambil pilihannya
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            listDeskripsi(urutPil,subPil ,arrPil); // array List deskripsi dari method
        }

        // aksi2 PINTU
        //belum menggunakan inheritance, jadi masih perlu penanganan terpisah untuk item spesifik seperti pintu
        urutPil++;
        subPil = 0;
        int pilPintu  = urutPil; //catat untuk pintu
        System.out.println("Pintu");

        listDeskripsi(urutPil,subPil ,objPintu.getAksi()); // array List deskripsi dari method

        // aksi2 NPC
        urutPil++;
        subPil = 0;
        int pilNPC  = urutPil; //catat untuk pintu
        System.out.println("NPC");

        listDeskripsi(urutPil,subPil ,objNPC.getAksi()); // array List deskripsi dari method

        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        //tdk perlu if spt ini kalau sudah menggunakan inheritance
        if (pil ==pilPintu) {

            objPintu.prosesAksi(subPil);  //aksi pintu
        }
        else if (pil==pilNPC) {

            objNPC.prosesAksi(subPil);
        }
        else {
            //item
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {

        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {

        arrItem.add(objItem);
    }
}