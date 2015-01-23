package acc.resto.model;

import com.parse.ParseObject;

/**
 * Created by MITHUN on 1/23/2015.
 */
public class Offers extends ParseObject {
    String image;
    String title;
    String description;
    Offers(){}
    public String getImage(){
        return getString("image");
    }
    public String getTitle(){
        return getString("title");
    }
    public String getDescription(){
        return getString("description");
    }
}
