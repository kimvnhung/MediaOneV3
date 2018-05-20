/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Khac;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField.AbstractFormatter;



public class DateLabelFormatter extends AbstractFormatter{

    private String datePattern = "dd/MM/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    private String time ;
    private long miliTime;
    
    private final long ONE_DAY = 86400000;//miliseconds 
    
    public DateLabelFormatter() {
        miliTime = new Date().getTime();
        time = dateFormatter.format(miliTime);
    }

    public DateLabelFormatter(String timeInFormat) throws ParseException{
        miliTime = dateFormatter.parse(timeInFormat).getTime();
        time = dateFormatter.format(miliTime);
    }
    
    public DateLabelFormatter(long miliTime){
        this.miliTime = miliTime;
        time = dateFormatter.format(miliTime);
    }
    
    public String getTime() {
        return time;
    }

    public long getMiliSeconds() {
        return miliTime;
    }
    
    public String getNextDayTime(){
        return new DateLabelFormatter(miliTime+ONE_DAY).getTime();
    }
    
    public String getPreviousDayTime(){
        return new DateLabelFormatter(miliTime-ONE_DAY).getTime();
    }
    
    public int compareTime(long another,String type) throws Exception{
        Date thisTime = new Date(miliTime);
        Date toTime = new Date(another);
         
        switch(type){
            case "YEAR":
                
                break;
            case "MONTH":
                break;
            case "DAY":
                break;
            case "HOUR":
                break;
            default:
                throw new Exception("TIME UNKNOWN!");
        }
        return 0;
    }

    @Override
    public Object stringToValue(String string) throws ParseException {
        return dateFormatter.parseObject(string);
    }

    @Override
    public String valueToString(Object o) throws ParseException {
        if (o != null) {
            Calendar cal = (Calendar) o;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }

    public String getDatePattern() {
        return datePattern;
    }
    
    
    

	
}
