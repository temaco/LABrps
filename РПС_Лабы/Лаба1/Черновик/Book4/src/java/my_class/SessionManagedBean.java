package my_class;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionManagedBean {
     private static int col;
     private final long time = System.currentTimeMillis();
     
    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        String sDate = sdf.format(new Date(System.currentTimeMillis()));
        return sDate;
    }
    
    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col++;
    }
    
    public SessionManagedBean(int col) {
        this.col = col;
    }
    /**
     * Creates a new instance of ManagedBean
     */
    public SessionManagedBean() {
    }

}
