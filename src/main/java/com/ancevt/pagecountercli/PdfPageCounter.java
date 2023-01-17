package com.ancevt.pagecountercli;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class PdfPageCounter implements PageCounter {

    @Override
    public int count(Path path) {
        try (PDDocument doc = PDDocument.load(new File(path.toString()))) {
            return doc.getNumberOfPages();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
