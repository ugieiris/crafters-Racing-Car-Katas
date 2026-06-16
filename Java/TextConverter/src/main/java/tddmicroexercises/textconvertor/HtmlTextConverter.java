package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlTextConverter
{
    private BufferedReader reader;
    private StringEscape stringEscape;

    public HtmlTextConverter(BufferedReader reader, StringEscape stringEscape)
    {
        this.reader = reader;
        this.stringEscape = stringEscape;
    }

    public String convertToHtml() throws IOException{
        //BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += stringEscape.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }

}
