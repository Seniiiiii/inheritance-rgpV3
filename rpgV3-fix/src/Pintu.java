import java.util.ArrayList;

public class Pintu extends Item {


    public Pintu() {

        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    @Override
    public ArrayList<String> getAksi() {

        return arrAksi;
    }

    @Override
    public void prosesAksi(int subPil) {

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
