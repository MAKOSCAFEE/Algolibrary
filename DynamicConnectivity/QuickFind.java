import java.util.*;
import java.io.*;
public class QuickFind {

	private int [] data;
	private int counts;
    // Initialize UnionFind data structure with N objects 
	public QuickFind (int N){
		counts =N;
        data= new int[N];
	for (int i=0; i<N; i++ )
		data[i]=i;
	}
    
    // Connect the two pair to form one object
	public void union(int p,int q){
		// Get the coresponding components
		int pdata = data[p];
		int qdata = data[q];
		for (int i=0; i<data.length; i++ ) {
			if(data[i]==pdata) data[i]=qdata;
			
		}
	}
	// Asks to find if two pair are connected/belong to the same component 
	public boolean unionConnected(int p,int q){
		return data[p]==data[q];
	}
	
    // Counts the number of objects in the component
    public int count(){
    	return counts;
    }

    public static void main(String[] args)throws FileNotFoundException {
    	// Read data from the file one interger at a time
    	Scanner input = new Scanner(new File("tinyUF.txt"));
        
        // Now read the first interger from the file
        int N =input.nextInt();

        // create the UnionFind object
    	QuickFind  qf = new QuickFind (N);
    	// Read throught the whole file
    	while(input.hasNextInt()) {

    		// Read the first interger
    		int p = input.nextInt();
    		// Read the next interger
    		int q = input.nextInt();
    		if(!qf.unionConnected(p,q)){
    			qf.union(p,q);
    			System.out.println(p+" "+ q);
    		}

    	};
    }
	
}