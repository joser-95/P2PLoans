package server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CreateXMLLoans {
	final static String xmlPath = "C:\\Users\\Casa\\Documents\\PeerTree\\";
	CreateXMLLoans(){
		
		loanBuilder("Iuvo", 12, 1000, "prt", 1);
	}
	
	private static void createLoans() {
		
	}
	
	private static void loanBuilder(String LO, int months, float principle, String country, int id){
		
		try {
			//preparar as funções que criam o documento
			DocumentBuilderFactory loanFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder loanBuilder = loanFactory.newDocumentBuilder();
			//criar o documento
			Document loan = loanBuilder.newDocument();
			
			//raíz do xml
			Element root = loan.createElement("loan");
			loan.appendChild(root);
			//elemento empresa
			Element loanOriginator = loan.createElement(LO);
			loanOriginator.setTextContent(LO);
			root.appendChild(loanOriginator);
			//identificador do emprestimo
			//loanOriginator.setAttribute("loan ID", String.valueOf(id));
			/*
				TODO resto dos atributos
			
 				*/
			
			//enviar da memória para um ficheiro no disco
			
			TransformerFactory xmlFactory = TransformerFactory.newInstance();
			Transformer xmlTransformer = xmlFactory.newTransformer();
			DOMSource domSource = new DOMSource(loan);
			StreamResult result  = new StreamResult(new File(xmlPath.toString()));
			xmlTransformer.transform(domSource, result);
		} catch (Exception e) {
			
			System.out.println(e);
		} 
	}
}
