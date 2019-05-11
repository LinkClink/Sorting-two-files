import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static sun.nio.ch.IOStatus.EOF;

/**
 * Created by LinkClink on 10.05.2019.
 */

public class Main
{
    public static void main(String[] args ) throws Exception
    {
        File file_in1 = new File("C:/Users/LinkClink/IdeaProjects/File_plus/src/in_1.txt");
        File file_in2 = new File("C:/Users/LinkClink/IdeaProjects/File_plus/src/in_2.txt");

        File file_out = new File ("C:/Users/LinkClink/IdeaProjects/File_plus/src/out.txt");

        FileWriter fileWriter = new FileWriter(file_out);

        int arg1 = 0 , arg2 = 0;

        int end_file1 = 0 ;
        int end_file2 = 0 ;

        Scanner scanner_1 = new Scanner(file_in1);
        Scanner scanner_2 = new Scanner(file_in2);

        while (scanner_1.hasNextInt() || scanner_2.hasNextInt())
        {

            if ( scanner_1.hasNext() == false ) // Check end of file
            {
                end_file1= 1;
            }else arg1 = scanner_1.nextInt();

            if ( scanner_2.hasNext() == false ) // Check end of file
            {
                end_file2 = 1;
            } else arg2 = scanner_2.nextInt();

            if(end_file1 == 0 && end_file2 == 0) // Check end of line
            {
                if (arg1 < arg2) // compare two number
                {
                    fileWriter.write(String.valueOf(arg1) + " ");
                    fileWriter.write(String.valueOf(arg2) + " ");
                }
                else
                {
                    fileWriter.write(String.valueOf(arg2) + " ");
                    fileWriter.write(String.valueOf(arg1) + " ");
                }
            }

            if(end_file1 == 1 && end_file2 == 0) // Write end file
            {
                fileWriter.write(String.valueOf(arg2) + " ");
            }

            if(end_file1 == 0 && end_file2 == 1) // Write end file
            {
                fileWriter.write(String.valueOf(arg1) + " ");
            }

        }
        fileWriter.close();

    }
}
