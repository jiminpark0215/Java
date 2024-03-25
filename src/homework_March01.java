import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//20240312 박지민 - 깜짝과제 1

public class homework_March01 {
    public static void main(String[] args) throws IOException {
        try{
            File file = new File("C:\\Users\\lunas\\IdeaProjects\\untitled\\src\\property.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(   "<!DOCTYPE html>\n"+
                            "<html lang = \"UTF-8\">\n" +
                            "<head>\n" +
                            "   <meta charset = \"UTF-8\">\n" +
                            "   <style>\n" +
                            "       table{ border-collapse : collapse; width: 100%; }\n" +
                            "       th, td { border : solid 1px #000; }\n" +
                            "   </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "   <h1>자바 환경정보</h1>\n" +
                            "   <table>\n" +
                            "       <tr>\n" +
                            "           <th>키</th>\n" +
                            "           <th></th>\n" +
                            "       </tr>\n"
            );

            for (Object k : System.getProperties().keySet()){
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("  <tr>\n" +
                                "       <td>" + key + "</td>\n" +
                                "       <td>" + value + "</td>\n" +
                                "   </tr>\n"
                );
            }

            writer.write(
                    "   </table>\n" +
                    "</body>\n" +
                    "</html>\n"
            );
            writer.close();

        } catch(IOException e){
            e.printStackTrace();
        }

    }
}