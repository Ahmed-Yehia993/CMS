package com.tie.consume.ws;

import com.tie.model.Contract;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.tie.model.Mag;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class BRMCaller {
    ConsumeCustomerService consumeCustomerService = new ConsumeCustomerService();
    ConsumeBillService consumeBillService = new ConsumeBillService();

    public void createBrmAccount(Contract contract) throws IOException, SAXException, ParserConfigurationException {
        String xmlCustCreateResponse = consumeCustomerService.createCustomerService(contract);
        String accountPoid = getAccountDetails(xmlCustCreateResponse).get("ACCOUNT_OBJ");
        String balGrbObj = getAccountDetails(xmlCustCreateResponse).get("Retail Revenue Sharing");
        int magCount = 0;
        for (Mag mag : contract.getMags()) {
            consumeBillService.makeBillDebitService(accountPoid,balGrbObj,1001001,mag.getAmount(),mag.getValidFrom().getTime()/1000, mag.getValidTo().getTime()/1000,magCount);
            consumeBillService.makeBillDebitService(accountPoid,balGrbObj,1001002,mag.getAmount(),mag.getValidFrom().getTime()/1000, mag.getValidTo().getTime()/1000,magCount);
            consumeBillService.makeBillDebitService(accountPoid,balGrbObj,1001003,mag.getAmount(),mag.getValidFrom().getTime()/1000, mag.getValidTo().getTime()/1000,magCount);
            magCount++;
        }
        consumeBillService.makeBillNowService(accountPoid);
    }

    public static Document toXmlDocument(String str) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new InputSource(new StringReader(str)));
        return document;
    }

    public static HashMap<String,String> getAccountDetails(String xml) throws IOException, SAXException, ParserConfigurationException {
        HashMap<String,String> accuntDetails = new HashMap<>();
        Document document = toXmlDocument(xml);
        NodeList accountPoidNode = document.getElementsByTagName("brm:ACCOUNT_OBJ");
        String  accountPoid = accountPoidNode.item(0).getTextContent();
        accuntDetails.put("ACCOUNT_OBJ", accountPoid);

        NodeList balGrp = document.getElementsByTagName("brm:BAL_INFO");
        for (int i=0; i<balGrp.getLength();i++){
            if(balGrp.item(i).hasChildNodes()){
                NodeList myNodeist = balGrp.item(i).getChildNodes();
                String balGrpObj = "";
                String balGrpName  = "";
                for(int j=0;j< myNodeist.getLength();j++) {

                    if (myNodeist.item(j).getNodeName().equals("brm:NAME") ) {
                        balGrpName  = myNodeist.item(j).getTextContent();
                    }
                    else if (myNodeist.item(j).getNodeName().equals("brm:POID") ) {
                        balGrpObj = myNodeist.item(j).getTextContent();

                    }
                }
                accuntDetails.put(balGrpName,balGrpObj);
            }
        }
        return accuntDetails;
    }
}

