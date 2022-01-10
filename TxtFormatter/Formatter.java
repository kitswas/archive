import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Formatter
{
    static BufferedWriter fw;
    static Scanner sc, stdIn = new Scanner(System.in);

    public static void main(String args[]) throws IOException
    {
        String path = null, opath = null;
        boolean truth = true;
        do
        {
            try
            {
                System.out.println("Enter path:");
                path = stdIn.nextLine();
                opath = path.substring(0, path.lastIndexOf(".")) + "_formatted.txt";
                truth = false;
            } catch (Exception a)
            {
                System.out.println("Invalid path");
            }
        } while (truth);
        try
        {
            sc = new Scanner(new FileReader(path));
            sc.useDelimiter("\n");
            fw = new BufferedWriter(new FileWriter(opath));
            getInput();
            System.out.println("Success...");
        }catch (IOException e)
        {
            System.out.println("Unable to access files");
        } catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Processing Error");
        } finally
        {
            if (fw != null)
                fw.flush();
            if (sc != null)
                sc.close();
            if (fw != null)
                fw.close();
        }
    }

    private static void getInput() throws IOException
    {
        String st;
        //Person P=new Person();
        int previndex = 0, index = 0;
        st = sc.nextLine();//removes first Line containing headings
        while (sc.hasNextLine())
        {
            previndex = 0;
            index = 0;
            st = sc.nextLine();
            index = st.indexOf('\t', previndex);
            Person.name = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.tno = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.vndcd = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.bnk = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.acno = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.ifsc = st.substring(previndex, index);
            previndex = index+1;
            index = st.indexOf('\t', previndex);
            Person.pan = st.substring(previndex, index);
            Person.pnmtmd = st.substring(previndex);
            writeOutput();
        }
    }

    private static void writeOutput() throws IOException//No errors as yet
    {
        int i;
        char delim = '#';
        char name[] = Person.name.trim().toCharArray();
        for (i = 0; i < 45 && i < name.length; i++)
        {
            fw.write(name[i]);
        }
        for (; i < 45; i++)
        {
            fw.write(' ');
        }
        fw.write(delim);
        fw.write(Person.acno);
        fw.write(delim);
        fw.write(Person.ifsc);
        fw.write(delim);
        fw.write(delim);
        fw.write(delim);
        fw.write(delim);
        fw.write(delim);
        fw.write(delim);
        fw.write(Person.vndcd);
        fw.write(System.getProperty("line.separator"));
    }

}