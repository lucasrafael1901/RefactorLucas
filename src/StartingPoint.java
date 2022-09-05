import gr.uom.java.xmi.diff.CodeRange;
import org.eclipse.jgit.lib.Repository;
import org.refactoringminer.api.*;
import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;
import org.refactoringminer.util.GitServiceImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.List;
import com.google.gson.Gson;

public class StartingPoint {


    public static void main(String...args) throws Exception {
        GitService gitService = new GitServiceImpl();
        GitHistoryRefactoringMiner miner = new GitHistoryRefactoringMinerImpl();
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mestrado","root","admin");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from codigo");

            while (resultSet.next()){
                System.out.println(resultSet.getString(""));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        final String[] json = {""};

        Repository repo = gitService.cloneIfNotExists(
                "tmp/refactoring-toy-example",
                "https://github.com/danilofes/refactoring-toy-example.git");

        miner.detectAll(repo, "master", new RefactoringHandler() {
            @Override
            public void handle(String commitId, List<Refactoring> refactorings) {
                int i=0;
                for (Refactoring ref : refactorings) {
                    if (ref.getRefactoringType().toString() == "EXTRACT_OPERATION") {
                        System.out.println("Refactorings at " + commitId);
                        //System.out.println(ref.toJSON());
                        json[0] = ref.toJSON();

                        Gson gson = new Gson();
                        Json json1 = gson.fromJson(json[0], Json.class);

                        System.out.println(json1.getLeftSideLocations(0).getStartLine());
                        System.out.println(json1.getLeftSideLocations(0).getEndLine());
                    }
                }
            }
        });
        }
    }
