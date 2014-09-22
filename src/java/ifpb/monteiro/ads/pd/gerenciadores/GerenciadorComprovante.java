/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.monteiro.ads.pd.gerenciadores;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import ifpb.monteiro.ads.pd.beans.Pedido;
import ifpb.monteiro.ads.pd.beans.Produto;
import ifpb.monteiro.ads.pd.exceptions.HumQueCaroException;
import ifpb.monteiro.ads.pd.fachada.FachadaBD;
import ifpb.monteiro.ads.pd.validacao.Validacao;
import java.io.FileOutputStream;
import java.util.Date;

/**
 *
 * @author DVD
 */
public class GerenciadorComprovante implements GerenciadorComprovanteIF {

    @Override
    public void comprovanteSms(Pedido pedido) throws HumQueCaroException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private static final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    private FachadaBD fachadaBD;
    private static String FILE = "./comprovantes_pdf/";

    public GerenciadorComprovante() {
        fachadaBD = new FachadaBD();
    }

    @Override
    public void comprovanteImpresso(String idCliente) throws HumQueCaroException {
        Validacao.validaEntrada(idCliente, "Campo Invalido");
        criaComprovantePdf(fachadaBD.buscaPedido(idCliente));
    }

    /**
     * Cria o comprovante PDF
     *
     * @param pedido o pedido do comprovante
     */
    private void criaComprovantePdf(Pedido pedido) {
        adicionaElementosPDF(pedido);
    }

    private static void adicionaElementosPDF(Pedido pedido) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE + "_" + pedido.getTelefoneCliente() + "_" + new Date()));
            document.open();
            addMetaData(document);
            addProdutosNoComp(document, pedido);
            document.close();
        } catch (Exception e) {
        }
    }

    /**
     * Adiciona metaDados
     *
     * @param document
     */
    private static void addMetaData(Document document) {
        document.addTitle("Comprovante de Pagamento - HumQueCaro");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("HumQueCaro");
    }

    private static void addProdutosNoComp(Document document, Pedido pedidos)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        addMenuEstab(preface);
        int total = 0;
        for (Produto produto : pedidos.getProdutos()) {
            preface.add(new Paragraph(produto.getNome() + "      R$" + produto.getValor(),
                    catFont));
            total = total + Integer.parseInt(produto.getValor());
        }
        preface.add(new Paragraph("TOTAL      R$" + total,
                catFont));

        document.add(preface);

    }

    /**
     * Adiciona Menu no comprovante
     *
     * @param preface
     */
    private static void addMenuEstab(Paragraph preface) {
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "                                           HUM...QUECARO",
                catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "                            COMPROVANTE DE PAGAMENTO", catFont));
        preface.add(new Paragraph(
                "                                                               " + new Date(),
                smallBold));
        addEmptyLine(preface, 3);
    }

    /**
     * Adiciona linhas em branco
     *
     * @param paragraph paragrafo atual
     * @param number numero de linhas
     */
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
