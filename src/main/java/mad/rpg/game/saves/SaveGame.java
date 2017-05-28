package mad.rpg.game.saves;

import mad.rpg.game.context.Context;

import java.io.Serializable;
import java.util.Date;

public class SaveGame implements Serializable {

    private Context context;
    private Date date;

    public SaveGame(Context context) {
        this.context = context;
        this.date = new Date();
    }

    public Context context(){
        return context;
    }

    public Date date(){
        return date;
    }

}
