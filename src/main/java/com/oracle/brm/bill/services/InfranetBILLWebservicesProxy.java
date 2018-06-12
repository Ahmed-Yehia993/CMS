package com.oracle.brm.bill.services;

public class InfranetBILLWebservicesProxy implements com.oracle.brm.bill.services.InfranetBILLWebservices {
  private String _endpoint = null;
  private com.oracle.brm.bill.services.InfranetBILLWebservices infranetBILLWebservices = null;
  
  public InfranetBILLWebservicesProxy() {
    _initInfranetBILLWebservicesProxy();
  }
  
  public InfranetBILLWebservicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initInfranetBILLWebservicesProxy();
  }
  
  private void _initInfranetBILLWebservicesProxy() {
    try {
      infranetBILLWebservices = (new com.oracle.brm.bill.services.InfranetBILLWebservicesServiceLocator()).getBRMBillServices();
      if (infranetBILLWebservices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)infranetBILLWebservices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)infranetBILLWebservices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (infranetBILLWebservices != null)
      ((javax.xml.rpc.Stub)infranetBILLWebservices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.brm.bill.services.InfranetBILLWebservices getInfranetBILLWebservices() {
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices;
  }
  
  public java.lang.String pcmOpBillGetItemEventChargeDiscount(int flags, java.lang.String PCM_OP_BILL_GET_ITEM_EVENT_CHARGE_DISCOUNT_request) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.pcmOpBillGetItemEventChargeDiscount(flags, PCM_OP_BILL_GET_ITEM_EVENT_CHARGE_DISCOUNT_request);
  }
  
  public java.lang.String pcmOpBillGroupMoveMember(int flags, java.lang.String PCM_OP_BILL_GROUP_MOVE_MEMBER_request) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.pcmOpBillGroupMoveMember(flags, PCM_OP_BILL_GROUP_MOVE_MEMBER_request);
  }
  
  public java.lang.String pcmOpBillMakeBillNow(int flags, java.lang.String PCM_OP_BILL_MAKE_BILL_NOW_request) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.pcmOpBillMakeBillNow(flags, PCM_OP_BILL_MAKE_BILL_NOW_request);
  }
  
  public java.lang.String pcmOpBillDebit(int flags, java.lang.String PCM_OP_BILL_DEBIT_request) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.pcmOpBillDebit(flags, PCM_OP_BILL_DEBIT_request);
  }
  
  public java.lang.String pcmOpBillGroupGetParent(int flags, java.lang.String PCM_OP_BILL_GROUP_GET_PARENT_request) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.pcmOpBillGroupGetParent(flags, PCM_OP_BILL_GROUP_GET_PARENT_request);
  }
  
  public java.lang.String opcodeWithFlags(java.lang.String opcode, int flags, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.opcodeWithFlags(opcode, flags, inputXML, m_SchemaFile);
  }
  
  public java.lang.String opcode(java.lang.String opcode, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.opcode(opcode, inputXML, m_SchemaFile);
  }
  
  public java.lang.String test() throws java.rmi.RemoteException{
    if (infranetBILLWebservices == null)
      _initInfranetBILLWebservicesProxy();
    return infranetBILLWebservices.test();
  }
  
  
}