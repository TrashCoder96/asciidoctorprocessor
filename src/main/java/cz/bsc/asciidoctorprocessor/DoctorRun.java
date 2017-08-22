package cz.bsc.asciidoctorprocessor;

import org.asciidoctor.AsciiDocDirectoryWalker;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.SafeMode;

import java.util.Map;

import static org.asciidoctor.Asciidoctor.Factory.create;
import static org.asciidoctor.OptionsBuilder.options;

/**
 * Created by Ivan Timofeev on 21.08.2017.
 */
public class DoctorRun {

    public static void main(String[] args) {
        Asciidoctor asciidoctor = create();
        Map<String, Object> options = options().safe(SafeMode.SAFE).asMap();
        //asciidoctor.javaExtensionRegistry().treeprocessor(new TerminalCommandTreeprocessor(options));
        asciidoctor.javaConverterRegistry().register(Cond<String>.class, "");
        asciidoctor.convertDirectory(new AsciiDocDirectoryWalker("D:\\rc-req-mb-client\\src"), options);
    }

}
