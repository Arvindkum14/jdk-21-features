/**
2. Using LinkedHashSet to Track Recently Used Files (MRU)
🧠 Use Case: Track files a user recently opened in an editor (no duplicates, maintains insertion order)
* */
package com.malik.sequencedcollections;

import java.util.LinkedHashSet;
import java.util.SequencedCollection;

public class RecentFiles {
    public static void main(String[] args) {
        SequencedCollection<String> recentFiles = new LinkedHashSet<>();

        // Simulate user opening files
        recentFiles.add("report.docx");
        recentFiles.add("presentation.pptx");
        recentFiles.add("budget.xlsx");

        System.out.println("Most Recent: " + recentFiles.getLast());
        System.out.println("Oldest: " + recentFiles.getFirst());

        // User reopens "report.docx", move it to end
        recentFiles.remove("report.docx");
        recentFiles.add("report.docx");

        System.out.println("Updated Recent Files: " + recentFiles);
    }
}

