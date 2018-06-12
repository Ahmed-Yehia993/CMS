package com.oracle.brm.cust.services;

public class InfranetCUSTWebservicesProxy implements com.oracle.brm.cust.services.InfranetCUSTWebservices {
  private String _endpoint = null;
  private com.oracle.brm.cust.services.InfranetCUSTWebservices infranetCUSTWebservices = null;
  
  public InfranetCUSTWebservicesProxy() {
    _initInfranetCUSTWebservicesProxy();
  }
  
  public InfranetCUSTWebservicesProxy(String endpoint) {
    _endpoint = endpoint;
    _initInfranetCUSTWebservicesProxy();
  }
  
  private void _initInfranetCUSTWebservicesProxy() {
    try {
      infranetCUSTWebservices = (new com.oracle.brm.cust.services.InfranetCUSTWebservicesServiceLocator()).getBRMCustServices();
      if (infranetCUSTWebservices != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)infranetCUSTWebservices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)infranetCUSTWebservices)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (infranetCUSTWebservices != null)
      ((javax.xml.rpc.Stub)infranetCUSTWebservices)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.oracle.brm.cust.services.InfranetCUSTWebservices getInfranetCUSTWebservices() {
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices;
  }
  
  public java.lang.String pcmOpCustCommitCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustCommitCustomer(in0, in1);
  }
  
  public java.lang.String pcmOpCustModifyCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustModifyCustomer(in0, in1);
  }
  
  public java.lang.String pcmOpCustUpdateCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustUpdateCustomer(in0, in1);
  }
  
  public java.lang.String pcmOpCustUpdateServices(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustUpdateServices(in0, in1);
  }
  
  public java.lang.String pcmOpCustDeleteAcct(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustDeleteAcct(in0, in1);
  }
  
  public java.lang.String pcmOpCustDeletePayinfo(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustDeletePayinfo(in0, in1);
  }
  
  public java.lang.String pcmOpCustCreateProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustCreateProfile(in0, in1);
  }
  
  public java.lang.String pcmOpCustModifyProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustModifyProfile(in0, in1);
  }
  
  public java.lang.String pcmOpCustDeleteProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustDeleteProfile(in0, in1);
  }
  
  public java.lang.String pcmOpCustCreateCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.pcmOpCustCreateCustomer(in0, in1);
  }
  
  public java.lang.String opcodeWithFlags(java.lang.String opcode, int flags, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.opcodeWithFlags(opcode, flags, inputXML, m_SchemaFile);
  }
  
  public java.lang.String opcode(java.lang.String opcode, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.opcode(opcode, inputXML, m_SchemaFile);
  }
  
  public java.lang.String test() throws java.rmi.RemoteException{
    if (infranetCUSTWebservices == null)
      _initInfranetCUSTWebservicesProxy();
    return infranetCUSTWebservices.test();
  }
  
  
}