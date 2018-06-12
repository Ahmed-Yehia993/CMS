/**
 * InfranetBILLWebservicesServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.brm.bill.services;

public class InfranetBILLWebservicesServiceLocator extends org.apache.axis.client.Service implements com.oracle.brm.bill.services.InfranetBILLWebservicesService {

    public InfranetBILLWebservicesServiceLocator() {
    }


    public InfranetBILLWebservicesServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InfranetBILLWebservicesServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BRMBillServices
    private java.lang.String BRMBillServices_address = "http://192.168.56.101:7001/infranetwebsvcnew/services/BRMBillServices";

    public java.lang.String getBRMBillServicesAddress() {
        return BRMBillServices_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BRMBillServicesWSDDServiceName = "BRMBillServices";

    public java.lang.String getBRMBillServicesWSDDServiceName() {
        return BRMBillServicesWSDDServiceName;
    }

    public void setBRMBillServicesWSDDServiceName(java.lang.String name) {
        BRMBillServicesWSDDServiceName = name;
    }

    public com.oracle.brm.bill.services.InfranetBILLWebservices getBRMBillServices() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BRMBillServices_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBRMBillServices(endpoint);
    }

    public com.oracle.brm.bill.services.InfranetBILLWebservices getBRMBillServices(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oracle.brm.bill.services.BRMBillServicesSoapBindingStub _stub = new com.oracle.brm.bill.services.BRMBillServicesSoapBindingStub(portAddress, this);
            _stub.setPortName(getBRMBillServicesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBRMBillServicesEndpointAddress(java.lang.String address) {
        BRMBillServices_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oracle.brm.bill.services.InfranetBILLWebservices.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oracle.brm.bill.services.BRMBillServicesSoapBindingStub _stub = new com.oracle.brm.bill.services.BRMBillServicesSoapBindingStub(new java.net.URL(BRMBillServices_address), this);
                _stub.setPortName(getBRMBillServicesWSDDServiceName());
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
        if ("BRMBillServices".equals(inputPortName)) {
            return getBRMBillServices();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://192.168.56.101:7001/infranetwebsvcnew/services/BRMBillServices", "InfranetBILLWebservicesService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://192.168.56.101:7001/infranetwebsvcnew/services/BRMBillServices", "BRMBillServices"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BRMBillServices".equals(portName)) {
            setBRMBillServicesEndpointAddress(address);
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
