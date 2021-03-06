import java.io.*;

public class Converter {

    public String CssLocation;
    public String JSLocation;

    public Converter(String CssLocation, String JSLocation) {
        this.CssLocation = CssLocation;
        this.JSLocation = JSLocation;
    }

    public String cssToString() {
        File file = new File(CssLocation);
        StringBuilder css = new StringBuilder();

        //
        css.append("<style>");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                css.append(line);

            }
            br.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        css.append("</style>");

        return css.toString();
    }

    public String jsToString() {
        File file = new File(JSLocation);
        StringBuilder js = new StringBuilder();

        //

        js.append("<script src= \"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script> \n");
        js.append("<script>");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                js.append(line);

            }
            br.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        js.append("</script>");

        return js.toString();
    }
}
