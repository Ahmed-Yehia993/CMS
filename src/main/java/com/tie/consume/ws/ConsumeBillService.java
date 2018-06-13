package com.tie.consume.ws;

import com.oracle.brm.bill.services.InfranetBILLWebservicesServiceLocator;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class ConsumeBillService {
    InfranetBILLWebservicesServiceLocator serviceLocator = new InfranetBILLWebservicesServiceLocator();

    public void makeBillDebitService(String accountPoid, String balGrpObj, int ncrId, double amount, long validFrom, long validTo, int recId){

        String xmlRequest ="    <PCM_OP_BILL_DEBIT_inputFlist>\r\n"
                + "			<POID>"+ accountPoid +"</POID>\r\n"
                + "			<BAL_GRP_OBJ>"+ balGrpObj +"</BAL_GRP_OBJ>\r\n"
                + "			<PROGRAM_NAME>Apply Mag</PROGRAM_NAME>\r\n"
                + "			<DEBIT elem=\""+ ncrId +"\">\r\n"
                + " 			<BAL_OPERAND>"+ amount +"</BAL_OPERAND>\r\n"
                + "         </DEBIT>\r\n"
                + "			<SUB_BALANCES elem=\""+ recId +"\">\r\n"
                + " 			<VALID_FROM>"+ validFrom +"</VALID_FROM>\r\n"
                + " 			<VALID_TO>"+ validTo +"</VALID_TO>\r\n"
                + "         </SUB_BALANCES>\r\n"
                + "    </PCM_OP_BILL_DEBIT_inputFlist>\r\n";
        try {
            System.out.println("makeBillDebitService" + xmlRequest);
            String xmlResponse = serviceLocator.getBRMBillServices().pcmOpBillDebit(0,xmlRequest);
            System.out.println("makeBillDebitService" + xmlResponse);
        } catch (RemoteException | ServiceException e) {
            e.printStackTrace();
        }
    }

    public void makeBillNowService(String accountPoid){
        String xmlRequest =
                  "    <PCM_OP_BILL_MAKE_BILL_NOW_inputFlist>\r\n"
                + "			<POID>"+ accountPoid + "</POID>\r\n"
                + "			<PROGRAM_NAME>Make Bill Now</PROGRAM_NAME>\r\n"
                + "    </PCM_OP_BILL_MAKE_BILL_NOW_inputFlist>\r\n"
                ;
        try {
            System.out.println("makeBillNowService" + xmlRequest);
            String xmlResponse = serviceLocator.getBRMBillServices().pcmOpBillMakeBillNow(0,xmlRequest);
            System.out.println("makeBillNowService" + xmlResponse);
        } catch (RemoteException |ServiceException  e) {
            e.printStackTrace();
        }
    }
}
