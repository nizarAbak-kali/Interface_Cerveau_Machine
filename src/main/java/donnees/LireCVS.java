package donnees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nizar on 04/03/2016.
 *
 * @author(Nizar ABAK-KALI)
 */
public class LireCVS {
    private String file_p;

    public LireCVS(String file_path) {
        this.file_p = file_path;
    }

    public void run() {
        BufferedReader bufferedReader = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            bufferedReader = new BufferedReader(new FileReader(this.file_p));
            while ((line = bufferedReader.readLine()) != null) {
                String[] signal = line.split(cvsSplitBy);

                System.out.println(signal.toString());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

}
