package acc.resto;

import android.graphics.drawable.Drawable;

public class OffersData {

    public Drawable icon;
    public String title;
    public String description;
    public OffersData(){
        super();
    }

    public OffersData(Drawable icon, String title, String description ) {
        super();
        this.icon = icon;
        this.title = title;
        this.description = description;
    }
}
