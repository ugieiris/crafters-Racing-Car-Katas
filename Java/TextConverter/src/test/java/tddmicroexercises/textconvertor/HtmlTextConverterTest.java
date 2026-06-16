package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HtmlTextConverterTest {

    @Test
    public void read_empty_file() throws IOException {
        BufferedReader reader = Mockito.mock(BufferedReader.class);

        HtmlTextConverter converter = new HtmlTextConverter(reader, new StringEscapeUtils());
        assertEquals("", converter.convertToHtml());
    }

    @Test
    public void read_one_line() throws IOException {
        BufferedReader reader = Mockito.mock(BufferedReader.class);

        when(reader.readLine()).thenReturn("&").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(reader, new StringEscapeUtils());
        assertEquals("&amp;<br />", converter.convertToHtml());
    }

    @Test
    public void read_two_lines() throws IOException {
        BufferedReader reader = Mockito.mock(BufferedReader.class);

        when(reader.readLine()).thenReturn("&").thenReturn(">").thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(reader, new StringEscapeUtils());
        assertEquals("&amp;<br />&gt;<br />", converter.convertToHtml());
    }

    @Test
    public void read_three_lines() throws IOException {
        BufferedReader reader = Mockito.mock(BufferedReader.class);
        StringEscape stringEscape = Mockito.mock(StringEscape.class);

        Mockito.when(stringEscape.escapeHtml(Mockito.anyString())).thenReturn("");

        when(reader.readLine())
                .thenReturn("")
                .thenReturn("")
                .thenReturn("")
                .thenReturn(null);

        HtmlTextConverter converter = new HtmlTextConverter(reader, stringEscape);

        assertEquals("<br /><br /><br />", converter.convertToHtml());
        Mockito.verify(stringEscape, times(3)).escapeHtml(Mockito.anyString());
    }

}
