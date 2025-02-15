import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ParseFile {
    List<SATsolver.Clause> clauses;
    Map<Integer, List<SATsolver.Clause>> watch;

    public ParseFile(String inputName) throws Exception {
        clauses = new ArrayList<>();
        watch = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputName))) {
            String line = br.readLine();
            while (line != null) {
                if (line.endsWith(" 0")) {
                    List<Integer> literals = Stream.of(line.substring(0, line.length() - 2).split("\\s+"))
                            .map(Integer::parseInt).toList();
                    SATsolver.Clause clause = new SATsolver.Clause(literals, watch);
                    clauses.add(clause);
                }
                line = br.readLine();
            }
        }
    }

    public List<SATsolver.Clause> getClauses() {
        return clauses;
    }

    public Map<Integer, List<SATsolver.Clause>> getWatch() {
        return watch;
    }
}
