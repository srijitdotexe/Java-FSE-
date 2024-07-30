import java.util.Scanner;

public class FactoryMethodTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the type of document to create (word/pdf/excel):");
        String type = scanner.nextLine().toLowerCase();
        
        DocumentFactory factory = null;
        switch (type) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Invalid document type.");
                return;
        }
        
        Document document = factory.createDocument();
        document.open();
        document.close();
    }
}
