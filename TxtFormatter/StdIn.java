import java.io.*;
import java.util.*;

/**
 * Class StdIn provides formatted buffered input from the console.
 * @author Swastik Pal
 * @version 20/3/19
 */
public class StdIn
{
    static private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static private StringTokenizer st;

    static String nextLine() throws IOException
    {
        if(st==null || !st.hasMoreTokens())
            st=new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    
    static int nextInt() throws IOException
    {
        return Integer.parseInt(nextLine());
    }
    
    static long nextLong() throws IOException
    {
        return Long.parseLong(nextLine());
    }
    
    static float nextFloat() throws IOException
    {
        return Float.parseFloat(nextLine());
    }
    
    static double nextDouble() throws IOException
    {
        return Double.parseDouble(nextLine());
    }    
}
