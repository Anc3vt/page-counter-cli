package com.ancevt.pagecounter.cli;

import com.ancevt.util.args.Args;
import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PageCounterApplication {

    public static void main(String[] args) throws IOException {
        Args a = Args.of(args);

        if (!a.hasNext()) {
            System.err.println("Error: required at least 1 argument as base directory");
            System.exit(1);
        }

        new PageCounterApplication(a.next());
    }

    private static final Map<String, PageCounter> pageCounterImplementations = Map.of(
            "docx", new DocxPageCounter(),
            "pdf", new PdfPageCounter()
            // You can extend content of this map with your own PageCounter implementations
    );

    public PageCounterApplication(String basePath) throws IOException {
        AtomicInteger documents = new AtomicInteger();
        AtomicInteger pages = new AtomicInteger();

        Files.walk(Path.of(basePath))
                .filter(Files::isRegularFile)
                .forEach(path -> handleDocument(path, documents, pages));

        System.out.printf("Documents: %d%n", documents.get());
        System.out.printf("Pages: %d%n", pages.get());
    }

    private static void handleDocument(Path path, AtomicInteger documents, AtomicInteger pages) {
        PageCounter pageCounter = pageCounterImplementations.get(getExtension(path));

        if (pageCounter != null) {
            documents.incrementAndGet();
            pages.addAndGet(pageCounter.count(path));
        }
    }

    private static String getExtension(Path path) {
        return FilenameUtils.getExtension(path.toString()).toLowerCase();
    }


}
