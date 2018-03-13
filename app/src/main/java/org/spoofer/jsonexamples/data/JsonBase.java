package org.spoofer.jsonexamples.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

/**
 * Base class for JsonParser, performs simple stream to JsonObject parsing.
 * Created by rob on 13/03/2018.
 */

public class JsonBase {


    /**
     * Open a new JsonObject from the given input stream.
     * Stream is expected to be UTF-8 encoded text stream.
     *
     * @param in Inputstream to source raw json text stream
     * @return new Json Object opened with the given stream of text
     * @throws IOException if stream fails to open or parse.
     */
    public JSONObject openJson(InputStream in) throws IOException, JSONException {
        JSONObject j = new JSONObject();

        Writer writer = new StringWriter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
        }
        return new JSONObject(writer.toString());
    }


    public JSONObject openJson(URL src) throws IOException, JSONException {
        InputStream in = src.openStream();
        if (null == in)
            throw new IOException("Failed to open stream");

        try {  // You open it, so you close it.  Dem's the rules :-)
            return openJson(src.openStream());
        } finally {
            if (null != in)
                in.close();
        }
    }


}
