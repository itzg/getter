import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;

public class GetTgz {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.err.println("url is required");
            System.exit(2);
        }
        final URL downloadUrl = new URL(args[0]);

        try (InputStream tgzStream = downloadUrl.openStream()) {
            final Process proc = new ProcessBuilder("tar", "zxf", "-")
                .redirectOutput(Redirect.INHERIT)
                .start();
            tgzStream.transferTo(proc.getOutputStream());
            proc.getOutputStream().close();

            System.exit(
                proc.waitFor()
            );
        }
    }
}
