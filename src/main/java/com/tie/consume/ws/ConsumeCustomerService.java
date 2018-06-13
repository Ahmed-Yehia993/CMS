/**
 * 
 */
package com.tie.consume.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tie.model.Contact;
import javax.xml.rpc.ServiceException;

import com.oracle.brm.cust.services.InfranetCUSTWebservicesServiceLocator;
import com.tie.model.Contract;
import com.tie.model.Deal;
import com.tie.model.Package;
import org.hibernate.Hibernate;

/**
 * @author Ahmed El-Deeb
 *
 */
public class ConsumeCustomerService {
    InfranetCUSTWebservicesServiceLocator serviceLocator = new InfranetCUSTWebservicesServiceLocator();
    public String createCustomerService(Contract contract) {
		String xmlResponse = "";
		List<Contact> contractContacts = new ArrayList<>(contract.getContact());
		List<Package> contractPackages = new ArrayList<>(contract.getPackages());
		String xmlRequest = "	<PCM_OP_CUST_CREATE_CUSTOMER_inputFlist>\r\n"
				+ "					<POID>0.0.0.1 /account 1 1</POID>\r\n"
				+ "					<END_T>1514761200</END_T>\r\n"
				+ "					<NAMEINFO elem=\"0\">\r\n"
				+ "						<FIRST_NAME>"+ contract.getCompanyName() +"</FIRST_NAME>\r\n"
				+ "						<ZIP>" + contractContacts.get(0).getZipCode() +"</ZIP>\r\n"
				+ "						<COUNTRY>" + contractContacts.get(0).getCountry() +"</COUNTRY>\r\n"
				+ "						<EMAIL_ADDR>"+ contractContacts.get(0).getEmailAddress() +"</EMAIL_ADDR>\r\n"
				+ "						<LAST_NAME>"+ contractContacts.get(0).getFirstName() + " " + contractContacts.get(0).getLastName() +"</LAST_NAME>\r\n"
				+ "						<ADDRESS>"+ contractContacts.get(0).getAddress() +"</ADDRESS>\r\n"
				+ "						<CITY>"+ contractContacts.get(0).getCity() +"</CITY>\r\n"
				+ "					</NAMEINFO>\r\n"
				+ "					<ACCTINFO elem=\"0\">\r\n"
				+ "						<POID>0.0.0.1 /account -1 0</POID>\r\n"
				+ "						<BAL_INFO elem=\"0\"></BAL_INFO>\r\n"
				+ "						<ACCOUNT_NO>" + contract.getAccountNo() + "</ACCOUNT_NO>\r\n"
				+ "					</ACCTINFO>\r\n"
				+ "					<PROFILES elem=\"0\">\r\n"
				+ "						<PROFILE_OBJ>0.0.0.1 /profile/bac_rental -1 0</PROFILE_OBJ>\r\n"
				+ "						<INHERITED_INFO elem=\"0\">\r\n"
				+ "							<BAC_FLD_RENTAL elem=\"0\">\r\n"
				+ "								<BAC_FLD_RENTAL_AREA>"+ contract.getArea() +"</BAC_FLD_RENTAL_AREA>\r\n"
				+ "							</BAC_FLD_RENTAL>\r\n"
				+ "						</INHERITED_INFO>\r\n"
				+ "					</PROFILES>\r\n"
				+ "					<PROFILES elem=\"1\">\r\n"
				+ "						<PROFILE_OBJ>0.0.0.1 /profile/acct_extrating -1 0</PROFILE_OBJ>\r\n"
				+ "						<INHERITED_INFO elem=\"0\">\r\n"
				+ "							<DATA_ARRAY elem=\"0\">\r\n"
				+ "								<NAME>Shop Area</NAME>\r\n"
				+ "								<VALUE>"+ contract.getArea() +"</VALUE>\r\n"
				+ "								<VALID_FROM>0</VALID_FROM>\r\n"
				+ "								<VALID_TO>0</VALID_TO>\r\n"
				+ "							</DATA_ARRAY>\r\n"
				+ "						</INHERITED_INFO>\r\n"
				+ "					</PROFILES>\r\n"
				+ "					<PAYINFO elem=\"0\">\r\n"
				+ "						<POID>0.0.0.1 /payinfo -1 0</POID>\r\n"
				+ "						<PAY_TYPE>10001</PAY_TYPE>\r\n"
				+ "						<INV_TYPE>0</INV_TYPE>\r\n"
				+ "						<INHERITED_INFO elem=\"0\">\r\n"
				+ "							<INV_INFO elem=\"0\">\r\n"
				+ "								<ADDRESS>"+ contractContacts.get(0).getAddress() +"</ADDRESS>\r\n"
				+ "							</INV_INFO>\r\n"
				+ "						</INHERITED_INFO>\r\n"
				+ "					</PAYINFO>\r\n";


		        for (int i=0; i< contractPackages.size();i++){
                    Hibernate.initialize(contractPackages.get(i).getDeals());
                    Set<Deal> packageDeals  = contractPackages.get(i).getDeals();
                    if (contractPackages.get(i).getName().equals("Retail Revenue Sharing") && contract.getType().equals("Revenue Sharing")){
                        xmlRequest = xmlRequest
                                + "					<BILLINFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /billinfo -1 0</POID>\r\n"
                                + "						<BILLINFO_ID>"+ (i+1) + " - " + contractPackages.get(i).getName() +"</BILLINFO_ID>\r\n"
                                + "						<PAYINFO elem=\"0\"></PAYINFO>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<PAY_TYPE>10001</PAY_TYPE>\r\n"
                                + "						<BILLING_SEGMENT>0</BILLING_SEGMENT>\r\n"
                                + "						<PARENT_FLAGS>0</PARENT_FLAGS>\r\n"
                                + "						<BILL_WHEN>1</BILL_WHEN>\r\n"
                                + "						<ACTG_TYPE>2</ACTG_TYPE>\r\n"
                                + "						<CURRENCY>48</CURRENCY>\r\n"
                                + "					</BILLINFO>\r\n"
                                + "					<BAL_INFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /balance_group -1 0</POID>\r\n"
                                + "						<BILLINFO elem=\""+ i +"\"></BILLINFO>\r\n"
                                + "						<NAME>"+ contractPackages.get(i).getName()+"</NAME>\r\n"
                                + "						<LIMIT elem=\"1001001\">\r\n"
                                + "							<CREDIT_FLOOR>NULL</CREDIT_FLOOR>\r\n"
                                + "							<CREDIT_LIMIT>NULL</CREDIT_LIMIT>\r\n"
                                + "						</LIMIT>\r\n"
                                + "						<LIMIT elem=\"1001002\">\r\n"
                                + "							<CREDIT_FLOOR>NULL</CREDIT_FLOOR>\r\n"
                                + "							<CREDIT_LIMIT>NULL</CREDIT_LIMIT>\r\n"
                                + "						</LIMIT>\r\n"
                                + "						<LIMIT elem=\"1001003\">\r\n"
                                + "							<CREDIT_FLOOR>NULL</CREDIT_FLOOR>\r\n"
                                + "							<CREDIT_LIMIT>NULL</CREDIT_LIMIT>\r\n"
                                + "						</LIMIT>\r\n"
                                + "					</BAL_INFO>\r\n"
                                + "					<SERVICES elem=\"0\">\r\n"
                                + "						<SERVICE_OBJ>0.0.0.1 /service/bac/retail -1 0</SERVICE_OBJ>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<LOGIN>LAGARDERE_" + contractPackages.get(i).getName().replace(" " , "_")+ "_" + contract.getAccountNo() +"</LOGIN>\r\n";

                        int dealCount = 0;
                        for (Deal deal : packageDeals) {
                            xmlRequest = xmlRequest
                                    + "						<DEALS elem=\""+ dealCount +"\">\r\n"
                                    + "							<DEAL_OBJ>0.0.0.1 /deal " + deal.getPoid() +" 0</DEAL_OBJ>\r\n"
                                    + "						</DEALS>\r\n";
                            dealCount++;
                        }
                        xmlRequest = xmlRequest
                                + "					</SERVICES>\r\n";
                    }
                    else if (contractPackages.get(i).getName().equals("Rental")){
                        xmlRequest = xmlRequest
                                + "					<BILLINFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /billinfo -1 0</POID>\r\n"
                                + "						<BILLINFO_ID>"+ (i+1) + " - " + contractPackages.get(i).getName() +"</BILLINFO_ID>\r\n"
                                + "						<PAYINFO elem=\"0\"></PAYINFO>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<PAY_TYPE>10001</PAY_TYPE>\r\n"
                                + "						<BILLING_SEGMENT>0</BILLING_SEGMENT>\r\n"
                                + "						<PARENT_FLAGS>0</PARENT_FLAGS>\r\n"
                                + "						<BILL_WHEN>1</BILL_WHEN>\r\n"
                                + "						<ACTG_TYPE>2</ACTG_TYPE>\r\n"
                                + "						<CURRENCY>48</CURRENCY>\r\n"
                                + "					</BILLINFO>\r\n"
                                + "					<BAL_INFO elem=\"" + i + "\">\r\n"
                                + "						<POID>0.0.0.1 /balance_group -1 0</POID>\r\n"
                                + "						<BILLINFO elem=\""+ i +"\"></BILLINFO>\r\n"
                                + "						<NAME>"+ contractPackages.get(i).getName() +"</NAME>\r\n"
                                + "					</BAL_INFO>\r\n"
                                + "					<SERVICES elem=\"0\">\r\n"
                                + "						<SERVICE_OBJ>0.0.0.1 /service/bac/rental -1 0</SERVICE_OBJ>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<LOGIN>LAGARDERE_" + contractPackages.get(i).getName().replace(" " , "_")+ "_" + contract.getAccountNo() +"</LOGIN>\r\n";

                        int dealCount = 0;
                        for (Deal deal : packageDeals) {
                            xmlRequest = xmlRequest
                                    + "						<DEALS elem=\""+ dealCount +"\">\r\n"
                                    + "							<DEAL_OBJ>0.0.0.1 /deal " + deal.getPoid() +" 0</DEAL_OBJ>\r\n"
                                    + "						</DEALS>\r\n";
                            dealCount++;
                        }
                        xmlRequest = xmlRequest
                                + "					</SERVICES>\r\n";


                    }
                    else if (contractPackages.get(i).getName().equals("IPTV")){
                        xmlRequest = xmlRequest
                                + "					<BILLINFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /billinfo -1 0</POID>\r\n"
                                + "						<BILLINFO_ID>" + (i+1) + " - " + contractPackages.get(i).getName() + "</BILLINFO_ID>\r\n"
                                + "						<PAYINFO elem=\"0\"></PAYINFO>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<PAY_TYPE>10001</PAY_TYPE>\r\n"
                                + "						<BILLING_SEGMENT>0</BILLING_SEGMENT>\r\n"
                                + "						<PARENT_FLAGS>0</PARENT_FLAGS>\r\n"
                                + "						<BILL_WHEN>1</BILL_WHEN>\r\n"
                                + "						<ACTG_TYPE>2</ACTG_TYPE>\r\n"
                                + "						<CURRENCY>48</CURRENCY>\r\n"
                                + "					</BILLINFO>\r\n"
                                + "					<BAL_INFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /balance_group -1 0</POID>\r\n"
                                + "						<BILLINFO elem=\""+ i +"\"></BILLINFO>\r\n"
                                + "						<NAME>"+ contractPackages.get(i).getName() +"</NAME>\r\n"
                                + "					</BAL_INFO>\r\n"
                                + "					<SERVICES elem=\"0\">\r\n"
                                + "						<SERVICE_OBJ>0.0.0.1 /service/bac/iptv -1 0</SERVICE_OBJ>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<LOGIN>LAGARDERE_" + contractPackages.get(i).getName().replace(" " , "_")+ "_" + contract.getAccountNo() +"</LOGIN>\r\n";

                        int dealCount = 0;
                        for (Deal deal : packageDeals) {
                            xmlRequest = xmlRequest
                                    + "						<DEALS elem=\""+ dealCount +"\">\r\n"
                                    + "							<DEAL_OBJ>0.0.0.1 /deal " + deal.getPoid() +" 0</DEAL_OBJ>\r\n"
                                    + "						</DEALS>\r\n";
                            dealCount++;
                        }
                        xmlRequest = xmlRequest
                                + "					</SERVICES>\r\n";
                    }

                    else if ((contractPackages.get(i).getName().equals("Power") || contractPackages.get(i).getName().equals("Water")) && !xmlRequest.contains("- Utilities")){
                        xmlRequest = xmlRequest
                                + "					<BILLINFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /billinfo -1 0</POID>\r\n"
                                + "						<BILLINFO_ID>"+ (i+1) + " - Utilities</BILLINFO_ID>\r\n"
                                + "						<PAYINFO elem=\"0\"></PAYINFO>\r\n"
                                + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                + "						<PAY_TYPE>10001</PAY_TYPE>\r\n"
                                + "						<BILLING_SEGMENT>0</BILLING_SEGMENT>\r\n"
                                + "						<PARENT_FLAGS>0</PARENT_FLAGS>\r\n"
                                + "						<BILL_WHEN>1</BILL_WHEN>\r\n"
                                + "						<ACTG_TYPE>2</ACTG_TYPE>\r\n"
                                + "						<CURRENCY>48</CURRENCY>\r\n"
                                + "					</BILLINFO>\r\n"
                                + "					<BAL_INFO elem=\""+ i +"\">\r\n"
                                + "						<POID>0.0.0.1 /balance_group -1 0</POID>\r\n"
                                + "						<BILLINFO elem=\""+ i + "\"></BILLINFO>\r\n"
                                + "						<NAME>Utilities</NAME>\r\n"
                                + "						<LIMIT elem=\"1001010\">\r\n"
                                + "							<CREDIT_FLOOR>NULL</CREDIT_FLOOR>\r\n"
                                + "							<CREDIT_LIMIT>NULL</CREDIT_LIMIT>\r\n"
                                + "						</LIMIT>\r\n"
                                + "						<LIMIT elem=\"1001011\">\r\n"
                                + "							<CREDIT_FLOOR>NULL</CREDIT_FLOOR>\r\n"
                                + "							<CREDIT_LIMIT>NULL</CREDIT_LIMIT>\r\n"
                                + "						</LIMIT>\r\n"
                                + "					</BAL_INFO>\r\n";


                                int serviceCount = i;
                                if (contractPackages.get(i).getName().equals("Power")) {
                                    xmlRequest = xmlRequest
                                            + "					<SERVICES elem=\""+ serviceCount +"\">\r\n"
                                            + "						<SERVICE_OBJ>0.0.0.1 /service/bac/util/power -1 0</SERVICE_OBJ>\r\n"
                                            + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                            + "						<LOGIN>LAGARDERE_" + contractPackages.get(i).getName().replace(" " , "_") + "_" + contract.getAccountNo() +"</LOGIN>\r\n"
                                            + "						<DEALS elem=\"0\">\r\n"
                                            + "							<DEAL_OBJ>0.0.0.1 /deal 4461432 0</DEAL_OBJ>\r\n"
                                            + "						</DEALS>\r\n";
                                    int dealCount = 0;
                                    for (Deal deal : packageDeals) {
                                        xmlRequest = xmlRequest
                                                + "						<DEALS elem=\""+ dealCount +"\">\r\n"
                                                + "							<DEAL_OBJ>0.0.0.1 /deal " + deal.getPoid() +" 0</DEAL_OBJ>\r\n"
                                                + "						</DEALS>\r\n";
                                        dealCount++;
                                    }
                                    xmlRequest = xmlRequest
                                            + "					</SERVICES>\r\n";
                                    serviceCount++;
                                }
                                if (contractPackages.get(i).getName().equals("Water")) {
                                    xmlRequest = xmlRequest

                                            + "					<SERVICES elem=\""+serviceCount+"\">\r\n"
                                            + "						<SERVICE_OBJ>0.0.0.1 /service/bac/util/water -1 0</SERVICE_OBJ>\r\n"
                                            + "						<BAL_INFO elem=\""+ i +"\"></BAL_INFO>\r\n"
                                            + "						<LOGIN>LAGARDERE_" + contractPackages.get(i).getName().replace(" " , "_") + "_" + contract.getAccountNo() +"</LOGIN>\r\n";
                                    int dealCount = 0;
                                    for (Deal deal : packageDeals) {
                                        xmlRequest = xmlRequest
                                                + "						<DEALS elem=\""+ dealCount +"\">\r\n"
                                                + "							<DEAL_OBJ>0.0.0.1 /deal " + deal.getPoid() +" 0</DEAL_OBJ>\r\n"
                                                + "						</DEALS>\r\n";
                                        dealCount++;
                                    }
                                    xmlRequest = xmlRequest
                                            + "					</SERVICES>\r\n";
                        }
                    }
		        }
        xmlRequest = xmlRequest
                + "				</PCM_OP_CUST_CREATE_CUSTOMER_inputFlist>";
		try {
            System.out.println("createCustomerService" + xmlRequest);
			xmlResponse = serviceLocator.getBRMCustServices().pcmOpCustCreateCustomer(0, xmlRequest);
            System.out.println("createCustomerService" + xmlRequest);
		} catch (RemoteException | ServiceException e) {
			e.printStackTrace();
		}
		return xmlResponse;
	}
}


