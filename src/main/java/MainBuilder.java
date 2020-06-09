import com.datastax.oss.driver.api.core.CqlSession;

import java.util.Scanner;

public class MainBuilder {
    public static void main(String[] args) {
        int i=0;
        try (CqlSession session = CqlSession.builder().build()) {
            KeyspaceBuilderMenager keyspaceManager = new KeyspaceBuilderMenager(session, "czytelnia");
            keyspaceManager.dropKeyspace();
            keyspaceManager.selectKeyspaces();
            keyspaceManager.createKeyspace();
            keyspaceManager.useKeyspace();

            BibliotekaTableBuilderMenager tableManager = new BibliotekaTableBuilderMenager(session);
            tableManager.createTable();
            tableManager.insertIntoTable();
            System.out.println("Witaj w bibliotece casandry!\n Podaj cyfrę aby: \n 1:Zaktualizuj Dane w tabeli\n 2.Prosty Select\n 3.Usun dane z tabeli\n");
            Scanner scanner = new Scanner(System.in);
            i=scanner.nextInt();

                switch (i) {
                    case 1:
                        tableManager.updateIntoTable();
                        break;
                    case 2:
                        tableManager.selectFromTable();
                        break;
                    case 3:
                        tableManager.deleteFromTable();
                        break;
                }
                tableManager.dropTable();




        }
    }
}
