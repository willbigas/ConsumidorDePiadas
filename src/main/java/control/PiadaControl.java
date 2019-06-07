package control;

import dao.DaoServer;
import model.Piada;
import view.TelaPrincipal;

/**
 *
 * @author William
 */
public class PiadaControl {

    TelaPrincipal telaPrincipal;
    Piada piada;

    public PiadaControl() {
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setLocationRelativeTo(null);
        telaPrincipal.setVisible(true);
    }

    public void novaPiadaAction() {
        piada = DaoServer.getPiada();
        telaPrincipal.getLblPiada().setText(piada.getPergunta());
        telaPrincipal.getLblResposta().setText(piada.getResposta());
        piada = null;
    }
    

}
