import java.util.ArrayList;

public class NPC {

    //kunci dipindahkan dari ruangan
    private boolean isKenal             = false;
    private Item  objKunci;
    private GameInfo objGameInfo;
    private ArrayList<String> arrAksi   = new ArrayList<>();

    public NPC() {

        //init kunci
        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");
    }

    public void setObjGameInfo(GameInfo objGameInfo) {

        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

    public ArrayList<String> getAksi() {

        return arrAksi;
    }

    public void prosesAksi(int subPil) {

        if (subPil == 1) { // kenalan

            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;

        }
        else if (subPil == 2) { //ambil kunci

            if (isKenal) {

                //berikan kunci pada player
                if (objKunci==null) {

                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                }
                else {

                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
                    objKunci = null;
                }

            }
            else {

                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }
}
