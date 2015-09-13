/*----------------------------------------------------------------
 *  Author:        Barnabas Makonda
 *  Written:       10/09/2015
 *  Last updated:  14/09/2015
 *  
 *  Compilation:   javac ClientQuickFind.java
 *  Execution:     java ClientQuick
 *  
 *  Prints pairs of joined pairs from the text file input
 *
 *  % java ClientQuick
 *  4 3
 *  3 8
 *  6 5
 *  9 4
 *  2 1
 *  5 0
 *  7 2
 *  6 1
 *
 *----------------------------------------------------------------*/
import java.util.*;
import java.io.*;

class ClientQuickFind{
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