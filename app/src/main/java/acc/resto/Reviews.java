package acc.resto;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Sagar Gopale on 1/9/2015.

 */

@ParseClassName("Reviews")
public class Reviews extends ParseObject {

    public String getDish(){
        return getString("dish");
    }

    public String getReview(){
        return getString("review");
    }

    public void setDish(String dish)
    {
        put("dish",dish);
    }

    public void setReview(String review)
    {
        put("review",review);
    }

}
