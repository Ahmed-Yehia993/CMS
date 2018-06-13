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
        System.out.println("AHMED : " +  xmlCustCreateResponse);
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
        System.out.println("ACCOUNT_OBJ : " + accountPoid);
        NodeList balGrp = document.getElementsByTagName("brm:BAL_INFO");
        for (int i=0; i<balGrp.getLength();i++){
            if(balGrp.item(i).hasChildNodes()){
                NodeList myNodeist = balGrp.item(i).getChildNodes();
                for(int j=0;j< myNodeist.getLength();j++) {
                    String balGrpName = "";
                    String balGrpObj = "";
                    if (myNodeist.item(j).getNodeName().equals("brm:NAME") ) {
                        balGrpName = myNodeist.item(j).getTextContent();
                        System.out.print(balGrpName + " : ");
                    }
                    if (myNodeist.item(j).getNodeName().equals("brm:POID") ) {
                        balGrpObj = myNodeist.item(j).getTextContent();
                        System.out.println(balGrpObj);
                    }
                    accuntDetails.put(balGrpName,balGrpObj);
                }

            }
        }
        return accuntDetails;
    }

    public static void main (String [] args) throws ParserConfigurationException, SAXException, IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><brm:PCM_OP_CUST_CREATE_CUSTOMER_outputFlist xmlns:brm=\"http://xmlns.oracle.com/BRM/schemas/BusinessOpcodes\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:ACCTINFO elem=\"0\"><brm:ACCOUNT_NO>000006</brm:ACCOUNT_NO><brm:BAL_INFO elem=\"0\"></brm:BAL_INFO><brm:POID>0.0.0.1 /account -1 0</brm:POID></brm:ACCTINFO><brm:BAL_INFO elem=\"0\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:BILLINFO_OBJ>0.0.0.1 /billinfo 5229039 0</brm:BILLINFO_OBJ><brm:LIMIT elem=\"1001010\"><brm:CREDIT_FLOOR></brm:CREDIT_FLOOR><brm:CREDIT_LIMIT></brm:CREDIT_LIMIT></brm:LIMIT><brm:LIMIT elem=\"1001011\"><brm:CREDIT_FLOOR></brm:CREDIT_FLOOR><brm:CREDIT_LIMIT></brm:CREDIT_LIMIT></brm:LIMIT><brm:NAME>Utilities</brm:NAME><brm:POID>0.0.0.1 /balance_group 5228831 0</brm:POID><brm:SERVICE_OBJ>0.0.0.0  0 0</brm:SERVICE_OBJ></brm:BAL_INFO><brm:BAL_INFO elem=\"1\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:BILLINFO_OBJ>0.0.0.1 /billinfo 5229551 0</brm:BILLINFO_OBJ><brm:NAME>Rental</brm:NAME><brm:POID>0.0.0.1 /balance_group 5227807 0</brm:POID></brm:BAL_INFO><brm:BAL_INFO elem=\"2\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:BILLINFO_OBJ>0.0.0.1 /billinfo 5228575 0</brm:BILLINFO_OBJ><brm:LIMIT elem=\"1001001\"><brm:CREDIT_FLOOR></brm:CREDIT_FLOOR><brm:CREDIT_LIMIT></brm:CREDIT_LIMIT></brm:LIMIT><brm:LIMIT elem=\"1001002\"><brm:CREDIT_FLOOR></brm:CREDIT_FLOOR><brm:CREDIT_LIMIT></brm:CREDIT_LIMIT></brm:LIMIT><brm:LIMIT elem=\"1001003\"><brm:CREDIT_FLOOR></brm:CREDIT_FLOOR><brm:CREDIT_LIMIT></brm:CREDIT_LIMIT></brm:LIMIT><brm:NAME>Retail Revenue Sharing</brm:NAME><brm:POID>0.0.0.1 /balance_group 5229855 0</brm:POID></brm:BAL_INFO><brm:BAL_INFO elem=\"3\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:BILLINFO_OBJ>0.0.0.1 /billinfo 5229087 0</brm:BILLINFO_OBJ><brm:NAME>IPTV</brm:NAME><brm:POID>0.0.0.1 /balance_group 5227295 0</brm:POID></brm:BAL_INFO><brm:BILLINFO elem=\"0\"><brm:ACTG_TYPE>2</brm:ACTG_TYPE><brm:BAL_GRP_OBJ>0.0.0.1 /balance_group 5228831 0</brm:BAL_GRP_OBJ><brm:BILLINFO_ID>0 - Utilities</brm:BILLINFO_ID><brm:BILLING_SEGMENT>0</brm:BILLING_SEGMENT><brm:BILL_WHEN>1</brm:BILL_WHEN><brm:CURRENCY>48</brm:CURRENCY><brm:CURRENCY_SECONDARY>0</brm:CURRENCY_SECONDARY><brm:EFFECTIVE_T>2017-12-31T23:00:00Z</brm:EFFECTIVE_T><brm:PARENT_FLAGS>0</brm:PARENT_FLAGS><brm:PAYINFO_OBJ>0.0.0.1 /payinfo/invoice 5230319 0</brm:PAYINFO_OBJ><brm:PAY_TYPE>10001</brm:PAY_TYPE><brm:POID>0.0.0.1 /billinfo 5229039 0</brm:POID></brm:BILLINFO><brm:BILLINFO elem=\"1\"><brm:ACTG_TYPE>2</brm:ACTG_TYPE><brm:BAL_GRP_OBJ>0.0.0.1 /balance_group 5227807 0</brm:BAL_GRP_OBJ><brm:BILLINFO_ID>1 - Rental</brm:BILLINFO_ID><brm:BILLING_SEGMENT>0</brm:BILLING_SEGMENT><brm:BILL_WHEN>1</brm:BILL_WHEN><brm:CURRENCY>48</brm:CURRENCY><brm:CURRENCY_SECONDARY>0</brm:CURRENCY_SECONDARY><brm:EFFECTIVE_T>2017-12-31T23:00:00Z</brm:EFFECTIVE_T><brm:PARENT_FLAGS>0</brm:PARENT_FLAGS><brm:PAYINFO_OBJ>0.0.0.1 /payinfo/invoice 5230319 0</brm:PAYINFO_OBJ><brm:PAY_TYPE>10001</brm:PAY_TYPE><brm:POID>0.0.0.1 /billinfo 5229551 0</brm:POID></brm:BILLINFO><brm:BILLINFO elem=\"2\"><brm:ACTG_TYPE>2</brm:ACTG_TYPE><brm:BAL_GRP_OBJ>0.0.0.1 /balance_group 5229855 0</brm:BAL_GRP_OBJ><brm:BILLINFO_ID>2 - Retail Revenue Sharing</brm:BILLINFO_ID><brm:BILLING_SEGMENT>0</brm:BILLING_SEGMENT><brm:BILL_WHEN>1</brm:BILL_WHEN><brm:CURRENCY>48</brm:CURRENCY><brm:CURRENCY_SECONDARY>0</brm:CURRENCY_SECONDARY><brm:EFFECTIVE_T>2017-12-31T23:00:00Z</brm:EFFECTIVE_T><brm:PARENT_FLAGS>0</brm:PARENT_FLAGS><brm:PAYINFO_OBJ>0.0.0.1 /payinfo/invoice 5230319 0</brm:PAYINFO_OBJ><brm:PAY_TYPE>10001</brm:PAY_TYPE><brm:POID>0.0.0.1 /billinfo 5228575 0</brm:POID></brm:BILLINFO><brm:BILLINFO elem=\"3\"><brm:ACTG_TYPE>2</brm:ACTG_TYPE><brm:BAL_GRP_OBJ>0.0.0.1 /balance_group 5227295 0</brm:BAL_GRP_OBJ><brm:BILLINFO_ID>3 - IPTV</brm:BILLINFO_ID><brm:BILLING_SEGMENT>0</brm:BILLING_SEGMENT><brm:BILL_WHEN>1</brm:BILL_WHEN><brm:CURRENCY>48</brm:CURRENCY><brm:CURRENCY_SECONDARY>0</brm:CURRENCY_SECONDARY><brm:EFFECTIVE_T>2017-12-31T23:00:00Z</brm:EFFECTIVE_T><brm:PARENT_FLAGS>0</brm:PARENT_FLAGS><brm:PAYINFO_OBJ>0.0.0.1 /payinfo/invoice 5230319 0</brm:PAYINFO_OBJ><brm:PAY_TYPE>10001</brm:PAY_TYPE><brm:POID>0.0.0.1 /billinfo 5229087 0</brm:POID></brm:BILLINFO><brm:END_T>2017-12-31T23:00:00Z</brm:END_T><brm:GROUP_INFO/><brm:NAMEINFO elem=\"0\"><brm:ADDRESS>October</brm:ADDRESS><brm:CANON_COUNTRY>EG</brm:CANON_COUNTRY><brm:CITY>Giza</brm:CITY><brm:COMPANY></brm:COMPANY><brm:CONTACT_TYPE></brm:CONTACT_TYPE><brm:COUNTRY>Egypt</brm:COUNTRY><brm:ELEMENT_ID>0</brm:ELEMENT_ID><brm:EMAIL_ADDR>ahmed@bac.com</brm:EMAIL_ADDR><brm:FIRST_NAME>Orange</brm:FIRST_NAME><brm:LAST_NAME>Ahmed El-Deeb</brm:LAST_NAME><brm:MIDDLE_NAME></brm:MIDDLE_NAME><brm:SALUTATION></brm:SALUTATION><brm:STATE></brm:STATE><brm:TITLE></brm:TITLE><brm:ZIP>12345</brm:ZIP></brm:NAMEINFO><brm:PAYINFO elem=\"0\"><brm:INHERITED_INFO><brm:INV_INFO elem=\"0\"><brm:ADDRESS>October</brm:ADDRESS></brm:INV_INFO></brm:INHERITED_INFO><brm:INV_TYPE>0</brm:INV_TYPE><brm:PAY_TYPE>10001</brm:PAY_TYPE><brm:POID>0.0.0.1 /payinfo/invoice 5230319 0</brm:POID></brm:PAYINFO><brm:POID>0.0.0.1 /account 1 1</brm:POID><brm:PROFILES elem=\"0\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:END_T>2017-12-31T23:00:00Z</brm:END_T><brm:INHERITED_INFO><brm:BAC_FLD_RENTAL><brm:BAC_FLD_RENTAL_AREA>124</brm:BAC_FLD_RENTAL_AREA></brm:BAC_FLD_RENTAL></brm:INHERITED_INFO><brm:POID>0.0.0.1 /profile/bac_rental -1 0</brm:POID><brm:PROFILE_OBJ>0.0.0.1 /profile/bac_rental 5229727 0</brm:PROFILE_OBJ></brm:PROFILES><brm:PROFILES elem=\"1\"><brm:ACCOUNT_OBJ>0.0.0.1 /account 5228271 0</brm:ACCOUNT_OBJ><brm:END_T>2017-12-31T23:00:00Z</brm:END_T><brm:INHERITED_INFO><brm:DATA_ARRAY elem=\"0\"><brm:NAME>Shop Area</brm:NAME><brm:VALID_FROM>1970-01-01T00:00:00Z</brm:VALID_FROM><brm:VALID_TO>1970-01-01T00:00:00Z</brm:VALID_TO><brm:VALUE>124.0</brm:VALUE></brm:DATA_ARRAY></brm:INHERITED_INFO><brm:POID>0.0.0.1 /profile/acct_extrating -1 0</brm:POID><brm:PROFILE_OBJ>0.0.0.1 /profile/acct_extrating 5227167 0</brm:PROFILE_OBJ></brm:PROFILES><brm:SERVICES elem=\"0\"><brm:BAL_INFO elem=\"3\"></brm:BAL_INFO><brm:BILLINFO_OBJ>0.0.0.1 /billinfo 5229087 0</brm:BILLINFO_OBJ><brm:DEALS elem=\"0\"><brm:DEAL_OBJ>0.0.0.1 /deal 4272156 0</brm:DEAL_OBJ></brm:DEALS><brm:LOGIN>LAGARDERE_IPTV_000006</brm:LOGIN><brm:SERVICE_OBJ>0.0.0.1 /service/bac/iptv 5229215 0</brm:SERVICE_OBJ></brm:SERVICES><brm:START_T>2018-05-15T04:00:00Z</brm:START_T></brm:PCM_OP_CUST_CREATE_CUSTOMER_outputFlist>";
        getAccountDetails(xml);
    }
}

