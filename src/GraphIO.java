import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphIO {

    public static void readFile(Graph g, String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            // Read first line to get the node amount.
            final int NODE_AMOUNT = Integer.parseInt(br.readLine());

            // Read the first amount of nodes.
            for (int i = 0; i < NODE_AMOUNT; i++) {
                String[] node = br.readLine().split(" ");
                g.addNode(Integer.parseInt(node[0]), Integer.parseInt(node[1]), Integer.parseInt(node[2]));
            }

            // Read the last lines containing edges.
            String line;
            while ((line = br.readLine()) != null) {
                String[] edge = line.split(" ");
                g.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), Integer.parseInt(edge[2]));
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new IOException("Text-format error!");
        }
    }
}
