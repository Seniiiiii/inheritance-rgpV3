public class GameInfo {

    private Ruangan objRuangan;
    private Player objPlayer;
    private Boolean isGameOver = false;

    public Ruangan getObjRuangan() {

        return objRuangan;
    }

    public void setObjRuangan(Ruangan objRuangan) {

        this.objRuangan = objRuangan;
    }

    public Player getObjPlayer() {

        return objPlayer;
    }

    public void setObjPlayer(Player objPlayer) {

        this.objPlayer = objPlayer;
    }

    public Boolean getGameOver() {

        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {

        isGameOver = gameOver;
    }
}
