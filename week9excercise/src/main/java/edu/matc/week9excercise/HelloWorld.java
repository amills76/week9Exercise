package edu.matc.week9excercise;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by student on 10/26/16.
 */
public class HelloWorld extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("Hello Enterprise Java!");
        out.println(evaluateDate(getCurrentDateTime()));
    }

    public Date getCurrentDateTime() {
        Date date = new Date();
        return date;
    }

    public String evaluateDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        DateFormat timeFormat = new SimpleDateFormat("kk");
                String seasonalGreeting = "";
        if(Integer.parseInt(timeFormat.format(date)) >= 12){
            seasonalGreeting = "Good Afternoon";
        } else {
            seasonalGreeting = "Good Morning";
        }
        if(dateFormat.format(date).equals("10/31")){
            seasonalGreeting = seasonalGreeting.concat(" Happy Halloween!");
        }

        return seasonalGreeting;
    }
}
