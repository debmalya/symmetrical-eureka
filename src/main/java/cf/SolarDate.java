package cf;

public class SolarDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	String solarDate(int n) {
	    int l = 186;
	    String[] x = new String[]{"Fa","Or","Kh","Ti","Mo","Sh"};
	    String[] y = new String[]{"Me","Ab","Az","De","Ba","Es"};
	   
	    int d = 0;
	    int m = 0;
	    int z = 0;
	    String r = "";
	    String[] v = null;
	    if (n <= l ){   
	    	v = x;
	        z = 31;      
	    } else {
	        n -= l;
	        v = y;
	        z = 30;
	    }
	    d = n % z;
        m = n / z;
        if (d == 0) {
        	 d = z;
        	 m--;
         }
        System.out.println(n+" "+d+" "+m);
        return ""+d+", "+v[m];

	}
	
	String solarDate0(int n) {
	    int l = 186;
	    String[] x = new String[]{"Fa","Or","Kh","Ti","Mo","Sh"};
	    String[] y = new String[]{"Me","Ab","Az","De","Ba","Es"};
	   
	    int d = 0;
	    int m = 0;
	    String r = "";
	    if (n <= l ){   
	         d = n % 31;
	         m = n / 31;
	         if (d == 0) {
	        	 d = 31;
	        	 m--;
	         }
	        System.out.println(n+" "+d+" "+m);
	        r = ""+d+", "+x[m];        
	    } else {
	        n -= l;
	        d = n % 30;
	        m = n / 30;
	        if (d == 0) {
	        	 d = 30;
	        	 m--;
	         }
	        System.out.println(n+" "+d+" "+m);
	        r = ""+d+", "+y[m]; 
	    }
	    return r;

	}
}
