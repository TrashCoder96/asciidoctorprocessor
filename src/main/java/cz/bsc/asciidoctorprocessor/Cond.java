package cz.bsc.asciidoctorprocessor;

import org.asciidoctor.ast.ContentNode;
import org.asciidoctor.converter.Converter;

import java.util.Map;

/**
 * Created by vvershinin on 22.08.2017.
 */
public class Cond implements Converter {


    public Object convert(ContentNode node, String transform, Map opts) {
        return null;
    }

    public Map<String, Object> getOptions() {
        return null;
    }

    public void setOutfileSuffix(String outfilesuffix) {

    }

    public String getOutfileSuffix() {
        return null;
    }
}
