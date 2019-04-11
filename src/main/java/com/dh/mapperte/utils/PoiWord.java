package com.dh.mapperte.utils;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.util.ResourceUtils;

public class PoiWord {
    public PoiWord() {
    }

    public static void main(String[] args) throws Exception, IOException {
    }

    public static void mains(Map<String, String> map) throws IOException {
        File path1 = new File(ResourceUtils.getURL("classpath:").getPath());
        System.out.println(path1.getAbsolutePath());
        String inFile = path1.getAbsolutePath() + "/001.doc";
        String outFile = path1.getAbsolutePath() + "/test.doc";
        HWPFDocument doc = createTemplateDoc(inFile, map);
        saveDoc(doc, outFile);
    }

    private static void saveDoc(HWPFDocument doc, String outPath) {
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(new File(outPath));
            doc.write(out);
        } catch (Exception var12) {
            var12.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException var11) {
                    var11.printStackTrace();
                }
            }

        }

    }

    private static HWPFDocument createTemplateDoc(String file, Map<String, String> map) throws IOException, FileNotFoundException {
        HWPFDocument doc = new HWPFDocument(new FileInputStream(file));
        Range range = doc.getRange();
        int paraNum = range.numParagraphs();

        for(int i = 0; i < paraNum; ++i) {
            Paragraph paragraph = range.getParagraph(i);
            if (paragraph.text().indexOf("$") > -1) {
                Iterator var7 = map.entrySet().iterator();

                while(var7.hasNext()) {
                    Entry<String, String> entry = (Entry)var7.next();
                    paragraph.replaceText((String)entry.getKey(), (String)entry.getValue());
                }
            }
        }

        return doc;
    }
}
