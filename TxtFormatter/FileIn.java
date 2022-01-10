import java.io.*;
import java.util.*;

/**
 * Class FileIn provides formatted buffered input from a target file.
 * @author Swastik Pal
 * @version 20/3/19
 */
public class FileIn
{
    private BufferedReader br;
    private String st;
    private int nret,ntab;

    public FileIn(String path) throws IOException
    {
        br=new BufferedReader(new FileReader(path));
    }

    String nextLine() throws IOException
    {
        if(st==null)
        {
            st=br.readLine();
            nret=0;
            ntab=0;
        }
        nret=st.indexOf(nret,'\n');
        ntab=st.indexOf(ntab,'\t');
        return st.substring(ntab);
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt(nextLine());
    }

    long nextLong() throws IOException
    {
        return Long.parseLong(nextLine());
    }

    float nextFloat() throws IOException
    {
        return Float.parseFloat(nextLine());
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble(nextLine());
    }    
}
