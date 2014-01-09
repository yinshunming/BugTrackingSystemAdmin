package test;

import java.sql.Timestamp;



public class TaskJob {  
      
    public void job1() {  
    	Timestamp tt = new Timestamp(System.currentTimeMillis());  
        System.out.println(tt.toString());  
    }  
}  