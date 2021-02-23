package transform;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TransformTest {
    public static void main(String[] args) {
        Path path;
        if(args.length > 0) path = Paths.get(args[0]);
        else path = Paths.get("transform", "makehtml.xsl");
        try (InputStream styleIn = Files.newInputStream(path))
        {
            StreamSource styleSource = new StreamSource(styleIn);

            Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);
        }
    }
}
