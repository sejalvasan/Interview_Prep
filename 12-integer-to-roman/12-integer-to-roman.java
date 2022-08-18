class Solution {
    public String intToRoman(int num) {
        
    	String[]ones ={"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
		String[]tens ={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[]hunds={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[]thou ={"","M","MM","MMM"};
		
		
		return thou[num/1000]+hunds[(num%1000)/100]+
		tens[(num%100)/10]+ones[num%10];
	}
}