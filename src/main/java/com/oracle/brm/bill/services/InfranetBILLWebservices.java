/**
 * InfranetBILLWebservices.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oracle.brm.bill.services;

public interface InfranetBILLWebservices extends java.rmi.Remote {
    public java.lang.String pcmOpBillGetItemEventChargeDiscount(int flags, java.lang.String PCM_OP_BILL_GET_ITEM_EVENT_CHARGE_DISCOUNT_request) throws java.rmi.RemoteException;
    public java.lang.String pcmOpBillGroupMoveMember(int flags, java.lang.String PCM_OP_BILL_GROUP_MOVE_MEMBER_request) throws java.rmi.RemoteException;
    public java.lang.String pcmOpBillMakeBillNow(int flags, java.lang.String PCM_OP_BILL_MAKE_BILL_NOW_request) throws java.rmi.RemoteException;
    public java.lang.String pcmOpBillDebit(int flags, java.lang.String PCM_OP_BILL_DEBIT_request) throws java.rmi.RemoteException;
    public java.lang.String pcmOpBillGroupGetParent(int flags, java.lang.String PCM_OP_BILL_GROUP_GET_PARENT_request) throws java.rmi.RemoteException;
    public java.lang.String opcodeWithFlags(java.lang.String opcode, int flags, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException;
    public java.lang.String opcode(java.lang.String opcode, java.lang.String inputXML, java.lang.String m_SchemaFile) throws java.rmi.RemoteException;
    public java.lang.String test() throws java.rmi.RemoteException;
}
