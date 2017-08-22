package cz.bsc.asciidoctorprocessor;

import org.asciidoctor.ast.*;
import org.asciidoctor.extension.Contexts;
import org.asciidoctor.extension.Treeprocessor;

import java.util.*;
import java.util.List;

/**
 * Created by Ivan Timofeev on 21.08.2017.
 */
public class TerminalCommandTreeprocessor extends Treeprocessor {

    private Document document;

    public TerminalCommandTreeprocessor(Map<String, Object> config) {
        super(config);
    }

    @Override
    public Document process(Document document) {
        this.document = document;
        final List<StructuralNode> nodes = this.document.getBlocks();
        Integer number = 1;
        for (StructuralNode node: nodes) {
            change(node, number);
        }
        return this.document;
    }

    private void change(StructuralNode block, Integer number) {
        if (block instanceof org.asciidoctor.ast.List) {
            org.asciidoctor.ast.List list = ((org.asciidoctor.ast.List) block);
            List<StructuralNode> structuralNodes = new ArrayList<StructuralNode>();
            for (int i = 0; i < list.getItems().size(); i++) {
                if (list.getItems().get(i) instanceof ListItem) {
                    list.getItems().get(i).convert();
                    structuralNodes.add(createBlock(document, Contexts.PARAGRAPH, "ololololo"));
                }
            }
        } else {
            if (block.getBlocks() != null && !block.getBlocks().isEmpty()) {
                for (int i = 0; i < block.getBlocks().size(); i++) {
                    change(block.getBlocks().get(i), number);
                }
            }
        }
    }

}
