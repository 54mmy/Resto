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
    public Drawable getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
