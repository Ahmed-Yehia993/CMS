/**
 * InfranetCUSTWebservices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.brm.cust.services;

public interface InfranetCUSTWebservices extends java.rmi.Remote {
    public java.lang.String pcmOpCustCommitCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustModifyCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustUpdateCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustUpdateServices(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustDeleteAcct(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustDeletePayinfo(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustCreateProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustModifyProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustDeleteProfile(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String pcmOpCustCreateCustomer(int in0, java.lang.String in1) throws java.rmi.RemoteException;
    public java.lang.String opcodeWithFlags(java.lang.String opcode, int flags, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException;
    public java.lang.String opcode(java.lang.String opcode, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException;
    public java.lang.String test() throws java.rmi.RemoteException;
}
