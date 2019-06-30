
package com.leo.crm.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.leo.crm.service.Customer;
import com.leo.crm.service.DetachedCriteria;
import com.leo.crm.service.ObjectFactory;
import com.leo.crm.service.PageBean;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerService", targetNamespace = "http://service.crm.leo.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "deleteCustomer", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.DeleteCustomer")
    @ResponseWrapper(localName = "deleteCustomerResponse", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.DeleteCustomerResponse")
    public void deleteCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns com.leo.crm.service.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCustomerById", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.GetCustomerById")
    @ResponseWrapper(localName = "getCustomerByIdResponse", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.GetCustomerByIdResponse")
    public Customer getCustomerById(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns com.leo.crm.service.PageBean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPageBean", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.GetPageBean")
    @ResponseWrapper(localName = "getPageBeanResponse", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.GetPageBeanResponse")
    public PageBean getPageBean(
        @WebParam(name = "arg0", targetNamespace = "")
        DetachedCriteria arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Integer arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Integer arg2);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addCustomer", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.AddCustomer")
    @ResponseWrapper(localName = "addCustomerResponse", targetNamespace = "http://service.crm.leo.com/", className = "com.leo.crm.service.AddCustomerResponse")
    public void addCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        Customer arg0);

}
