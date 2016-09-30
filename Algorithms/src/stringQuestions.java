
import java.util.*;
public class stringQuestions {

	static void minLenWindow(String text,String pat){
		int start=0;
		int end=0;
		int count=0;
		int[] needed  = new int[256];
		int[] hasFound = new int[256];
		
		for(int i=0;i<pat.length();i++)
			needed[pat.charAt(i)]++;
		
		for(end=0;end<text.length();end++){
			if(text.charAt(end) !=  pat.charAt(end))
				continue;
			
			hasFound[text.charAt(end)]++;
			if(hasFound[text.charAt(end)] <= needed[text.charAt(end)])
				count++;
			
			if(count==pat.length()){
				while( (hasFound[text.charAt(start)]==0) || ( hasFound[text.charAt(start)] > needed[text.charAt(start)] ))
					if( hasFound[text.charAt(start)] > needed[text.charAt(start)] )
						hasFound[text.charAt(start)]--;
				start++;
				
			}
		}
	}
}
