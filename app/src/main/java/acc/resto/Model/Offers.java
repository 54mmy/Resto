package acc.resto.model;

import com.parse.ParseObject;

/**
 * Created by MITHUN on 1/23/2015.
 */
public class Offers extends ParseObject {
    String image;
    String title;
    String description;
    public String getImage(){
        return getString("image");
    }
    public String getTitle(){
        return getString("title");
    }
    public String getDescription(){
        return getString("description");
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setImage(String image){
        this.image = image;
    }
}
