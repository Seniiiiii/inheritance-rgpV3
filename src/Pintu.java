import java.util.ArrayList;

//menghapus method setObjGameInfo karena sudah dibut di class Item

public class Pintu extends Item { //menjadikan Pintu sebagai subclass, karena beberapa atribut & method mirip

    public Pintu() {

        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    @Override
    public ArrayList<String> getAksi() { // menjadikan method sebagai override karena nama method sama, namun intruksi didalamnya berbeda

        return arrAksi;
    }

    @Override
    public void prosesAksi(int subPil) { // menjadikan method sebagai override karena nama method sama, namun intruksi didalamnya berbeda

        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {

            System.out.println("Pintu berwarna merah dengan tulisan 'EXIT' di atas ");
        }
        else if (subPil==2) {

            //cek apakah mempunyai kunci
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {

                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); //game over
            }
            else {
                //kunci tidak ada
                System.out.println("Player mencoba membuka pintu. TERKUNCI!");
            }
        }
    }
}
