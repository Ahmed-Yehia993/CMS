/**
 * InfranetCUSTWebservicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.brm.cust.services;

public class InfranetCUSTWebservicesServiceLocator extends org.apache.axis.client.Service implements com.oracle.brm.cust.services.InfranetCUSTWebservicesService {

    public InfranetCUSTWebservicesServiceLocator() {
    }


    public InfranetCUSTWebservicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InfranetCUSTWebservicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BRMCustServices
    private java.lang.String BRMCustServices_address = "http://192.168.56.101:7001/infranetwebsvcnew/services/BRMCustServices";

    public java.lang.String getBRMCustServicesAddress() {
        return BRMCustServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BRMCustServicesWSDDServiceName = "BRMCustServices";

    public java.lang.String getBRMCustServicesWSDDServiceName() {
        return BRMCustServicesWSDDServiceName;
    }

    public void setBRMCustServicesWSDDServiceName(java.lang.String name) {
        BRMCustServicesWSDDServiceName = name;
    }

    public com.oracle.brm.cust.services.InfranetCUSTWebservices getBRMCustServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BRMCustServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBRMCustServices(endpoint);
    }

    public com.oracle.brm.cust.services.InfranetCUSTWebservices getBRMCustServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oracle.brm.cust.services.BRMCustServicesSoapBindingStub _stub = new com.oracle.brm.cust.services.BRMCustServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getBRMCustServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBRMCustServicesEndpointAddress(java.lang.String address) {
        BRMCustServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oracle.brm.cust.services.InfranetCUSTWebservices.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oracle.brm.cust.services.BRMCustServicesSoapBindingStub _stub = new com.oracle.brm.cust.services.BRMCustServicesSoapBindingStub(new java.net.URL(BRMCustServices_address), this);
                _stub.setPortName(getBRMCustServicesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BRMCustServices".equals(inputPortName)) {
            return getBRMCustServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://192.168.56.101:7001/infranetwebsvcnew/services/BRMCustServices", "InfranetCUSTWebservicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://192.168.56.101:7001/infranetwebsvcnew/services/BRMCustServices", "BRMCustServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BRMCustServices".equals(portName)) {
            setBRMCustServicesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
